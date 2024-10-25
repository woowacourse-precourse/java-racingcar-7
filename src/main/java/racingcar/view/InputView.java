package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String CAR_NAME = "경주할 자동차 이름을 입력하세요.(쉼표(,) 기준으로 구분, 각 5자 이하)";
    public static final String ROUNDS = "시도할 횟수는 몇 회인가요?";

    public static String carNames() {
        System.out.println(CAR_NAME);
        return Console.readLine();
    }

    public static String gameRounds() {
        System.out.println(ROUNDS);
        return Console.readLine();
    }

    public static String request(String empty, String outputStrings) {
        String request = empty;

        while (request.isEmpty()) {
            System.out.println(outputStrings);
            request = Console.readLine();
        }
        return request;
    }
}
