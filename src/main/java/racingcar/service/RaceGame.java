package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.RacingGameSettings;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class RaceGame {

    private final List<Car> raceCars;

    public RaceGame(List<Car> raceCars) {
        this.raceCars = raceCars;
    }

    public void start(){
        for (Car car : raceCars) {
            int number = Randoms.pickNumberInRange(
                    RacingGameSettings.PICK_NUMBER_START.getValue(),
                    RacingGameSettings.PICK_NUMBER_END.getValue());
            if(isMovable(number)){
                car.move();
            }
            car.print();
        }
    }

    public List<Car> getWinningCar(){
        List<Car> winningCar = new ArrayList<>();

        if(raceCars == null || raceCars.isEmpty()){
            return winningCar;
        }

        int maxForward = raceCars.getFirst().getForward();
        for(Car car : raceCars){
            if(car.getForward() > maxForward){
                maxForward = car.getForward();
            }
        }

        for(Car car: raceCars){
            if(car.getForward() == maxForward){
                winningCar.add(car);
            }
        }
        return winningCar;
    }

    private boolean isMovable(int value){
        return value >= RacingGameSettings.MOVABLE_NUMBER_THRESHOLD.getValue();
    }
}
