package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        printCarNamePrompt();
        String inputCarNames = readInput();
        Validator validator = new Validator();
        String[] carNames = validator.validateCarNames(inputCarNames);

        printCountPrompt();
        String inputCount = readInput();
        int count = validator.validateCount(inputCount);

        printResultPrompt();

        Game game = new Game(carNames);

        for (int i = 0; i < count; i++) {
            Map<String, StringBuilder> roundResult = game.moveCarsIfQualified();
            printStatus(roundResult);
            System.out.println();
        }

        List<String> winners = game.getWinners();
        printWinners(winners);
    }

    public static void printCarNamePrompt() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static String readInput() {
        return Console.readLine();
    }

    public static void printCountPrompt() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void printResultPrompt() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printStatus(Map<String, StringBuilder> roundResult) {
        for (String carName : roundResult.keySet()) {
            System.out.println(carName + " : " + roundResult.get(carName));
        }
    }

    public static void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }

}
