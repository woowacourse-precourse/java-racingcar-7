package racingcar.domain;

import racingcar.util.generator.RandomNumberGenerator;

public class Referee {
    final static int MIN_MOVABLE_NUMBER = 4;
    final RandomNumberGenerator randomNumberGenerator;
    public Referee(final RandomNumberGenerator randomNumberGenerator){
        this.randomNumberGenerator = randomNumberGenerator;
    }
    public boolean judgeRacerCanMove(){
        if(randomNumberGenerator.generateNumber() >= MIN_MOVABLE_NUMBER){
            return true;
        }
        return false;
    }
}
