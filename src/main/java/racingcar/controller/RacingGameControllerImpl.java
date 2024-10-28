package racingcar.controller;

import racingcar.model.RacingGameModel;
import racingcar.view.RacingGameView;

/**
 * RacingGameController 인터페이스의 구현체로, 자동차 경주 게임의 흐름을 제어한다.
 * 모델과 뷰를 사용하여 사용자 입력을 받고, 게임 로직을 실행하고, 결과를 출력한다.
 */
public class RacingGameControllerImpl implements RacingGameController {

    private final RacingGameModel model;  // 게임 로직을 처리하는 모델
    private final RacingGameView view;    // 사용자와 상호작용(입출력)하는 뷰

    /**
     * RacingGameControllerImpl 생성자
     * @param model 자동차 경주 게임의 로직을 처리하는 모델 객체
     * @param view 사용자 입력과 결과 출력을 담당하는 뷰 객체
     */
    public RacingGameControllerImpl(RacingGameModel model, RacingGameView view) {
        this.model = model;
        this.view = view;
    }

    /**
     * 자동차 경주 게임을 실행한다.
     * 사용자로부터 자동차 이름과 시도 횟수를 입력받고, 모델을 통해 게임을 진행한 후 결과를 출력한다.
     */
    @Override
    public void run() {
        // 사용자로부터 자동차 이름과 시도 횟수를 입력받음
        String carNames = view.getCarNames();
        String trialNum = view.getTrialNum();

        // 모델을 통해 게임 실행 후 결과를 받아옴
        String result = model.play(carNames, trialNum);

        // 결과를 사용자에게 출력
        view.showResult(result);
    }
}