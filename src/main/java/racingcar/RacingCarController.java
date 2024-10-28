package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {
    private final List<RacingCar> racingCars;
    private final int tryCount;

    public RacingCarController() {
        this.racingCars = InputView.inputRacingCars();
        this.tryCount = InputView.inputTryCount();
    }

    // 매 차수별 실행 결과를 출력
    public void carRun() {
        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            runRound();
            ResultView.printResult(racingCars);
        }
        ResultView.printWinners(determineWinners());
    }

    // 랜덤한 값을 기준으로 차량을 전진
    private void runRound() {
        for (RacingCar racingCar : racingCars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                racingCar.move();
            }
        }
    }

    // 우승자를 추려 List에 저장
    private List<RacingCar> determineWinners() {
        List<RacingCar> winners = new ArrayList<>();
        int maxPosition = getMaxPosition();
        for (RacingCar racingCar : racingCars) {
            if (racingCar.getPosition() == maxPosition) {
                winners.add(racingCar);
            }
        }
        return winners;
    }

    // RacingCar List중 최대로 전진한 값을 구함
    private int getMaxPosition() {
        int maxPosition = 0;
        for (RacingCar racingCar : racingCars) {
            if (maxPosition < racingCar.getPosition()) {
                maxPosition = racingCar.getPosition();
            }
        }
        return maxPosition;
    }
}
