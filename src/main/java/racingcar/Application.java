package racingcar;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
    	try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String inputNames = Console.readLine();
            List<String> carNames = Arrays.asList(inputNames.split(","));

            System.out.println("시도할 횟수는 몇 회인가요?");
            int rounds = Integer.parseInt(Console.readLine());

            Race race = new Race(carNames, new DefaultMoveStrategy(), new RacePrinter());
            race.play(rounds);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}
