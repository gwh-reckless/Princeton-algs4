package sort;

public class InsertionIdiot extends SortingTemplate {
    public void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                // Use if here would be horrible, cause the loop will always run from i to 1
                // This became worse than selection sort
                // Like doulbe the time becuase of same compares and additional exchange
                if (less(a[j], a[j - 1]))
                    exch(a, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        sortDouble(new InsertionIdiot());
    }
}
