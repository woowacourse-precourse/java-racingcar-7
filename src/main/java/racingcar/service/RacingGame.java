package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.model.Car;

public class RacingGame {
    static final int MIN_ACCELERATOR = 4;

    /**
     * 자동차 리스트와 각 자동차에 해당하는 가속도 리스트를 받아 레이스를 시작합니다.
     *
     * @param cars         레이스에 참여하는 자동차 리스트
     * @param accelerators 각 자동차의 가속도 값 리스트
     */
    public void startRace(List<Car> cars, List<Integer> accelerators) {
        IntStream.range(0, cars.size())
                .filter(car -> accelerators.get(car) >= MIN_ACCELERATOR)
                .mapToObj(cars::get)
                .forEach(Car::move);
    }


    /**
     * 가장 멀리 이동한 자동차들의 이름을 찾아 반환합니다.
     *
     * @param cars 레이스가 끝난 후의 자동차 리스트
     * @return 우승자의 이름 리스트
     */
    public List<String> findWinner(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::currentPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.currentPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
