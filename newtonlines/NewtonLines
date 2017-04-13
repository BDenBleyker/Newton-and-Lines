/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newtonlines;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 *
 * @author benne_000
 */
public class NewtonLines {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("\n**********Requirement Two**********");
        reqTwo();
        System.out.println("\n**********Requirement Three**********");
        reqThree();
        System.out.println("\n**********Requirement Four**********");
        reqFour();
    }

    public static void reqTwo() {
        Scanner stdIn = new Scanner(System.in);
        System.out.print("Please insert the number you want the square root of: ");
        boolean cont = true;
        double q = stdIn.nextDouble();
        double x = q;
        for (int i = 0; i <= q; i++) {
            if (i * i < q && (i + 1) * (i + 1) > q) {
                x = i;
                x += (q - i * i) / ((i + 1) * (i + 1) - (i * i));
            }
        }
        double prev = x;
        int iteration = 0;
        while (cont) {
            iteration++;
            x = (x + (q / x)) / 2;
            BigDecimal a = new BigDecimal(x).setScale(10, RoundingMode.HALF_UP);
            BigDecimal b = new BigDecimal(prev).setScale(10, RoundingMode.HALF_UP);
            if (a.equals(b)) {
                cont = false;
            }
            prev = x;
        }

        System.out.println("Your result is: " + x);
        System.out.println("Iterations: " + iteration);
    }

    public static void reqThree() {
        Scanner stdIn = new Scanner(System.in);
        System.out.print("Please insert the number you want the square root of: ");
        BigDecimal q = new BigDecimal(stdIn.nextDouble());
        BigDecimal x = q;
        for (int i = 0; i <= q.doubleValue(); i++) {
            if (i * i < q.doubleValue() && (i + 1) * (i + 1) > q.doubleValue()) {
                x = x.add(new BigDecimal((i + (q.doubleValue() - i * i) / ((i + 1) * (i + 1) - (i * i)))));
            }
        }
        RootOutput result = reqThreeRecursive(q, x, 1);
        System.out.println("Your result is: " + result.getResult() + "\nIterations: " + result.getIteration());
    }
    public static RootOutput reqThreeRecursive(BigDecimal q, BigDecimal x, int iteration) {
        q = q.setScale(10, RoundingMode.HALF_UP);
        x = x.setScale(10, RoundingMode.HALF_UP);
        BigDecimal a = new BigDecimal ((x.doubleValue() + (q.doubleValue() / x.doubleValue())) / 2).setScale(10, RoundingMode.HALF_UP);
        BigDecimal b = x.setScale(10, RoundingMode.HALF_UP);
        RootOutput result;
        if (!a.equals(b)) {
            result = reqThreeRecursive(q, a, iteration + 1);
        } else {
            result = new RootOutput(a.doubleValue(), Math.abs(new BigDecimal(Math.sqrt(q.doubleValue())).subtract(a).doubleValue()), iteration);
        }
        return result;
    }

    public static void reqFour() {
        System.out.println("a. What happens when you seed your algorithm with 0?\n"
                + " | It throws java.lang.NumberFormatException: Infinite or NaN");
        System.out.println("c. How many iterations does it take for your code to:"
                + "\n\ti. converge when you start at 100, looking for square root of two.\n"
                + "\t | " + reqThreeRecursive(new BigDecimal(2), new BigDecimal(100), 1).getIteration()
                + "\n\tii. converge when you start at 1, looking for the square root of 1,000,000,000,000,000?\n"
                + "\t | 16" + reqThreeRecursive(new BigDecimal("1000000000000000"), new BigDecimal(1), 1).getIteration());
        System.out.println("d. Find the error parameter\n"
                + " | ±" + reqThreeRecursive(new BigDecimal(2), new BigDecimal(1), 1).getError());
        System.out.println("e. Define convergence\n"
                + " | Convergence is the point where the square root does not change to the 12th decimal place");
            RootOutput i = reqThreeRecursive(new BigDecimal("10000000000"), new BigDecimal("1"), 1);
            RootOutput ii = reqThreeRecursive(new BigDecimal("1000000000000000000000000000000"), new BigDecimal("1"), 1);
            RootOutput iii = reqThreeRecursive(new BigDecimal("100000000000000000000000000000000000000000000000000"), new BigDecimal("1"), 1);
            RootOutput iv = reqThreeRecursive(new BigDecimal("10000000000000000000000000000000000000000000000000000000000000000000000"), new BigDecimal("1"), 1);
            RootOutput v = reqThreeRecursive(new BigDecimal("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"), new BigDecimal("1"), 1);
        System.out.println("f. Report your error parameter and iterations of the following:\n"
                + "\ti. 1 for the sqrt of 10^10\n"
                + "\t | I:" + i.getIteration() + " E:" + i.getError() + "\n"
                + "\tii. 1 for the sqrt of 10^30\n"
                + "\t | I:" + ii.getIteration() + " E:" + ii.getError() + "\n"
                + "\tiii. 1 for the sqrt of 10^50\n"
                + "\t | I:" + iii.getIteration() + " E:" + iii.getError() + "\n"
                + "\tiv. 1 for the sqrt of 10^70\n"
                + "\t | I:" + iv.getIteration() + " E:" + iv.getError() + "\n"
                + "\tv. 1 for the sqrt of 10^100\n"
                + "\t | I:" + v.getIteration() + " E:" + v.getError());
            i = reqThreeRecursive(new BigDecimal("0.0000000001"), new BigDecimal("1"), 1);
            ii = reqThreeRecursive(new BigDecimal("0.000000000000000000000000000001"), new BigDecimal("1"), 1);
            iii = reqThreeRecursive(new BigDecimal("0.00000000000000000000000000000000000000000000000001"), new BigDecimal("1"), 1);
            iv = reqThreeRecursive(new BigDecimal("0.0000000000000000000000000000000000000000000000000000000000000000000001"), new BigDecimal("1"), 1);
            v = reqThreeRecursive(new BigDecimal("0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001"), new BigDecimal("1"), 1);
        System.out.println("g. Report your error parameter and iterations of the following:\n"
                + "\ti. 1 for the sqrt of 10^-10\n"
                + "\t | I:" + i.getIteration() + " E:" + i.getError() + "\n"
                + "\tii. 1 for the sqrt of 10^-30\n"
                + "\t | I:" + ii.getIteration() + " E:" + ii.getError() + "\n"
                + "\tiii. 1 for the sqrt of 10^-50\n"
                + "\t | I:" + iii.getIteration() + " E:" + iii.getError() + "\n"
                + "\tiv. 1 for the sqrt of 10^-70\n"
                + "\t | I:" + iv.getIteration() + " E:" + iv.getError() + "\n"
                + "\tv. 1 for the sqrt of 10^-100\n"
                + "\t | I:" + v.getIteration() + " E:" + v.getError());
        System.out.println("h. How does convergence differ for the positive and negative powers of 10.\n"
                + " | The convergence is completely different in that the error rate is sky high with negative powers.");
    }

}
