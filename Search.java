package Code;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Search{
    public static void main(String[] args) {
        byte [] bytes= getFileBytes("half_gaps.bin");
        long[] primes = new long[bytes.length + 2] ;
        primes[0] = 2;
        primes[1] = 3;
        long sum = 0;
       
        for (int i = 0; i < bytes.length; i++) {
        long gap = i < 2 ? Byte.toUnsignedLong(bytes[i]) : Byte.toUnsignedLong(bytes[i]);
        sum += gap;
        primes[i + 2] = sum * 2 + 3;
}



        double start = System.nanoTime();
        double favourable = 0;
        for(int i = 1; i <= 1000000; i++) {
            long x = getRandomInt(2, Integer.MAX_VALUE);
            //favourable += linearSearch(x, primes) ? 1.0:0.0;
            favourable += binarySearch(x,primes, 0, primes.length - 1) ? 1.0:0.0;
            System.out.println(favourable / i);
        }
        double duration = (System.nanoTime()- start)/Math.pow(10,9);
        System.out.printf("Time taken: %.2f seconds%n", duration);
        }
    
        public static int getRandomInt(int min, int max) {
            return (int) (Math.random() * (max - min + 1)) + min;
        }
    
        public static boolean linearSearch(long x, long[] primes) {
            for (int i = 0; primes[i] <= x; i++) {
                if (x == primes[i]) {
                    return true;
                }
            }
            return false;
        }
            public static boolean binarySearch(long x, long[] primes, int low, int high) {
            while(low <= high) {
                int mid = low + (high-low)/2;

            if (primes[mid]==x){
                return true;
            }
            else if (primes[mid] < x) {
                low = mid + 1;
            }
            else if (primes[mid] > x) {
                high = mid - 1;
            }
            }
            return false;

        }
         public static byte[] getFileBytes(String path) {
        byte[] bytes = null;
        try {
            bytes = Files.readAllBytes(Paths.get(path));
        }
        catch (
            IOException e) {
                e.printStackTrace();
            }
            return bytes;
        }
    }

