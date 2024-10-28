package racingcar.domain;

public class Racing {

    private final CarList carList;
    private final int movingCount;

    public Racing(CarList carList, int movingCount) {
        this.carList = carList;
        this.movingCount = movingCount;
    }

    public String start() {
        StringBuilder result = new StringBuilder();
        getResult(result);
        return result.toString();
    }

    private void getResult(StringBuilder result) {
        result.append("\n실행 결과\n");
        try {
            aggregateProgress(result);
            getWinners(result);
        } catch (OutOfMemoryError e) {
            throw new IllegalArgumentException("이동 횟수가 너무 많습니다.");
        }
    }

    private void aggregateProgress(StringBuilder result) {
        for (int i = 0; i < movingCount; i++) {
            carList.getCars().forEach(Car::move);
            carList.getCars().forEach(car -> createMoveResult(car, result));
            result.append("\n");
        }
    }

    private void getWinners(StringBuilder result) {
        int maxPosition = carList.getMaxPosition();
        result.append("최종 우승자 : ");
        carList.getCars().stream()
                .filter(car -> car.isWinner(maxPosition))
                .forEach(car -> result.append(car.getName()).append(", "));
        result.delete(result.length() - 2, result.length());
    }

    private void createMoveResult(Car car, StringBuilder result) {
        result.append(car.getName()).append(" : ").append(car.getPositionResult()).append("\n");
    }

}
