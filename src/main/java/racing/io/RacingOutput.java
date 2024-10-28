package racing.io;

import racing.game.domain.Car;

import java.util.List;

public class RacingOutput {

    //   todo : 메서드 명 수정
    private String displayPosition(int repeatCnt) {
        return "-".repeat(repeatCnt);
    }

    private void displayCarPosition(Car car) {
        System.out.println(car.getName() + " : " + displayPosition(car.getPosition()));
    }

    public void displayPositions(List<Car> cars) {
        System.out.println("실행 결과");
        for (Car car : cars) {
            displayCarPosition(car);
        }
        System.out.println();
    }

    public void displayWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

}
