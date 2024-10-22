package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.IntStream;

public class GameDirector {
    private final int count;
    private final CarManager manager = new CarManager();

    public GameDirector(String carNames,String count) {
        manager.add(carNames);
        this.count = Validator.validateCountIfNegative(count);
    }

    public void run() {
        List<Car> result = getResult();
    }

    private List<Car> getResult() {
        List<Car> carList = manager.getList();
        IntStream.range(0, count)
                .forEach(i -> {
                    carList.forEach(car -> {
                        int moveNum = Randoms.pickNumberInRange(0, 9);
                        car.move(moveNum);
                        Printer.print(car);
                    });
                    Printer.newLine();
                });
        return carList;
    }
}
