package racingcar.service.input;

import java.util.List;
import java.util.function.Function;
import racingcar.domain.Input;
import racingcar.domain.Registration;
import racingcar.repository.InputRepository;
import racingcar.service.constant.ExpressionFormat;
import racingcar.view.constant.Request;

public class RegistrationService {

    private final InputRepository inputRepository;

    public RegistrationService() {
        this.inputRepository = InputRepository.connect();
    }

    public Registration register() {
        Input carInput = inputRepository.get(Request.CAR_NAMES.toString());
        Input lapInput = inputRepository.get(Request.ATTEMPT_NUMBER.toString());
        return new Registration(lineupSetting(carInput.getInput())
                , lapCountSetting(lapInput.getInput()));
    }

    private List<String> lineupSetting(String carNames) {
        return List.of(carNames.split(ExpressionFormat.SEPARATOR.form()));
    }

    private Long lapCountSetting(String count) {
        return Long.parseLong(count);
    }
}
