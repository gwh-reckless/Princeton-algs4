package sort;

import edu.princeton.cs.algs4.StdRandom;

public class Quick extends SortingTemplate {
    public void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v)) if (i == hi) break; // a[i] > v now

            while (less(v, a[--j])) if (j == lo) break; // a[j] < v now
            if (i >= j) break;
            exch(a, i, j); // we exhange a[i] and a[j]
        }
        exch(a, lo, j);
        return j;
    }

    public static void main(String[] args) {
        sortDouble(new Quick());
    }
}
