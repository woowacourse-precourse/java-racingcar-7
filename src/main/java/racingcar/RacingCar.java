package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingCar {

    public static void readInputs(String[] names, int[] counts, Integer times){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input_names = readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input_times = readLine();

        names = input_names.split(",");
        counts = new int[names.length];
        times = Integer.parseInt(input_times);
    }
    private static void randomlyProceed(int[] distances, int car){
        if (Randoms.pickNumberInRange(0,9) >= 4) {
            distances[car] += 1;
        }
    }
    public static void printProcess(int times, String[] names, int[] distances){
        for (int i=0; i<times; i++){
            for (int j=0; j<names.length; j++) {
                randomlyProceed(distances, j);
                System.out.println(names[j] + " : " + "-".repeat(distances[j]));
            }
            System.out.println("");
        }
    }

    public static String[] getWinners(String[] names, int[] distances) {
        int max = Arrays.stream(distances).max().getAsInt();
        int[] max_indices = IntStream.range(0, distances.length).filter(i -> distances[i] == max).toArray();
        String[] winners = IntStream.of(max_indices).mapToObj(i -> names[i]).toArray(String[]::new);
        return winners;
    }
}
