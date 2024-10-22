package racingcar;

public class Controller {

    private final OutputView outputView = new OutputView();

    public void run() {
        outputView.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

}
