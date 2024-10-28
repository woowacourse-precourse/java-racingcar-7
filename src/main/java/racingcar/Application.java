package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();
        System.out.println("시도할 횟수는 몇 번인가요?");
        int n = Integer.parseInt(readLine());

        Car car = new Car(input);
        List<Car> cars = car.makeCarList(input);

        checkList(cars);

        Controller controller = new racingcar.Controller();
        List<Car> result = controller.startMove(cars, n);

        System.out.print("최종 우승자 : ");
        System.out.println(result.stream().map(Car::getName)
                .collect(Collectors.joining(",")));

    }

    private static void checkList(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}

