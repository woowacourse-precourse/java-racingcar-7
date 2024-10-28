package racingcar.domain;

public class Car {
    private String carName;
    private int currentDistances;
    private MoveStrategy moveStrategy;

    public Car(String carName, MoveStrategy moveStrategy) {
        this.carName = carName;
        this.moveStrategy = moveStrategy;
        currentDistances = 0;
    }

    public int move(){
        if(moveStrategy.isAllowedToAdvance())
            currentDistances++;
        return currentDistances;
    }

    public String getCarName() {
        return carName;
    }

    public int getCurrentDistances() {
        return currentDistances;
    }
}
