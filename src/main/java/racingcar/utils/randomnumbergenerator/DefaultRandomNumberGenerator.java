// RandomNumberPicker.java 또는 DefaultRandomNumberGenerator.java
package racingcar.utils.randomnumbergenerator;

import camp.nextstep.edu.missionutils.Randoms;

public class DefaultRandomNumberGenerator implements RandomNumberGenerator {
    @Override
    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
