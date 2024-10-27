package racingcar;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RacingGame {
    private final RacingCars racingCars;

    public RacingGame(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    // 전체 레이싱 실행 메서드
    public void startRacing(int movementNumber) {
        validateMovement(movementNumber);
        System.out.println("\n실행 결과");
        for (int i = 0; i < movementNumber; i++) {
            raceRound();
            System.out.println();
        }
    }

    private void raceRound() {
        List<Car> cars = racingCars.getCars();
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            raceCar(car);
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
    }

    // 개별 자동차의 이동 여부를 결정하고 이동시키는 메서드
    private void raceCar(Car car) {
        if (moveForward()) {
            car.moveForward();
        }
    }

    private boolean moveForward() {
        return randomFunction() >= 4;
    }

    public int randomFunction() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private void validateMovement(int movement) {
        if (movement <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 정수여야 합니다.");
        }
    }
}

