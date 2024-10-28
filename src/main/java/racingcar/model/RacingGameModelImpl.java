package racingcar.model;

import java.util.List;

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
