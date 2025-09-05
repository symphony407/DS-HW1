package Code;

    public class Eratosthenes{
    public static void main(String[] args) {

        long startTime = System.nanoTime();


        int n = Integer.parseInt(args[0]);
        boolean[] marks = new boolean[n];

        
        for (int i = 2; i < Math.sqrt(marks.length); i++) {
            for (int j = i + i; j < marks.length; j += i) {
                if (j % i == 0) 
                    marks[j] = true;
            }
        }

        for (int i = 2; i < marks.length; i++) {
            if(!marks[i]) {
                System.out.printf("%d ", i);
           }
        }
        long endTime = System.nanoTime();
        double duration = (endTime-startTime)/1_000_000_000.0;
        System.out.printf("%nSolve time: %.6f seconds%n", duration);

    }
}  
