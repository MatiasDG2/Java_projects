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
    public synchronized void transfer(int originAccount, int destinationAccount, double amount) throws InterruptedException{
        if (accounts[originAccount]<amount){
            wait();
        }
        accounts[originAccount]-= amount;
        accounts[destinationAccount]+= amount;
        System.out.println("The money was transferred");
        System.out.println("Current money: " + accounts[originAccount]);
        notifyAll();
    }
    public double getTotalMoney(){
        double total= 0;
        for (double i: accounts){
            total+= i;
        }
        return total;
    }
    private final double[] accounts;
}

class ExecuteRandomTransferences implements Runnable{
    public ExecuteRandomTransferences (Bank bank, int originAccount, int maxAmount){
        this.bank= bank;
        this.originAccount= originAccount;
        this.maxAmount= maxAmount;
    }
    public void run(){
        try{
            for (int i=0; i<100; i++){
                int destinationAccount= (int) (Math.random()*100);
                double amount= maxAmount*Math.random();
                bank.transfer(originAccount, destinationAccount, amount);
                Thread.sleep((int)(Math.random()*10));
            }
        }catch(InterruptedException e){}
    }
    private Bank bank;
    private int originAccount;
    private int maxAmount;
}
