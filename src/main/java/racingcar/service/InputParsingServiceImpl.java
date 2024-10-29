package racingcar.service;

import java.util.List;

public class InputParsingServiceImpl implements InputParsingService {
    @Override
    public List<String> parseCarNameListString(String input) {
        return List.of(input.split(","));
    }

    @Override
    public int parseAttemptCountString(String input) {
        int attemptCount = Integer.parseInt(input);
        if (attemptCount < 1) {
            throw new IllegalArgumentException("시도 횟수는 1보다 커야 합니다.");
        }
        return attemptCount;
    }
}
