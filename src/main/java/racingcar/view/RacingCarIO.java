package racingcar.view;

import racingcar.model.Car;

import java.math.BigInteger;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingCarIO {

    public String getCarInfo() {
        System.out.println("경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
        return readLine();
    }

    public String tryCountInfo() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return readLine();
    }

    public void printResult(List<Car> cars) {
        System.out.println("실행 결과");

        for (int i = 0; i < cars.size(); i++) {
            StringBuilder slash = getSlash(cars.get(i).getMove());
            System.out.println(cars.get(i).getName() + " : " + slash);
        }
    }

    private static StringBuilder getSlash(BigInteger value) {
        StringBuilder slash = new StringBuilder();

        for (BigInteger i = BigInteger.ZERO; i.compareTo(value) < 0; i = i.add(BigInteger.ONE)) {
            slash.append("-");
        }
        return slash;
    }

    public void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");

        if (winners.isEmpty()) {
            return;
        }

        System.out.print(winners.get(0));
        for (int i = 1; i < winners.size(); i++) {
            System.out.print("," + winners.get(i));
        }
    }
}
