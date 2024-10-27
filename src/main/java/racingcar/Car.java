package racingcar;

public class Car {
    private String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }


}
