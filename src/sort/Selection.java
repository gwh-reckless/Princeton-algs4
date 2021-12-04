/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package sort;

public class Selection extends SortingTemplate {


    public void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int least = i;
            for (int j = i; j < a.length; j++) {
                if (less(a[j], a[least])) {
                    least = j;
                }
            }
            exch(a, i, least);
        }
    }


    public static void main(String[] args) {
        // sortDouble(new Selection());

    }
}
