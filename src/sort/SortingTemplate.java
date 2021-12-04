/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package sort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SortingTemplate {

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }


    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }


    public static void sortString(SortingTemplate st) {
        String[] a = StdIn.readAllStrings();
        StdOut.println("Before Sorting:");
        show(a);
        StdOut.println("-----------------------------------");
        StdOut.println("After Sorting:");
        st.sort(a);
        show(a);
        assert isSorted(a);
    }

    public static void sortDouble(SortingTemplate st) {
        double[] aPrimitive = StdIn.readAllDoubles();
        Double[] a = new Double[aPrimitive.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = aPrimitive[i];
        }
        StdOut.println("Before Sorting:");
        show(a);
        StdOut.println("-----------------------------------");
        StdOut.println("After Sorting:");
        st.sort(a);
        show(a);
        assert isSorted(a);
    }

    public void sort(Comparable[] a) {
        StdOut.println("Template do not sort");
    }

    public static void main(String[] args) {
        sortString(new SortingTemplate());
    }
}
