package ex01;

import java.util.Scanner;
public class DisplayOutput {
    public static int dosth(int a , int b){
        while(a*b!=0){
            if(a>b) a = a-b;
            else b = b + a;//16+24
        }
        if(a==0) return b;
        return a;
    }
    public static int printScan(final Scanner sc, final String txt){
        System.out.println(txt);
        return Integer.parseInt(sc.nextLine());
    }
    public static void main(String[] arg){
        Scanner sc= new Scanner(System.in);
        int a,b;
        a = printScan(sc,"First Number:");
        b = printScan(sc, "Second Number:");
        System.out.printf("Result is %d",dosth(a, b));
        sc.close();
    }
}