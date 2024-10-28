package racingcar.view;

import racingcar.view.constant.Output;

public class ScoreBoard {

    public static String initMessage() {
        System.out.print(Output.SEPARATOR_BLANK_LINES);
        return Output.RESULT_HEADLINE.toString();
    }
}
