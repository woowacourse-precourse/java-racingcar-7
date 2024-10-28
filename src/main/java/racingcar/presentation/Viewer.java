package racingcar.presentation;

import racingcar.domain.refree.value.TotalResult;

public final class Viewer {

    private static final String ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ENTER_COUNT = "시도할 횟수는 몇 회인가요?";
    private static final String EXECUTION_RESULT = "실행 결과";
    private static final String WINNER_IS = "최종 우승자 : ";

    private Viewer() {
    }

    public static void enterCarNamesMessage() {
        System.out.println(ENTER_CAR_NAMES);
    }

    public static void enterCountMessage() {
        System.out.println(ENTER_COUNT);
    }

    public static void showResultMessage(TotalResult totalResult) {
        System.out.println(EXECUTION_RESULT);
        System.out.println(totalResult.resultToString());
        System.out.println(WINNER_IS + totalResult.winnerNamesToString());
    }

}
