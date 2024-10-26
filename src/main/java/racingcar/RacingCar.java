package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RacingCar {
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
