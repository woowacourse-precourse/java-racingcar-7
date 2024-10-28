package service;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {
    public static int randomNumberGenerator() {
        return Randoms.pickNumberInRange(0,9);
    }
}
