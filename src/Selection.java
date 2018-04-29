public class Selection extends Algo{


    public Selection(){
        this.name = "Selection";
    }


    @Override
    public void sort(int[] tab){

        this.start_time = System.nanoTime();

        for (int i = 0; i < tab.length - 1; i++) {

            int smallest = i;

            for (int j = i + 1; j < tab.length ; j++) {

                if (tab[j] < tab[smallest]){
                    smallest = j;
                    this.access++;
                }
            }
            Algo.swap(tab, i, smallest);
        }
    }

}
