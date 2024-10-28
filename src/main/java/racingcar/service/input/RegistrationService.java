package racingcar.service.input;

import java.util.List;
import racingcar.repository.InputRepository;
import racingcar.service.constant.ExpressionFormat;

public class RegistrationService {

    private final InputRepository inputRepository;

    public RegistrationService() {
        this.inputRepository = InputRepository.connect();
    }

    private List<String> lineupSetting(String carNames) {
        return List.of(carNames.split(ExpressionFormat.SEPARATOR.form()));
    }

    private Long lapCountSetting(String count) {
        return Long.parseLong(count);
    }
}
