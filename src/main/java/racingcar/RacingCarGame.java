package racingcar;

import java.util.Arrays;
import java.util.List;
import racingcar.car.RacingCars;
import racingcar.io.RacingCarIOHandler;

public class RacingCarGame {

    private final RacingCarIOHandler ioHandler = new RacingCarIOHandler();

    public void run(){
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
        for (int i = 0; i < round; i++) {
            racingCars.playOneRound();
            ioHandler.showRacingCarsProgress(racingCars);
        }
    }
}
