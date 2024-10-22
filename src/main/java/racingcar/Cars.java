package racingcar;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public record Cars(List<Car> carList) {
    // 일급 컬렉션으로 사용한다.
    public Cars(List<Car> carList) {
        validateDuplicateNames(carList);
        this.carList = Collections.unmodifiableList(carList);
    }

    // TODO : 검증이 다소 보기 힘든데, Set 으로 변환 할 수 있을 지 고민한다.
    private void validateDuplicateNames(List<Car> carList) {
        carList.stream()
                .collect(Collectors.groupingBy(Car::getName, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .findAny()
                .ifPresent(entry -> {
                    throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAME.getMessage());
                });
    }
}
