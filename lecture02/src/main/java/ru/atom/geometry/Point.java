package ru.atom.geometry;

import java.util.Objects;

/**
 * Template class for
 */
public class Point implements Collider /* super class and interfaces here if necessary */ {
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // fields
    // and methods
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean isColliding(Collider other) {
        if (other instanceof Point)
            return this.equals(other);
        if (other instanceof Bar){
            Bar bar = (Bar)other;
            return (bar.getFirstCornerX() <= x && x <= bar.getSecondCornerX()) && (bar.getFirstCornerY() <= y && y <= bar.getSecondCornerY());
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }
}
