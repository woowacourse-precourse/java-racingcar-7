package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CarList {
    private static final String DELIMITER = ",";
    private static final int SINGLE_WINNER = 1;
    private final List<Car> list;

    public CarList() {
        this.list = new ArrayList<>();
    }

    public void add(String carNames) {
        Arrays.stream(carNames.split(DELIMITER))
                .map(Validator::validateNameLength)
                .map(Car::generateCars)
                .forEach(list::add);
    }

    //전진 조건에 따라서 정책이 바뀌어
    //그럼 4일 경우 기본 정책이다를 기준으로, movceCars, findWinnder
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

    public String getWinners(List<Car> matchResult) {
        return getWinnerNames(matchResult.stream()
                .filter(car -> car.getPosition() == findMaxPosition(matchResult))
                .map(Car::getName)
                .toList());
    }

    private String getWinnerNames(List<String> winnerList) {
        if (isSingleWinner(winnerList)) {
            return winnerList.getFirst();
        }
        return String.join(WINNER_FORMAT, winnerList);
    }

    private boolean isSingleWinner(List<String> winnerList) {
        return winnerList.size() == 1;
    }

    public List<Car> getList() {
        return list;
    }

    private int findMaxPosition(List<Car> matchResult) {
        List<Car> sortedList = new ArrayList<>(matchResult);
        sortedList.sort(Comparator.comparing(Car::getPosition).reversed());
        return sortedList.getFirst().getPosition();
    }
}
