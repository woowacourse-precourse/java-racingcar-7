package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.GameManage;
import racingcar.UserInterface;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserInterface {
    public enum ConsoleMessage {
        Car_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
        RESULT("실행 결과"),
        WINNER("최종 우승자 : ");

        private final String message;

        ConsoleMessage(final String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
    public void closeConsole() {
        Console.close();
    }
    public void printNewLine() {
        System.out.println();
    }
    public String[] getCarNames() {
        System.out.println(ConsoleMessage.Car_NAME.getMessage());
        final String input = Console.readLine();
        return input.split(",");
    }
    public String getOperationCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
        return Console.readLine();
    }
    public void printRacingresult() {
        System.out.println(MessageFormat.format("\n{0}", ConsoleMessage.RESULT.getMessage()));
    }
    public void printScore(final String key, final int value) {
        String forwardAmount = "-".repeat(value);
        System.out.println(MessageFormat.format("{0} : {1}",key,forwardAmount));
    }
    public void printVictory(final List<String> names) {
        final String winners = String.join("-", names);
        System.out.println(ConsoleMessage.WINNER.getMessage()+winners);
    }
}
