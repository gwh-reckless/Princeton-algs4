package sort;

public class InsertionNoExch extends SortingTemplate {
    public void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            int j;
            Comparable tmp = a[i];
            for (j = i; j > 0 && less(tmp, a[j - 1]); j--) {
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }
    }

    public static void main(String[] args) {
        sortDouble(new InsertionNoExch());
    }
}
