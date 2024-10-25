package racingcar;

import static util.Input.getInput;

import dto.RacingInput;
import java.util.ArrayList;
import util.Car;
import util.Output;

public class Application {
    public static void main(String[] args) {
        // 여기서 사용되지 않는 코드는 필요 없는 코드가 아닐까?
        // 절차지향으로 TDD 한 뒤에 리팩토링 하면서 함수 쪼개고 TDD 하기

        // 입력 기능
        RacingInput input = getInput();

        // 자동차 이름 추출 기능
        String[] inputCars = input.cars().split(",");

        // 자동차 이름 유효성 검증
        for (String car : inputCars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 최대 5글자 입니다.");
            }
        }

        Car[] cars = new Car[inputCars.length];
        for (int i = 0; i < inputCars.length; i++) {
            cars[i] = new Car(inputCars[i]);
        }

        int repeatCount = Integer.parseInt(input.repeatCount());

        // 실행
        for (Car car : cars) {
            car.startRacing(repeatCount);
        }

        // 출력
        System.out.println("실행 결과");
        for (int i = 1; i <= repeatCount; i++) {
            Output.printRaceStatus(cars, i);
        }

        // 우승 차량 선별 기능
        // extractWinningCars
        int max = 0;
        for (Car car : cars) {
            if (car.getForwardCount(repeatCount) > max) {
                max = car.getForwardCount(repeatCount);
            }
        }

        ArrayList<String> winningCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getForwardCount(repeatCount) == max) {
                winningCars.add(car.getName());
            }
        }

        // 우승자 출력
        String result = String.join(", ", winningCars);
        System.out.println("최종 우승자 : " + result);
    }
}
