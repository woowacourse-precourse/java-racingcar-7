package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class StopAndGo {
    public boolean[] stopAndGo(int times){
        boolean[] result = new boolean[times];
        for(int i=0;i<times;i++){
            result[i] = Randoms.pickNumberInRange(0, 9) >= 4;
        }
        return result;
    }

}
