package racingcar.view;

import racingcar.domain.RacingCar;

import java.util.List;

public class RoundView {

    List<RacingCar> racingCars;

    public RoundView() {
    }

    public void setRacingCars(List<RacingCar> racingCars) {
        System.out.println();
        System.out.println("실행 결과");
        this.racingCars = racingCars;
    }

    public void showRoundResults() {
        racingCars.forEach(
                racingCar -> System.out.println(racingCar.getName() + " : " + "-".repeat((int) racingCar.getMoveCount()))
        );
        System.out.println();
    }
}
