package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        int randomValue = Randoms.pickNumberInRange(0, 9); // 0에서 9 사이의 랜덤 값 생성
        if (randomValue >= 4) {
            ++position; // 랜덤 값이 4 이상일 경우 전진
        }
    }

    public String getPositionRepresentation() {
        return "-".repeat(position); // 현재 위치만큼 '-'를 반복하여 문자열 생성
    }
}
