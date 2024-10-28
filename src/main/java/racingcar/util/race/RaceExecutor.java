package racingcar.util.race;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;

import java.util.List;

public class RaceExecutor {
    public void raceStart(List<Car> cars, int moveCount) {
        for(int i = 0 ; i<moveCount; i++) {
            race(cars);
            printCarsPositionStatus(cars);
        }
    }

    private void race(List<Car> cars) {
        for(Car car : cars){
            tryMoveForward(car);
        }
    }

    private void printCarsPositionStatus(List<Car> cars) {
        for(Car car : cars){
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    private void tryMoveForward(Car car){
        if(canMove())
            car.moveForward();
    }

    private boolean canMove(){
        return Randoms.pickNumberInRange(0,9) >=4;
    }
}
