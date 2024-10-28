package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.CarRacingGame;

import java.util.List;

public class RacingController {

    private final CarRacingGame carRacingGame = new CarRacingGame();

    public void run() {
        try {
            // 1. 사용자 입력 처리
            List<String> carNames = inputCarNames();
            int attemptCount = inputAttemptCount();

            // 2. 게임 초기화 및 경주 시작
            carRacingGame.initializeCars(carNames);

            // 3. 각 라운드의 결과 출력
            for (int i = 0; i < attemptCount; i++) {
                carRacingGame.advanceRound();
                printRoundResults(carRacingGame.getCurrentRoundResults());
            }

            // 4. 최종 우승자 출력
            printWinners(carRacingGame.getWinners());

        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            throw e;
        }
    }

    // 사용자로부터 자동차 이름을 입력받고 처리
    private List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> carNames = carRacingGame.parseCarNames(input);

        validateCarNames(carNames);
        return carNames;
    }

    // 자동차 이름 유효성 검증 메서드
    private void validateCarNames(List<String> carNames) {
        if (carNames.isEmpty() || carNames.stream().anyMatch(String::isEmpty)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 1자 이상 5자 이하여야 합니다.");
        }

        carNames.forEach(this::validateCarNameLength);
    }

    // 개별 자동차 이름 길이 검증
    private void validateCarNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 1자 이상 5자 이하여야 합니다.");
        }
    }

    // 사용자로부터 이동 횟수를 입력받고 처리
    private int inputAttemptCount() {
        System.out.println("시도할 횟수를 입력하세요:");
        try {
            int attemptCount = Integer.parseInt(Console.readLine());
            if (attemptCount <= 0) {
                throw new IllegalArgumentException("[ERROR] 이동 횟수는 1 이상의 정수여야 합니다.");
            }
            return attemptCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }

    // 라운드 결과를 출력
    private void printRoundResults(List<String> roundResults) {
        for (String result : roundResults) {
            System.out.println(result);
        }
        System.out.println();  // 라운드 사이에 줄바꿈으로 구분
    }

    // 최종 우승자 출력
    private void printWinners(List<String> winners) {
        String result = String.join(", ", winners);
        System.out.println("최종 우승자 : " + result);
    }
}
