package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Name;
import racingcar.domain.Names;
import racingcar.domain.RepeatCount;

public class UserInputService {

    public UserInputService() {
    }

    public void close() {
        Console.close();
    }

    public Cars createCar() {
        Names names = createNames();

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            Name name = names.getNames().get(i);
            Car car = new Car(name);
            cars.add(car);
        }
        return new Cars(cars);
    }

    private Names createNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String carNameLine = Console.readLine();
        String[] carNames = carNameLine.split(",");

        List<Name> nameList = new ArrayList<>();
        for (String carName : carNames) {
            nameList.add(new Name(carName));
        }
        return new Names(nameList);
    }

    public RepeatCount createRepeat() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        String userInput = Console.readLine();
        return new RepeatCount(userInput);
    }
}
