package racingcar.client.exception;

import static racingcar.client.error.ErrorMessage.UN_NECESSARY_CHAR_INCLUDED;

public class UnNecessaryCharIncludedException extends InputException {
    public UnNecessaryCharIncludedException() {
        super(UN_NECESSARY_CHAR_INCLUDED);
    }
}
