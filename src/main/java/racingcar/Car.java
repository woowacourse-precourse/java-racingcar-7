package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    private void validateName(String name) {
        if (name.isEmpty() || name.length() > 5)
            throw new IllegalArgumentException("이름은 빈 문자열이거나 5자를 초과할 수 없습니다.");
    }

    public void randomMove() {
        int rand = Randoms.pickNumberInRange(0, 9);

        if (rand >= 4)
            position++;
    }

    public String displayPosition() {
        StringBuilder display = new StringBuilder(name + " : ");
        display.append("-".repeat(position));

        return display.toString();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
