package service;

import domain.CTag;
import domain.Entity;
import domain.Tag;
import repository.EntityRepository;
import repository.TagRepository;

import java.util.HashMap;
import java.util.List;

public class PendentServiceImpl {

    private final EntityRepository entityRepository;
    private final TagRepository tagRepository;

    public PendentServiceImpl(EntityRepository entityRepository, TagRepository tagRepository) {
        this.entityRepository = entityRepository;
        this.tagRepository = tagRepository;
    }

    public void startTracking(String id, List<Tag> tagList) {
        if(tagList.isEmpty()) {
            return;
        }

        if(entityRepository.getEntityById(id) == null) {

            CTag firstCTag = tagRepository.findByTag(tagList.get(0));
            HashMap<Tag,CTag> linkedTags;

            // If firstCTag is not already present
            if(firstCTag == null) {
                firstCTag = new CTag(tagList.get(0).getName(), tagList.get(0).getType());
                linkedTags = new HashMap<>();
                tagRepository.addCTag(tagList.get(0), firstCTag);
            } else {
                linkedTags = firstCTag.getLinkedTags();
            }
            firstCTag.addTracking();

            CTag prevCTag = firstCTag ;
            // Inserting all the new tags in trie
            for( int i = 1 ; i < tagList.size() ; i++ ) {
                CTag nextCTag = null ;

                // If CTag is present
                if(linkedTags.containsKey(tagList.get(i))) {
                    nextCTag = linkedTags.get(tagList.get(i));

                } else {
                    nextCTag = new CTag(tagList.get(i).getName(), tagList.get(i).getType());
                    linkedTags.put(tagList.get(i), nextCTag);
                    prevCTag.setLinkedTags(linkedTags);
                }

                nextCTag.addTracking();

                linkedTags = nextCTag.getLinkedTags();
                prevCTag = nextCTag;
            }

            Entity entity = new Entity(id, tagList, firstCTag);

            entityRepository.addEntity(entity);
        }
    }

    public void stopTracking(String entityId) {
        Entity entity = entityRepository.getEntityById(entityId);
        if(entity == null) return;
        CTag firstCTag = entity.getFirstCTag();
        List<Tag> tagList = entity.getTagList();
        firstCTag.stopTracking();
        for (Tag tag : tagList) {

            HashMap<Tag, CTag> linkedTags = firstCTag.getLinkedTags();
            CTag currentCTag = linkedTags.get(tag);
            currentCTag.stopTracking();
            firstCTag = currentCTag;
        }
    }

    public int getCounts(List<Tag> tagList) {
        if(tagList.isEmpty())
            return 0;

        Tag firstTag = tagList.get(0);
        CTag firstCTag = tagRepository.findByTag(firstTag);
        if(firstCTag == null) return 0;
        int result = firstCTag.getCount();
        for (int i =1;i<tagList.size();i++) {

            HashMap<Tag, CTag> linkedTags = firstCTag.getLinkedTags();
            CTag currentCTag = linkedTags.get(tagList.get(i));
            result = Math.min(currentCTag.getCount(), result);
            firstCTag = currentCTag;
        }
        return result;
    }
}
