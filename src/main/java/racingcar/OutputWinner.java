package racingcar;

import java.util.ArrayList;
import java.util.List;

public class OutputWinner {
    public static String findWinners(String[] carList, List<StringBuilder> progressList) {
        int maxCount = 0;
        List<String> winnerList = new ArrayList<>();

        for (StringBuilder progress : progressList) {
            int count = progress.length();
            if (count > maxCount) {
                maxCount = count;
            }
        }
        for (int i = 0; i < carList.length; i++) {
            if (progressList.get(i).length() == maxCount) {
                winnerList.add(carList[i]);
            }
        }
        DelimiterName delimiter = new DelimiterName();
        return String.join(delimiter.delimiter, winnerList);
    }
}

