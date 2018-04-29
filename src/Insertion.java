public class Insertion extends Algo {

    public Insertion(){

        this.name = "Insertion";

    }

    @Override
    public void sort(int[] tab) {

        this.start_time = System.nanoTime();

        for (int i = 1; i < tab.length; i++){ // SIZE OF THE SORTED SECTON
            for (int j = i; j > 0; j--){    // insert tab[j] where it belongs

                if (tab[j] < tab[j-1]) {
                    Algo.swap(tab, j, j - 1);
                    this.access++;
                }

            }
        }

    }
}
