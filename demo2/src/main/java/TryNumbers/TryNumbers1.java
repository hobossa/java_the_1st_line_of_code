package TryNumbers;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Random;

public class TryNumbers1 {
    public static void main(String[] args) throws Exception {
        System.out.println(Math.round(15.45));  // 15 + 0.45 -> 15
        System.out.println(Math.round(15.5));   // 15 + 0.5 -> 15 + 1 -> 15
        System.out.println(Math.round(-15.5));  // -16 + 0.5 -> -16 + 1 -> -15
        System.out.println(Math.round(-15.55)); // -16 + 0.45 -> -16

        System.out.println(round(12.345, 2)); // 12.35
        System.out.println(round(12.345, 2)); // 12.35

        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            System.out.print(rand.nextInt(100) + " ");
        }
        System.out.println("");

        System.out.println(Double.MAX_VALUE);

        // BigInteger and BigDecimal
        BigInteger bigA = new BigInteger("1111111111111111111111");
        BigInteger bigB = new BigInteger("44444444444444");
        System.out.println("bigA + bigB = " + bigA.add(bigB));
        System.out.println(bigA.subtract(bigB));
        System.out.println(bigA.multiply(bigB));
        System.out.println(bigA.divide(bigB));
        BigInteger result[] = bigA.divideAndRemainder(bigB);
        System.out.println(result[0] + "-" + result[1]);
    }

    public static double round(double num, int scale) {
        return Math.round(num * Math.pow(10.0, scale)) / Math.pow(10.0, scale);
    }

    public static double roundEx(double num, int scale) {
        BigDecimal big = new BigDecimal(num);
        BigDecimal result = big.divide(new BigDecimal(1), scale, RoundingMode.HALF_UP);
        return result.doubleValue();
    }
}
