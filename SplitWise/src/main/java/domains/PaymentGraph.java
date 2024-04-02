package domains;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class PaymentGraph {

    private final Map<String, BalanceMap> paymentGraph;

    public PaymentGraph(Map<String, BalanceMap> paymentGraph) {
        this.paymentGraph = paymentGraph;
    }
}
