package repository;

import domain.CTag;
import domain.Tag;

import java.util.HashMap;

public class TagRepository {

    private HashMap<Tag, CTag> cTagHashMap;

    public TagRepository() {
        this.cTagHashMap = new HashMap<>();
    }

    public CTag findByTag(Tag tag) {
        return cTagHashMap.get(tag);
    }

    public void addCTag(Tag tag, CTag ctag) {
        cTagHashMap.put(tag, ctag);
    }
}
