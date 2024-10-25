package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;


public class Application {
    public static void main(String[] args) {
        Printer.print(SystemMessage.START_MESSAGE);
        String carNames = Console.readLine();

        Printer.print(SystemMessage.ATTEMPT_COUNT_MESSAGE);
        String count = Console.readLine();

        Printer.newLine();
        Printer.print(SystemMessage.RESULT_MESSAGE);
        MoveStrategy strategy = new RandomNumStrategy();
        GameDirector gameDirector = new GameDirector(carNames, count, strategy);
        List<Car> matchResult = gameDirector.run();
        gameDirector.printWinner(matchResult);

        Console.close();
    }
}
