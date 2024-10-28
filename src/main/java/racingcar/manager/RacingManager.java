package racingcar.manager;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingManager {

    private final List<Car> cars = new ArrayList<>();

    public void registerCars(String carNames) {

        String[] split = carNames.split(",");

        for (String carName : split) {

            isDuplicatedName(carName);
            cars.add(Car.of(carName));
        }
    }

    public void race(String count) {
        int parsedCount = Integer.parseInt(count);
        System.out.println("실행 결과");

        for (int i = 0; i < parsedCount; i++) {
            cars.forEach(
                    car -> {
                        int picked = Randoms.pickNumberInRange(0, 9);
                        if (picked >= 4) {
                            car.move(picked);
                        }
                        System.out.println(car.getName() + " : " + car.getForward());
                    }
            );
            System.out.println();
        }
    }

    private void isDuplicatedName(String carName) {
        if (cars.stream().anyMatch(car -> car.getName().equals(carName))) {
            throw new IllegalArgumentException("자동차 이름은 중복이 안됩니다.");
        }
    }

}
