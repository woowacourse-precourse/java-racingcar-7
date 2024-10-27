package racingcar;

import java.util.List;
import java.util.Map;

public class WinnerSorter {

    public List<String> getJointWinners(Map<String, Integer> sortedTotalForwardCount) {
//        맵은 우승자 판별 어케하는지 모르겠네
        for (int i = 0; i < sortedTotalForwardCount.size(); i++) {
            sortedTotalForwardCount.get(i).compareTo(sortedTotalForwardCount.get(i+1));
//            뭐 이런거 써야하나?
        }
//        return List<String> winnerList;
        return null;
    }
}
