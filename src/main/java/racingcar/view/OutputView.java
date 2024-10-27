package racingcar.view;

public class OutputView {
    private static final String NOTICE_STATEMENT_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String NOTICE_STATEMENT_CNT = "시도할 횟수는 몇 회인가요?";

    void printNoticeStatementName() {
        System.out.println(NOTICE_STATEMENT_NAME);
    }

    void printNoticeStatementCnt(){
        System.out.println(NOTICE_STATEMENT_CNT);
    }
}
