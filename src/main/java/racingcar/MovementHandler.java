package racingcar;

public class MovementHandler {

    public int storeMovement(String movement) {
        CarData carData = new CarData();
        carData.setMovementNumber(Integer.parseInt(movement));

        // 설정한 movementNumber 값을 반환
        return carData.getMovementNumber();
    }
}
