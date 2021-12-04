package sort;

import edu.princeton.cs.algs4.StdDraw;

public class MergeAnimation extends Merge {
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
        super.sort(a);
    }

    public void sort(Comparable[] a, int lo, int hi) {
        // Sort a[lo..hi]
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        show(a, lo, mid, hi);
        merge(a, lo, mid, hi);
        show(a, lo, mid, hi);
    }

    public void show(Comparable[] a, int lo, int mid, int hi) {
        int N = a.length;
        StdDraw.enableDoubleBuffering();
        StdDraw.clear();
        for (int i = 0; i < a.length; i++) {
            double x = 1.0 * i / N + 1.0 / (2 * N);
            double y = (double) a[i] / (max * 2);
            double rw = 0.5 / N;
            double rh = (double) a[i] / (max * 2);
            if (i == mid) {
                StdDraw.setPenColor(StdDraw.BLUE);
            } else if (i >= lo && i <= hi) {
                StdDraw.setPenColor(StdDraw.BLACK);
            } else if (i < lo) {
                StdDraw.setPenColor(StdDraw.MAGENTA);
            } else {
                StdDraw.setPenColor(StdDraw.GRAY);
            }

            StdDraw.filledRectangle(x, y, rw, rh);
        }
        StdDraw.show();
        StdDraw.pause(1000);
    }


    public static void main(String[] args) {
        sortDouble(new MergeAnimation());
    }
}
