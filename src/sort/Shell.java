/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package sort;

public class Shell extends SortingTemplate {
    public void sort(Comparable[] a) {
        int h = 1;
        int N = a.length;
        while (h < N / 3) {
            h *= 3;
            h += 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                Comparable tmp = a[i];
                int j;
                for (j = i; j >= h && less(tmp, a[j - h]); j--) {
                    a[j] = a[j - h];
                }
                a[j] = tmp;
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {
        sortDouble(new Shell());
    }
}
