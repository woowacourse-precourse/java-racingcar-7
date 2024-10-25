package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
public class ForwardOrNotEmb implements ForwardOrNot {
    @Override
    public final boolean isBiggerOrEqualFour(){
        return 4<=Randoms.pickNumberInRange(0,9);
    }
}
