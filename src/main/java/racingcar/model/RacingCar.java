package racingcar.model;

import static racingcar.exception.ErrorBase.CAR_NAME_IS_BETWEEN_ONE_AND_FIVE;
import static racingcar.exception.ErrorBase.CAR_NAME_IS_EMPTY;

import java.util.function.Supplier;
import org.junit.platform.commons.util.StringUtils;

public class RacingCar {
    private String name; // 자동차의 이름
    private int pos; // 자동차의 현재 위치
    private final int MOVESTANDARD = 4;


    public RacingCar(String name) {
        withName(name);
        this.pos = 0;
    }

    public void moveForward(Supplier<Integer> randomSupplier) {
        if(isForward(randomSupplier.get())) pos++;
    }


    public int getPos() {
        return pos;
    }

    public String getName(){
        return name;
    }

    private void withName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException(CAR_NAME_IS_EMPTY.getMessage());
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException(CAR_NAME_IS_BETWEEN_ONE_AND_FIVE.getMessage());
        }
        this.name = name;
    }

    private boolean isForward(int num) {
        return num >= MOVESTANDARD;
    }
}
