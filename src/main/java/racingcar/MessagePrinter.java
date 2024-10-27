package racingcar;

import java.util.List;

public class MessagePrinter {

    MapBuilder mapBuilder = new MapBuilder();

    final String carNameGuideMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    final String roundNumGuideMessage = "시도할 횟수는 몇 회인가요?";
    final String resultGuideMessage = "실행 결과";

    public String totalRandomResultMessage(){
        String totalRandomResult = mapBuilder.getTotalRandomResultFromMap();
        totalRandomResult += "\\n";
        return totalRandomResult;
    }

    public String getWinnerMessage(List<String> winnerList) {
        String winnerMessage = "최종 우승자 : ";
        winnerMessage += String.join(",", winnerList);

        return winnerMessage;
    }
}
