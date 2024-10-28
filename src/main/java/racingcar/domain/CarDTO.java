package racingcar.domain;

public class CarDTO {
    private String carName;
    private int goStraight;

    public CarDTO(String carName, int goStraight) {
        this.carName = carName;
        this.goStraight = goStraight;
    }

    public String getCarName() {
        return carName;
    }

    public int getGoStraight() {
        return goStraight;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public  void setGoStraight(int goStraight) {
        this.goStraight = goStraight;
    }

}
