package domains;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Group {

    private final String name;
    private final String imageUrl;
    private final List<String> userList; // This defines the group
}
