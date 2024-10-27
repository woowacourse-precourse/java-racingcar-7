package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Input.readCarNames();

        CarRacing carRacing = new CarRacing();
        List<Car> carList = carRacing.settingCar(carNames);

        System.out.println("시도할 횟수는 몇 회인가요?");
        int numberOfMoves = Input.readNumberOfMoves();

        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < numberOfMoves; i++) {
            carRacing.moveCar(carList);
            carRacing.printCarLocation(carList);
        }

        int max = 0;
        for (Car car : carList) {
            max = Math.max(max, car.getLocation());
        }

        List<String> winners = new ArrayList<>();
        for (Car car : carList) {
            if (car.getLocation() == max) {
                winners.add(car.getName());
            }
        }
        String result = String.join(",", winners);

        System.out.println("최종 우승자 : " + result);
    }
}
