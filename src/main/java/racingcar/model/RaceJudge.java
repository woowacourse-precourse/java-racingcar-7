package racingcar.model;

import java.util.List;

public class RaceJudge {
    public static String[] determineWinner(List<RacingCar> racingCars) {
        return racingCars.stream()
                .filter(compareCar -> compareCar.getDistance().length()
                        == racingCars.stream()
                        .mapToInt(car -> car.getDistance().length())
                        .max()
                        .orElseThrow(() -> new IllegalArgumentException("리스트 값이 비어있습니다.")))
                .map(RacingCar::getName)
                .toArray(String[]::new);
    }
}
