package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
        try {
            // 자동차 이름 입력 받기
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String inputNames = Console.readLine();
            List<String> carNames = Arrays.asList(inputNames.split(","));

            checkCarNames(carNames);

            // 시도 횟수 입력 받기
            System.out.println("시도할 횟수는 몇 회인가요?");
            int tryCount = Integer.parseInt(Console.readLine());

            // 자동차 경주 시작
            List<Car> cars = initializeCars(carNames);
            startRace(cars, tryCount);


        } catch (IllegalArgumentException e) {
            System.out.println("입력 오류: " + e.getMessage());
        }
    }

    private static void checkCarNames(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }
    }

    private static List<Car> initializeCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private static void startRace(List<Car> cars, int tryCount) {
        System.out.println("\n실행 결과");

        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                int randomValue = Randoms.pickNumberInRange(0, 9);
                if (randomValue >= 4) {
                    car.move();
                }
                System.out.println(car);
            }
            System.out.println();
        }
    }

}
