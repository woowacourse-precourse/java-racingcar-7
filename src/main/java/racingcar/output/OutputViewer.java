package racingcar.output;

import racingcar.constant.Constant;

public class OutputViewer {

    public OutputViewer() {
    }

    public void getCarNameInputMessage() {
        System.out.println(Constant.CAR_NAME_INPUT_STRING);
    }

    public void getTryCountInputMessage() {
        System.out.println(Constant.TRY_COUNT_INPUT_STRING);
    }

    public void getRacingProgressMessage() {
        System.out.println("\n" + Constant.RACING_PROGRESS_STRING);
    }

    public void getSystemOutPrint(String string) {
        System.out.print(string);
    }

    public void getRacingResultMessage(String result) {
        System.out.println(Constant.RACING_RESULT_STRING + result);
    }
}
