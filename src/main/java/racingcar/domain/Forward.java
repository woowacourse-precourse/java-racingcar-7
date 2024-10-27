package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.validator.NumberValidator;

public class Forward{
    public static void move(int[] forwardDistance) {

        for (int index = 0; index < forwardDistance.length; index++) {
            int random = Randoms.pickNumberInRange(0, 9);

            if (NumberValidator.isNumberOverFour(random)) {
                forwardDistance[index]++;
            }
        }
    }
}
