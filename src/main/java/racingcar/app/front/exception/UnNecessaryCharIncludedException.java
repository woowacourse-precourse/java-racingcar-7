package racingcar.app.front.exception;

import static racingcar.app.front.error.ErrorMessage.UN_NECESSARY_CHAR_INCLUDED;

public class UnNecessaryCharIncludedException extends InputException {
    public UnNecessaryCharIncludedException() {
        super(UN_NECESSARY_CHAR_INCLUDED);
    }
}
