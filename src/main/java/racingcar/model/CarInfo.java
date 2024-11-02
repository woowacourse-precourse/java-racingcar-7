package racingcar.model;


public class CarInfo {

    private final String carName;
    public long moveCount;


    public CarInfo(String name) {
        this.carName = name;
        moveCount = 0;
    }

    public String getCarName() {
        return this.carName;
    }




}
