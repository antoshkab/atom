package ru.atom.geometry;

import java.util.Objects;

public class Bar implements Collider {

    public int getFirstCornerX() {
        return firstCornerX;
    }

    public int getFirstCornerY() {
        return firstCornerY;
    }

    public int getSecondCornerX() {
        return secondCornerX;
    }

    public int getSecondCornerY() {
        return secondCornerY;
    }

    private int firstCornerX;
    private int firstCornerY;
    private int secondCornerX;
    private int secondCornerY;

    public Bar(int firstCornerX, int firstCornerY, int secondCornerX, int secondCornerY) {
        this.firstCornerX = firstCornerX;
        this.firstCornerY = firstCornerY;
        this.secondCornerX = secondCornerX;
        this.secondCornerY = secondCornerY;
    }

    @Override
    public boolean isColliding(Collider other) {
        if (other instanceof Bar) {
            Bar bar = (Bar)other;

            int denom = (firstCornerX - secondCornerX) * (bar.firstCornerY - bar.secondCornerY) - (firstCornerY - secondCornerY) * (bar.firstCornerX - bar.secondCornerX);
            if (denom != 0) {
                int x = ((firstCornerX * secondCornerY - firstCornerY * secondCornerX) * (bar.firstCornerX - bar.secondCornerX) - (firstCornerX - secondCornerX) * (bar.firstCornerX * bar.secondCornerY - bar.firstCornerY * bar.secondCornerX))
                        / denom;
                int y = ((firstCornerX * secondCornerY - firstCornerY * secondCornerX) * (bar.firstCornerY - bar.secondCornerY) - (firstCornerY - secondCornerY) * (bar.firstCornerX * bar.secondCornerY - bar.firstCornerY * bar.secondCornerX))
                        / denom;

                //Point point = new Point(x, y);
                return true;
                //return barContainsPoint(point) || bar.barContainsPoint(point);
            }

            Point point1 = new Point(firstCornerX, firstCornerY);
            Point point2 = new Point(secondCornerX, secondCornerY);
            if (bar.barContainsPoint(point1) || bar.barContainsPoint(point2))
                return true;
            point1 = new Point(bar.firstCornerX, bar.firstCornerY);
            point2 = new Point(bar.secondCornerX, bar.secondCornerY);
            if (barContainsPoint(point1) || barContainsPoint(point2))
                return true;
        }
        if (other instanceof Point){
            Point point = (Point)other;
            return barContainsPoint(point);
        }
        return false;
    }

    private boolean barContainsPoint(Point point){
        return (firstCornerX <= point.getX() && point.getX() <= secondCornerX) && (firstCornerY <= point.getY() && point.getY() <= secondCornerY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bar bar = (Bar) o;
        return (firstCornerX - secondCornerX) * (bar.firstCornerY - bar.secondCornerY) - (firstCornerY - secondCornerY) * (bar.firstCornerX - bar.secondCornerX) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstCornerX, firstCornerY, secondCornerX, secondCornerY);
    }
}
