package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class MovementDecider {

    private final int randomNumber;

    public MovementDecider() {
        this.randomNumber = generateRandomNumber();
        generateRandomNumber();
    }

    public boolean makeDecision(){
        return randomNumber >= 4;
    }

    private int generateRandomNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }
}
