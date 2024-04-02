package domains;

import lombok.Data;

@Data
public class Amount {

    private final Currency currency;
    private final double amount;

    public Amount add(Amount amount) {
        return new Amount(currency, this.amount + amount.amount);
    }

}
