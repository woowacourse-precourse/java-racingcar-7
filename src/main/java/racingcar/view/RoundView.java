package racingcar.view;

import racingcar.domain.RacingCars;

import static racingcar.util.PromptMessage.ROUND_RESULTS;


public class RoundView {

    public void startRaceRound() {
        System.out.println(ROUND_RESULTS);
    }

    public void showRoundResults(RacingCars racingCars) {
        racingCars.getRacingCars().forEach(
                racingCar -> System.out.println(racingCar.getName() + " : " + "-".repeat((int) racingCar.getMoveCount()))
        );
        System.out.println();
    }
}
