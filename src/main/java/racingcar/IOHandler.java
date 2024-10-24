package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class IOHandler {

    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String END_MESSAGE = "최종 우승자 : ";

    public static String inputName() {
        System.out.println(START_MESSAGE);
        return Console.readLine();
    }

    public static String inputTryCount() {
        System.out.println(TRY_COUNT_MESSAGE);
        return Console.readLine();
    }

    public static void printResult() {
        System.out.println(RESULT_MESSAGE);

    }

    public static void printWinner() {
        System.out.println(END_MESSAGE);

    }
}
