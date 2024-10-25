package racingcar.controller;

import racingcar.view.InputView;

public class RacingGame {
    private int attemptCount;
    public RacingGame(){
        initialize();
    }
    //게임 시작시 필요한 초기 설정 수행
    private void initialize(){
        String[] carNames = InputView.getCarNames();
        this.attemptCount = InputView.getAttemptCount();

    }
    public void run(){
        int attemptCount = InputView.getAttemptCount();
    }
}

