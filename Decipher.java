package Decipher;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Decipher {
    public static void main(String[] args) {
        int m = (int)Math.pow(2,7); //sets m to 128
        char[] cipher = new char[ m ]; //creates a char array named cipher of length 128
        for(int i = 0; i < m; i++) { //loops from 0 to 127
            cipher[i] = (char) mod (55 * (i - 3) , m );//55*i+91 //fills the cipher array with the appropriate characters
            String plain = read("cipher.txt");
             for (int j = 0; j < plain.length(); j++)
                     System.out.print(cipher[plain.charAt(j)]);
                }
            }
        
            public static String read (String path) {
                String ret = null;
                try{
                    ret = new String(Files.readAllBytes(Paths.get(path)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return ret;
             }
             public static int mod(int x, int n) {
                return((x%n)+ n) %n;
             }
            
            
            
            
            }

        
    
