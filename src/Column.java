import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Column {

    public int value;
    private int rectHeight;
    private double color;
    private GraphicsContext context;

    private static final int rect_width = Vue.SCREEN_WIDTH / Sorting.ARRAY_SIZE;

    public Column(int value, GraphicsContext c){
        this.value = value;
        this.rectHeight = (int) (Vue.SCREEN_HEIGHT *  ( (double) value / Sorting.ARRAY_SIZE + 2));
        this.color = 100 + ((double) rectHeight/(double) Vue.SCREEN_HEIGHT) * 125;
        this.context = c;

    }

    public void draw(int xPos){

        this.context.setFill(Color.hsb(this.color, 1, 1));
        this.context.fillRect(xPos * rect_width, 0, rect_width, this.rectHeight);

    }

    public void highlight(double h){
        this.color = h;
    }


}
