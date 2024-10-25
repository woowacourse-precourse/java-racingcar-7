package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Model {

    private String getStep(String step, int randomNumber) {
        if (randomNumber >= 4) {
            step += "-";
        }
        return step;
    }

    public HashMap<String, String> initRacing(String[] listUser) {
        HashMap<String, String> initracingHashmap = new HashMap<>();
        for (String name : listUser) {
            InvalidException.checkNamelength(name);
            initracingHashmap.put(name, "");
        }
        return initracingHashmap;
    }

    public HashMap<String, String> Racing(HashMap<String, String> initracingHashmap, String strRound) {
        InvalidException.checkRound(strRound);
        int round = Integer.parseInt(strRound);
        HashMap<String, String> racingHashmap = new HashMap<>();
        for (int i = 0; i < round; i++) {
            for (String name : initracingHashmap.keySet()) {
                String step = getStep(initracingHashmap.get(name), Randoms.pickNumberInRange(0, 9));
                racingHashmap.put(name, step);
                System.out.println(name + " : " + step);
            }
        }
        return racingHashmap;
    }

    public List findWinner(HashMap<String, String> racingHashmap) {
        List<String> listWinners = new ArrayList<>();
        HashMap<String, Integer> winnerMap = new HashMap<>();
        for (String name : racingHashmap.keySet()) {
            winnerMap.put(name, racingHashmap.get(name).length());
        }
        for (String name : winnerMap.keySet()) {
            if (winnerMap.get(name).equals(Collections.max(winnerMap.values()))) {
                listWinners.add(name);
            }
        }
        return listWinners;
    }
}
