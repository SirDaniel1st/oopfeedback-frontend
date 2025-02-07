import java.util.Scanner;
import java.lang.Math;
import java.util.Random;
public class Lab1PartThree{
    public static void exercise1(){
       System.out.println("Enter radius");
       Scanner keyboard = new Scanner(System.in);
       double radius = keyboard.nextDouble() ;
       double area = radius * radius * Math.PI;
       System.out.println("The area is " + area);
       
    }
    public static void exercise2(){
       int i=0;
       Scanner keyboard = new Scanner(System.in);
       int n = keyboard.nextInt();
       for(i=0;i<=n;i++){
           if(i % 2 == 0){
               System.out.println(i + " ");
           }
       }
    }
    public static void exercise3(){
        Random r = new Random();
        int n1 = r.nextInt(1000);
        int n2 = r.nextInt(1000);
        System.out.println("What is " + n1 + " + " + n2 + "?");
        System.out.println(n1+n2);
    }
    public static void exercise4(){
        String[] arr;
        arr = new String[3];
        arr[0] = "hi";
        arr[1] = "howdy";
        arr[2] = "exit";
        Random r = new Random();
        
        String word;
        int n = r.nextInt(3);
        while( n != 2){
            word = arr[n];
            n = r.nextInt(3);
            System.out.println(word);
        }
    }
}