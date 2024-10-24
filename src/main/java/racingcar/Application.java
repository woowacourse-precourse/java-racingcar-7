package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 이름입력 기능
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarName = Console.readLine();

        // 이름 판단
        List<String> carNameList = Validate.carName(inputCarName);

        // 시도할 횟수를 입력 받는 기능
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputAttempts = Console.readLine();
        int attempts = Validate.attempts(inputAttempts);

        // Car 객체 생성
        List<Car> carList = Car.makeCar(carNameList);

        // 자동차 경주 진행
        for (int i = 0; i < attempts; i++) {
            race(carList);
        }
    }

    // 자동차 경주 진행
    private static void race(List<Car> carList) {
        for (Car car : carList) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                car.move();
            }
        }
    }

}