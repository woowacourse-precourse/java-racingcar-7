package racingcar.view;

import java.util.List;
import java.util.Map;

public class UserOutputView {

    public static void InputCarNameMessage(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void InputAttemptCountMessage(){
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void RacingRoundMessage(List<Map<String, Integer>> m){
        System.out.println("실행 결과");

        for (Map<String, Integer> stringIntegerMap : m) {
            stringIntegerMap.forEach((key, value) -> {
                System.out.print(key + " : " + "-".repeat(value));
            });
        }
    }

    public static void RacingResultMessage(List<String> result){
        System.out.println("최종 우승자 : " + String.join(", ", result));
    }
}