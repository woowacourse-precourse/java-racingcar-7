package racingcar.model;

import static racingcar.exception.ErrorBase.CAR_NAME_IS_BETWEEN_ONE_AND_FIVE;
import static racingcar.exception.ErrorBase.INPUT_IS_EMPTY;

import java.util.function.Supplier;
import org.junit.platform.commons.util.StringUtils;

public class RacingCar {
    private String name; // 자동차의 이름
    private int position; // 자동차의 현재 위치
    private final int FORWARD_STANDARD = 4;

    public RacingCar(String name) {
        this.name = name;
        this.position = 0;
    }

    public void moveForward(Supplier<Integer> randomSupplier) {
        if(isForward(randomSupplier.get())) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName(){
        return name;
    }


    private boolean isForward(int num) {
        return num >= FORWARD_STANDARD;
    }
}
