package racingcar.view;

/**
 * RacingGameView 인터페이스는 자동차 경주 게임의 입출력과 관련된 동작을 정의한다.
 * 사용자로부터 입력을 받거나, 결과를 출력하는 역할을 담당한다.
 */
public interface RacingGameView {

    /**
     * 경주에 참여할 자동차 이름을 입력받는다.
     * @return 콤마로 구분된 자동차 이름 문자열
     */
    String getCarNames();

    /**
     * 경주 시도 횟수를 입력받는다.
     * @return 경주 시도 횟수를 나타내는 문자열
     */
    String getTrialNum();

    /**
     * 경주 결과를 화면에 출력한다.
     * @param result 출력할 경주 결과 문자열
     */
    void showResult(String result);
}
