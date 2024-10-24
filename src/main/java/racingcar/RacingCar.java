package racingcar;

public class RacingCar extends Car implements Drivable {
    public RacingCar(String name) {
        super(name);
    }

    public void forward() {
        // 한칸 전진
        currentPosition++;
    }
    public void stop() {
        // 아무 동작도 하지 않음
    }

}
