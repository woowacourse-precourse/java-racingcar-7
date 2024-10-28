package racingcar.model;

public class Car {

    private static final String CAR_POSITION = "-";
    private final String name;
    private Integer position;
    private String currentPosition = "";

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }


    public String getName() {
        return name;
    }


    public Integer getPosition() {
        return position;
    }


    public String getCurrentPosition() {
        return currentPosition;
    }


    public void moveCarPosition() {
        position += 1;
        currentPosition += CAR_POSITION;
    }

}
