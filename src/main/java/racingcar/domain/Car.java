package racingcar.domain;

import static racingcar.utils.Constant.MAX_RANDOM;
import static racingcar.utils.Constant.MIN_RANDOM;
import static racingcar.utils.Constant.MOVE_THRESHOLD;
import static racingcar.utils.Constant.MOVING;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Objects;

public class Car {

    private final String name;
    private Long cnt;

    public Car(String name) {
        this.name = name;
        this.cnt = 0L;
    }

    public Car(String name, Long cnt) {
        this.name = name;
        this.cnt = cnt;
    }

    // 랜덤값에 따라 전진하는지 멈추는 기능
    public Long move() {
        if (isMoveable()) {
            this.cnt += 1;
        }

        return this.cnt;
    }

    // 현재 현황을 스트링으로 표현하는 기능
    public String generateStatus() {
        StringBuilder output = new StringBuilder(this.name + " : ");

        long repeat = 0L;
        while (repeat < this.cnt) {
            output.append(MOVING);
            repeat++;
        }

        return output.toString();
    }

    public boolean isMaxMove(Long maxCnt) {
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
