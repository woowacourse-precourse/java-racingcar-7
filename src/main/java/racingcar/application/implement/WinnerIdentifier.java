package racingcar.application.implement;

import java.util.List;

public interface WinnerIdentifier<T> {

    List<T> identify(List<T> participants);
}
