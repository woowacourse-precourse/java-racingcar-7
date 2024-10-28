package racingcar.view;

import racingcar.domain.Car;

public class RaceStatusView {

    public void showRaceStatus(Car car) {
        System.out.println(car.getName() + " : " + car.getRacingCount());
    }
}
