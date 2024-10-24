package racingcar.car;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.ErrorMessage;

public record Cars(List<Car> carList) {
    // 일급 컬렉션으로 사용한다.
    public Cars(List<Car> carList) {
        validateDuplicateNames(carList);
        this.carList = Collections.unmodifiableList(carList);
    }

    public void moveAll(){
        carList.forEach(Car::move);
    }

    public List<String> getWinnerNames(){
        int maxPosition = getMaxPosition();

        return carList.stream()
                .filter(each -> each.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    private int getMaxPosition() {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow();
    }

    private void validateDuplicateNames(List<Car> carList) {
        Set<String> uniqueNames = carList.stream()
                .map(Car::getName)
                .collect(Collectors.toSet());

        if (uniqueNames.size() != carList.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAME.getMessage());
        }
    }
}
