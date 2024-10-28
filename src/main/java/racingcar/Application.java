package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import racingcar.car.Car;
import racingcar.validation.CarNameValidator;
import racingcar.findwinner.FindWinner;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();


        List<String> carNames = new ArrayList<>(Arrays.asList(input.split(",")));
        List<Car> cars = new ArrayList<>();

        CarNameValidator validator = new CarNameValidator();
        validator.validateCarNames(carNames);

        //자동차 객체 생성
        for (String name : carNames) {
            Car car = new Car(name);
            cars.add(car);
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        int attempts = Integer.parseInt(Console.readLine());
        Console.close();

        //전진 시작
        System.out.println("실행 결과");
        for (int i = 0; i < attempts; i++) {
            for (Car car : cars) {
                car.tryMove();
            }
            //자동차의 현재 전진 거리 출력
            printCarDistance(cars);
            System.out.println();
        }

        System.out.println("최종 우승자 : " + FindWinner.findWinner(cars));
    }

    private static void printCarDistance(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getDistance());
        }
    }
}
