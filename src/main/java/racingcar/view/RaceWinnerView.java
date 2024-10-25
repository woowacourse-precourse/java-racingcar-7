package racingcar.view;

public class RaceWinnerView {
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String COMMA = ",";
    private static final String BLANK = " ";
    private static final String LINE_BLANK = "\n";

    public void announceWinner(String[] winners) {
        System.out.print(LINE_BLANK + WINNER_MESSAGE);
        if (winners.length == 1) {
            System.out.print(winners[0]);
            return;
        }
        StringBuilder winner = getCoWinner(winners);
        System.out.print(winner);
    }

    private static StringBuilder getCoWinner(String[] winners) {
        StringBuilder winner = new StringBuilder();
        for (int i = 0; i < winners.length; i++) {
            winner.append(winners[i]);
            if (i != winners.length - 1) {
                winner.append(COMMA).append(BLANK);
            }
        }
        return winner;
    }

}
