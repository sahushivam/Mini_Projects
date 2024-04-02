package domains;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class BalanceMap {

    private final Map<String, Amount> balances;

    public BalanceMap() {
        this.balances = new HashMap<>();
    }

    public BalanceMap(Map<String, Amount> resultBalances) {
        this.balances = resultBalances;
    }
}
