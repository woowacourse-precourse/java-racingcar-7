package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 자동차 이름 입력 및 유효성 검사
        List<String> carNames = CarRacingGame.getCarNames();

        // 자동차 객체 초기화
        List<Car> cars = CarRacingGame.initializeCars(carNames);

        // 이동 횟수 입력 및 유효성 검사
        int attempts = CarRacingGame.getNumberOfAttempts();

        System.out.println("\n실행 결과");

        // 라운드별로 자동차 경주 진행
        for (int i = 0; i < attempts; i++) {
            CarRacingGame.playRound(cars);
        }

        // 우승자 선정 및 출력
        List<String> winners = CarRacingGame.findWinners(cars);
        CarRacingGame.printWinners(winners);
    }
}