package racingcar.view;

import racingcar.model.Player;

import java.util.List;
import java.util.StringJoiner;

public class PrintHelper {
    private static final String POINT = "-";
    private static final String COLON = ":";
    private static final String BLANK = " ";
    private static final String LINE_BREAK = "\n";
    private static final String WINNER_IS = "최종 우승자 : ";
    private static final String COMMA = ",";

    public void printScoreBoard(List<Player> players) {
        StringJoiner scoreBoard = new StringJoiner(LINE_BREAK);

        for (Player p : players) {
            scoreBoard.add(getState(p));
        }

        System.out.println(scoreBoard.toString());

        System.out.println();
    }

    private String getState(Player p) {
        StringBuilder state = new StringBuilder();

        state.append(p.getName());

        state.append(BLANK);
        state.append(COLON);
        state.append(BLANK);

        for (int i = 0; i < p.getScore(); i++) {
            state.append(POINT);
        }

        return state.toString();
    }

    public void printResult(List<Player> players) {
        StringJoiner winner = new StringJoiner(COMMA + BLANK);

        for (Player player : players) {
            winner.add(player.getName());
        }

        String result = WINNER_IS + winner.toString();

        System.out.println(result);
    }

    public void startScoreBoard() {
        System.out.println("\n실행 결과");
    }
}
