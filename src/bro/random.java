package bro;

import java.util.Random;


public class random {
    public static void main(String[] args) {
        String[] arr = new String[]{"a", "b", "c", "d", "e", "f", "g" };
        Random r= new Random();
        String random=arr[r.nextInt(arr.length)];
        System.out.println(random);

    }
}

