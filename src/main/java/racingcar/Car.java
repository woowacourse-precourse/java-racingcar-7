package racingcar;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("자동차 이름은 null 이거나 빈 칸일 수 없습니다. 입력된 이름: (%s)", name));
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException(String.format("자동차 이름은 쉼표(,)를 기준으로 5글자이하로만 가능합니다. 입력된 이름: (%s)", name));
        }
        this.name = name.trim();
        this.position = position;
    }

    public int go(MoveCondition moveCondition) {
        if (moveCondition.canMove()) {
            return ++this.position;
        }
        return this.position;
    }

    public String getName() {
        return name;
    }
}
