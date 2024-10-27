package racingcar.domain;

public class Car {
    private static final int MINIMUM_ADVANCE_VALUE = 4;

    private final String name;
    private int distance;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.distance = 0;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 최대 5자까지만 입력 가능합니다.");
        }
        if(name.isBlank()){
            throw new IllegalArgumentException("자동차 이름은 빈칸일 수 없습니다.");
        }
    }

    public void setDistance(int randomNumber) {
        if (randomNumber >= MINIMUM_ADVANCE_VALUE) {
            this.distance += 1;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
