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

    public List<Car> moveCars(int count) {
        for (int i = 0; i < count; i++) {
            for (Car car : this.getList()) {
                int randomNum = Randoms.pickNumberInRange(0, 9);
                car.move(randomNum);
                Printer.print(car);
            }
            Printer.newLine();
        }
        return this.getList();
    }

    public String getWinner(List<Car> matchResult) {
        int maxPosition = getMaxPosition(matchResult);
        List<String> winnerList = matchResult.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();

        if (winnerList.size() == 1) {
            return winnerList.getFirst();
        }
        return String.join(DELIMITER, winnerList);
    }

    public List<Car> getList() {
        return list;
    }

    private int getMaxPosition(List<Car> matchResult) {
        List<Car> sortedList = new ArrayList<>(matchResult);
        sortedList.sort(Comparator.comparing(Car::getPosition).reversed());
        return sortedList.getFirst().getPosition();
    }
}
