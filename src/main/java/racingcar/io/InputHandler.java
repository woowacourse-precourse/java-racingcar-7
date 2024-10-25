package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public interface InputHandler {

    String getUserInput();

    List<String> getCarNamesFromUser();

    int getCarNumberFromUser();
}
