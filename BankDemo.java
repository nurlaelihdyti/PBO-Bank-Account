import java.util.Scanner;

public class BankDemo {

    // Mengubah double menjadi teks "Rp 100000" (casting ke long)
    public static String rp(double nilai) {
        return "Rp " + (long) nilai;
    }

    public static void main(String[] args) {
        Bank bank = new Bank();

        // Mengisi data nasabah, tiap nasabah punya 1 rekening dulu
        bank.addCustomer("Adi", "Saputra");
        bank.getCustomer(0).setAccount(new Account(100000)); // saldo awal Rp 100.000

        bank.addCustomer("Budi", "Santoso");
        bank.getCustomer(1).setAccount(new Account(250000));

        bank.addCustomer("Citra", "Dewi");
        bank.getCustomer(2).setAccount(new Account(500000));

        // ===== BAGIAN 1: Soal Exercise B (nasabah Adi) =====
        Account akunAdi = bank.getCustomer(0).getAccount(0);

        System.out.println("Welcome to Bank ABC");
        System.out.println("Current balance: " + rp(akunAdi.getBalance()));
        System.out.println();

        akunAdi.deposit(500000);
        System.out.println("Deposit: Rp 500000");
        System.out.println("Current balance: " + rp(akunAdi.getBalance()));
        System.out.println();

        akunAdi.withdraw(150000);
        System.out.println("Withdraw: Rp 150000");
        System.out.println("Current balance: " + rp(akunAdi.getBalance()));
        System.out.println();

        // ===== BAGIAN 2: Daftar semua nasabah =====
        System.out.println("=== Daftar Nasabah (" + bank.getNumOfCustomers() + " orang) ===");
        for (int i = 0; i < bank.getNumOfCustomers(); i++) {
            Customer c = bank.getCustomer(i);
            System.out.println((i + 1) + ". " + c.getFirstName() + " " + c.getLastName()
                    + " | Jumlah rekening: " + c.getNumOfAccounts()
                    + " | Saldo rekening 1: " + rp(c.getAccount(0).getBalance()));
        }

        // ===== BAGIAN 3: Menu ATM sederhana =====
        Scanner input = new Scanner(System.in);

        System.out.println();
        System.out.println("=== ATM Bank ABC ===");
        for (int i = 0; i < bank.getNumOfCustomers(); i++) {
            System.out.println((i + 1) + ". " + bank.getCustomer(i).getFirstName());
        }
        System.out.print("Pilih nasabah (1-" + bank.getNumOfCustomers() + "): ");
        int pilih = input.nextInt();

        if (pilih < 1 || pilih > bank.getNumOfCustomers()) {
            System.out.println("Nasabah tidak ditemukan!");
            input.close();
            return;
        }

        Customer nasabah = bank.getCustomer(pilih - 1);
        int menu;

        do {
            System.out.println();
            System.out.println("--- Menu ATM: " + nasabah.getFirstName() + " " + nasabah.getLastName() + " ---");
            System.out.println("1. Lihat semua rekening");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Tambah rekening baru");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            menu = input.nextInt();

            switch (menu) {
                case 1:
                    for (int i = 0; i < nasabah.getNumOfAccounts(); i++) {
                        System.out.println("Rekening " + (i + 1) + ": "
                                + rp(nasabah.getAccount(i).getBalance()));
                    }
                    break;
                case 2:
                    System.out.print("Pilih nomor rekening: ");
                    int rekD = input.nextInt();
                    if (rekD < 1 || rekD > nasabah.getNumOfAccounts()) {
                        System.out.println("Rekening tidak ada!");
                        break;
                    }
                    System.out.print("Jumlah deposit: Rp ");
                    double jmlD = input.nextDouble();
                    if (nasabah.getAccount(rekD - 1).deposit(jmlD)) {
                        System.out.println("Deposit berhasil. Saldo: "
                                + rp(nasabah.getAccount(rekD - 1).getBalance()));
                    } else {
                        System.out.println("Deposit gagal, jumlah harus lebih dari 0!");
                    }
                    break;
                case 3:
                    System.out.print("Pilih nomor rekening: ");
                    int rekW = input.nextInt();
                    if (rekW < 1 || rekW > nasabah.getNumOfAccounts()) {
                        System.out.println("Rekening tidak ada!");
                        break;
                    }
                    System.out.print("Jumlah withdraw: Rp ");
                    double jmlW = input.nextDouble();
                    if (nasabah.getAccount(rekW - 1).withdraw(jmlW)) {
                        System.out.println("Withdraw berhasil. Saldo: "
                                + rp(nasabah.getAccount(rekW - 1).getBalance()));
                    } else {
                        System.out.println("Withdraw gagal, saldo tidak cukup atau jumlah salah!");
                    }
                    break;
                case 4:
                    System.out.print("Saldo awal rekening baru: Rp ");
                    double awal = input.nextDouble();
                    nasabah.setAccount(new Account(awal));
                    System.out.println("Rekening baru dibuat. Total rekening: "
                            + nasabah.getNumOfAccounts());
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan Bank ABC!");
                    break;
                default:
                    System.out.println("Menu tidak valid!");
            }
        } while (menu != 0);

        input.close();
    }
}