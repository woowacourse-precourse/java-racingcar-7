package racingcar.parser;

public interface Parser<I, O> {

    O parse(I input);

}
