package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");
        validateCarNames(carNames);

        System.out.println("시도할 횟수는 몇 회인가요?");
        int attempts = Integer.parseInt(Console.readLine());
        validateAttempts(attempts);

        RacingGame game = new RacingGame(carNames, attempts);
        game.play();
    }

    // 자동차 이름 유효성 검사 메서드
    private static void validateCarNames(String[] carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                System.out.println("chk");
                throw new IllegalArgumentException("자동차 이름은 최대 5자 이하만 가능합니다.");
            }
        }
    }

    // 시도 횟수 유효성 검사 메서드
    private static void validateAttempts(int attempts) {
        if (attempts <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
        }
    }
}
