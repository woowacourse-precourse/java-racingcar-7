package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class CarManager {

    private final List<Car> list;

    public CarManager() {
        this.list = new ArrayList<>();
    }
    public void add(String carNames) {
        Arrays.stream(carNames.split(","))
                .map(Validator::validateNameLength)
                .map(Car::generateCars)
                .forEach(list::add);
    }

    public List<Car> moveCars(int count) {
        List<Car> resultList = getList();
        IntStream.range(0, count).forEach(i -> {
            resultList.forEach(
                    car -> {
                        int moveNum = Randoms.pickNumberInRange(0, 9);
                        car.move(moveNum);
                        Printer.print(car);
                    });
            Printer.newLine();
        });
        return resultList;
    }

    public List<Car> getList() {
        return new ArrayList<>(list);
    }
}
