package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.List;

public class Application {

    private static HashMap<String, String> input(HashMap<String, String> request) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        request.put("carNames", Console.readLine());

        System.out.println("시도할 횟수는 몇 회인가요?");
        request.put("attempts", Console.readLine());

        return request;
    }

    private static void output(List<String> response) {
        System.out.println("실행 결과");
        for (String data : response) {
            System.out.println(data + "\n");
        }
    }

    public static void main(String[] args) {

        HashMap<String, String> request = new HashMap<>();

        input(request);
        CarRacing carRacing = new CarRacing(request.get("carNames"), request.get("attempts"));
        output(carRacing.race());
    }
}
