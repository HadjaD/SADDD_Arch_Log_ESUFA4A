package utils;


public class Surface {
    private final int lowerBoundCoordinateX = 0;
    private final int lowerBoundCoordinateY = 0;
    private final int upperBoundCoordinateX;
    private final int upperBoundCoordinateY;

    public Surface(int upperBoundCoordinateX, int upperBoundCoordinateY) {
        this.upperBoundCoordinateX = upperBoundCoordinateX;
        this.upperBoundCoordinateY = upperBoundCoordinateY;
    }

    public int getUpperBoundCoordinateX() {
        return upperBoundCoordinateX;
    }

    public int getUpperBoundCoordinateY() {
        return upperBoundCoordinateY;
    }

    public int getLowerBoundCoordinateX() {
        return lowerBoundCoordinateX;
    }

    public int getLowerBoundCoordinateY() {
        return lowerBoundCoordinateY;
    }
}

