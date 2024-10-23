package racingcar.domain;

import java.util.List;

public class Output {

    private static Output output;

    private Output() {}

    public static Output getInstance() {
        if (output == null) {
            output = new Output();
        }
        return output;
    }

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
