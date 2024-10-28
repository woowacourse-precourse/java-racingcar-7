package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Map<String, Integer> cars = init();
        int times = calculateTimes();

        List<String> winners = run(cars, times);

        printWinners(winners);
    }

    public static Map<String, Integer> init() {
        Map<String, Integer> cars = new LinkedHashMap<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        StringTokenizer st = new StringTokenizer(Console.readLine(), ",");

        while (st.hasMoreTokens()) {
            String token = st.nextToken();

            if (token.length() > 5) throw new IllegalArgumentException("car name is too long");

            cars.put(token, 0);
        }

        return cars;
    }

    public static int calculateTimes(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public static boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public static List<String> run(Map<String, Integer> cars, int times) {
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < times; i++) {
            moveCars(cars);
            printCars(cars);
        }

        return getWinners(cars);
    }

    public static void moveCars(Map<String, Integer> cars) {
        for (String car : cars.keySet()) {
            if (canMove()) cars.put(car, cars.get(car) + 1);
        }
    }

    public static void printCars(Map<String, Integer> cars) {
        StringBuilder sb = new StringBuilder();

        for (String car : cars.keySet()) {
            sb.append(car).append(" : ").repeat('-', cars.get(car)).append("\n");
        }

        System.out.println(sb);
    }

    public static int getMaxValue(Map<String, Integer> cars) {
        return cars.values().stream().max(Integer::compare).orElse(0);
    }

    public static List<String> getWinners(Map<String, Integer> cars) {
        int max = getMaxValue(cars);
        return cars.entrySet().stream()
                .filter(entry -> entry.getValue() == max)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
