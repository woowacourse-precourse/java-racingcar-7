package racingcar.view;

import racingcar.model.RacingCar;

public class RaceView {
    public void printResults(RacingCar[] cars) {
        for (RacingCar car : cars) {
            System.out.print(car.getName() + ": " + car.getResults() + " "); // 자동차 이름과 누적 결과 출력
        }
        System.out.println(); // 줄바꿈
    }

    public void printWinner(String winners) {
        System.out.println("최종 우승자: " + winners);
    }

    public void printInputPrompt(String message) {
        System.out.println(message);
    }
}

