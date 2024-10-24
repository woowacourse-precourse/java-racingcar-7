package racingcar;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class RacingCarController {

    private static final int MIN_CAR_LENGTH = 1;
    private static final int MAX_CAR_LENGTH = 100;
    private static final String CAR_LENGTH_ERROR_MESSAGE =
            String.format("자동차의 개수는 %d 이상 %d 이하여야 합니다.", MIN_CAR_LENGTH, MAX_CAR_LENGTH);
    private static final int MIN_ROUND = 1;
    private static final int MAX_ROUND = 100;
    private static final String RACE_ROUND_LENGTH_ERROR_MESSAGE =
            String.format("시도 횟수는 %d 이상 %d 이하여야 합니다.", MIN_CAR_LENGTH, MAX_CAR_LENGTH);

    public void racing(List<String> carNames, int raceRound) {
        if (carNames.size() < MIN_ROUND || carNames.size() > MAX_ROUND) {
            throw new IllegalArgumentException(CAR_LENGTH_ERROR_MESSAGE);
        }
        if (raceRound < MIN_ROUND || raceRound > MAX_ROUND) {
            throw new IllegalArgumentException(RACE_ROUND_LENGTH_ERROR_MESSAGE);
        }

        List<Car> cars = carNames.stream().map(Car::new).collect(Collectors.toList());

        System.out.println();
        System.out.println("실행결과");
        while (raceRound-- > 0) {
            cars.forEach(Car::move);
            cars.forEach(car -> {
                StringBuilder sb = new StringBuilder(car.getName() + " : ");
                int distance = car.getDistance();
                while (distance-- > 0) {
                    sb.append("-");
                }
                System.out.println(sb);
            });
            System.out.println();
        }

        cars.sort(Collections.reverseOrder());
        Car largestCar = cars.get(0); // 가장 큰 요소
        List<Car> largestCars = cars.stream()
                .filter(car -> car.compareTo(largestCar) == 0)
                .toList();
        String result = largestCars.stream().map(Car::getName).collect(Collectors.joining(", "));
        System.out.print("최종 우승자 : " + result);
    }
}
