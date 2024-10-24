package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import racingcar.car.RacingCar;
import racingcar.car.RacingCars;
import racingcar.io.RacingCarIOHandler;

public class RacingCarGame {

    private final RacingCarIOHandler ioHandler = new RacingCarIOHandler();

    public void run() {
        // 입력에 대한 검증 필요
        String carNamesString = ioHandler.askCarNames();
        String roundString = ioHandler.askRound();

        if (carNamesString == null || roundString == null) {
            throw new IllegalArgumentException();
        }

        List<String> carNames = extractCarNames(carNamesString);
        int round = convertToRound(roundString);

        ioHandler.showExecutionResultMessage();
        RacingCars racingCars = RacingCars.fromNames(carNames);
        playRound(round, racingCars);

        List<String> winnersName = racingCars.getWinnersName();
        ioHandler.showWinners(winnersName);
    }

    private List<String> extractCarNames(String carNamesString) {
        // 자동차 이름에 대한 검증 로직
        List<String> carNames = Arrays.asList(carNamesString.split(","));

        carNames.stream()
                .filter(carName -> carName.isEmpty() || carName.length() >= 5)
                .findAny()
                .ifPresent(carName -> {
                    throw new IllegalArgumentException();
                });

        return carNames;
    }

    private int convertToRound(String roundString) {
        // 시도할 횟수에 대한 검증 로직
        int round = Integer.parseInt(roundString);

        if (round <= 0) {
            throw new IllegalArgumentException();
        }

        return round;
    }

    private void playRound(int round, RacingCars racingCars) {
        List<RacingCar> cars = racingCars.getCars();
        for (int i = 0; i < round; i++) {
            playOneRound(cars);
            ioHandler.showRacingCarsProgress(cars);
        }
    }

    private void playOneRound(List<RacingCar> cars) {
        cars.forEach(car -> {
            int pickedNumber = Randoms.pickNumberInRange(0, 9);
            car.moveIfRandomNumberIsAbove(pickedNumber);
        });
    }
}
