package newtonlines;

public class Line {
    private final Coordinate a;
    private final Coordinate b;
    private static final GraphicsContext gc = NewtonLines.getGC();
    
    public Line (Coordinate a, Coordinate b) {
        if (!a.equals(b)) {
            this.a = a;
            this.b = b;
        } else {
            this.a = a;
            this.b = new Coordinate(a.getX() + 1, a.getY());
        }
        draw();
    }
    
    private double getM() {
        return (a.getY() - b.getY()) / (a.getX() - b.getX());
    }
    
    private double getB() {
        return -(getM() * a.getX) / a.getY();
    }
    
    private void draw() {
        gc.moveTo(a.getX(), a.getY());
        gc.lineTo(b.getX(), b.getY());
        
        gc.moveTo(0, Graph.toCanvas(getB()));
        gc.lineTo(Graph.toCanvas(1), Graph.toCanvas(getM() + getB()));
        
        gc.stroke();
    }
}
