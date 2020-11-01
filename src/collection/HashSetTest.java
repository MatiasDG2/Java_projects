package collection;

public class HashSetTest {
    public static void main(String[] args) {
        Set <Account> s= new HashSet<Account>();
        s.add(new Account("Pepe Mujica",0,9999999);
        s.add(new Account("Felipe Olivera",1,1000);
        s.add(new Account("Leandro Santoro",2,250000);
        for (Account a: s){
            System.out.println("---------------------------");
            System.out.println("Nombre: " + s.getNombre());
            System.out.println("Id: " + s.getId());
            System.out.println("Balance: " + s.getBalance());
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
    public String getId(){return id;}
    public String getBalance(){return balance;}
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
        libro other= (libro) obj;
        if (id != other.id)
            return false;
        return true;
    }
    private String name;
    private int id;
    private long balance;
}
