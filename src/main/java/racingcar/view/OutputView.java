package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String REQUEST_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_ROUND = "시도할 회수는 몇 회인가요?";
    private static final String ROUND_RESULT = "실행 결과";
    private static final String WINNER = "최종 우승자 : ";

    public void printRequestCarNames() {
        System.out.println(REQUEST_CAR_NAMES);
    }

    public void printRequestRound() {
        System.out.println(REQUEST_ROUND);
        System.out.println();
    }

    public void printRoundResult(List<String> roundInfo) {
        System.out.println(ROUND_RESULT);
        for (String info : roundInfo) {
            System.out.println(info);
        }
        System.out.println();
    }

    public void printWinner(List<String> winnerNames) {
        System.out.print(WINNER);
        for (String name : winnerNames) {
            System.out.print(name + " ");
        }
    }
}
