package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class RacingGame {
    private List<Racingcar> racingcars;
    private int moveCount;
    private int moveForwardCondition=4;

    public RacingGame(List<Racingcar> racingcars, int moveCount) {
        this.racingcars = racingcars;
        this.moveCount = moveCount;
    }



    public void MoveRacingcars() {
       for(Racingcar racingcar : racingcars) {
           int randomValue = Randoms.pickNumberInRange(0, 9);
           if (randomValue >= moveForwardCondition) {
               racingcar.moveRacingcar();
           }
       }
    }

    public List<String> getCarsLocation(){
        List<String> carsLocation = new ArrayList<>();
        for(Racingcar racingcar : racingcars) {
            carsLocation.add(racingcar.getCarName() + " : " + "-".repeat(racingcar.getLocation()));
        }
        return carsLocation;
    }



}
