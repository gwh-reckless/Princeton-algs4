package sort;
public class MaxPQ{
    // binary heap
    private Key[] pq;

    private int N = 0;

    public MaxPQ(int maxN){
        pq = (Key[]) new Comparable[maxN+1];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size()
    {
        return N;
    }

    public void insert(Key v){
        pq[++N] = v;
        swim(N);
    }

    public Key deleteMax(){
        Key max = pq[1];
        exch(1, N--);
        pq[N+1] = null;
        sink(1);
        return max;
    }

    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j){
        Key tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

    private void swim(int k){
        int parent = k/2;
        while(less(parent,k))
            k = parent;
            if(k == 1) return;
            parent = k/2;
        }
    }

    private void sink(int k){
        
        int children1 = 2*k;
        int children2 = 2*k + 1;
        int children = children1;
        if(less(children1, children2)){
            children = children2;
        }
        while(less(k,children)){
            exch(k,children);
            k = children;
            if(k = N) break;
            children1 = 2*k;
            children2 = 2*k + 1;
            children = children1;
            if(less(children1, children2)){
                children = children2;
            }
        }
    }
}
