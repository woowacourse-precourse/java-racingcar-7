package racingcar.controller;

import racingcar.dto.RaceRequest;
import racingcar.model.RacingModel;
import racingcar.view.RacingView;

public class RacingController {

    private final RacingModel model;
    private final RacingView view;


    // Controller 생성자 (Model과 View를 주입받음)
    public RacingController(RacingModel model, RacingView view) {
        this.model = model;
        this.view = view;
    }

    // 게임 실행
    public void run(RaceRequest request) {
        try {

            // 1. 자동차 이름을 Model에 초기화
            model.initializeCars(request.getCarName());

            // 2. 시도 횟수만큼 경주 진행
            for (int i = 0; i < request.getRoundCount(); i++) {
                System.out.println("차시 : " + (i + 1));
                view.printCarStates(model.getCarStates());
                model.raceOneRound();
            }

            // 3. 최종 우승자
            view.printWinners(model.getWinners());
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("오류");
        }
    }
}
