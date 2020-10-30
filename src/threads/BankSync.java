package threads;

public class BankSync {
    public static void main(String[] args) {
        Bank b= new Bank();
        for (int i=0; i<100; i++){
            Thread t= new Thread(new ExecuteRandomTransferences(b,i,2000));
            t.start();
        }
    }
}

class Bank{
    public Bank(){
        accounts= new double [100];
        for (int i=0; i<accounts.length; i++){
            accounts[i]= 2000;
        }
    }
    public void transfer(int originAccount, int destinationAccount, double amount){
        l.lock();
        try{
            if (originAccount>amount){
                System.out.println("Transfer money exceeds account money");
                return;
            }
            accounts[originAccount]-= amount;
            accounts[destinationAccount]+= amount;
            System.out.println("The money was transferred");
            System.out.println("Current money: " + accounts[originAccount]);
        }finally{
            l.unlock();
        }
    public double getTotalMoney(){
        double total= 0;
        for (double i: accounts){
            total+= i;
        }
        return total;
    }
    private final double[] accounts;
    private Lock l= new ReentrantLock();
}

class ExecuteRandomTransferences implementes Runnable{
    public ExecuteRandomTransferences (Bank bank, int originAccount, int maxAmount){
        this.bank= bank;
        this.originAccount= originAccount;
        this.maxAmount= maxAmount;
    }
    public void run(){
        while (true){
            int destinationAccount= (int) (Math.random()*100);
            double amount= maxAmount*Math.random;
            transfer(originAccount, destinationAccount, amount);
            Thread.sleep((int)(Math.random()*10));
        }
    }
    private Bank bank;
    private int originAccount;
    private int maxAmount;
}
