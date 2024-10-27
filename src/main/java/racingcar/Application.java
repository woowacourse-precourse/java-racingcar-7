package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carNames = Console.readLine();

            for (String name : RaceUtil.parseCarNames(carNames)) {
                Car.validateName(name);
            }

            System.out.println("시도할 횟수는 몇 회인가요?");
            String attemptsInput = Console.readLine();
            int attempts = RaceUtil.parseAttempts(attemptsInput);
            RaceUtil.validateAttempts(attempts);

            RaceGame game = new RaceGame(carNames);
            game.playGame(attempts);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}