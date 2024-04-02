package domains;

import lombok.Data;

@Data
public class Expense {

    private final BalanceMap userBalances; // User to amount map
    private final String title;
    private final String imageUrl;
    private final String description;
    private final String groupId;
}
