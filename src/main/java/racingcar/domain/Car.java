package racingcar.domain;

import racingcar.enums.CarMovement;

/**
 * packageName    : racingcar.domain
 * fileName       : Car
 * author         : ehgur
 * date           : 2024-10-24
 * description    : 자동차 정보를 관리하기 위한 class
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-24         ehgur            최초 생성
 */

public class Car {

    private final String name;
    private int moveCount;
    private CarMovement movementStatus;

    public Car(String name, int moveCount) {
        this.name = name;
        this.moveCount = moveCount;
        this.movementStatus = CarMovement.STOPPED;
    }

    public void updateMovementStatus(CarMovement movementStatus) {
        this.movementStatus = movementStatus;
    }

    public void addMoveCount() {
        this.moveCount += 1;
    }

    public String getName() {
        return this.name;
    }

    public int getMoveCount() {
        return this.moveCount;
    }

    public CarMovement getMovementStatus() {
        return this.movementStatus;
    }
}
