/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package sort;

import edu.princeton.cs.algs4.StdDraw;

public class InsertionAnimation extends SortingTemplate {
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
        for (int i = 1; i < a.length; i++) {
            Comparable tmp = a[i];
            int j;

            show(a, i, i);
            for (j = i; j > 0 && less(tmp, a[j - 1]); j--) {
                a[j] = a[j - 1];
            }
            a[j] = tmp;
            show(a, i, j);
        }
    }

    public void show(Comparable[] a, int start, int end) {
        int N = a.length;
        StdDraw.clear();
        StdDraw.enableDoubleBuffering();
        for (int i = 0; i < a.length; i++) {
            double x = 1.0 * i / N + 1.0 / (2 * N);
            double y = (double) a[i] / (2 * max);
            double rw = 0.5 / N;
            double rh = (double) a[i] / (2 * max);

            // if (i == cur) {
            //     StdDraw.setPenColor(StdDraw.BLUE);
            // }

            if (i <= start && i > end) {
                StdDraw.setPenColor(StdDraw.BLACK);
            }
            else if (i == end) {
                StdDraw.setPenColor(StdDraw.RED);
            }
            else {
                StdDraw.setPenColor(StdDraw.GRAY);
            }
            StdDraw.filledRectangle(x, y, rw, rh);
        }
        StdDraw.show();
        StdDraw.pause(1000);
    }

    public static void main(String[] args) {
        sortDouble(new InsertionAnimation());
    }
}
