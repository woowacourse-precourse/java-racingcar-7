package racingcar.model.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.model.domain.Car;
import racingcar.model.domain.GameEnvironment;
import racingcar.model.dto.RoundResult;
import racingcar.model.dto.Winners;
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

    public List<RoundResult> proceedRacingGame() {
        List<Car> cars = racingcarRepository.findAll();
        Integer attemptCount = gameEnvironment.getAttemptCount();

        return IntStream.range(0, attemptCount)
                .mapToObj(i -> {
                    cars.forEach(car -> car.modifyStatusFromRandomNumber(getRandomNumber()));
                    cars.forEach(Car::moveBasedOnStatus);
                    return new RoundResult(getCurrentRoundResult(cars));
                })
                .toList();
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private String getCurrentRoundResult(List<Car> cars) {
        return cars.stream()
                .map(car -> car.getName() + " : " + "-".repeat(car.getMovingForwardCount()))
                .collect(Collectors.joining("\n"));
    }

    public Winners determineWinners() {
        List<Car> cars = racingcarRepository.findAll();

        int maxForwardCount = cars.stream()
                .mapToInt(Car::getMovingForwardCount)
                .max()
                .orElse(0);

        List<String> winnerNames = cars.stream()
                .filter(car -> car.getMovingForwardCount() == maxForwardCount)
                .map(Car::getName)
                .collect(Collectors.toList());

        return new Winners(winnerNames);
    }
}
