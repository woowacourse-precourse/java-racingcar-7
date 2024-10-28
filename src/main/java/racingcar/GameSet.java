package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class GameSet {
    private List<Car> carList;
    private int tryNumber;


    public void init() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        carList = splitCarNames(carNamesInput);

        System.out.println("시도할 횟수는 몇 회인가요?");
        tryNumber = Integer.parseInt(Console.readLine());
        if (tryNumber <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
        }
    }

    public List<Car> splitCarNames(String carNamesInput) {
        String[] names = carNamesInput.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            name = name.trim();
            cars.add(new Car(name));
        }
        return cars;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getTryNumber() {
        return tryNumber;
    }


}
