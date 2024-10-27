package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapBuilder {

    TreeMap<String, Integer> forwardCounter = new TreeMap<>();
    Map<String, String> lineCounter = new HashMap<>();

    public void mapCarNamesToForwardCounts(List<String> carNames) {
        for (int i = 0; i < carNames.size(); i++) {
            forwardCounter.put(carNames.get(i), 0);
        }
    }

    public void mapCarNamesToStringForwardLines(List<String> carNames) {
        for (int i = 0; i < carNames.size(); i++) {
            lineCounter.put(carNames.get(i), "");
        }
    }

    public void mapSingleCarForwardResult(String carName) {
        // forwardCounter에 전진횟수 추가
        int forwardCount = forwardCounter.get(carName);
        forwardCount += 1;
        forwardCounter.put(carName, forwardCount);

        // lineCounter에 라인 추가
        String forwardLine = lineCounter.get(carName);
        forwardLine = forwardLine + "-";
        lineCounter.put(carName, forwardLine);
    }

    public List<Map.Entry<String, String>> getSingleRoundResult(List<String> carNames, int roundNum) {

        List<Map.Entry<String, String>> entry = new ArrayList<>(lineCounter.entrySet());

        return entry;
    }

    public TreeMap<String, Integer> getCarNameAndForwardCount(){

        return forwardCounter;
    }
}
