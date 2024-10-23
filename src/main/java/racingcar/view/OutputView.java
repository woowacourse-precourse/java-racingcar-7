package racingcar.view;

import java.util.LinkedHashMap;
import java.util.List;
import racingcar.model.Round;

public class OutputView {
    public void printRoundState(List<Round> roundList) {
        System.out.println("\n실행 결과");

        roundList.forEach(this::printCarState);
    }

    private void printCarState(Round round) {
        LinkedHashMap<String, Integer> state = round.getState();

        state.sequencedEntrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " : " + "-".repeat(entry.getValue()));
        });

        System.out.println();
    }

    public void printWinners(Round round) {
        String winners = String.join(" ", round.findAllLeadingCars());

        System.out.print("최종 우승자 : " + winners);
    }
}
