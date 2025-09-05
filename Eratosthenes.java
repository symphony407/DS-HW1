package Code;

    public class Eratosthenes{
    public static void main(String[] args) {

        long startTime = System.nanoTime();

        int n = Integer.parseInt(args[0]);
        boolean[] marks = new boolean[n];

        
        for (int i = 2; i < Math.sqrt(marks.length); i++) {//sieve of Eratosthenes algorithm
            for (int j = i + i; j < marks.length; j += i) {
                if (j % i == 0) 
                    marks[j] = true;
            }
        }

            
            System.out.print("\nLast 5: ");// printing out last 5 prime numbers
            int[] last5 = new int[5];
            int count = 0;
            for (int i = marks.length - 1; i >= 2 && count < 5; i--) {// looping through to find last 5 primes
                if (!marks[i]) {
                    last5[count] = i;
                    count++;
                }
            }
            for (int i = count - 1; i >= 0; i--) {//
                System.out.printf("%d ", last5[i]);
            }


        long endTime = System.nanoTime();
        double duration = (endTime-startTime)/1_000_000_000.0;
        System.out.printf("%nSolve time: %.6f seconds%n", duration);

    }
}  
