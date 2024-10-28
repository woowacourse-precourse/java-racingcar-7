package racingcar.domain.numbergenerator;

public interface NumberGenerator {

    int START_INCLUSIVE = 0;
    int END_INCLUSIVE = 9;

    int generate();
}
