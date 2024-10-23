package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Printer.print(SystemMessage.START_MESSAGE);
        String carNames = Console.readLine();
        // pobi,woni,jun
        Printer.print(SystemMessage.ATTEMPT_COUNT_MESSAGE);
        String count = Console.readLine();

        GameDirector gameDirector = new GameDirector(carNames, count);
        Printer.print(SystemMessage.RESULT_MESSAGE);
        gameDirector.run();
        gameDirector.printWinner();
    }
}
