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
            return firstCornerX <= bar.firstCornerX || firstCornerY <= bar.firstCornerY || secondCornerX <= bar.secondCornerX || secondCornerY <= bar.secondCornerY;
        }
        if (other instanceof Point){
            Point point = (Point)other;
            return (firstCornerX <= point.getX() && point.getX() <= secondCornerX) && (firstCornerY <= point.getY() && point.getY() <= secondCornerY);
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bar bar = (Bar) o;
        return firstCornerX == bar.firstCornerX &&
                firstCornerY == bar.firstCornerY &&
                secondCornerX == bar.secondCornerX &&
                secondCornerY == bar.secondCornerY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstCornerX, firstCornerY, secondCornerX, secondCornerY);
    }
}
