package algorithms1;

import java.util.*;

public class Transactions {

    public static void main(String[] args) {
        List<String> rejectedTransactions = findRejectedTransactions(Arrays.asList("", ""), 200);
        rejectedTransactions.forEach(System.out::println);
    }

    public static List<String> findRejectedTransactions(List<String> transactions, int creditLimit) {
        if (transactions == null || transactions.isEmpty()) return Collections.emptyList();
        List<Entry> transactionList = parseTransactions(transactions);
        return getRejectedTransactions(transactionList, creditLimit);
    }

    private static List<String> getRejectedTransactions(List<Entry> transactionList, int creditLimit) {

        Map<Consumer, Double> consumerMap = new HashMap<>();
        List<String> rejectedTransactionIds = new ArrayList<>();
        for (Entry entry :
                transactionList) {
            Double credit = Double.parseDouble(String.valueOf(creditLimit));
            Consumer consumer = new Consumer(entry.firstName, entry.lastName, entry.email);
            if(consumerMap.containsKey(consumer)) {
                credit = consumerMap.get(consumer);
            } else {
                consumerMap.put(consumer, credit);
            }

            if (Double.compare(entry.amount, credit) > 0) {
                rejectedTransactionIds.add(entry.transactionId);
            } else {
                credit -= entry.amount;
                consumerMap.put(consumer, credit);
            }
        }
        return rejectedTransactionIds;
    }

    static List<Entry> parseTransactions(List<String> transactions) {
        List<Entry> transactionEntries = new ArrayList<>();
        transactions.forEach(t -> {
            String[] entry = t.split(",");
            if (entry.length != 5) {
                throw new IllegalArgumentException();
            }
            try {
                Double.parseDouble(entry[3]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }

            transactionEntries.add(new Entry(entry[0], entry[1], entry[2], Double.valueOf(entry[3]), entry[4]));
        });

        return transactionEntries;
    }

    static class Consumer {
        String firstName;

        String lastName;
        String email;

        double creditLimit;

        public Consumer(String firstName, String lastName, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Consumer consumer = (Consumer) o;
            return firstName.equals(consumer.firstName) && lastName.equals(consumer.lastName) && email.equals(consumer.email);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName, lastName, email);
        }
    }

    static class Entry {
        String firstName;
        String lastName;
        String email;

        double amount;
        String transactionId;

        public Entry(String firstName, String lastName, String email, double amount, String transactionId) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.amount = amount;
            this.transactionId = transactionId;
        }
    }
}
