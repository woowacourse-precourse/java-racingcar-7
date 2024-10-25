package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;

public class CarImpl implements ICar {

    private final static int DRIVE_STANDARD = 4;
    private final String name;
    private int position;

    public CarImpl(String name) {
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
