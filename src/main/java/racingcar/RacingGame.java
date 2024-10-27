package racingcar;

import java.util.List;


public class RacingGame {
    private final CarNameParser carNameParser;

    public RacingGame(CarNameParser carNameParser) {
        this.carNameParser = carNameParser;
    }


    public List<String> validatedCarName(){
        String input = carNameParser.inputCarNames();
        String[] splitCarName = carNameParser.splitCarNamesByComma(input);

        return carNameParser.getValidatedCarNames(splitCarName);
    }
}
