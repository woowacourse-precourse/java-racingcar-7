package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.NumberGenerator;
import racingcar.domain.RandomNumberGenerator;
import racingcar.domain.Round;
import racingcar.dto.RacingResult;
import racingcar.dto.TotalRoundResult;
import racingcar.dto.WinnerResult;
import racingcar.repository.Cars;
import racingcar.repository.Rounds;
import racingcar.util.converter.CarConverter;
import racingcar.util.converter.TryCountConverter;

public class Race {
    private final Cars carRepository;
    private final Rounds roundRepository;

    public Race() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        this.carRepository = new Cars(numberGenerator);
        this.roundRepository = new Rounds();
    }

    public RacingResult start(String carNames, String tryCount) {
        carRepository.saveAll(CarConverter.convert(carNames));
        progressRace(TryCountConverter.convert(tryCount));
        return getRaceResult();
    }

    private void progressRace(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            carRepository.attemptMoveAllCars();
            List<Car> currentCars = carRepository.getCurrentCars();
            roundRepository.save(new Round(currentCars));
        }
    }

    private RacingResult getRaceResult() {
        List<Round> rounds = roundRepository.findAllRounds();
        List<Car> cars = roundRepository.findWinnerCars();
        return new RacingResult(TotalRoundResult.from(rounds), WinnerResult.from(cars));
    }
}
