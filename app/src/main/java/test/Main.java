package test;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int arr[] = {1, 9, 5, 6, 8, 10};
        int maxfirst = -6, maxsecound = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {

            if (maxfirst < arr[i]) {
                maxsecound = maxfirst;
                maxfirst = arr[i];
            } else if (maxfirst != arr[i] && arr[i] > maxsecound)
                maxsecound = arr[i];
        }
        System.out.println(maxfirst);
        System.out.println(maxsecound);
        int n = scan.nextInt();
        int r = 0;
        for (int i = 1; i <= 10; i++) {

            System.out.println(n+"*"+i+"="+n*i);
        }

    }

}

