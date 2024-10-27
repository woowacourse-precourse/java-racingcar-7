package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class View {

    private final String NUMBER_FORMAT_ERROR_MESSAGE = "[error] 정상적인 숫자 입력이 아닙니다.";

    public String inputString() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String str = Console.readLine();
        return str;
    }

    public int inputTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryCount = 0;
        try {
            tryCount = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
        }
        return tryCount;
    }
}
