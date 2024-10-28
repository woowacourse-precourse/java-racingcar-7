package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();

        String[] strings = carNames.split(",");
        List<Vehicle> vehicles = new ArrayList<>();
        for (String carName : strings) {
            Engine engine = new RandomEngine(1, 9, 4);
            vehicles.add(new Car(carName, engine));
        }
        Track track = new Track(vehicles);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String cycleString = Console.readLine();
        int cycle = Integer.parseInt(cycleString);

        System.out.println("실행 결과");

        for (int i = 1; i <= cycle; i++) {
            track.runOneCycle();
            System.out.println(track.getWholeSituation());
        }

        System.out.println("최종 우승자 : " + track.selectWinner());
    }
}
