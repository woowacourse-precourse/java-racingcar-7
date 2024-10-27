package racingcar.view;


import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String CAR_NAME_QUESTION = "경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)";
    private static final String CAR_TRY_QUESTION = "시도할 횟수";
    private static final String TRY_COUNT_ERROR_MESSAGE = "시도 횟수는 양수여야 합니다.";
    private static final int MIN_TRY_COUNT = 1;

    public InputView() {
    }

    public String inputCarNames() {
        System.out.println(CAR_NAME_QUESTION);
        return Console.readLine();
    }

    public static int inputTryCount() {
        System.out.println(CAR_TRY_QUESTION);
        int tryCount = Integer.parseInt(Console.readLine());
        validateTryCount(tryCount);
        return tryCount;
    }

    public static void validateTryCount(int tryCount) {
        if(tryCount < MIN_TRY_COUNT) {
            throw new IllegalArgumentException(TRY_COUNT_ERROR_MESSAGE);
        }
    }

}
