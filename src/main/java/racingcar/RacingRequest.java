package racingcar;

public class RacingRequest {
    private String carNameList;
    private int raceMovement;

    public void setCarNameList(String carNameList) {
        this.carNameList = carNameList;
    }

    public void setMovement(String movement) {
        this.raceMovement = Integer.parseInt(movement);
    }

    public String getCarNameList() {
        return carNameList;
    }

    public int getRaceMovement() {
        return raceMovement;
    }
}
