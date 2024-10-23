package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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

    public List<Car> getSortedList() {
        List<Car> sortedList = new ArrayList<>(this.list);
        sortedList.sort(Comparator.comparing(Car::getPosition).reversed());
        return sortedList;
    }

    public List<String> getWinner() {
        int maxPosition = getMaxPosition();
        return getSortedList().stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    public List<Car> getList() {
        return list;
    }

    private int getMaxPosition() {
        return getSortedList().getFirst().getPosition();
    }
}
