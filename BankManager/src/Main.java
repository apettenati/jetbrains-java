public class Main {

    public static void main(String[] args) {

        BankAccount fidelity = new BankAccount();
        CheckingAccount fidelityCheckingAccount = new CheckingAccount();
        SavingsAccount fidelitySavingsAccount = new SavingsAccount();
        CertificateOfDeposit fidelityCertificateOfDeposit = new CertificateOfDeposit();

        System.out.println(fidelityCertificateOfDeposit.balance);
        System.out.println(fidelityCertificateOfDeposit.account);
        System.out.println(fidelityCertificateOfDeposit.routingNumber);

    }
}
