public class Account {
    private double balance;

    // Konstruktor: mengisi saldo awal
    public Account(double initBalance) {
        this.balance = initBalance;
    }

    public double getBalance() {
        return balance;
    }

    // Menambah saldo, berhasil (true) jika jumlah lebih dari 0
    public boolean deposit(double amt) {
        if (amt > 0) {
            balance = balance + amt;
            return true;
        }
        return false;
    }

    // Mengurangi saldo, berhasil (true) jika saldo cukup
    public boolean withdraw(double amt) {
        if (amt > 0 && balance >= amt) {
            balance = balance - amt;
            return true;
        }
        return false;
    }
}