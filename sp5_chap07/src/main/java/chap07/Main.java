package chap07;

public class Main {
    public static void main(String[] args) {
        ImpeCalculator impeCal = new ImpeCalculator();
        long start1 = System.currentTimeMillis();
        long fourFactorial1 = impeCal.factorial(4);
        long end1 = System.currentTimeMillis();
        System.out.printf("ImpeCalculator.factorial(4) 실행시간 = %d\n",
                (end1 - start1));

        RecCalculator recCal = new RecCalculator();
        long start2 = System.currentTimeMillis();
        long fourFactorial2 = recCal.factorial(4);
        long end2 = System.currentTimeMillis();
        System.out.printf("RecCalculator.factorial(4) 실행시간 = %d\n",
                (end1 - start1));
    }
}
