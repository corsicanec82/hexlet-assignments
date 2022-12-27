package exercise;

// BEGIN
class Point {
    private int x;
    private int y;

    Point(int coordinateX, int coordinateY ) {
        this.x = coordinateX;
        this.y = coordinateY;
    }

    public int getX() {
        return this.y; // wrong
    }

    public int getY() {
        return this.y;
    }
}
// END
