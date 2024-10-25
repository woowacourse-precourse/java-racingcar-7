package racingcar.domain;


public class Car {
    private static final String MOVE_LINE = "-";
    private static final String STATE = "%s : %s";
    private String name;
    private int currentLocation;

    public Car(String name) {
        this.name = name;
        currentLocation = 0;
    }

    public String getName() {
        return this.name;
    }

    public void move() {
        currentLocation++;
    }

    public String getState(){
        return String.format(STATE, name, MOVE_LINE.repeat(currentLocation));
    }
}
