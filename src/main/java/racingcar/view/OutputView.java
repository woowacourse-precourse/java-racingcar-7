package racingcar.view;

import racingcar.model.dto.Winners;

public class OutputView {

    public void printProceedGameMessage() {
        System.out.println("\n실행 결과");
    }

    public void printRoundResult(String roundResult) {
        System.out.println(roundResult);
        System.out.println();
    }

    public void printWinners(Winners winners) {
        System.out.println("\n최종 우승자 : " + winners.getFormattedWinnerNames());
    }
}
