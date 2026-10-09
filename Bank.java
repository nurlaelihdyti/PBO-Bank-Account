public class Bank {
    private Customer[] customers;    // ARRAY berisi objek Customer
    private int numberOfCustomers;   // penanda indeks kosong berikutnya

    // Konstruktor: ukuran array 10
    public Bank() {
        customers = new Customer[10];
        numberOfCustomers = 0;
    }

    // Membuat Customer baru lalu menaruhnya di array
    public void addCustomer(String f, String l) {
        if (numberOfCustomers < customers.length) {
            customers[numberOfCustomers] = new Customer(f, l);
            numberOfCustomers++;
        } else {
            System.out.println("Bank penuh, nasabah tidak bisa ditambah!");
        }
    }

    public int getNumOfCustomers() {
        return numberOfCustomers;
    }

    public Customer getCustomer(int index) {
        return customers[index];
    }
}