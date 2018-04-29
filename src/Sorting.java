import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Sorting extends Application{

    public static final int ARRAY_SIZE = 100;
    public static final int UPDATE_TIME = 500; // in ms


    public void start(Stage primaryStage) {

        Vue vue = new Vue(primaryStage);
        Controller controller = new Controller(vue);
        vue.setController(controller);
        vue.setAlgo(new Selection());

        int[] test = iota(ARRAY_SIZE);
        Algo.shuffle(test, 4, true);
        controller.setCurrentArray(test);

        vue.drawArray(test);

        Benchmark benchmark = new Benchmark(test);
        // benchmark.execute();

    }


    protected static int[] iota(int n){
        int[] result = new int[n];
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }
        return result;
    }


    protected static int arrayMax(int[] arr) {
        int max = Integer.MIN_VALUE;

        for(int cur: arr)
            max = Math.max(max, cur);

        return max;
    }


    public static void print(int[] tab){

        StringBuffer output = new StringBuffer();
        output.append("[ ");
        for (int i = 0; i < tab.length - 1; i++) {
            output.append(tab[i]).append(", ");
            if ((i + 1) % 15 == 0){
                output.append("\n");
            }
        }
        output.append(tab[tab.length-1]).append(" ]");
        System.out.println(output);
    }

    public static void main(String[] args){
        launch(args);
    }


}
