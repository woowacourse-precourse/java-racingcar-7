package racingcar.service;

import racingcar.model.entity.Car;
import racingcar.model.entity.Cars;
import racingcar.model.dto.RacingProgress;
import racingcar.model.dto.RacingResult;
import racingcar.model.entity.RacingChance;
import racingcar.model.dto.RacingWinners;
import racingcar.repository.Repository;

public class RacingServiceImpl implements RacingService {

    private final Repository repository;

    public RacingServiceImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void raceOfCarsAndChance(Cars cars, RacingChance racingChance) {
        repository.saveStartMessage();
        raceAndSaveProgress(cars, racingChance);

        RacingWinners racingWinners = RacingWinners.getFromCars(cars);
        repository.saveResult(racingWinners);
    }

    @Override
    public RacingResult getResult() {
        return repository.getResult();
    }

    private void raceAndSaveProgress(Cars cars, RacingChance racingChance) {
        for (int i = 0; i < racingChance.getValue(); i++) {
            for (Car car : cars) {
                car.moveOrNot();
                RacingProgress progress = new RacingProgress(car);
                repository.saveProgress(progress);
            }
            repository.saveBreakingLine();
        }
    }


}
