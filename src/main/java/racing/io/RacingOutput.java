package racing.io;

import racing.game.domain.Car;

import java.util.List;

public class RacingOutput {

    private String displayPosition(int repeatCnt) {
        return "-".repeat(repeatCnt);
    }

    private void displayCarPosition(Car car) {
        System.out.println(car.getName() + " : " + displayPosition(car.getPosition()));
    }

    public void displayStartMessage() {
        System.out.println("\n실행 결과");
    }
    public void displayCarPositions(List<Car> cars) {
        for (Car car : cars) {
            displayCarPosition(car);
        }
        System.out.println();
    }

    public void displayWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

}
