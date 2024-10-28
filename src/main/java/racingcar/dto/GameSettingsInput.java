package racingcar.dto;

import java.util.List;
import racingcar.utils.CarNameSplitter;
import racingcar.utils.TryCountParser;

public record GameSettingsInput(
        List<String> carNames,
        int tryCount
) {
    public static GameSettingsInput of(CarNamesInput carNamesInput, TryCountInput tryCountInput) {
        List<String> carNames = CarNameSplitter.separateCarNames(carNamesInput.carNames());
        int parsedTryCount = TryCountParser.parseTryCount(tryCountInput.tryCount());
        return new GameSettingsInput(carNames, parsedTryCount);
    }
}