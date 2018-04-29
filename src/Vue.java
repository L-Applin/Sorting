import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Vue {

    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 600;

    public Stage primaryStage;
    public GraphicsContext context;
    public Controller controller;
    public Algo currentAlgo;

    public Vue(Stage primaryStage){

        this.primaryStage = primaryStage;

        VBox root = new VBox();
        Pane pane = new Pane();
        Scene scene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT + 40);
        Canvas canvas = new Canvas(SCREEN_WIDTH, SCREEN_HEIGHT);
        pane.getChildren().add(canvas);
        root.getChildren().add(pane);

        HBox buttonGroup = new HBox();
        buttonGroup.setSpacing(20);

        Button buttonShuffle = new Button("Shuffle array");
        Button buttonSort = new Button("Sort Array");
        buttonGroup.getChildren().addAll(buttonShuffle, buttonSort);

        root.setAlignment(Pos.BASELINE_CENTER);
        buttonGroup.setAlignment(Pos.BASELINE_CENTER);

        root.getChildren().add(buttonGroup);

        buttonShuffle.setOnAction((event) -> {
            context.fillRect(0,0,context.getCanvas().getWidth(), context.getCanvas().getHeight());
            int[] newRandomArray = Sorting.iota(Sorting.ARRAY_SIZE);
            controller.setCurrentArray(newRandomArray);
            Algo.shuffle(newRandomArray, 4, true);
            this.drawArray(newRandomArray);
        });

        buttonSort.setOnAction( (event) -> {
            context.fillRect(0,0,context.getCanvas().getWidth(), context.getCanvas().getHeight());

            try {
                controller.sortArray(currentAlgo);
            } catch (Exception e){
                e.printStackTrace();
            }

            this.drawArray(controller.getCurrentArray());
        });

        this.context = canvas.getGraphicsContext2D();
        context.fillRect(0,0,context.getCanvas().getWidth(), context.getCanvas().getHeight());

        context.translate(0, SCREEN_HEIGHT);
        context.scale(1, -1);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void drawArray(int[] tab){

        int max = 0;
        int rectWidth = (int) SCREEN_WIDTH / tab.length;

        for (int i : tab){
            if (i > max){
                max = i;
            }
        }

        for (int i = 0; i < tab.length; i++){

            int current = tab[i];
            int rectHeight = (int) (SCREEN_HEIGHT *  ( (double) current / max));
            this.context.setFill(Color.hsb(100 + ((double) rectHeight/(double)SCREEN_HEIGHT) * 125, 1, 1));
            this.context.fillRect(i * rectWidth, 0, rectWidth, rectHeight);

        }
        context.setFill(Color.BLACK);
    }

    public void setController(Controller controller){
        this.controller = controller;

    }

    public void setAlgo(Algo algo){
        this.currentAlgo = algo;
    }

    public static void highlightIndex(int[] tab, int indexA, String color){

        switch (color) {

            case "red":
                break;
            case "green":
                break;
            case "blue":
        }

    }

}
