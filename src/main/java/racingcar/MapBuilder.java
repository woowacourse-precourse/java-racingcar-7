package racingcar;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapBuilder {

    Map<String, Integer> forwardCounter = new TreeMap<>();
    Map<String, String> lineCounter = new TreeMap<>();

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
