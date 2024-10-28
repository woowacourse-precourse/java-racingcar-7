package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> names = inputCarNames();
        int attempts = inputTryCount();
        RacingGame game = new RacingGame(names);
        game.executeRace(attempts);
        game.announceWinner();
    }

    private static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> names = Arrays.asList(input.split(","));
        Validator.validateCarNames(names);
        return names;
    }

    private static int inputTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        Validator.validateTryCount(input);
        return Integer.parseInt(input);
    }
}