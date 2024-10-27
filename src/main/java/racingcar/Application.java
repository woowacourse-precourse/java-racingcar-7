package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 경주 클래스
        RacingGame racingGame = new RacingGame();

        // 경주 차량 입력
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        racingGame.inputCars(carNames);

        // 시도 횟수 입력
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            int attempts = Integer.parseInt(Console.readLine());
            racingGame.inputAttempts(attempts);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }

        // 경주 시작
        racingGame.start();

        // 우승자 출력
        racingGame.printWinners();
    }
}
