package racingcar.ui;

import java.util.List;
import java.util.Objects;
import racingcar.domain.CarNames;

public class InputCarNames {

    private final static String SEPARATOR = ",";
    private final List<String> carNames;

    private InputCarNames(final List<String> carNames) {
        this.carNames = carNames;
    }

    public CarNames getCarNames() {
        return CarNames.of(this.carNames);
    }

    static InputCarNames of(final String inputMessage) {
        validateForm(inputMessage);
        return new InputCarNames(List.of(inputMessage.split(SEPARATOR)));
    }

    private static void validateForm(final String inputCarName) {
        final String blankReplacedInputCarName = inputCarName.replace(" ", "");
        validateStartWithSeparator(blankReplacedInputCarName);
        validateEndWithSeparator(blankReplacedInputCarName);
        validateRepeatedSeparator(blankReplacedInputCarName);
        validateBlank(blankReplacedInputCarName);
    }

    private static void validateBlank(final String inputCarName) {
        if (inputCarName.isBlank()) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요");
        }
    }

    private static void validateStartWithSeparator(final String inputCarName) {
        if (inputCarName.startsWith(SEPARATOR)) {
            throw new IllegalArgumentException(SEPARATOR + " 로 시작될 수 없습니다");
        }
    }

    private static void validateEndWithSeparator(final String inputCarName) {
        if (inputCarName.endsWith(SEPARATOR)) {
            throw new IllegalArgumentException(SEPARATOR + " 로 종룓힐 수 없습니다");
        }
    }

    private static void validateRepeatedSeparator(final String inputCarName) {
        if (inputCarName.contains(SEPARATOR+SEPARATOR)) {
            throw new IllegalArgumentException(SEPARATOR+SEPARATOR + "자동차 이름은 빈 문자열일 수 없습니다");
        }
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        final InputCarNames targetInputCarNames = (InputCarNames) object;
        return Objects.equals(this.carNames, targetInputCarNames.carNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carNames);
    }
}
