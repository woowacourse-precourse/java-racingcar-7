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

    public List<String> makeRacingHashmap(String[] listUser, String strRound) {
        HashMap<String, String> racingHashmap = new HashMap<>();
        for (String name : listUser) {
            InvalidException.checkNamelength(name);
            racingHashmap.put(name, "");
        }
        InvalidException.checkRound(strRound);
        int round = Integer.parseInt(strRound);
        for (int i = 0; i < round; i++) {
            for (String name : racingHashmap.keySet()) {
                String step = getStep(racingHashmap.get(name), Randoms.pickNumberInRange(0, 9));
                racingHashmap.replace(name, step);
                System.out.println(name + " : " + step);
            }
        }

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
