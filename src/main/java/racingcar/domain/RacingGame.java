package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RacingGame {

    final List<Car> playRacingCarList;
    public RacingGame(List<Car> playRacingCarList){

        this.playRacingCarList = playRacingCarList;
    }

    private void moveForwardCar(Car car){

        if(isGreaterThanOrEqualFour()){
            car.moveCarForward();
        }
    }

    private boolean isGreaterThanOrEqualFour() {

        return generateRandomNumberZeroToNine() >= 4;
    }

    private int generateRandomNumberZeroToNine(){

        return Randoms.pickNumberInRange(0, 9);
    }
}
