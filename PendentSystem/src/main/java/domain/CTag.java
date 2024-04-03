package domain;

import lombok.Data;

import java.util.HashMap;

public class CTag extends Tag{

    int count;
    private HashMap<Tag, CTag> linkedTags;

    public CTag(String name, TagType type) {
        super(name, type);
        this.count = 0;
        this.linkedTags = new HashMap<>();
    }

    public void addTracking() {
        this.count += 1;
    }

    public HashMap<Tag, CTag> getLinkedTags() {
        return linkedTags;
    }

    public void stopTracking() {
        this.count -= 1;
    }

    public void setLinkedTags(HashMap<Tag, CTag> linkedTags) {
        this.linkedTags = linkedTags;
    }

    public int getCount() {
        return this.count;
    }
}
