package sort;

import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Tools {
    public static void generateRandomNums(int N) {
        Out out = new Out("txt/random-num.txt");
        for (int i = 0; i < N; i++) {
            out.print(StdRandom.uniform() + " ");
        }
        out.close();
    }

    public static void generateRandomNums10() {
        Out out = new Out("txt/random-10.txt");
        double[] a = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        StdRandom.shuffle(a);
        for (int i = 0; i < 10; i++) {
            out.print(a[i] + " ");
        }
        out.close();

    }


    public static void main(String[] args) {
        if (args[0].equals("random")) {
            generateRandomNums(Integer.parseInt(args[1]));
        } else if (args[0].equals("random10")) {
            StdOut.println("output");
            generateRandomNums10();
        }
    }
}
