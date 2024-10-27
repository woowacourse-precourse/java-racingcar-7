package racingcar.view;

public class OutputView {
    private OutputView() {}

    private static class Holder {
        private static final OutputView INSTANCE = new OutputView();
    }

    public static OutputView getInstance() {
        return Holder.INSTANCE;
    }
}
