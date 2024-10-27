package output;

import java.util.List;

public class WinnerOutput {
    public void printFinalWinners(List<String> finalWinnerList) {
        String finalWinners = makeFinalWinnersToString(finalWinnerList);

        System.out.println("최종 우승자 : " + finalWinners);
    }

    private String makeFinalWinnersToString(List<String> finalWinnerList) {
        String finalWinners = String.join(", ", finalWinnerList);

        return finalWinners;
    }
}
