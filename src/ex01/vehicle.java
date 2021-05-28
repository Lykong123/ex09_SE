package ex01;

abstract class Bike{
    abstract void run();
}
class vehicle extends Bike {
    void run(){System.out.println("bike is running safely");}
    public static void main(String args[]){
        Bike obj = new vehicle();
        obj.run();
    }
}