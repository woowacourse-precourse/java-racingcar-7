package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class RacingCarService {

    public List<String> splitCarNames(String carNames) {
        //공백이 넘어온 경우? 구분자가 없는 경우?
        List<String> listCarNames = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(carNames);

        while (stringTokenizer.hasMoreTokens()) {
            listCarNames.add(stringTokenizer.nextToken(","));
        }

        return listCarNames;
    }

    public Map<String, String> mapCarNames(List<String> carNames) {
        Map<String, String> mapCarNames = new HashMap<>();

        for (int i = 0; i < carNames.size(); i++) {
            mapCarNames.put(carNames.get(i), "");
        }
        return mapCarNames;
    }

    public int createRandomNumber() {
        return (int) (Math.random() * 10);
    }
}
