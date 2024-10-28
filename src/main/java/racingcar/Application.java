package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            RacingCarGame game = new RacingCarGame();

            // 자동차 이름 입력 및 자동차 생성
            List<String> carNames = game.getCarNames();
            List<Car> cars = game.createCars(carNames);

            // 이동 횟수 입력 및 경주 시작
            int moveCount = game.getMoveCount();
            game.startRace(cars, moveCount);

            // 우승자 결정 및 출력
            List<String> winners = game.findWinners(cars);
            game.printWinners(winners);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
