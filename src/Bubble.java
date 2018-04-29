public class Bubble extends Algo {

    public Bubble(){
        this.name = "Bubble";
    }

    @Override
    public void sort(int[] tab){

        this.start_time = System.nanoTime();

        for (int i = 0; i < tab.length;i++){
            for (int j = 0; j < tab.length - i - 1; j++){
                // highlight tab[j] > tab[j+1]
                if (tab[j] > tab[j+1]) {
                    Algo.swap(tab, j, j+1);
                    // afficher le swap
                    this.access++;

                }
            }

        }


    }
}
