package domain;

import lombok.Data;

import java.util.List;

@Data
public class Entity {

    private final String id;
    private final List<Tag> tagList;
    private final CTag firstCTag;

    public Entity(String id, List<Tag> tagList, CTag cTag) {
        this.id = id;
        this.tagList = tagList;
        this.firstCTag = cTag;
    }
}
