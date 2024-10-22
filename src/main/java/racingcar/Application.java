package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Printer.print(SystemMessage.START_MESSAGE);
        String carNames = Console.readLine();

        Printer.print(SystemMessage.ATTEMPT_COUNT_MESSAGE);
        String count = Console.readLine();
    }
}
