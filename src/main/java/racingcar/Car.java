package racingcar;

public class Car {
    private String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public void go() {
        distance++;
    }

    public String getName() {
        return name;
    }
    public int getDistance() {
        return distance;
    }
    //거리 -치환
    public String exchangeDistance() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

}
