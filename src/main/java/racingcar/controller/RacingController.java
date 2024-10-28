package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.CarRacingGame;

import java.util.List;

public class RacingController {

    private final CarRacingGame carRacingGame = new CarRacingGame();

    public void run() {
        // 1. 사용자 입력 처리
        List<String> carNames = inputCarNames();
        int attemptCount = inputAttemptCount();

        // 2. 게임 초기화 및 경주 시작
        carRacingGame.initializeCars(carNames);
        List<String> results = carRacingGame.startRace(attemptCount);

        // 3. 경주 결과 출력
        printRaceResults(results);
    }

    // 사용자로부터 자동차 이름을 입력받고 처리
    private List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return carRacingGame.parseCarNames(input);
    }

    // 사용자로부터 이동 횟수를 입력받고 처리
    private int inputAttemptCount() {
        System.out.println("시도할 횟수를 입력하세요:");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }

    // 경주 결과를 출력
    private void printRaceResults(List<String> raceResults) {
        System.out.println("경주 결과:");
        for (String result : raceResults) {
            System.out.println(result);
        }
    }
}
