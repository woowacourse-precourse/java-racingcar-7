package racingcar.domain;

import static racingcar.utils.Constant.COLON;
import static racingcar.utils.Constant.MAX_RANDOM;
import static racingcar.utils.Constant.MIN_RANDOM;
import static racingcar.utils.Constant.MOVE_THRESHOLD;
import static racingcar.utils.Constant.MOVING;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Objects;

public class Car {

    private final String name;
    private Integer moveCnt;

    public Car(String name) {
        this.name = name;
        this.moveCnt = 0;
    }

    public Car(String name, Integer moveCnt) {
        this.name = name;
        this.moveCnt = moveCnt;
    }

    public static Car create(String name) {
        return new Car(CarNameCollect.validName(name));
    }

    public static Car create(String name, Integer cnt) {
        return new Car(CarNameCollect.validName(name), cnt);
    }

    public Integer move() {
        if (isMoveable()) {
            this.moveCnt += 1;
        }

        return this.moveCnt;
    }

    protected String status() {
        String repeatStr = MOVING.repeat(this.moveCnt);

        return this.name + COLON + repeatStr;
    }

    public boolean isMaxMove(Integer maxCnt) {
        return moveCnt.equals(maxCnt);
    }

    private boolean isMoveable() {
        int randomNum = Randoms.pickNumberInRange(MIN_RANDOM, MAX_RANDOM);

        return randomNum >= MOVE_THRESHOLD;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(moveCnt, car.moveCnt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, moveCnt);
    }
}
