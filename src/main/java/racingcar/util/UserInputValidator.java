package racingcar.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import racingcar.dto.UserInputDto;

public class UserInputValidator {
    public UserInputDto validate(String[] userInitialInputs) {
        String carNames = userInitialInputs[0];
        String trialCount = userInitialInputs[1];

        List<String> parsedCarNames = Arrays.stream(carNames.split(",")).toList();
        validateCarNames(parsedCarNames);

        int validatedTrialCount = validateTrialCount(trialCount);

        return new UserInputDto(parsedCarNames, validatedTrialCount);
    }

    private int validateTrialCount(String trialCount) {
        if (trialCount.chars().allMatch(Character::isDigit)) {
            int parsedCount = Integer.parseInt(trialCount);
            validatePositive(parsedCount);
            return parsedCount;
        }
        throw new IllegalArgumentException("시도 횟수는 양의 정수만 가능합니다 : " + trialCount);
    }

    private void validatePositive(int parsedCount) {
        if (parsedCount < 1) {
            throw new IllegalArgumentException("시도 횟수는 양의 정수만 가능합니다 : " + parsedCount);
        }
    }

    private void validateCarNames(List<String> parsedCarNames) {
        for (String parsedCarName : parsedCarNames) {
            if (parsedCarName.length() == 0 || parsedCarName.length() > 5) {
                throw new IllegalArgumentException("이름의 길이는 1 ~ 5 만 허용합니다 : " + parsedCarName);
            }
        }
        if (parsedCarNames.size() != new HashSet<String>(parsedCarNames).size()) {
            throw new IllegalArgumentException("중복된 이름은 사용할 수 없습니다");
        }
    }
}
