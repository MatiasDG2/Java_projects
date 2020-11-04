package collection;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Iterator;

public class LinkedListTest{
    public static void main(String[] args) {
        LinkedList <String> list= new LinkedList<String>();
        list.add("Samuel");
        list.add("Martin");
        list.add("Pepe");
        list.add("Roberto");
        ListIterator<String> iterator= list.listIterator();
        while (iterator.hasNext()){
            String s= iterator.next();
            System.out.println(s);
        }
    }
}
