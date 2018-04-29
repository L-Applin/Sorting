public class SelectionAnim extends Algo{

    private Controller controller;

    public SelectionAnim(Controller controller){
        this.name = "Selection";
        this.controller = controller;
    }


    @Override
    public void sort(int[] tab) throws InterruptedException{

        this.start_time = System.nanoTime();

        for (int i = 0; i < tab.length - 1; i++) {

            int smallest = i;

            controller.highlightCurrent(tab, smallest);

            for (int j = i + 1; j < tab.length ; j++) {

                controller.highlightNext(tab, j);

                if (tab[j] < tab[smallest]){
                    smallest = j;
                    this.access++;
                }

                Thread.sleep(100);
            }
            // Algo.swap(tab, i, smallest);
            controller.highlightSwap(tab, i, smallest);
            int temp = tab[i];
            tab[i] = tab[smallest];
            tab[smallest] = temp;
        }
    }

}
