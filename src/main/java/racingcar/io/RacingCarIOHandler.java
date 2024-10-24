package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.car.RacingCar;

public class RacingCarIOHandler {

    public List<String> askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameString = Console.readLine();
        return extractCarNames(carNameString);
    }

    public int askRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String roundCountString = Console.readLine();
        return convertToRound(roundCountString);
    }

    public void showExecutionResultMessage() {
        System.out.println("\n실행결과");
    }

    public void showRacingCarsProgress(List<RacingCar> cars) {
        cars.forEach(car -> System.out.printf("%s : %s%n", car.getName(), car.getProgress()));
    }

    public void showWinners(List<String> winners) {
        String result = String.join(", ", winners);
        System.out.printf("최종 우승자 : %s%n", result);
    }

    private List<String> extractCarNames(String carNamesString) {
        // 자동차 이름에 대한 검증 로직
        if (carNamesString == null) {
            throw new IllegalArgumentException();
        }

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
        if (roundString == null) {
            throw new IllegalArgumentException();
        }

        int round = Integer.parseInt(roundString);

        if (round <= 0) {
            throw new IllegalArgumentException();
        }
        return round;
    }
}
