package racingcar.Dto;

public class CarData {
    private final String carName;
    private final int distance;

    public CarData(String carName, int distance) {
        this.carName = carName;
        this.distance = distance;
    }
    public String getCarName(){
        return carName;
    }

    public int getDistance(){
        return distance;
    }
}
