package racingcar.View;

public class OutputView {

    InputView inputView = new InputView();

    public void askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        inputView.inputRacingCarName();
    }

}
