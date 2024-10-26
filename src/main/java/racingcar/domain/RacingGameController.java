package racingcar.domain;

import racingcar.util.RandomDigitGenerator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RacingGameController {

    private List<Car> cars;
    private int tryCount;
    private RandomDigitGenerator rdg;

    public RacingGameController(Cars cars, int tryCount, RandomDigitGenerator rdg) {
        validTryCount(tryCount);
        this.cars = cars.getCars();
        this.tryCount = tryCount;
        this.rdg = rdg;
    }


    // 각 위치 출력하는 부분 OutputView로 분리해야 함
    public void playGame() {

        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                int digit = rdg.generateDigit();
                car.moveForwardIfDigitAboveThreshold(digit);
            }
            cars
                    .forEach(Car::printPosition);
            System.out.println();
        }
    }

    private List<Car> createCar(List<String> carNames) {
        List<Car> result = carNames.stream()
                .map(Car::new)
                .toList();

        validDuplicateName(result);

        return result;
    }

    public List<String> getWinner() {
        int max = cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(0);

        List<Car> winner = cars.stream().filter(car -> car.getPosition() == max)
                .toList();

        return winner.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private void validTryCount(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException("1이상 2,147,483,647이하의 양수만 입력 가능합니다.");
        }
    }

    private void validNameSize(List<String> carNames) {
        if (carNames.size() > 100) {
            throw new IllegalArgumentException("자동차는 100대까지 등록 가능합니다.");
        }
    }

    private static void validDuplicateName(List<Car> result) {
        Set<Car> carHashSet = new HashSet<>(result);
        if (result.size() != carHashSet.size()) {
            throw new IllegalArgumentException("중복되는 자동차 이름이 있습니다.");
        }
    }
}
