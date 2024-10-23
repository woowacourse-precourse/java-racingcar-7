package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class CarList {

    private final List<Car> cars;
    private Long maxMoveCnt;

    public CarList() {
        this.cars = new ArrayList<>();
        this.maxMoveCnt = 0L;
    }

    public CarList(List<Car> cars) {
        this.cars = cars;
        this.maxMoveCnt = 0L;
    }

    public void add(String name) {
        cars.add(new Car(name));
    }


    // 모든 자동차들을 움직이게 합니다.
    public void moveAll() {
        for (Car car : cars) {
            Long moveCnt = car.move();
            changeMaxMoveCnt(moveCnt);
        }
    }

    // 모든 자동차들의 현황을 출력합니다.
    public String generateStatus() {
        StringJoiner stringJoiner = new StringJoiner("\n");

        for (Car car : cars) {
            stringJoiner.add(car.generateStatus());
        }
        stringJoiner.add("\n");

        return stringJoiner.toString();
    }

    private void changeMaxMoveCnt(Long moveCnt) {
        if (this.maxMoveCnt < moveCnt) {
            this.maxMoveCnt = moveCnt;
        }
    }

    // 제일 많이 움직인 자동차들을 반환합니다.
    public Winners toWinners() {
        List<Car> winnerList = cars.stream()
                .filter(car -> car.isMaxMove(this.maxMoveCnt))
                .toList();

        return new Winners(winnerList);
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ");

        for (Car car : cars) {
            stringJoiner.add(car.toString());
        }

        return stringJoiner.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarList compareCarList = (CarList) o;
        return Objects.equals(cars, compareCarList.cars) && Objects.equals(maxMoveCnt,
                compareCarList.maxMoveCnt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, maxMoveCnt);
    }
}
