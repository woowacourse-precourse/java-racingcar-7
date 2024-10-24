package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;


public class Application {
    public static void main(String[] args) {
        // TODO: Print하는 부분 템플릿 메서드 패턴 적용해보기
        Printer.print(SystemMessage.START_MESSAGE);
        String carNames = Console.readLine();

        Printer.print(SystemMessage.ATTEMPT_COUNT_MESSAGE);
        String count = Console.readLine();

        Printer.newLine();
        Printer.print(SystemMessage.RESULT_MESSAGE);
        GameDirector gameDirector = new GameDirector(carNames, count);
        List<Car> matchResult = gameDirector.run();
        gameDirector.printWinner(matchResult);

        Console.close();
    }
}
