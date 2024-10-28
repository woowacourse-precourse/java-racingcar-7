package racingcar.config;

import racingcar.view.View;
import racingcar.util.Parser;
import racingcar.util.Validator;

public class Config {
    private final Validator validator = new Validator();
    private final View view = new View();
    private final Parser parser = new Parser(validator);

    public Validator getValidator() {
        return validator;
    }

    public View getView() {
        return view;
    }

    public Parser getParser() {
        return parser;
    }
}
