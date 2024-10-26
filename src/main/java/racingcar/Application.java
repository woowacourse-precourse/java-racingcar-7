package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String[] names = {};
        int[] counts = {};
        Integer times = 0;
        RacingCar.readInputs(names,counts,times);

        System.out.println("실행 결과");
        RacingCar.printProcess(times,names,counts);
        String[] winners = RacingCar.getWinners(names, counts);
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
