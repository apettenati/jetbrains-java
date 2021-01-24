public class BankAccount {
    String account;
    double balance;
    private final String routingNumber = "fidelityRoutingNumber";

    public BankAccount(String account, double balance) {
        this.account = account;
        this.balance = balance;
    }

    public BankAccount() {
        this.account = "123";
        this.balance = 1000000.01;
    }

    public String getRoutingNumber() {
        return routingNumber;
    }
}
