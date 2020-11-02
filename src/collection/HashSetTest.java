package collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        Set <Account> s= new HashSet<Account>();
        s.add(new Account("Pepe Mujica",0,9999999));
        s.add(new Account("Felipe Olivera",1,1000));
        s.add(new Account("Leandro Santoro",2,250000));
        for (Account a: s){
            System.out.println("---------------------------");
            System.out.println("Nombre: " + a.getName());
            System.out.println("Id: " + a.getId());
            System.out.println("Balance: " + a.getBalance());
        }
    }
}
class Account{
    public Account(String name, int id, long balance){
        this.name= name;
        this.id= id;
        this.balance= balance;
    }
    public String getName(){return name;}
    public int getId(){return id;}
    public double getBalance(){return balance;}
    public void setName(String name){this.name= name;}
    public void setId(int id){this.id= id;}
    public void setBalance(long balance){this.balance= balance;}
    public int hashCode(){
        final int prime= 31;
        int result= 1;
        result= prime * result + id;
        return result;
    }
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Account other= (Account) obj;
        if (id != other.id)
            return false;
        return true;
    }
    private String name;
    private int id;
    private long balance;
}
