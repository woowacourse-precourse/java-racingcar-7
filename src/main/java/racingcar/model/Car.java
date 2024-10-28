package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

// 자동차 객체
public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
        this.name = name;
    }

    // 전진 메소드
    public void move() {
        int randValue = Randoms.pickNumberInRange(0, 9);
        if (randValue >= 4) { // 랜덤값이 4 이상이면 한칸 전진
            position++;
        }
    }

    // getter
    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
