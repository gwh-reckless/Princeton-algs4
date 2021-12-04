package sort;

import edu.princeton.cs.algs4.StdDraw;

public class SelectionAnimation extends SortingTemplate {

    public Double max;

    public void setMax(Comparable[] a) {
        max = (Double) a[0];
        for (int i = 1; i < a.length; i++) {
            if (less(max, a[i])) {
                max = (Double) a[i];
            }
        }
    }

    public void sort(Comparable[] a) {
        setMax(a);
        for (int i = 0; i < a.length; i++) {
            int least = i;
            for (int j = i; j < a.length; j++) {
                if (less(a[j], a[i])) {
                    least = j;
                }
            }
            show(a, i, least);
            exch(a, i, least);
            show(a, i, i);
        }
    }

    public void show(Comparable[] a, int start, int min) {
        int N = a.length;
        StdDraw.enableDoubleBuffering();
        StdDraw.clear();
        for (int i = 0; i < a.length; i++) {
            double x = 1.0 * i / N + 1.0 / (2 * N);
            double y = (double) a[i] / (max * 2);
            double rw = 0.5 / N;
            double rh = (double) a[i] / (max * 2);
            if (i < start) {
                StdDraw.setPenColor(StdDraw.GRAY);
            } else if (i == min) {
                StdDraw.setPenColor(StdDraw.RED);
            } else {
                StdDraw.setPenColor(StdDraw.BLACK);
            }
            StdDraw.filledRectangle(x, y, rw, rh);
        }
        StdDraw.show();
        StdDraw.pause(1000);
    }

    public static void main(String[] args) {
        sortDouble(new SelectionAnimation());
    }
}
