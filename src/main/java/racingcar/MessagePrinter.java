package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MessagePrinter {

    MapBuilder mapBuilder = new MapBuilder();

    final String carNameGuideMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    final String roundNumGuideMessage = "시도할 횟수는 몇 회인가요?";
    final String resultGuideMessage = "실행 결과";

    public String getWinnerMessage(List<String> winnerList) {

        validateWinnerList(winnerList);

        String winnerMessage = "최종 우승자 : ";
        winnerMessage += String.join(",", winnerList);

        return winnerMessage;
    }

    public String getSingleRoundResultMessage(List<String> carNames, int roundNum) {
        List<Map.Entry<String, String>> entry = mapBuilder.getSingleRoundResult(carNames, roundNum);
        List<String> singleRoundResultMessages = new ArrayList<>();

        for (int i = 0; i < entry.size(); i++) {
            String carName = entry.get(i).getKey();
            String line = entry.get(i).getValue();
            singleRoundResultMessages.add(carName + " : " + line);
        }

        String singleRoundResultMessage = String.join("\n", singleRoundResultMessages);
        return singleRoundResultMessage;
    }

    public String getTotalRoundResultMessage(List<String> totalRoundResultList) {

        String totalRoundResultMessage = String.join("\n", totalRoundResultList);
        totalRoundResultMessage += "\n";

        return totalRoundResultMessage;
    }

    private void validateWinnerList(List<String> winnerList) {
        if(winnerList == null) {
            throw new IllegalArgumentException();
        }
    }
}
