package racingcar.view;


import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String CAR_NAME_QUESTION = "경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)";
    private static final String CAR_TRY_QUESTION = "시도할 횟수";

    public InputView() {
    }

    public String inputCarNames() {
        System.out.println(CAR_NAME_QUESTION);
        return Console.readLine();
    }

    public static int inputTryCount() {
        System.out.println();
        System.out.println(CAR_TRY_QUESTION);
        return Integer.parseInt(Console.readLine());
    }

}
