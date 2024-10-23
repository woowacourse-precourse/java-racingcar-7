package racingcar.entity;

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

    // 랜덤값에 따라 전진하는지 멈추는 기능
    public Integer move() {

        // 랜덤 값을 강제로 지정하게 하고 싶은데
        int randomNum = Randoms.pickNumberInRange(0, 9);

        if (randomNum <= 4) {
            return this.cnt;
        }
        this.cnt += 1;

        return this.cnt;
    }

    // 현재 현황을 스트링으로 표현하는 기능
    public String print() {
        String status = MOVING.repeat(cnt);
        String output = this.name + " : " + status;
        System.out.println(output);

        return output;
    }

    public boolean isMaxMove(Integer maxCnt) {
        return cnt.equals(maxCnt);
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
