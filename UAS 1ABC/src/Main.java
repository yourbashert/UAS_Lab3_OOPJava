// Interface
interface Calculatable {
    double calculate();
}

// Superclass (kelas induk)
class Shape {
    public double calculate(){
        return 0;
    }
}

class Circle extends Shape implements Calculatable {
    private double r;
    public Circle(double r){
        this.r = r;
    }
    public double calculate(){
        return Math.PI * r * r;
    }
}

class Rectangle extends Shape implements Calculatable {
    private double p;
    private double l;
    public Rectangle(double p, double l){
        this.p = p;
        this.l = l;
    }

    public double calculate(){
        return p*l;
    }
}

// Kelas utama
public class Main {
    public static void main(String[] args) {
        Calculatable shape1 = new Circle(7);
        Calculatable shape2 = new Rectangle(4,9);

        double bgndatar1 = shape1.calculate();
        double bgndatar2 = shape2.calculate();

        System.out.println("Luas lingkaran : " + bgndatar1);
        System.out.println("Luas Persegi Panjang : " + bgndatar2);
    }
}