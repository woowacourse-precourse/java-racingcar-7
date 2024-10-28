package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapBuilder {

    public static TreeMap<String, Integer> forwardCounter = new TreeMap<>();
    public static Map<String, String> lineCounter = new HashMap<>();

    public static void mapCarNamesToForwardCounts(List<String> carNames) {

        validateCarNames(carNames);

        for (int i = 0; i < carNames.size(); i++) {
            forwardCounter.put(carNames.get(i), 0);
        }
    }

    public static void mapCarNamesToStringForwardLines(List<String> carNames) {

        validateCarNames(carNames);

        for (int i = 0; i < carNames.size(); i++) {
            lineCounter.put(carNames.get(i), "");
        }
    }

    public static void mapSingleCarForwardResult(String carName) {

        validateForwards(carName);

        // forwardCounter에 전진횟수 추가
        int forwardCount = forwardCounter.get(carName);
        forwardCount += 1;
        forwardCounter.put(carName, forwardCount);

        // lineCounter에 라인 추가
        String forwardLine = lineCounter.get(carName);
        forwardLine = forwardLine + "-";
        lineCounter.put(carName, forwardLine);
    }

    public static List<Map.Entry<String, String>> getSingleRoundResult(List<String> carNames, int roundNum) {

        validateSingleRoundResult(lineCounter);

        List<Map.Entry<String, String>> entry = new ArrayList<>(lineCounter.entrySet());

        return entry;
    }

    public static TreeMap<String, Integer> getCarNameAndForwardCount(){

        validateForwardCounter(forwardCounter);

        return forwardCounter;
    }

    public static void validateCarNames(List<String> carNames) {
        if(carNames == null) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateForwards(String carName) {
        if(forwardCounter.get(carName) == null || lineCounter.get(carName) == null) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateSingleRoundResult(Map<String, String> lineCounter) {
        if(lineCounter == null) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateForwardCounter(TreeMap<String, Integer> forwardCounter) {
        if (forwardCounter == null) {
            throw new IllegalArgumentException();
        }
    }
}
