package racingcar;

import java.util.List;

public class RacingCarGame {

    private static final String MOVEMENT_INDICATOR = "-";
    private static final String STATUS_DELIMITER = " : ";

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingCarGame(InputHandler inputHandler,
                         OutputHandler outputHandler,
                         RandomNumberGenerator randomNumberGenerator) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void play() {
        List<CarName> carNames = inputHandler.inputCarNames();
        List<RacingCar> racingCars = carNames.stream()
                .map(carName -> new RacingCar(carName, 0))
                .toList();
        TryCount tryCount = inputHandler.inputTryCount();

        outputHandler.printResultMessage();
        for (int i = 0; i < tryCount.getValue(); i++) {
            racingCars.forEach(racingCar -> racingCar.move(randomNumberGenerator.generate()));
            outputHandler.printResult(racingCars);
        }
        outputHandler.printWinners(findWinners(racingCars));
    }

    private List<String> findWinners(List<RacingCar> racingCars) {
        int maxLocation = getMaxLocationCars(racingCars);
        return racingCars.stream()
                .filter(racingCar -> racingCar.isSameLocation(maxLocation))
                .map(RacingCar::getCarNameValue)
                .toList();
    }

    private int getMaxLocationCars(List<RacingCar> racingCars) {
        return racingCars.stream()
                .mapToInt(RacingCar::getLocation)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("최대 위치인 자동차가 없습니다."));
    }
}
