package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

import static racingcar.model.CarFactory.createCars;
import static racingcar.model.GameResults.getCarStatesPerTrial;
import static racingcar.model.GameResults.getResultOfGame;
import static racingcar.model.TrialValidator.validateTrial;

public class RacingGameModelImpl implements RacingGameModel{
    @Override
    public String play(String carNames, String trialNum) {
        List<RacingCar> cars = createCars(carNames);
        int trial = validateTrial(trialNum);

        return resultThroughCarsAndTrial(cars, trial);
    }

    private String resultThroughCarsAndTrial(List<RacingCar> cars, int trial) {
        StringBuilder result = new StringBuilder();

        result.append("\n실행 결과\n");

        // 반복 시도 마다 저장
        for(int i = 0; i < trial; i++){
            moveCars(cars);
            result.append(getCarStatesPerTrial(cars));
        }

        result.append(getResultOfGame(cars));

        return result.toString();
    }

    private void moveCars(List<RacingCar> cars) {
        for(RacingCar car : cars){
            car.move(isMovable());
        }
    }

    private boolean isMovable() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }






}
