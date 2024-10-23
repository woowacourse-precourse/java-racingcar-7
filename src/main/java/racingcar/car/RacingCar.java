package racingcar.car;

public class RacingCar {

    private String carName;
    private Long distance;

    public void forwardCar(Long move) {
        distance += move;
    }

    public void printMoveStatus() {
        String currentCarStatus = carName + " : " + "=".repeat(Math.toIntExact(distance));
        System.out.println(currentCarStatus);
    }
}
