package racingcar.domain;

import static racingcar.utils.Constant.COLON_SEPARATOR;
import static racingcar.utils.Constant.MAX_RANDOM;
import static racingcar.utils.Constant.MIN_RANDOM;
import static racingcar.utils.Constant.MOVE_THRESHOLD;
import static racingcar.utils.Constant.MOVING;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Objects;

public class Car {

    private final String name;
    private Integer cnt;

    public Car(String name) {
        this.name = name;
        this.cnt = 0;
    }

    public Car(String name, Integer cnt) {
        this.name = name;
        this.cnt = cnt;
    }

    public static Car create(String name) {
        return new Car(NameCollect.validName(name));
    }

    public static Car create(String name, Integer cnt) {
        return new Car(NameCollect.validName(name), cnt);
    }

    public Integer move() {
        if (isMoveable()) {
            this.cnt += 1;
        }

        return this.cnt;
    }

    // 현재 현황을 스트링으로 표현하는 기능
    protected String status() {
        String repeatStr = MOVING.repeat(this.cnt);

        return this.name + COLON_SEPARATOR + repeatStr;
    }

    public boolean isMaxMove(Integer maxCnt) {
        return cnt.equals(maxCnt);
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
        return Objects.equals(name, car.name) && Objects.equals(cnt, car.cnt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cnt);
    }
}
