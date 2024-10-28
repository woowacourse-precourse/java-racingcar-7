package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

/**
 * 해당 클래스는 입력을 담당하는 클래스 입니다.
 *
 * @version 1.0
 */
public class InputView {
    /**
     * 사용자에게 입력받은 자동차 이름을 반환하는 메서드
     *
     * @return 사용자로부터 입력받은 문자열
     */
    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("[ERROR] 입력이 잘못되었습니다.");
        }

    }

    /**
     * 사용자에게 입력받은 시도 횟수를 반환하는 메서드
     *
     * @return 사용자로부터 입력받은 시도 횟수
     */
    public int inputTryCount() {
        System.out.println("시도할 회수는 몇 회인가요?");

        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("[ERROR] 입력이 잘못되었습니다.");
        }
    }
}
