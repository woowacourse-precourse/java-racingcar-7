package random;

import camp.nextstep.edu.missionutils.Randoms;

public interface RandomGenerate {

    public final int minNumber = 0;
    public final static int maxNumber = 9;
    default int generateRandomNumber(){
        int randomNumber = Randoms.pickNumberInRange(minNumber, maxNumber);

        return randomNumber;
    }


}
