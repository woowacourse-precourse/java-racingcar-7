package racingcar.view.exception;

import static racingcar.common.message.ErrorMessage.UN_NECESSARY_CHAR_INCLUDED;

import racingcar.common.exception.InputException;

public class UnNecessaryCharIncludedException extends InputException {
    public UnNecessaryCharIncludedException() {
        super(UN_NECESSARY_CHAR_INCLUDED);
    }
}
