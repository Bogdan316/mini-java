//package org.example;
class Main {
    public static void main(String[] args) {
        System.out.println(new TestShape());
    }
}

class Circle extends Shape {
    int radius;

    public int print() {
        System.out.println(x);
        System.out.println(y);
        System.out.println(radius);
        return 0;
    }
}

class Rectangle extends Shape {
    int width;
    int height;

    public int print() {
        System.out.println(x);
        System.out.println(y);
        System.out.println(width);
        System.out.println(height);
        return 0;
    }
}


class Shape {
    int x;
    int y;

    public int print() {
        Circle c;
        return 0;
    }

    public int translate(int dx, int dy) {
        x = x + dx;
        y = y + dy;
        return 0;
    }
}

class TestShape {
    public int test() {
        Shape s;
        Rectangle r;
        Circle c;
        int[] d;

        r = new Rectangle();
        c = new Circle();

        s = r;
        s = c;

        s.print();
        s.translate(1, 1);
        s.print();

        c.print();
        c.translate(2, 2);
        c.print();

        return 0;
    }
}