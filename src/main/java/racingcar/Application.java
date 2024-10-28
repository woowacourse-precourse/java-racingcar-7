package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Car> cars = InputHandler.getCars();  // 입력된 자동차 목록 받기
        int attempts = InputHandler.getAttempts();  // 입력된 시도 횟수 받기

        RaceController raceController = new RaceController();
        System.out.println();
        System.out.println("실행 결과");
        raceController.runRace(attempts, cars);

        raceController.getWinner(cars);
    }
}
