package racingcar.service;

import java.util.List;

public class InputParsingServiceImpl implements InputParsingService {
    @Override
    public List<String> parseCarNameListString(String input) {
        return List.of(input.split(","));
    }

    @Override
    public int parseAttemptCountString(String input) {
        return Integer.parseInt(input);
    }
}
