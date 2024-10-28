package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Race {

    private int totalRound;
    private RacingCars racingCars;

    public void init() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        String carsRawInput = Console.readLine();
        racingCars = new RacingCars(parseCarNames(carsRawInput));
        System.out.println("시도할 횟수는 몇 회인가요?");
        String totalRoundRawInput = Console.readLine();
        totalRound = parseTotalRound(totalRoundRawInput);
    }

    private ArrayList<String> parseCarNames(String carsRawInput) {
        if (null == carsRawInput || carsRawInput.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
        ArrayList<String> carNames = new ArrayList<>(Arrays.asList(carsRawInput.split(",")));
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능하다.");
            }
        }
        return carNames;
    }

    private int parseTotalRound(String totalRoundRawInput) {
        try {
            int round = Integer.parseInt(totalRoundRawInput);
            if (round < 0) {
                throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
            }
            return round;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    public void start() {
        System.out.println();
        System.out.println("실행 결과");
        for (int currentRound = 0; currentRound < totalRound; ++currentRound) {
            round();
        }
        System.out.println("최종 우승자 : " + racingCars.getWinner());
    }

    private void round() {
        racingCars.moveEachCarsIfPossible(0, 9);
        racingCars.printEachCarsStatus();
    }

}
