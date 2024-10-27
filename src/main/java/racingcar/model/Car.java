package racingcar.model;

public class Car {
    private final String name;
    private int position = 0;
    private static final int MOVE_CRITERIA_VALUE = 4;

    public Car(String name) {
        validateName(name.strip());
        this.name = name.strip();
    }

    private void validateName(String name) {
        if (name == null || name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름을 1자에서 5자 이하로 입력하지 않았습니다.: " + name);
        }
    }

    public void move(int randomValue) {
        if (randomValue >= MOVE_CRITERIA_VALUE) {
            position++;
        }
    }

    //현재 상태를 표시(ex. pobi : ---)
    public String displayState() {
        return name + " : " + "-".repeat(position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
