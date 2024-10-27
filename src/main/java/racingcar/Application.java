package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = getCarNames();
        int tryCount = getTryCount();
        
        System.out.println();
        System.out.println("실행 결과");
        
        RacingGame game = new RacingGame(carNames, tryCount);
        while (!game.isDone()) {
            game.startOneStep();
            System.out.println(toStringCarInfo(game.getCarInfo()));
        }
        
        System.out.print("최종 우승자 : " + toStringCarNames(game.getFrontRunners()));
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
    
    private static String toStringCarInfo(List<Car> cars) {
        StringBuilder result = new StringBuilder();
        for (Car car : cars) {
            result.append(car.name)
                    .append(" : ")
                    .append("-".repeat(car.distance))
                    .append('\n');
        }
        return result.toString();
    }
    
    private static String toStringCarNames(List<Car> cars) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < cars.size(); i++) {
            result.append(cars.get(i).name);
            if (i != cars.size() - 1) {
                result.append(", ");
            }
        }
        return result.toString();
    }
}
