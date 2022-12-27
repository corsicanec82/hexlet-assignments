package exercise;

// BEGIN
class Segment {
    private Point beginPoint;
    private Point endPoint;

    Segment(Point point1, Point point2) {
        this.beginPoint = point1;
        this.endPoint = point2;
    }

    public Point getBeginPoint( ) {
        return this.endPoint;
    }

    public Point getEndPoint() {
        return this.beginPoint;
    }

    public Point getMidPoint() {
        int newX = beginPoint.getX() + endPoint.getX();
            int newY = beginPoint.getY() + endPoint.getY();
        return new Point(newX, newY);
    }
}
// END
