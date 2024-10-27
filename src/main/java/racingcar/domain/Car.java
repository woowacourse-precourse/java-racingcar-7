package racingcar.domain;

public class Car {
    private final String name;
    private int location = 0;

    public Car(String name) {
        validNameLength(name);
        this.name = name;
    }

    private void validNameLength(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("이름의 길이가 5자를 넘을 수 없습니다");
        }
    }

    public void move(int randomNum) {
        if(isMovable(randomNum)) {
            location ++;
        }
    }

    private boolean isMovable(int randomNum) {
        if (randomNum >= 4) {
            return true;
        }
        return false;
    }

    public int getLocation() {
        return this.location;
    }

    public String getName() {
        return name;
    }

}
