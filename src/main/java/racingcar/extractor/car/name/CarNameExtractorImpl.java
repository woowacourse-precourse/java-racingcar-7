package racingcar.extractor.car.name;

public class CarNameExtractorImpl implements CarNameExtractor {
    @Override
    public String[] extractFromInputString(String inputString) {
        return inputString.split(",");
    }
}
