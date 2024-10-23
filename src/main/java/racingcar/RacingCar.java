package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar implements Car {
    private String name;
    private int status = 0;

    public RacingCar(String name) {
        this.name = setName(name);
    }


    @Override
    public void moveOrStop() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            status++;
        }
    }

    @Override
    public void move() {

    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        if (name.length() > 5)
            throw new IllegalArgumentException("이름은 5자 이내로 입력하세요.");
        this.name = name;
        return name;
    }

    public int getStatus() {
        return status;
    }
    public String getStatusToDash() {
        return "-".repeat(Math.max(0, status));
    }
}
