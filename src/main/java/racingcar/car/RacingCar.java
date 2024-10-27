package racingcar.car;

import racingcar.strategy.MoveStrategy;

public class RacingCar {

    private final String carName;
    private int distance;

    /**
     * 생성자 - 테스트 코드에서만 사용 권고 합니다.
     *
     * @param carName
     * @param distance
     */
    public RacingCar(String carName, int distance) {
        this.carName = carName;
        this.distance = distance;
    }

    public static RacingCar of(String carName) {
        return new RacingCar(carName, 0);
    }

    public int getDistance() {
        return distance;
    }

    public String getCarName() {
        return carName;
    }

    public void moveForwardOneStep(MoveStrategy moveStrategy) {
        if (moveStrategy.canMove()) {
            distance += 1;
        }
    }

    public void printMoveStatus() {
        String currentCarStatus = carName + " : " + "-".repeat(distance);
        System.out.println(currentCarStatus);
    }


}
