package racingcar.view;

public class OutputView {
    private static final String RESULT_MESSAGE = "최종 우승자 : ";
    private static OutputView outputView;

    private OutputView(){
    }

    public static OutputView getInstance() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public void printResult(String result) {
        System.out.print(RESULT_MESSAGE + result);
    }

    public void close() {
        if (outputView != null) {
            outputView = null;
        }
    }
}
