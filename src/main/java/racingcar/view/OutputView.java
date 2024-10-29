package racingcar.view;

import java.util.List;

public class OutputView {
    public void printPlayMessage() {
        System.out.println();
        System.out.println("실행결과");
    }

    public void printPlayResults(List<String> results) {
        for (String result : results) {
            System.out.println(result);
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        String message = "최종 우승자 : ";
        if (winners.size() == 1) {
            printSingleWinner(message, winners);
            return;
        }
        printMultipleWinners(message, winners);

    }

    private void printSingleWinner(String message, List<String> winners) {
        System.out.println(message + winners.get(0));
    }

    private void printMultipleWinners(String message, List<String> winners) {
        System.out.println(message + String.join(", ", winners));
    }
}
