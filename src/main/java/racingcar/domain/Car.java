package racingcar.domain;

public class Car {
    public static final int NAME_LENGTH_MAX = 5;
    private final String name;
    private int location = 0;

    public Car(String name) {
        validBlank(name);
        validNameLength(name);
        this.name = name;
    }

    private void validBlank(String name) {
        if(name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백문자열일 수 없습니다");
        }
    }

    private void validNameLength(String name) {
        if(name.length() > NAME_LENGTH_MAX) {
            throw new IllegalArgumentException("이름의 길이가 5자를 넘을 수 없습니다");
        }
    }

    public void move(int randomNum) {
        if(isMovable(randomNum)) {
            location ++;
        }
    }

    private boolean isMovable(int randomNum) {
        return randomNum >= 4;
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

}
