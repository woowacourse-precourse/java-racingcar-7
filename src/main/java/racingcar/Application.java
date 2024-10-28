package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = readLine();
        String[] names = carNames.split(",");
        for (String name : names) {
            InputValidator.validateCarName(name.trim());
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        String attempts = readLine();
        int validAttempts = InputValidator.validateAttempts(attempts);
        System.out.println();

        RacingGame game = new RacingGame(names, validAttempts);
        game.start();

        String[] winners = game.getWinners();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
