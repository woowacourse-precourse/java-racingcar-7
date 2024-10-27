package racingcar;

import racingcar.domain.Car;
import racingcar.domain.CarGame;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            // 자동차 이름 입력
            String[] carNames = Input.carInput();

            // 게임 횟수 입력
            int n = Input.gameNumber();

            // 자동차 객체 생성
            List<Car> cars = CarGame.createCar(carNames);

            // 실행 결과 문구
            Output.printResultLetter();

            // 주어진 횟수 동안 실행
            CarGame.moveCar(cars, n);

            // 최대 전진 횟수 구하기
            int maxDistance = CarGame.findMaxDistance(cars);

            // 최대 전진 횟수를 가지는 자동차 이름 구하기
            List<String> winners = CarGame.findWinner(cars, maxDistance);

            // 최종 우승 자동차 출력
            Output.printWinner(winners);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}
