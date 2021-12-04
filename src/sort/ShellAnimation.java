/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package sort;

import edu.princeton.cs.algs4.StdDraw;

public class ShellAnimation extends SortingTemplate {
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
        int h = 1;
        int N = a.length;
        while (h < N / 3) {
            h *= 3;
            h += 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                show(a, i, i, h);
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                    show(a, i, j - h, h);
                }
                StdDraw.pause(1000);
            }
            h /= 3;
        }
    }

    public void show(Comparable[] a, int i_, int j_, int h) {
        int N = a.length;
        StdDraw.clear();
        StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(StdDraw.ORANGE);
        StdDraw.text(0.05, 0.95, "h:" + h);
        for (int i = 0; i < a.length; i++) {
            double x = 1.0 * i / N + 1.0 / (2 * N);
            double y = (double) a[i] / (2.1 * max);
            double rw = 0.5 / N;
            double rh = (double) a[i] / (2.1 * max);

            boolean sorting = (i_ - i) >= 0 && (i_ - i) % h == 0 ? true : false;
            if (i == j_) {
                StdDraw.setPenColor(StdDraw.RED);
            }
            else if (sorting) {
                StdDraw.setPenColor(StdDraw.BLACK);
            }
            else {
                StdDraw.setPenColor(StdDraw.GRAY);
            }

            StdDraw.filledRectangle(x, y, rw, rh);
        }
        StdDraw.show();
        StdDraw.pause(200);
    }

    public static void main(String[] args) {
        sortDouble(new ShellAnimation());
    }
}
