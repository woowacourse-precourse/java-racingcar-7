package racingcar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapBuilder {
    public void mapCarNamesToForwardCounts(List<String> carNames) {
        Map<String, Integer> forwardCounter = new TreeMap<>();
        for (int i = 0; i < carNames.size(); i++) {
            forwardCounter.put(carNames.get(i), 0);
        }
    }

    public void mapCarNamesToStringForwardLines(List<String> carNames) {
//        이 부분은 어떻게 할지 아직 모르겠다.
    }

    public void mapSingleCarForwardResult(String carNames) {
//        이 부분은 어떻게 할지 아직 모르겠다.
    }

    public void mapSingleRandomRoundResult(int i) {
//        이 부분은 어떻게 할지 아직 모르겠다.
    }

    public String getTotalRandomResultFromMap(){
//        이 부분은 어떻게 할지 아직 모르겠다.
        return "";
    }

    public Map<String, Integer> getCarNameAndForwardCount(){
//        이 부분은 어떻게 할지 아직 모르겠다.
        return null;
    }
}
