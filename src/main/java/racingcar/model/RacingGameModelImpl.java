package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

import static racingcar.model.CarFactory.createCars;
import static racingcar.model.TrialValidator.validateTrial;

public class RacingGameModelImpl implements RacingGameModel{
    @Override
    public String play(String carNames, String trialNum) {
        List<RacingCar> cars = createCars(carNames);
        int trial = validateTrial(trialNum);

        GameResults results = new GameResults(cars, trial);

        return results.getResults();
    }







}
