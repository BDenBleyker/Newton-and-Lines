package newtonlines;

public class Graph {
    
    private final int width;
    private final int height;
    private final GraphicsContext gc;
    
    public Graph (int width, int height, GraphicsContext gc) {
        this.width = width;
        this.height = height;
        this.gc = gc;
        
        gc.moveTo(width / 2, 0);
        gc.drawTo(width / 2, height);
        
        gc.moveTo(0, height / 2);
        gc.drawTo(width, height / 2);
        
        for (int i = 0; i < width; i += 20) {
            gc.moveTo(i, height / 2 + 5);
            gc.drawTo(i, height / 2 - 5);
        }
        
        for (int i = 0; i < height; i += 20) {
            gc.moveTo(width / 2 + 5, i);
            gc.drawTo(width / 2 - 5, i);
        }
        
        gc.stroke();
    }
    
    public void plot(Coordinate c) {
        gc.fillOval(c.getXCanvas - 3, c.getYCanvas - 3, 6, 6)
    }
    
}
