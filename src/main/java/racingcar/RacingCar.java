package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingCar {

    private static void randomlyProceed(int[] distances, int car){
        if (Randoms.pickNumberInRange(0,9) >= 4) {
            distances[car] += 1;
        }
    }
    private static void printProcess(int times, String[] names, int[] distances){
        for (int i=0; i<times; i++){
            for (int j=0; j<names.length; j++) {
                randomlyProceed(distances, j);
                System.out.println(names[j] + " : " + "-".repeat(distances[j]));
            }
            System.out.println("");
        }
    }

    private static String[] getWinners(String[] names, int[] distances) {
        int max = Arrays.stream(distances).max().getAsInt();
        int[] max_indices = IntStream.range(0, distances.length).filter(i -> distances[i] == max).toArray();
        String[] winners = IntStream.of(max_indices).mapToObj(i -> names[i]).toArray(String[]::new);
        return winners;
    }

    public static String[] readInputs(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input_names = readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input_times = readLine();
        return new String[] {input_names, input_times};
    }

    public static void processInputs(String[] names, int[] distances, Integer times, String input_names, String input_times){
        names = input_names.split(",");
        distances = new int[names.length];
        times = Integer.parseInt(input_times);
    }

    public static void printOutputs(String[] names, int[] distances, Integer times) {
        System.out.println("실행 결과");
        printProcess(times,names,distances);
        String[] winners = getWinners(names, distances);
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public static void checkInputException(String input_names, String input_times) {
        // input_names 스트링을 반점 기준으로 나눴을때 빈 스트링이 없는지 체크
        if(input_names == null ||  input_names == "" || input_names.charAt(-1)==','){
            throw new IllegalArgumentException();
        }
        // input_times 스트링이 양의 정수로 변환가능한지 체크
        if(input_times == null || input_times.matches("\\d+")){
            throw new IllegalArgumentException();
        }
    }
}
