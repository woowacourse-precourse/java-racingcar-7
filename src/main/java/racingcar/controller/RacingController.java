package racingcar.controller;

import racingcar.dto.RaceRequest;
import racingcar.dto.RaceResponse;
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
    public void run(RaceRequest request) {

        // 1. 자동차 이름을 Model에 초기화
        model.initializeCars(request.getCarName());

        // 2. 시도 횟수만큼 경주 진행
        for (int i = 0; i < request.getRoundCount(); i++) {
            System.out.println("차시 : " + (i + 1));
            model.raceOneRound();
        }

        //3. 경주 결과 생성 (자동차 상태와 우승자를 포함한 Response 객체)
        RaceResponse response = new RaceResponse(model.getCarStates(), model.getWinners());

        // 4. 우승자 결정 및 출력
        view.printRaceResult(response);
    }
}
