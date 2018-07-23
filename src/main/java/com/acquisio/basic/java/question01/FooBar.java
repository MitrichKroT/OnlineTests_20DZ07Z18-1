package com.acquisio.basic.java.question01;

/**
 * QUESTION 01: FooBar
 * You have a program that receives a value, which we assume is a positive
 * integer. You need to loop on all integer value between 0 and the value
 * received. Ex.: If you receive 50, you must loop from 0 to 50.
 * <p>
 * The program must follow those rules:
 * - Must not print anything if the value cannot be divided by itself.
 * - Must print 'Foo' if the value can be divided by 3.
 * - Must print 'Bar' if the value can be divided by 5.
 * - Otherwise, print the current integer value in the loop.
 *
 * IMPORTANT: Add all missing javadoc and/or unit tests that you think is necessary.
 */
public class FooBar {
    public static void main(String[] args) {
        FooBar main = new FooBar();
        main.fizzBuzz(50);
    }

    private void fizzBuzz(int maxValue) {
        for (int i=0;i<=maxValue;i++) {
            String tmp="";
            if (i!=0) {
                if(i%3==0 && i%5==0) { tmp="Foo & Bar";}
                else if (i%3==0)tmp="Foo";
                else if (i%5==0) tmp="Bar";
            }
            System.out.println("value "+i+ "= >"+ tmp);
        }
    }
}
