import javafx.application.Application;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Sorting extends Application{

    public static final int ARRAY_SIZE = 100;
    public static final int UPDATE_TIME = 500; // in ms
    public static Algo CURRENT_ALGO = new SelectionAnim();


    public void start(Stage primaryStage) {

        Vue vue = new Vue(primaryStage);
        Controller controller = new Controller(vue);
        vue.setController(controller);
        vue.setAlgo(CURRENT_ALGO);

        ((SelectionAnim) CURRENT_ALGO).setController(controller);

        int[] test = iota(ARRAY_SIZE);
        Column[] testColumn = initArray(ARRAY_SIZE, vue.context);
        Algo.shuffle(test, 4, true);
        controller.setCurrentArray(testColumn);

        Algo.shuffle(testColumn, 4, true);
        vue.drawArray(testColumn);

        // Benchmark benchmark = new Benchmark(test);
        // benchmark.execute();

    }

    protected static Column[] initArray(int n, GraphicsContext c){

        Column[] result = new Column[n];

        for (int i = 0; i < result.length; i++) {
            result[i] = new Column(i, c);
        }

        return result;

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
