package racingcar.model.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.domain.Car;
import racingcar.model.domain.GameEnvironment;
import racingcar.model.repository.RacingcarRepository;
import racingcar.model.service.converter.RacingcarConverter;

public class RacingcarService {

    private final RacingcarRepository racingcarRepository;
    private final RacingcarConverter racingcarParser;
    private final GameEnvironment gameEnvironment;

    public RacingcarService(GameEnvironment gameEnvironment) {
        this.racingcarRepository = new RacingcarRepository();
        this.racingcarParser = new RacingcarConverter();
        this.gameEnvironment = gameEnvironment;
    }

    public int saveCars(String carNamesInput) {
        List<Car> cars = racingcarParser.convertToCars(carNamesInput);
        cars.forEach(racingcarRepository::save);

        return 1;
    }

    public int saveAttemptCount(String attemptCountInput) {
        Integer attemptCount = racingcarParser.convertToNumber(attemptCountInput);
        gameEnvironment.modifyAttemptCount(attemptCount);

        return 1;
    }

    public int proceedRacingGame() {
        List<Car> cars = racingcarRepository.findAll();
        Integer attemptCount = gameEnvironment.getAttemptCount();

        IntStream.range(0, attemptCount).forEach(i -> {
            cars.forEach(car -> car.modifyStatusFromRandomNumber(Randoms.pickNumberInRange(0, 9)));
            cars.forEach(Car::moveBasedOnStatus);
        });

        return 1;
    }
}
