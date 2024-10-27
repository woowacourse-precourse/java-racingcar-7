package racingcar.domain;

import static racingcar.utils.Constant.COMMA_SEPARATOR;
import static racingcar.utils.Constant.ENTER;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class CarList {

    private final List<Car> cars;
    private Integer maxMoveCnt;

    public CarList() {
        this.cars = new ArrayList<>();
        this.maxMoveCnt = 0;
    }

    protected CarList(List<Car> cars) {
        this.cars = cars;
        this.maxMoveCnt = 0;
    }

    public static CarList from(NameCollect nameCollect) {
        CarList carList = new CarList();
        String[] splitName = nameCollect.split();

        for (String name : splitName) {
            String validName = NameCollect.validName(name);
            carList.add(validName);
        }

        return carList;
    }

    public void add(String name) {
        Car car = Car.create(name);
        this.cars.add(car);
    }

    public void moveAll() {
        for (Car car : this.cars) {
            Integer moveCnt = car.move();
            changeMaxMoveCnt(moveCnt);
        }
    }

    // 모든 자동차들의 현황을 출력합니다.
    public String generateAllStatus() {
        StringJoiner stringJoiner = new StringJoiner(ENTER);

        for (Car car : this.cars) {
            String status = car.generateStatus();
            stringJoiner.add(status);
        }

        stringJoiner.add(ENTER);

        return stringJoiner.toString();
    }

    protected List<Car> toWinners() {
        return this.cars.stream()
                .filter(car -> car.isMaxMove(this.maxMoveCnt))
                .toList();
    }

    private void changeMaxMoveCnt(Integer moveCnt) {
        if (this.maxMoveCnt < moveCnt) {
            this.maxMoveCnt = moveCnt;
        }
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(COMMA_SEPARATOR + " ");

        for (Car car : this.cars) {
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
