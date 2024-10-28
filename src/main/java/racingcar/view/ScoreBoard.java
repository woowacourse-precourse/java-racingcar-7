package racingcar.view;

import racingcar.view.constant.Output;

public class ScoreBoard {

    public static String initMessage() {
        System.out.print(Output.SEPARATOR_BLANK_LINES);
        return Output.RESULT_HEADLINE.toString();
    }

    public static String carStatus (String carName, String mileages) {
        return String.format(Output.CAR_POSITION_FORMAT.toString(), carName, mileages);
    }
}
