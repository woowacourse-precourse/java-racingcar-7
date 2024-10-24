package racingcar;

import java.util.List;

public interface ReaderInterface {

    int MAX_NAME_LENGTH = 5;
    int MIN_RAPS = 1;

    List<String> getNameInput();
    int getTryInput();
}
