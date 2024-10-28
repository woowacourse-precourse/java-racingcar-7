package racingcar.domain;

public class Car {
    private String carName;
    private int currentDistances;

    public Car(String carName) {
        this.carName = carName;
        currentDistances = 0;
    }

    public int move(){
        if(RandomMoveStrategy.randomMoveStrategy())
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
