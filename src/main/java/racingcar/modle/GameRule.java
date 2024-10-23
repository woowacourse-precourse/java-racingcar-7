package racingcar.modle;

import camp.nextstep.edu.missionutils.Randoms;

public class GameRule {

    public Boolean isGo(int movingStandard){
        if(movingStandard >= 4){
            return true;
        }
        return false;
    }
}
