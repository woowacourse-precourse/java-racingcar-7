package racingcar.game.provider;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberProvider implements NumberProvider{
    @Override
    public Integer getNumber() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber;
    }
}
