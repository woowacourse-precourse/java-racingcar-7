package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 경주 클래스
        RacingGame racingGame = new RacingGame();
        String carNames = Console.readLine();

        // 경주 차량 입력
        racingGame.inputCars(carNames);

        // 시도 횟수 입력
        int attempts = Integer.parseInt(Console.readLine());
        racingGame.inputAttempts(attempts);

        // 경주 시작
        racingGame.start();

        // 우승자 출력
        racingGame.printWinners();
    }
}
