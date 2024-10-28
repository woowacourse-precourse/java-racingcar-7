package racingcar;

public class RacingRequest {
    private String carNameList;
    private int movement;

    public void setCarNameList(String carNameList) {
        this.carNameList = carNameList;
    }

    public void setMovement(String movement) {
        this.movement = Integer.parseInt(movement);
    }

    public String getCarNameList() {
        return carNameList;
    }

    public int getMovement() {
        return movement;
    }
}
