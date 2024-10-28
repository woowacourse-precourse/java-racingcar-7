package racingcar.view;
// 결과를 출력하는 OutputView 입니다.
// 결과를 출려하기 위해서 데이터를 기반으로 문자열을 만드는 역할을 RaceManager로 위임하여 출력하는 역할만 담당하도록 구현
public class OutputView {

    private static final String ROUND_RESULT_HEADER = "실행 결과";
    private static final String WINNER_HEADER = "최종 우승자 : ";

    public void printRoundHeader() {
        System.out.println(ROUND_RESULT_HEADER);
    }

    public void printRoundResult(String roundResult) {
        System.out.println(roundResult);
    }

    public void printWinners(String winners) {
        System.out.println(WINNER_HEADER + winners);
    }
}
