import javafx.scene.canvas.GraphicsContext;

public class Column {

    public int value;
    public double[] color;
    public GraphicsContext context;

    public Column(int value, double[] color, GraphicsContext c){
        this.value = value;
        this.color = color;
        this.context = c;
    }



}
