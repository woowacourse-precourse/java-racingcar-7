package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 콘솔로 입력값을 다루는 클래스
 * 입력값을 받아서 CarController에게 전달한다.
 */
public class ConsoleInputView implements InputView {

    @Override
    public String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    @Override
    public String getChanceToMove() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }
}
