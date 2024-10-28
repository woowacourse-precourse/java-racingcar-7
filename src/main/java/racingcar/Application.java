package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carInput = Console.readLine();

        List<String> carList = CarValidator.validateNames(carInput);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String attemptInput = Console.readLine();
        int attemptsNum = AttemptValidator.validatePositiveInt(attemptInput);

        Game game = new Game(carList, attemptsNum);
        game.startGame();

        Console.close();
    }
}