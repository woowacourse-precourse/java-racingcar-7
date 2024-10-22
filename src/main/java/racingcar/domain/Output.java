package racingcar.domain;

import java.util.List;

public class Output {
    public List<String> getAllCarProgress(final List<Car> carList) {
        return carList.stream()
                .map(this::getOutPut)
                .toList();
    }

    public String getOutPut(final Car car) {
        String scoreHyphen = "-".repeat(car.getMoveCnt());
        return String.format("%s : %s%n", car.getName(), scoreHyphen);
    }

}
