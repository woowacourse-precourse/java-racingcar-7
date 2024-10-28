package racingcar.model;

public class Car {
    private String name;
    private int moveCount;

    public Car(String name) {
        isValidateName(name);
        this.name = name;
        this.moveCount = 0;
    }

    public String getName() { return this.name; }

    public int getMoveCount() { return this.moveCount; }

    private void isValidateName(String name) {
        if (!name.matches("^[a-zA-Z가-힣0-9]{1,5}$")) {
            throw new IllegalArgumentException("이름이 유효하지 않습니다.");
        }
    }

    public void move() {
        moveCount++;
    }

    public String toString() {
        return this.name + " : " + "-".repeat(this.moveCount);
    }
}
