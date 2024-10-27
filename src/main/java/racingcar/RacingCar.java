package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingCar {

    private static void randomlyProceed(List<Integer> distances, Integer car){
        if (Randoms.pickNumberInRange(0,9) >= 4) {
            distances.set(car, distances.get(car) + 1);
        }
    }
    private static void printProcess(Integer times, List<String> names, List<Integer> distances){
        for (int i=0; i<times; i++){
            for (int j=0; j<names.size(); j++) {
                randomlyProceed(distances, j);
                System.out.println(names.get(j) + " : " + "-".repeat(distances.get(j)));
            }
            System.out.println("");
        }
    }

    private static List<String> getWinners(List<String> names, List<Integer> distances) {
        int maxDistance = distances.stream().
                max(Integer::compare).
                orElseThrow(() -> new NoSuchElementException("No scores found"));
        return IntStream.range(0, distances.size())
                .filter(i -> distances.get(i) == maxDistance)
                .mapToObj(names::get)
                .collect(Collectors.toList());
    }

    public static String[] readInputs(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input_names = readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input_times = readLine();
        return new String[] {input_names, input_times};
    }

    public static Map<String, Object> processInputs(String input_names, String input_times){
        Map<String, Object> processed_input = new HashMap<>();
        String[] name_arr = input_names.split(",");
        processed_input.put("names",Arrays.asList(name_arr));
        processed_input.put("distances", Stream.generate(()->0)
                                                .limit(name_arr.length)
                                                .collect(Collectors.toList()));// 0으로 채운 리스트
        processed_input.put("times", Integer.parseInt(input_times));
        return processed_input;
    }

    public static void printOutputs(List<String> names, List<Integer> distances, Integer times) {
        System.out.println("실행 결과");
        printProcess(times,names,distances);
        List<String> winners = getWinners(names, distances);
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public static void checkInputException(String input_names, String input_times) {
        // input_names 스트링을 반점 기준으로 나눴을때 빈 스트링이 없는지, 스트링 길이가 5 이하인지 체크
        if(input_names == null || !Arrays.stream(input_names.split(",",-1))
                                        .allMatch(name -> !name.isEmpty() && name.length() <= 5)){
            throw new IllegalArgumentException();
        }
        // input_times 스트링이 양의 정수로 변환가능한지 체크
        if(input_times == null || input_times.equals("0") || !input_times.matches("\\d+")){
            throw new IllegalArgumentException();
        }
    }
}
