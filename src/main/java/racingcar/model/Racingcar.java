package racingcar.model;

public class Racingcar {
    private String carName;
    private int location;

    public Racingcar(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
        this.carName = carName;
        this.location = 0;
    }
    public String getCarName() {
        return carName;
    }
    public int getLocation() {
        return location;
    }

    public void moveRacingcar() {
        location++;
    }

}
