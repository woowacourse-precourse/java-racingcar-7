package racingcar.view;

import java.util.List;

public class OutputView {
    public void startRacePhase() {
        System.out.println("\n실행 결과");
    }

    public void printProgress(String name, int progress) {
        String progressBar = "";
        for (int i = 0; i < progress; i++) {
            progressBar = progressBar + "-";
        }
        System.out.println(name + " : " + progressBar);
    }

    public void printBlank() {
        System.out.println("");
    }

    public void printWinner(List<String> winners) {
        String winnerMessage = "최종 우승자 : ";
        for (int i = 0; i < winners.size(); i++) {
            if (i == winners.size() - 1) {
                winnerMessage += winners.get(i);
            } else {
                winnerMessage = winnerMessage + winners.get(i) + ", ";
            }
        }
        System.out.println(winnerMessage);
    }
}
