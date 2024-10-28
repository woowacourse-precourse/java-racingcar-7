package racingcar.view;

public class ErrorView {
    private static final String ERROR_MESSAGE_TEMPLATE = "[ERROR] ";

    public void errorPage(String message) {
        System.out.println(ERROR_MESSAGE_TEMPLATE + message);
    }
}
