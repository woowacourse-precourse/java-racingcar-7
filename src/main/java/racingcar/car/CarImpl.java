package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;

public class CarImpl implements ICar {

    private final static int DRIVE_STANDARD = 4;
    private final static int CAR_NAME_LENGTH_LIMIT = 5;
    private final String name;
    private int position;

    /**
     * @throws IllegalArgumentException 자동차 이름이 5자리를 초화할 경우
     */
    public CarImpl(String name) {
        if (name.length() > CAR_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("자동차 이름은 5자리 이하여야합니다");
        }

        this.name = name;
        this.position = 0;
    }

    @Override
    public int drive() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (DRIVE_STANDARD <= random) {
            position++;
        }

        return position;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPosition() {
        return position;
    }
}
