package racingcar.output;

import racingcar.constant.Constant;

public class OutputViewer {

    private OutputViewer() {
    }

    public static void getCarNameInputMessage() {
        System.out.println(Constant.CAR_NAME_INPUT_STRING);
    }

    public static void getTryCountInputMessage() {
        System.out.println(Constant.TRY_COUNT_INPUT_STRING);
    }

    public static void getRacingProgressMessage() {
        System.out.println(Constant.RACING_PROGRESS_STRING);
    }

    public static void getRacingResultMessage(String result) {
        System.out.println(Constant.RACING_RESULT_STRING + result);
    }
}
