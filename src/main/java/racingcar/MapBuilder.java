package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapBuilder {

    public static TreeMap<String, Integer> forwardCounter = new TreeMap<>();
    public static Map<String, String> lineCounter = new HashMap<>();

    public void mapInitForwardCount(List<String> carNames) {
        validateCarNames(carNames);

        for (int i = 0; i < carNames.size(); i++) {
            forwardCounter.put(carNames.get(i), 0);
        }
    }

    public void mapInitLineCount(List<String> carNames) {
        validateCarNames(carNames);

        for (int i = 0; i < carNames.size(); i++) {
            lineCounter.put(carNames.get(i), "");
        }
    }

    public void mapSingleResult(String carName) {
        validateCount(carName);

        // forwardCounter에 전진횟수 추가
        int forwardCount = forwardCounter.get(carName);
        forwardCount += 1;
        forwardCounter.put(carName, forwardCount);

        // lineCounter에 라인 추가
        String forwardLine = lineCounter.get(carName);
        forwardLine = forwardLine + "-";
        lineCounter.put(carName, forwardLine);
    }

    public List<Map.Entry<String, String>> getSingleResult(List<String> carNames, int roundNum) {
        validateSingleResult(lineCounter);

        List<Map.Entry<String, String>> entry = new ArrayList<>(lineCounter.entrySet());

        return entry;
    }

    public TreeMap<String, Integer> getForwardCount() {
        validateForwardCounter(forwardCounter);

        return forwardCounter;
    }

    public void validateCarNames(List<String> carNames) {
        if (carNames == null) {
            throw new IllegalArgumentException();
        }
    }

    public void validateCount(String carName) {
        if (forwardCounter.get(carName) == null || lineCounter.get(carName) == null) {
            throw new IllegalArgumentException();
        }
    }

    private void validateSingleResult(Map<String, String> lineCounter) {
        if (lineCounter == null) {
            throw new IllegalArgumentException();
        }
    }

    private void validateForwardCounter(TreeMap<String, Integer> forwardCounter) {
        if (forwardCounter == null) {
            throw new IllegalArgumentException();
        }
    }
}
