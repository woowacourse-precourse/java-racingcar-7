package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * RacingGameView 인터페이스의 구현체로, 콘솔을 통해 자동차 경주 게임의 입출력을 처리한다.
 * 사용자로부터 자동차 이름과 시도 횟수를 입력받고, 결과를 출력한다.
 */
public class RacingGameViewImpl implements RacingGameView {

    /**
     * 사용자에게 자동차 이름을 입력받는다.
     * camp.nextstep.edu.missionutils.Console 클래스의 readLine 함수를 사용한다.
     * @return 입력된 자동차 이름 문자열 (콤마로 구분된 형식)
     */
    @Override
    public String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    /**
     * 사용자에게 경주 시도 횟수를 입력받는다.
     * camp.nextstep.edu.missionutils.Console 클래스의 readLine 함수를 사용한다.
     * @return 입력된 시도 횟수를 나타내는 문자열
     */
    @Override
    public String getTrialNum() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }

    /**
     * 경주 결과를 콘솔에 출력한다.
     * @param result 출력할 경주 결과 문자열
     */
    @Override
    public void showResult(String result) {
        System.out.println(result);
    }
}
