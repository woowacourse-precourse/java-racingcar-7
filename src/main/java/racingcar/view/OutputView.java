package racingcar.view;

import racingcar.model.dto.Winners;

public class OutputView {

    StringBuilder roundResultStringBuilder = new StringBuilder();

    public void printProceedGameMessage() {
        System.out.println("\n실행 결과");
    }

    public void collectRoundResult(String roundResult) {
        roundResultStringBuilder.append(roundResult).append("\n\n");
    }

    public void printRoundResult() {
        System.out.print(roundResultStringBuilder);
    }

    public void printWinners(Winners winners) {
        System.out.println("최종 우승자 : " + winners.getFormattedWinnerNames());
    }
}
