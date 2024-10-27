package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.view.OutputView;

// 게임 실행을 담당하는 클래스
public class GameRunner {
    private final OutputView outputView; // 출력 뷰 객체

    // 생성자: 출력 뷰 객체를 초기화
    public GameRunner(OutputView outputView) {
        this.outputView = outputView;
    }

    // 경주 게임을 실행하는 메서드
    public void run(RacingGame racingGame) {
        // 모든 시도 횟수 동안 게임 진행
        while (racingGame.hasMoreTrials()) {
            racingGame.playRound(); // 한 라운드 실행
            outputView.printRoundResult(racingGame.getCars()); // 현재 라운드 결과 출력
        }
        outputView.printWinners(racingGame.getWinners()); // 최종 우승자 출력
    }
}
