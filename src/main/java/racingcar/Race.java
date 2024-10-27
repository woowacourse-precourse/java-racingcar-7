package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<RacingCar> racingCars;

    public Race(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    /**
     * 시도 횟수를 입력으로 받아서 전진 조건에 맞추어서 시도 횟수만큼 반복하여 차를 움직이는 메소드
     * @param inputMoves 시도 횟수
     */
    public void startRace(int inputMoves) {
        System.out.println("실행 결과");
        for (int i = 0; i < inputMoves; i++) {
            moveCars();
            OutputHandler.printCars(racingCars);
        }
    }

    private void moveCars() {
        for (RacingCar racingCar : racingCars) {
            racingCar.move();
        }
    }

    public List<String> getWinners() {
        int maxPosition = racingCars.stream().mapToInt(RacingCar::getPosition).max().orElse(0);

        List<String> winners = new ArrayList<>();
        for (RacingCar racingCar : racingCars) {
            if (racingCar.getPosition() == maxPosition) {
                winners.add(racingCar.getName());
            }
        }
        return winners;
    }
}
