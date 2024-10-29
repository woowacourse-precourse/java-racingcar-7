package racingcar.service;

import java.util.List;

public interface InputParsingService {
    List<String> parseCarNameListString(String input);

    int parseAttemptCountString(String input);
}
