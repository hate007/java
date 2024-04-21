class BankAccount {
    int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(int amount) {
        int newBalance = balance + amount;
        try {
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " deposited.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        balance = newBalance; 
    }

    public synchronized int getBalance() {
        return balance;
    }
}

class BankUser implements Runnable {
    BankAccount account;

    public BankUser(BankAccount account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            account.deposit(100); 
            System.out.println("Balance: " + account.getBalance());
        }
    }
}

public class s30q1 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        Thread user1 = new Thread(new BankUser(account), "AMAN");
        Thread user2 = new Thread(new BankUser(account), "Bmaan");

        user1.start();
        user2.start();
    }
}
