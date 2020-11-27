package task15;

import java.util.ArrayList;
import java.util.Random;

public class main16 {
    public static void main(String[]args){
        Tester tester = new Tester();
        tester.start();
    }

    public static class Tester extends Thread {
        AtmSystem atmSystem = new AtmSystem();

        @Override
        public void run() {
            System.out.println("Start tester");
            Account account = new Account(new Person("Robert"));
            account.balance = 10000;

            Operation op = new Operation();
            op.setInfo(Operation.WITHDRAW_CODE, 1000, account);

            atmSystem.atms[0].addOperation(op);

            atmSystem.atms[1].addOperation(op);

            atmSystem.atms[0].start();
            atmSystem.atms[1].start();
        }
    }

    public static class Account {
        public int balance;
        private final Person person;

        Account(Person p) {
            person = p;
        }

        public Person getPerson() {
            return person;
        }
    }

    public static class Person {
        private String name;


        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static class AtmSystem {
        public final Atm[] atms = new Atm[3];
        public Account[] account = new Account[3];

        AtmSystem() {
            for (int i = 0; i < 3; i++) {
                atms[i] = new Atm(this, i + 1);
            }
            for (Atm atm : atms) atm.start();
        }

        public void Log(int index, String operation, int amount, boolean succeed, int newBalance, Person person) {
            if (succeed)
                System.out.println("ATM " + index + " " + operation + "ed " + amount + ". New balance = " + newBalance + " for person " + person.getName());
            else
                System.out.println("ATM " + index + " failed to " + operation + " " + amount + ". Balance = " + newBalance + " for person " + person.getName());
            System.out.println();
        }

        public synchronized Account[] getAccount() {
            return account;
        }
    }

    public static class Operation {
        final static int DEPOSIT_CODE = 0;
        final static int WITHDRAW_CODE = 1;

        private int opCode = 0;
        private int amount = 0;
        private Account account;

        public void setInfo(int o, int a, Account account) {
            opCode = o;
            amount = a;
            this.account = account;
        }

        public int getOpCode() {
            return opCode;
        }

        public int getAmount() {
            return amount;
        }

        public Account getAccount() {
            return account;
        }
    }

    public static class Atm extends Thread {
        public final AtmSystem atmSystem;
        public final int index;
        private final ArrayList<Operation> operations = new ArrayList<>();

        public Atm(AtmSystem atmSystem, int index) {
            this.atmSystem = atmSystem;
            this.index = index;
        }

        private void setNewAccount(Account account) {
            atmSystem.getAccount()[index] = account;
        }

        public void addOperation(Operation op) {
            operations.add(op);
        }

        private synchronized void deposit(int amount) {
            atmSystem.getAccount()[index].balance += amount;
            atmSystem.Log(index, "deposit", amount, true, atmSystem.getAccount()[index].balance, atmSystem.getAccount()[index].getPerson());
        }

        private synchronized void withdraw(int amount) {
            int localBalance = atmSystem.getAccount()[index].balance;
            if (localBalance - amount >= 0) {
                localBalance -= amount;
                atmSystem.getAccount()[index].balance = localBalance;
                atmSystem.Log(index, "withdraw", amount, true, atmSystem.getAccount()[index].balance, atmSystem.getAccount()[index].getPerson());
            } else
                atmSystem.Log(index, "withdraw", amount, false, atmSystem.getAccount()[index].balance, atmSystem.getAccount()[index].getPerson());
        }

        public void run() {
            boolean flag = true;
            while (flag) {
                try {
                    sleep(new Random().nextInt(1500));
                    if (operations.size() > 0) {
                        Operation current = operations.get(0);
                        operations.remove(0);

                        setNewAccount(current.getAccount());

                        switch (current.getOpCode()) {
                            case Operation.DEPOSIT_CODE:
                                deposit(current.getAmount());
                                break;
                            case Operation.WITHDRAW_CODE:
                                withdraw(current.getAmount());
                                break;
                        }
                    } else
                        flag = false;
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
            }
        }
    }

}
