package racingcar.domain;

import static racingcar.common.Constants.MOVE;
import static racingcar.common.Constants.ROUND_RESULT_PROMPT;
import static racingcar.common.Constants.START_LOCATION;
import static racingcar.service.ValidationService.validateCarName;

public class Car {
    private final String name;
    private Integer goCnt;

    public Car(String name) {
        validateCarName(name);

        this.name = name;
        this.goCnt = START_LOCATION;
    }

    public boolean compareCarName(String expectedCarName) {
        return name.equals(expectedCarName);
    }

    public boolean compareCarGoCnt(Integer expectedGoCnt) {
        return goCnt.equals(expectedGoCnt);
    }

    public void move() {
        goCnt ++;
    }

    public String getRoundResult() {

        return name + ROUND_RESULT_PROMPT + MOVE.repeat(goCnt);
    }

    public Integer getGoCnt() {
        return goCnt;
    }
}
