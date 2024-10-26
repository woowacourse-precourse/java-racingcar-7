package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.car.Car;
import racingcar.car.RacingCar;
import racingcar.race.Race;
import racingcar.race.ThresholdMoveStrategy;
import racingcar.separator.Separator;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int n = Integer.parseInt(Console.readLine());

        List<Car> cars = stringToRacingCars(",", input);
        Race race = new Race(cars, new ThresholdMoveStrategy(() -> Randoms.pickNumberInRange(0, 9), 4));

        System.out.println("실행 결과");
        race.start(n);
    }

    private static List<Car> stringToRacingCars(String delimiter, String carsString) {
        List<String> separated = Separator.separate(delimiter, carsString);
        List<Car> cars = new ArrayList<>();
        for (String carName : separated) {
            cars.add(new RacingCar(carName, 0));
        }
        return cars;
    }
}
