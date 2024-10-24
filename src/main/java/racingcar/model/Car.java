package racingcar.model;

public class Car {
    String name;
    int position; //위치를 나타냄..흠 이걸 여기에 두는게 맞을까 싶음.

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }


}
