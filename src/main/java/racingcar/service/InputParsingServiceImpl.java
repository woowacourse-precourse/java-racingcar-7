package racingcar.service;

import java.util.List;

public class InputParsingServiceImpl implements InputParsingService {
    @Override
    public List<String> parseCarNameListString(String input) {
        /** 예외처리 로직**/

        return List.of(input.split(","));
    }

    @Override
    public int parseAttemptCountString(String input) {
        /** 예외처리 로직**/

        return Integer.parseInt(input);
    }
}
