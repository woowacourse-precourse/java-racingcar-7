package racingcar;

public class RaceWinnerView {
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String COMMA = ",";
    private static final String BLANK = " ";
    private String winner = "";
    private static final String LINE_BLANK = "\n";

    public void announceWinner(String[] winners) {
        System.out.print(LINE_BLANK + WINNER_MESSAGE);
        if (winners.length == 1) {
            System.out.print(winners[0]);
            return;
        }
        for (String winner : winners) {
            this.winner += winner + COMMA + BLANK;
        }
        System.out.print(winner);
    }

}
