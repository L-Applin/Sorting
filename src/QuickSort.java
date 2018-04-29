public class QuickSort extends Algo {

    public QuickSort(){
        this.name = "Quicksort";
    }

    @Override
    public void sort(int[] tab) {

        this.start_time = System.nanoTime();

        this.quickSort(tab, 0, tab.length - 1);
    }


    private void quickSort ( int[] tab, int lo, int hi)
    {
        if (lo < hi) {

            // find pivot

            int pivot = this.partition(tab, lo, hi);

            quickSort(tab, lo, pivot - 1);
            quickSort(tab, pivot + 1, hi);
        }
    }


    private int partition (int[] tab, int lo, int hi) {
        int small_index = lo;

        for (int current_index = lo; current_index < hi; current_index++)
        {
            if (tab[current_index] < tab[hi])
            {
                Algo.swap(tab, current_index, small_index);
                small_index++;
                this.access++;
            }
        }
        swap(tab, hi, small_index);
        return small_index;
    }


}
