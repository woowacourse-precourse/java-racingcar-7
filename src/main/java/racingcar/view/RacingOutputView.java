package racingcar.view;

import racingcar.global.Symbol;

public class RacingOutputView {

    private static final String PROGRESS_GUIDE = "실행 결과";
    private static final String NAME_SCOPE = "%s : ";
    private static final String COUNT_MARK = "-";

    private static final String WINNER_GUIDE = "최종 우승자";
    private static final String DELIMITER = "%s ";
    private static final String ENTER = System.lineSeparator();

    public void guideProgress() {
        enter();
        System.out.println(PROGRESS_GUIDE);
    }

    public void showProgressResult(String name, int distance) {
        System.out.printf(NAME_SCOPE, name);
        System.out.println(COUNT_MARK.repeat(distance));
    }

    public void enter() {
        System.out.print(ENTER);
    }

    public void guideFinal() {
        System.out.printf(NAME_SCOPE, WINNER_GUIDE);
    }

    public void showWinners(String name) {
        System.out.print(name);
    }

    public void delimit() {
        System.out.printf(DELIMITER, Symbol.NAME_DELIMITER.getSymbol());
    }
}
