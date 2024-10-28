package racingcar.dto;

public class RacingCar {

    private final String Name;
    private String position;

    public RacingCar(String name, String position) {
        Name = name;
        this.position = position;
    }

    public String getName() {
        return Name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
