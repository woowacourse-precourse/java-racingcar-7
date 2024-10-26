package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final int MAX_NAME_LENGTH = 5;
    private final int NUMBER_CAN_GO = 4;

    private String name;
    private int progress;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.progress = 0;
    }

    public Car(String name, int progress) {
        validateName(name);
        this.name = name;
        this.progress = progress;
    }

    private void validateName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름은 공백이 될수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("5자 이하의 이름을 입력해주세요");
        }
    }

    public void randomGo() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= NUMBER_CAN_GO) {
            this.go();
        }
    }

    private void go() {
        this.progress++;
    }

    public String name() {
        return name;
    }
}
