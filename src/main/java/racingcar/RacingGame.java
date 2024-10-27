package racingcar;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;


public class RacingGame {
    private final CarNameParser carNameParser;
    private final AttemptCountParser attemptCountParser;
    private int attemptCount;

    public RacingGame(CarNameParser carNameParser, AttemptCountParser attemptCountParser){
        this.carNameParser = carNameParser;
        this.attemptCountParser = attemptCountParser;
    }

    /**
     * 사용자가 시도할 횟수를 입력받는 메서드
     **/
    public void getAttemptCount(){
        this.attemptCount = attemptCountParser.getAttemptCount();
    }

    /**
     * 입력받은 자동차 이름 리스트를 반환하는 메서드
     * */
    public List<String> validatedCarName(){
        String input = carNameParser.inputCarNames();
        String[] splitCarName = carNameParser.splitCarNamesByComma(input);

        return carNameParser.getValidatedCarNames(splitCarName);
    }
}
