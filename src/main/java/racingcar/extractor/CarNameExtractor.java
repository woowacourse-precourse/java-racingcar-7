package racingcar.extractor;

public class CarNameExtractor {

    public String[] extractCarName(String carNames) {
        return carNames.split(",");
    }
}
