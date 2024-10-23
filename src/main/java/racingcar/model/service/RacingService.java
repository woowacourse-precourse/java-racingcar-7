package racingcar.model.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.dto.Car;
import racingcar.model.dto.RacingResult;

import java.util.ArrayList;
import java.util.List;

public class RacingService {

    public List<RacingResult> play(List<Car> cars, int attemptCount){
        List<RacingResult> racingResults = new ArrayList<>();

        for (int i = 0; i < attemptCount; i++) {
            playAttemptCount(cars);
            racingResults.add(new RacingResult(new ArrayList<>(cars)));
        }

        return racingResults;
    }

    private void playAttemptCount(List<Car> cars){
        for (Car car : cars) {
            if(isPossibleMove()){
                car.move();
            }
        }
    }

    private boolean isPossibleMove(){
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }
}
