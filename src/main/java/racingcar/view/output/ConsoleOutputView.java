package racingcar.view.output;

import java.util.List;

public class ConsoleOutputView implements OutputView {
    @Override
    public void printGameStart() {
        System.out.println("\n실행 결과");
    }

    @Override
    public void printRoundResult(List<String> results) {
        results.forEach(System.out::println);
        System.out.println();
    }

    @Override
    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    @Override
    public void printError(String message) {
        System.out.println("[ERROR] " + message);
    }
}
