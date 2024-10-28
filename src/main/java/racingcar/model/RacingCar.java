package racingcar.model;

import java.util.function.Supplier;

public class RacingCar {
    private String name; // 자동차의 이름
    private Integer position; // 자동차의 현재 위치
    private final int FORWARD_STANDARD = 4;

    public RacingCar(String name) {
        this.name = name;
        this.position = 0;
    }

    public void moveForward(Supplier<Integer> randomSupplier) {
        if (isForward(randomSupplier.get())) {
            position++;
        }
    }

    public Integer getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }


    private boolean isForward(Integer num) {
        return num >= FORWARD_STANDARD;
    }
}
