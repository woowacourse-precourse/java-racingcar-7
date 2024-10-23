package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carNames = Console.readLine();

            System.out.println("시도할 횟수는 몇 회인가요?");
            int attempts = Integer.parseInt(Console.readLine());

            RaceGame game = new RaceGame(carNames);
            game.playGame(attempts);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
