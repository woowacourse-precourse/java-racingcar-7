package racingcar.model;

public class RacingCar {

    private String carName;
    private int position;

    public RacingCar(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    void move(boolean isMovable){
        if(isMovable){
            this.position++;
        }
    }
}