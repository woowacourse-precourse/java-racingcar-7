package racingcar.view;

import java.util.LinkedHashMap;
import java.util.List;
import racingcar.model.Round;

public class OutputView {
    public void printRoundState(List<Round> roundList) {
        StringBuilder leaderBoard = new StringBuilder();
        leaderBoard.append("\n실행 결과\n");

        roundList.forEach(round -> {
            LinkedHashMap<String, Integer> state = round.getState();

            state.sequencedEntrySet().forEach(entry -> {
                leaderBoard.append(entry.getKey())
                        .append(" : ")
                        .append("-".repeat(entry.getValue()))
                        .append("\n");
            });

            leaderBoard.append("\n");
        });

        System.out.print(leaderBoard);
    }

    public void printWinners(Round round) {
        String winners = String.join(" ", round.findAllLeadingCars());

        System.out.print("최종 우승자 : " + winners);
    }
}
