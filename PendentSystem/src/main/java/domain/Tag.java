package domain;

import lombok.Data;

@Data
public class Tag {

    String name;
    TagType type;

    public Tag(String name, TagType type) {
        this.name = name;
        this.type = type;
    }
}
