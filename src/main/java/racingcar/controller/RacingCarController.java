package racingcar.controller;

import racingcar.service.RacingCarService;
import racingcar.service.TryCount;

public class RacingCarController {
    private final RacingCarService racingCarService;

    public RacingCarController(RacingCarService racingCarService){
        this.racingCarService = racingCarService;
    }


    public void playGame(TryCount tryCount) {
        while(tryCount.playOneRound()){
            racingCarService.moveCars();
            // 각 회차별 움직인 모습 보여주는 OutputView 메소드 실행
        }
        // winner 보여주는 OutputView 메소드 실행
    }
}
