package Code;


public class Fibonacci {
    public static void main(String [] args) {
        if (args.length < 1) {// checking if value for n was given
            System.out.println("Please enter n.");
            return;
        }

    int[] fibonacci = new int[Integer.parseInt(args[0])];//array to store fib numbers
    fibonacci[0] = 0;
    fibonacci[1] = 1;

    for (int i = 2; i < fibonacci.length; i++) {//for loop to calculate fibonacci
        fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        System.out.println(fibonacci[i]);
    }
    }
    public static int fibonacci(int i, int[] arr, String level) {//recursive fibononacci
        System.out.println(level + "f(" + i + ")");
        if(i<2)
        return arr[i] = i;
        return arr [i] = fibonacci(i-1, arr, level + "  ") + fibonacci(i-2, arr, level + "  ");
    

    }
    
}
