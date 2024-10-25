package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {

    private String carName;
    private String position;

    public RacingCar(String carName, String position) {
        this.carName = carName;
        this.position = position;
    }

    public String getCarName() {
        return carName;
    }

    public String getPosition() {
        return position;
    }

    void move(boolean isMovable){
        if(isMovable){
            this.position += "-";
        }
    }

}