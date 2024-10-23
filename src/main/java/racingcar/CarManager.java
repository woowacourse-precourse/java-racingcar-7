package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarManager {
    private static final String DELIMITER = ",";
    private final List<Car> list;

    public CarManager() {
        this.list = new ArrayList<>();
    }

    public void add(String carNames) {
        Arrays.stream(carNames.split(DELIMITER))
                .map(Validator::validateNameLength)
                .map(Car::generateCars)
                .forEach(list::add);
    }

    public void moveCars(int count) {
        for (int i = 0; i < count; i++) {
            for (Car car : this.getList()) {
                int randomNum = Randoms.pickNumberInRange(0, 9);
                car.move(randomNum);
                Printer.print(car);
            }
            Printer.newLine();
        }
    }

    public List<Car> getList() {
        return new ArrayList<>(list);
    }

    public List<String> getWinner() {
        return getList().stream()
                .filter(car -> car.getPosition() == getMaxPosition())
                .map(Car::getName)
                .toList();
    }
    private int getMaxPosition() {
        getList().sort(Comparator.comparing(Car::getPosition).reversed());
        return getList().getFirst().getPosition();
    }
}
