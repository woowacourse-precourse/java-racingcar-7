package racingcar;

public class Car {
    private final String name;
    private String progress;

    Car (String name) {
        this.name = name;
        progress = "";
    }

    Car (String name, String progress) {
        this.name = name;
        this.progress = progress;
    }

    public void forward() {
        progress += "-";
    }

    public String getName() {
        return name;
    }

    public String getProgress() {
        return progress;
    }

    // name 을 기준으로 equals 와 hashCode 오버라이드
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
