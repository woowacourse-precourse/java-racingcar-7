package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class InputHandler {

    public UserInput inputCarNamesAndAttemptCount() {
        try {
            String carNamesInput = inputCarNames();
            String attemptCountInput = inputAttemptCount();

            return new UserInput(carNamesInput, attemptCountInput);
        } finally {
            Console.close();
        }
    }

    // 사용자로부터 자동차 이름을 입력받음
    private String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return getSafeInput();
    }

    // 사용자로부터 시도 횟수를 입력받음
    private String inputAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return getSafeInput();
    }

    // 빈 문자열 입력받기
    private String getSafeInput() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            return ""; // 빈 문자열로 처리
        }
    }
}