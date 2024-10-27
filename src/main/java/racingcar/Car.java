package racingcar;

public class Car {


    public Car(String name, int length, String distance) {
        this.name = name;
        this.length = length;
        this.distance = distance;
    }

    String name;
    int length;
    String distance;

    @Override
    public String toString() {
        return name + " : " + distance;
    }

    public String getName() {
        return name;
    }

    public void move(){
        this.length++;
        this.distance += "-";
    }

    public int lengthSize(){
        return this.length;
    }
}