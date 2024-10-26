package racingcar;

import java.util.List;

public class RacingCarGame {

    public void findWinners(List<RacingCar> racingCars) {
        int maxLocation = getMaxLocationCars(racingCars);
        List<String> winners = racingCars.stream()
                .filter(racingCar -> racingCar.getLocation() == maxLocation)
                .map(RacingCar::getCarNameValue)
                .toList();
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }

    public int getMaxLocationCars(List<RacingCar> racingCars) {
        return racingCars.stream()
            .mapToInt(RacingCar::getLocation)
            .max()
            .orElseThrow(() -> new IllegalArgumentException("최대 위치인 자동차가 없습니다."));
    }
}
