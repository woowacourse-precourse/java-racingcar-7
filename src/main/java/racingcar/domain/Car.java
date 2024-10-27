package racingcar.domain;

public class Car {
    private final String name;
    private int location = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int randomNum) {
        if(isMovable(randomNum)) {
            location ++;
        }
    }

    private boolean isMovable(int randomNum) {
        if (randomNum >= 4) {
            return true;
        }
        return false;
    }

    public int getLocation() {
        return this.location;
    }

    public String getName() {
        return name;
    }

}
