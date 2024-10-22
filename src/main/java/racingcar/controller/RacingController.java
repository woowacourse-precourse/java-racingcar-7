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
        // 1. 사용자 입력 받기 (자동차 이름 입력 및 시도 횟수 입력)
        String[] carNames = view.getCarNames();  // 자동차 이름 입력 받기
        int roundCount = view.getRoundCount();   // 라운드 수 입력 받기

        // 2. 자동차 이름을 Model에 초기화
        model.initializeCars(carNames);

        // 3. 시도 횟수만큼 경주 진행
        for (int i = 0; i < roundCount; i++) {
            System.out.println("차시 : " + (i + 1));
            model.raceOneRound();  // 각 라운드에서 모든 자동차 전진 시도
            view.printCarStates(model.getCarStates());  // 각 라운드의 자동차 상태 출력
        }

        // 4. 우승자 결정 및 출력
        String winners = model.getWinners();
        view.printWinners(winners);
    }
}
