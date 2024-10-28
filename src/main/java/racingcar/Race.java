package racingcar;

import java.util.List;

public class Race {
    private List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void startRace(int attempts) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < attempts; ++i) {
            moveCars();
        }
        announceWinners();
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
            System.out.println(car.getName() + " : " + car.getPositionRepresentation() + "\n");
        }
    }

    private void announceWinners() {
        int maxPosition = findMaxPosition();
        String winners = getWinners(maxPosition);
        System.out.println("최종 우승자 : " + winners);
    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private String getWinners(int maxPosition) {
        StringBuilder winners = new StringBuilder();
        appendWinners(winners, maxPosition);
        return winners.toString();
    }

    private void appendWinners(StringBuilder winners, int maxPosition) {
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                appendWinner(winners, car.getName());
            }
        }
    }

    private void appendWinner(StringBuilder winners, String name) {
        if (!winners.isEmpty()) {
            winners.append(", ");
        }
        winners.append(name);
    }
}