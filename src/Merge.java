import java.util.Arrays;

public class Merge extends Algo{

    public Merge(){
        this.name = "Merge sort";
    }

    @Override
    public void sort (int[] tab){

        this.start_time = System.nanoTime();
        this.merge_sort(tab);
    }


    private int[] merge_sort (int[] tab) {

        // gérer les cas de bases
        if (tab.length == 1){
            return tab;
        } else if ( tab.length == 2){
            if (tab[0] > tab[1]){
                Algo.swap(tab, 0, 1);
            } else return  tab;
        }

        int split = tab.length / 2;

        int[] left = merge_sort(Arrays.copyOf(tab, split));
        int[] right = merge_sort(Arrays.copyOfRange(tab, split, tab.length));

        return merge_tab(left, right);

    }

    private int[] merge_tab (int[] a, int[] b){

        int[] result = new int[a.length + b.length];

        int i = 0;
        int j = 0;
        int index = 0;

        while (i < a.length && j < b.length){
            if (a[i] < b[j]){
                result[index++] = a[i++];
            } else {
                result[index++] = b[j++];
            }
        }

        while (i < a.length){
            result[index++] = a[i++];
        }

        while (j < b.length){
            result[index++] = b[j++];
        }
        return result;
    }

}
