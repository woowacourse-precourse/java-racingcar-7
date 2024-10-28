package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
//

public class Car {
    private final String name;
    private int position;

    Car(String name) {
        this.name = name;
        position = 0;
    }

    Car(String name, int position) { //테스트용 생성자
        this.name = name;
        this.position = position;
    }

    public void move() {
        // TODO: 랜덤으로 전진 position +1
        if (Randoms.pickNumberInRange(0, 9) > 3) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
