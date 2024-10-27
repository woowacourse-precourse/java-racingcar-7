package racingcar;

import java.util.List;

public interface InputManager {
    void whatIsYourName();
    String getName();
    List<String> splitName(String readName);
    void HowManyAttempt();
    int getNumberOfAttempt();
}
