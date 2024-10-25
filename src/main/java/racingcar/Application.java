package racingcar;

import racingcar.game.Play;
import racingcar.view.Data;
import racingcar.view.InputView;
import racingcar.view.OutView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        Data inputData = inputView.inputData(); // 사용자에게 데이터 입력 받은 후 inputData 에 저장

        String[] cars = inputData.getCarNames().split(",");
        int trialNum = inputData.getTrialNum();

        Play racing = new Play();
        racing.playRacing(cars, trialNum);

        OutView outView = new OutView();


    }
}