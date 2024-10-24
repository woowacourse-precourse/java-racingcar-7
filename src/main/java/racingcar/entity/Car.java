package racingcar.entity;

public class Car {
    final String name;
    int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;

        if (name == null) {
            throw new IllegalArgumentException("이름은 null이 될 수 없습니다.");
        } else if (name.isEmpty()) {
            throw new IllegalArgumentException("이름은 빈 문자열이 될 수 없습니다.");
        } else if (5 < name.length()) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        } else if (name.contains(" ")) {
            throw new IllegalArgumentException("이름에 공백이 포함될 수 없습니다.");
        }

    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            this.position++;
        }
    }

}
