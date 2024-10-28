package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    private final String RESULT_MESSAGE = "실행 결과";
    private final String FINAL_RESULT_MESSAGE = "최종 우승자 : ";
    private final String COMMA_STRING = ",";
    private final String GAME_RESULT_PRINT = " : ";

    public void printGameResult(Map<String, String> resultMap){
        for(String car : resultMap.keySet()) {
            String result = car + GAME_RESULT_PRINT + resultMap.get(car);
            System.out.println(result);
        }
        System.out.println();
    }
    
    public void printGameResultMessage(){
        System.out.println(RESULT_MESSAGE);
    }

    public void printFinalWinner(List<String> winner) {
        System.out.print(FINAL_RESULT_MESSAGE + String.join(COMMA_STRING, winner));
    }
}
