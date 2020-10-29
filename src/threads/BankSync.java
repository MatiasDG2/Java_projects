package threads;

public class BankSync {
    public static void main(String[] args) {
        Bank b= new Bank();
        b.transfer(40,60,400.5);
        System.out.println(b.getTotalMoney());
    }
}

class Bank{
    public Bank(){
        accounts= new double [100];
        for (int i=0; i<accounts.length; i++){
            accounts[i]= 2000;
        }
    }
    public void transfer(int OriginAccount, int DestinationAccount, double amount){
        if (OriginAccount>amount){
            System.out.println("Transfer money exceeds account money");
            return;
        }
        accounts[OriginAccount]-= amount;
        accounts[DestinationAccount]+= amount;
        System.out.println("The money was transferred");
        System.out.println("Current money: " + accounts[OriginAccount]);
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