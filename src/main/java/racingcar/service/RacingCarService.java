package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.dto.UserInputDto;
import racingcar.view.OutputView;

public class RacingCarService {
    private static final Map<String, String> racingCarMap = new HashMap<>();
    private static final String dashCount = "-";

    private final OutputView outputView;

    public RacingCarService() {
        this.outputView = new OutputView();
    }

    public void racingStart(UserInputDto dto) {
        List<String> splitInput = dto.carNames();
        int epoch = dto.epoch();

        mapInit(splitInput);

        for (int i = 0; i < epoch; i++) {
            for (String car : splitInput) {
                chooseGoSTOP(car);
                outputView.displayProgress(car, racingCarMap.get(car));
            }
            System.out.println();
        }
    }

    public StringBuilder findWinner() {
        ArrayList<String> longestKeys = new ArrayList<>();
        int maxLength = 0;

        for (Map.Entry<String, String> entry : racingCarMap.entrySet()) {
            int length = entry.getValue().length();
            if (length == maxLength) {
                longestKeys.add(entry.getKey());
            } else if (length > maxLength) {
                maxLength = length;
                longestKeys.clear();
                longestKeys.add(entry.getKey());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < longestKeys.size() - 1; i++) {
            sb.append(longestKeys.get(i)).append(", ");
        }
        sb.append(longestKeys.getLast());
        return sb;
    }

    private static void chooseGoSTOP(String s) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            racingCarMap.put(s, racingCarMap.getOrDefault(s, dashCount) + dashCount);
        }
    }

    private static void mapInit(List<String> splitInput) {
        for (String s : splitInput) {
            racingCarMap.put(s, "");
        }
    }
}
