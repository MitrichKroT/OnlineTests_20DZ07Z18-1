package com.acquisio.basic.java.question03;

import org.w3c.dom.ranges.RangeException;

/**
 * QUESTION 04: StackOverflow
 * This program crashes after throwing StackOverflowError exception:
 * Fix the factorial method.
 *
 * IMPORTANT: Add all missing javadoc and/or unit tests that you think is necessary.
 */
public class IssueResolving {
    public static void main(String[] args) {
        IssueResolving instance = new IssueResolving();
        System.out.println(instance.factorial(20));
    }

    long factorial(int n) {
        long result = 0;
        System.out.println(n);
        if ((n < 0) || (n > 20))
            throw new IllegalArgumentException(n + " is out of range");
        return (1 > n) ? 1 : factorial(n - 1) * n;
    }

}
