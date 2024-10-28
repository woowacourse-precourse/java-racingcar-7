package output;

import java.util.List;

public class WinnerOutput {
    private static final String WINNER_DELIMITER = ", ";

    public void printFinalWinners(List<String> finalWinnerList) {
        String finalWinners = makeFinalWinnersToString(finalWinnerList);

        System.out.println("최종 우승자 : " + finalWinners);
    }

    private String makeFinalWinnersToString(List<String> finalWinnerList) {
        String finalWinners = String.join(WINNER_DELIMITER, finalWinnerList);

        return finalWinners;
    }
}
