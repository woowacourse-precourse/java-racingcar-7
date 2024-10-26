package random;

import camp.nextstep.edu.missionutils.Randoms;

public class CarRandom implements RandomGenerate{

    @Override
    public int generateRandomNumber(){
        return Randoms.pickNumberInRange(minNumber, maxNumber);
    }

}
