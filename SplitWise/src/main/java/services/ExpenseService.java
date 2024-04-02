package services;


import domains.Amount;
import domains.BalanceMap;
import domains.Expense;
import domains.PaymentGraph;

import java.util.*;

import static domains.Currency.USD;

/*
    1. AddExpense
    2. Get Group Expense
    3. Get Payment Graph of who has to pay directed graph, postive -> negative
 */
public class ExpenseService {

    private final Map<String, List<Expense>> groupExpenses;

    public ExpenseService() {
        this.groupExpenses = new HashMap<>();
    }

    public void addExpense(Expense expense) {
        final var groupId = expense.getGroupId();
        if (groupId != null) {
            groupExpenses.putIfAbsent(groupId, new ArrayList<>());
            groupExpenses.get(groupId).add(expense);
        }
    }

    public List<Expense> getGroupExpenses(String groupId) {
        return groupExpenses.get(groupId);
    }

    public PaymentGraph getPaymentGraph(BalanceMap groupBalances) {

        final Comparator<Map.Entry<String, Amount>> ascending = Comparator.comparingDouble(balance -> balance.getValue().getAmount());
        final PriorityQueue<Map.Entry<String, Amount>>
                positiveAmount = new PriorityQueue<>(ascending.reversed()),
                negativeAmount = new PriorityQueue<>(ascending);
        for (var balance : groupBalances.getBalances().entrySet()) {
            if (balance.getValue().getAmount() > 0) {
                positiveAmount.add(balance);
            } else {
                negativeAmount.add(balance);
            }
        }

        final var graph = new HashMap<String, BalanceMap>();
        while(!positiveAmount.isEmpty()) {
            final var largestPositivve = positiveAmount.poll();
            final var largestNegative = negativeAmount.poll();

            final var positiveAmnt = largestNegative.getValue().getAmount();
            final var negativeAmnt = -largestNegative.getValue().getAmount();

            graph.putIfAbsent(largestPositivve.getKey(), new BalanceMap());
            graph.get(largestPositivve.getKey()).getBalances()
                    .put(largestNegative.getKey(), new Amount(USD, Math.min(positiveAmnt, negativeAmnt)));
            double remaining = positiveAmnt - negativeAmnt;
            final var remainingAmount = new Amount(USD, remaining);
            if (remaining > 0) {
                positiveAmount.add(new AbstractMap.SimpleEntry<>(largestPositivve.getKey(), remainingAmount));
            } else if (remaining < 0) {
                negativeAmount.add(new AbstractMap.SimpleEntry<>(largestNegative.getKey(), remainingAmount));
            }
        }
        return new PaymentGraph(graph);

        }


    }
