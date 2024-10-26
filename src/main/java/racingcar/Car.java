package racingcar;

public class Car {
    private String name;
    private String distance;

    public Car(String name) {
        this.name = name;
        this.distance = "";
    }

    public void increaseDistance() {
        this.distance = this.distance.concat("-");
    }

    public String getDistance() {
        return this.distance;
    }

    public String getName() {
        return this.name;
    }

    public void move(Boolean isMove) {
        if (isMove) {
            increaseDistance();
        }
    }

}
