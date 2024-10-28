package racingcar.view;

import java.util.List;
import java.util.stream.IntStream;

public class OutputView {
    public void printRaceResultStart() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printRaceRound(List<String> carNames, List<Integer> positions) {
        IntStream.range(0, carNames.size()).forEach(i ->
                System.out.println(carNames.get(i) + " : " + "-".repeat(positions.get(i)))
        );
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        String winnerNames = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnerNames);
    }

    public void printErrorMessage(String message) {
        System.out.println("오류: " + message);
    }
}
