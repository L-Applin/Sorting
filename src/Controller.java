
public class Controller {

    public Vue vue;
    private int[] currentArray;

    public Controller(Vue vue) {
        this.vue = vue;
    }

    public void setCurrentArray(int[] tab){
        this.currentArray = tab;
    }

    public int[] getCurrentArray(){
        return currentArray;
    }

    public void sortArray(Algo algo) throws InterruptedException {
        algo.sort(this.currentArray);
    }

    public void highlightCurrent(Column[] tab, int i){
        vue.highlightIndex(tab, i, "red");
    }

    public void highlightNext(Column[] tab, int i){
        vue.highlightIndex(tab, i, "green");

    }

    public void highlightSwap(Column[] tab, int i, int j){

    }


    public void updateDisplay(){

        vue.drawArray(currentArray);

    }
}
