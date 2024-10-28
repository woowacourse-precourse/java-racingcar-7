package racingcar.model;

/**
 * RacingGameModel 인터페이스는 자동차 경주 게임의 주요 로직을 정의하는 인터페이스
 */
public interface RacingGameModel {

    /**
     * 자동차 경주 게임을 실행한다.
     * 입력된 자동차 이름과 시도 횟수를 기반으로 게임을 진행하며 결과를 반환한다.
     *
     * @param carNames 콤마로 구분된 자동차 이름 문자열
     * @param trialNum 경주 시도 횟수를 나타내는 문자열
     * @return 경주 결과를 나타내는 문자열
     */
    String play(String carNames, String trialNum);
}
