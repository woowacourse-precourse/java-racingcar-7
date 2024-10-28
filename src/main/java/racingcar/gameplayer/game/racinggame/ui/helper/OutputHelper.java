package racingcar.gameplayer.game.racinggame.ui.helper;

import java.util.List;
import racingcar.gameplayer.game.racinggame.app.dto.CarScore;
import racingcar.gameplayer.game.racinggame.app.dto.GameResult;
import racingcar.gameplayer.game.racinggame.app.dto.RoundResult;

public class OutputHelper {

    private final static String JOIN_DELIMITER = ",";
    private final static String POSITION_MARK = "-";

    public void printResult(GameResult result) {
        printRounds(result.results());
        printWinner(result.winner());
    }

    private void printRounds(List<RoundResult> results) {
        printBlank();
        for (RoundResult result : results) {
            printOneRound(result);
            printBlank();
        }
    }

    private void printBlank() {
        System.out.println();
    }

    private void printOneRound(RoundResult result) {
        for (CarScore score : result.scores()) {
            System.out.println(printName(score.name()) + printPosition(score.position()));
        }
    }

    private String printName(String name) {
        return String.format("%s : ", name);
    }

    private String printPosition(Long position) {
        return POSITION_MARK.repeat(position.intValue());
    }


    private void printWinner(List<String> names) {
        System.out.println("최종 우승 : " + joinNames(names));
    }

    private String joinNames(List<String> names) {
        return String.join(JOIN_DELIMITER, names);
    }
}
