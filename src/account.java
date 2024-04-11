public class account {
    LinkedList transactionLog;
    int balance;
    String accName, type;
    public account(String accName, String type, int balance, LinkedList transactionLog) {
        this.accName = accName;
        this.type = type;
        this.balance = balance;
        this.transactionLog = transactionLog;
    }

    public int getBalance() {
        return balance;
    }

    public LinkedList getTransactionLog() {
        return transactionLog;
    }

    public String getAccName() {
        return accName;
    }
    public String getType() {
        return type;
    }
}
