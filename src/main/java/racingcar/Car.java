package racingcar;

public class Car {

    String name;
    int pos = 0;

    Car(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return pos;
    }
}
