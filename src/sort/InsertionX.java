/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package sort;

public class InsertionX extends SortingTemplate {
    public void sort(Comparable[] a) {
        int least = 0;
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[least])) {
                least = i;
            }
        }
        exch(a, least, 0);

        for (int i = 2; i < a.length; i++) {
            Comparable tmp = a[i];
            int j;
            for (j = i; less(tmp, a[j - 1]); j--) {
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }

    }

    public static void main(String[] args) {
        sortDouble(new InsertionX());
    }
}
