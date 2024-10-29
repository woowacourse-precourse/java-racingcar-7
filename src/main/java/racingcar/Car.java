package racingcar;

// 자동차 객체를 위한 클래스
public class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void move(int randomValue) {
        if (randomValue >= 4) {
            distance++;
        }
    }

    public String getProgress() {
        return "-".repeat(distance);
    }

    // 테스트를 위한 setter 메서드 추가
    public void setDistance(int distance) {
        this.distance = distance;
    }
}