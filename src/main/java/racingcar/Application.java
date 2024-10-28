package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //1. 자동차 이름입력
        CarNameInput carNameInput = new CarNameInput();
        List<String> carList = carNameInput.getCarNames();
        System.out.println("입력된 자동차 이름들: " + carList);

        //2. 시도횟수 입력
        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryCount = Integer.parseInt(readLine());

        //3. Race 진행
        Race race = new Race(carList);
        RacePrinter racePrinter = new RacePrinter();

        //4. Race 결과 출력
        System.out.println("실행결과");
        for (int i = 0; i < tryCount; i++) {
            race.moveCars();
            racePrinter.printPositions(race.getCarNames(), race.getCarPositions());
        }

        // 5. 최종 우승자 출력
        RaceWinnerCal winnerCalculator = new RaceWinnerCal();
        String winners = winnerCalculator.calculateWinners(race.getCarNames(), race.getCarPositions());
        System.out.println("\n최종 우승자 : " + winners);

    }
}
