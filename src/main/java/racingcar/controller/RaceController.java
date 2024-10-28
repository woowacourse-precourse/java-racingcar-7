package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.OutputView;

/**
 * 레이싱 게임의 진행과 결과 출력을 관리하는 클래스
 */
public class RaceController {
    private final Cars cars;

    /**
     * 경주할 자동차들을 받아 초기화한다.
     *
     * @param cars 자동차 목록
     */
    public RaceController(Cars cars) {
        this.cars = cars;
    }

    /**
     * 정해진 라운드 수만큼 경주를 실행한다.
     *
     * @param rounds 전체 경주 라운드 수
     */
    public void startRace(int rounds) {
        for (int i = 0; i < rounds; i++) {
            playRound();
            OutputView.printRoundResult(cars); // 매 라운드 결과 출력
        }
        OutputView.printWinners(cars.getWinners()); // 최종 우승자 출력
    }

    /**
     * 한 라운드를 실행하며, 모든 자동차를 이동시킨다.
     */
    private void playRound() {
        cars.moveAll();
    }
}
