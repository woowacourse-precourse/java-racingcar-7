package racingcar.randomgenerator;

import camp.nextstep.edu.missionutils.Randoms;
public class JavaRandomGenerator implements RandomGenerator{
    @Override
    public int random(int boundary){
        return Randoms.pickNumberInRange(0,boundary);
    }
}
