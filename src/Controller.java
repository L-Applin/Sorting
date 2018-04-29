
public class Controller {

    public Vue vue;
    private Column[] currentArray;

    public Controller(Vue vue) {
        this.vue = vue;
    }

    public void setCurrentArray(Column[] tab){
        this.currentArray = tab;
    }

    public Column[] getCurrentArray(){
        return currentArray;
    }

    // TODO : make this method wor with Column Arrays
    public void sortArray(Algo algo) throws InterruptedException {
        algo.sort(this.currentArray);
    }

    public void highlightCurrent(Column col){
        vue.highlightIndex(col, "red");
    }

    public void highlightNext(Column col){
        vue.highlightIndex(col, "green");

    }

    public void highlightSwap(Column i, Column j){

    }


    public void updateDisplay(Column[] tab){

        vue.drawArray(currentArray);

    }
}
