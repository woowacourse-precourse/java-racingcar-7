package racingcar;

import java.util.List;

public class RacingCarGame {

    private static final String MOVEMENT_INDICATOR = "-";
    private static final String STATUS_DELIMITER = " : ";

    private final InputHandler inputHandler;
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingCarGame(InputHandler inputHandler, RandomNumberGenerator randomNumberGenerator) {
        this.inputHandler = inputHandler;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void play() {
        List<CarName> carNames = inputHandler.inputCarNames();
        List<RacingCar> racingCars = carNames.stream()
                .map(carName -> new RacingCar(carName, 0))
                .toList();
        TryCount tryCount = inputHandler.inputTryCount();

        System.out.println("\n실행 결과");
        for (int i = 0; i < tryCount.getValue(); i++) {
            racingCars.forEach(racingCar -> racingCar.move(randomNumberGenerator.generate()));
            racingCars.forEach(racingCar -> System.out.println(String.join(STATUS_DELIMITER, racingCar.getCarNameValue(),
                    MOVEMENT_INDICATOR.repeat(racingCar.getLocation()))));
        }
        findWinners(racingCars);
    }

    public void findWinners(List<RacingCar> racingCars) {
        int maxLocation = getMaxLocationCars(racingCars);
        List<String> winners = racingCars.stream()
                .filter(racingCar -> racingCar.getLocation() == maxLocation)
                .map(RacingCar::getCarNameValue)
                .toList();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public int getMaxLocationCars(List<RacingCar> racingCars) {
        return racingCars.stream()
            .mapToInt(RacingCar::getLocation)
            .max()
            .orElseThrow(() -> new IllegalArgumentException("최대 위치인 자동차가 없습니다."));
    }
}
