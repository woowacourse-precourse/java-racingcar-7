package racingcar.domain;

public class Car {
    
    private String carName;
    private int moveDistance;
    
    public Car(String carName) {
        this.carName = carName;
    }
    
    public String getCarName() {
        return carName;
    }
    
    public int getMoveDistance() {
        return moveDistance;
    }
    
    public void plusDistance() {
        moveDistance++;
    }
}
