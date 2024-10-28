package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        String inputCarNames = inputView.readCarNames();
        String inputTryCount = inputView.readTryCount();
    }
}
