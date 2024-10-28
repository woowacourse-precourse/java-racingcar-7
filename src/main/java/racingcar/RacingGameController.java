package racingcar;

import java.util.List;

public class RacingGameController {
    private final RacingGame racingGame;

    public RacingGameController(RacingGame racingGame){
        this.racingGame = racingGame;
    }

    /**
     * 실행 메서드
     * */
    public void start(){
        // 자동차 이름 입력받기
        List<String> carNames = racingGame.getValidatedCarNames();
        // 자동차 생성
        racingGame.createCars(carNames);
        // 사용자 실행 횟수 입력받기
        int attemptCount = racingGame.getAttemptCount();
        // 실행 횟수 만큼 자동차 전진
        racingGame.raceByAttemptCount(attemptCount);
        // 우승자 출력
        racingGame.outputWinners(racingGame.getWinners());
    }

}
