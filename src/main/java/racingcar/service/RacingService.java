package racingcar.service;

import racingcar.domain.RacingCar;

import java.util.List;

public class RacingService {
    private final List<RacingCar> cars;
    private final int laps;
    private int maxDistance = 0;

    public RacingService(List<RacingCar> cars, int laps) {
        this.cars = cars;
        this.laps = laps;
    }

    public void startRace() {
        System.out.println("실행 결과");
        for (int i = 0; i < laps; i++) {
            startLap();
        }
        showWinner();
    }

    private void showWinner() {
        final StringBuffer sb = new StringBuffer("최종 우승자 : ");
        final List<String> winners = cars.stream()
                .filter(car -> car.getForwardedNumber() == maxDistance)
                .map(RacingCar::getDriverName)
                .toList();
        System.out.println(sb.append(String.join(", ",winners)));
    }
    private void startLap() {
        for (RacingCar car : cars) {
            car.playRace();
            updateMaxDistance(car.getForwardedNumber());
        }
        System.out.println();
    }

    private void updateMaxDistance(int input) {
        if (input > maxDistance) {
            maxDistance = input;
        }
    }
}
