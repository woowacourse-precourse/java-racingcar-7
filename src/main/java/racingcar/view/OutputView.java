package racingcar.view;

import racingcar.util.Utils;

public class OutputView {
    private static OutputView outputView;

    public static OutputView getInstance() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public void inputMessage(){
        System.out.println(Utils.INPUT_MESSAGE);
    }

    public void inputCountMessage(){
        System.out.println(Utils.INPUT_COUNT_MESSAGE);
    }
}
