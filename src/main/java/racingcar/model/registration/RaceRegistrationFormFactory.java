package racingcar.model.registration;

import java.util.List;
import racingcar.dto.RaceRegistrationForm;

public class RaceRegistrationFormFactory {

    public static RaceRegistrationForm create(String inputCarNames, String inputRaceRoundCount) {
        validateInput(inputCarNames, inputRaceRoundCount);
        List<String> carNames = parseCarNames(inputCarNames);
        int raceRoundCount = parseRaceRoundCount(inputRaceRoundCount);
        return new RaceRegistrationForm(carNames, raceRoundCount);
    }

    private static void validateInput(String inputCarNames, String inputRaceRoundCount) {
        RegistrationValidator.validateRawInputCarNames(inputCarNames);
        RegistrationValidator.validateRawInputRaceRoundCount(inputRaceRoundCount);
    }

    private static List<String> parseCarNames(String inputCarNames) {
        return RegistrationValidator.splitRawInput(inputCarNames);
    }

    private static int parseRaceRoundCount(String inputRaceRoundCount) {
        return RegistrationValidator.parseInteger(inputRaceRoundCount);
    }
}
