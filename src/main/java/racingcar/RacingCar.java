package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.LinkedList;

public class RacingCar {

    public static void start(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = readLine();

        LinkedList<Car> carList = CarNameParser.parsingCarName(carNames);

        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryNum = Integer.parseInt(readLine());
        if (tryNum <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
