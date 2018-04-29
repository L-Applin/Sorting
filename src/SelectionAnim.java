public class SelectionAnim extends Algo implements ColumnSort {

    private Controller controller;

    public SelectionAnim(){
        this.name = "Selection";

    }

    public void setController(Controller c){
        this.controller = c;
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


    public void sort(Column[] tab) throws InterruptedException{

        this.start_time = System.nanoTime();

        for (int i = 0; i < tab.length - 1; i++) {

            int smallest = i;

            controller.highlightCurrent(tab[smallest]);

            for (int j = i + 1; j < tab.length ; j++) {

                controller.highlightNext(tab[j]);

                if (tab[j].value < tab[smallest].value){
                    smallest = j;
                    this.access++;
                }

                Thread.sleep(100);

                controller.updateDisplay(tab);

            }

            // Algo.swap(tab, i, smallest);
            controller.highlightSwap(tab[i], tab[smallest]);
            Column temp = tab[i];
            tab[i] = tab[smallest];
            tab[smallest] = temp;

            controller.updateDisplay(tab);
        }
    }

}
