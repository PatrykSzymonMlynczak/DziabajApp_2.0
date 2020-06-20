package pl.manciak.thymeleaf.Manager;

import org.junit.Test;

import java.math.BigInteger;

//todo - delete
public class MealManagerTest {

    @Test
    public void rekurs(){
        /*Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();*/
        //System.out.println(str);
        System.out.println( rekursja(5000));

    }
    @Test
    public void forloop(){
        /*Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();*/
        //System.out.println(str);
        System.out.println( xx(1000*1000*1000));

    }
    public long xx(int s){
        long wynik = 0;
        for (int i=0; i<=s; i++) {
            wynik += i;
        }
        return wynik;
    }

    long wynik = 0;
    long i = 0;
    public long rekursja(long liczba){
        if(i < liczba){
            i++;
            wynik+=i;
            rekursja(liczba);
            }
        return wynik;
    }
    @Test
    public void aa(){
        int i =1000000000;
        i = (i>>8);
        System.out.println(i);
    }

    @Test
    public void aaa(){
        int i =1000;
        byte x=0;
        x += i;
        double z = 1.0;
        System.out.println(z/0.0-5);
        String xza = System.getProperty("sun.arch.data.model");
        System.out.println(xza);

    }

    @Test
    public void test1(){
        String hello = "Witaj ";
        String world = "Świecie!";
        String powitanie = hello + world; //łączenie dwóch napisów
        System.out.println(powitanie);
        Integer c = 0;
        int b = c; //Integer.decode("1234");
        String czesc = powitanie.substring(0, 6) + "uczniu";
        System.out.println(b++);

        System.out.println(++b+"\n");

        String pierw = "p";
        String potem = "p";
        String potem2 = new String("p");
      //  potem2 = "p";
        double xx = 10000;
        xx = Math.log10(xx);
        System.out.println(pierw.equals(potem2));
        System.out.println(xx);

        BigInteger integer = BigInteger.valueOf(2222);
        BigInteger integer2 = new BigInteger("11111111111111");
        System.out.println(integer.add(integer2));
        int[] tab = new int[]{1, 2, 3, 4};
        int[] reverse =  new int[tab.length];
        int j = 0;
        for (int i=tab.length-1; i>=0; i--){
           reverse[i]=tab[j];
            //System.out.println(reverse[i]);
            //System.out.println(tab[i]);
           j++;
        }
        for (int i :reverse) {
            System.out.println(i);
        }

    }

}