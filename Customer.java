import java.util.ArrayList;

public class Customer {
    private String firstName;
    private String lastName;
    private ArrayList<Account> accounts; // ArrayList: jumlah rekening bisa bertambah

    public Customer(String f, String l) {
        firstName = f;
        lastName = l;
        accounts = new ArrayList<Account>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    // Menambah rekening ke daftar nasabah
    public void setAccount(Account acct) {
        accounts.add(acct);
    }

    // Mengambil rekening berdasarkan nomor urut
    public Account getAccount(int accountIndex) {
        return accounts.get(accountIndex);
    }

    public int getNumOfAccounts() {
        return accounts.size();
    }
}