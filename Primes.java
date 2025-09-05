package Code;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Primes {
    public static void main(String[] args) {
        double startTime = System.nanoTime();
        long[] primes = getCumulativeSums();
        double duration = (System.nanoTime() - startTime) / Math.pow(10, 9);
        System.out.printf("%nTime taken: %.2f seconds%n", duration);

        System.out.print("First 15: ");
        System.out.println("2 3");
        for (int i = 0; i < 15; i++) {
            System.out.print(primes[i] + " ");
        }
        System.out.print("\nLast 5: ");
        for (int i = primes.length - 5; i < primes.length; i++) {
            System.out.print(primes[i] + " ");
        }



    }


    public static long[] getCumulativeSums() {//cumulative sum method
        byte[] bytes = getFileBytes("half_gaps.bin");
        int[] gaps = new int[bytes.length];
        long cumulativeSum = 0;
        long[] transformed = new long[bytes.length];//array to store values after cumulative sum is done
        for (int i = 0; i < bytes.length; i++) {
            gaps[i] = Byte.toUnsignedInt(bytes[i]);
            cumulativeSum += gaps[i];
            transformed[i] = cumulativeSum * 2 + 3;
        }
        return transformed;
    }


    public static byte[] getFileBytes(String path) {
        byte[] bytes = null;
        try {
            bytes = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

}
