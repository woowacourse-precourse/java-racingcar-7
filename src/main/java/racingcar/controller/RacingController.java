package racingcar.controller;

import racingcar.model.RacingcarModel;
import racingcar.view.RacingView;

public class RacingController {

    private RacingcarModel model;
    private RacingView view;

    // Controller 생성자 (Model과 View를 주입받음)
    public RacingController(RacingcarModel model, RacingView view) {
        this.model = model;
        this.view = view;
    }

    // 게임 실행
    public void run() {
        // 1. 자동차 이름 입력 받기
        String[] carNames = view.getCarNames();
        model.initializeCars(carNames);  // Model에 자동차 이름 초기화

        // 2. 시도 횟수 입력 받기
        int roundCount = view.getRoundCount();

        // 3. 경주 진행
        for (int i = 0; i < roundCount; i++) {
            System.out.println("차시 : " + (i + 1));
            for (String carName : carNames) {
                model.advanceCar(carName);  // 각 차수마다 자동차 전진
            }
            // 4. 현재 차수의 자동차 상태 출력
            view.printCarStates(model.getCarStates());
        }

        // 5. 최종 우승자 출력
        String winners = model.getWinners();
        view.printWinners(winners);
    }
}
