package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = getCarNames();
        int tryCount = getTryCount();
    }
    
    private static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesStr = Console.readLine();
        return CarNameParser.parse(carNamesStr, 5);
    }
    
    private static int getTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryCount;
        
        try {
            tryCount = Integer.parseInt(Console.readLine());
        }
        catch (Exception e) {
            throw new IllegalArgumentException();
        }
        
        if (tryCount < 0) {
            throw new IllegalArgumentException();
        }
        
        return tryCount;
    }
}
