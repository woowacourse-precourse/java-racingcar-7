package racingcar;

public class RacingCar {

    private final String id;
    private int distance = 0;

    public RacingCar(String id) {
        this.id = id;
    }

    // TODO : 클래스 내부에서 이동거리 더하는 연산으로 변경 예정
    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return id + " : " + "-".repeat(distance);
    }
}
