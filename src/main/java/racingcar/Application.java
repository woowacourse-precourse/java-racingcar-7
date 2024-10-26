package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input_names = readLine();
        String[] names = input_names.split(",");
        int[] counts = new int[names.length];
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input_times = readLine();
        int times = Integer.parseInt(input_times);
        System.out.println("실행 결과");
        RacingCar.printProcess(times,names,counts);
        int max = Arrays.stream(counts).max().getAsInt();
        int[] max_indices = IntStream.range(0, counts.length).filter(i -> counts[i] == max).toArray();
        String[] winners = IntStream.of(max_indices).mapToObj(i -> names[i]).toArray(String[]::new);
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
