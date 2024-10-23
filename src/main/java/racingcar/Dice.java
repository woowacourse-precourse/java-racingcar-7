package racingcar;


import camp.nextstep.edu.missionutils.Randoms;

public class Dice{
    public static boolean roll(){
        int i = Randoms.pickNumberInRange(0, 9);
        return i >= 4;
    }

}