package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = new ArrayList<>();
        carNames = getCarNames();

        isValidCarNames(carNames);

        System.out.println("시도할 횟수는 몇 회인가요?");
        int totalRaceCount = 0;
        totalRaceCount = getTotalRaceCount();
    }

    public static List<String> getCarNames(){
        String input = Console.readLine();
        // 입력된 문자열을 쉼표로 분리하고, 빈 문자열을 필터링하여 유효한 이름만 리스트에 추가
        return Arrays.stream(input.split(","))
                .map(String::trim) // 공백 제거
                .filter(name -> !name.isEmpty()) // 빈 문자열 필터링
                .toList();
    }

    public static int getTotalRaceCount(){
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    public static void isValidCarNames(List<String> carNames) {
        // 유효한 이름이 하나도 없는 경우 예외 처리
        if (carNames == null || carNames.isEmpty() || carNames.stream().allMatch(String::isEmpty)) {
            throw new IllegalArgumentException();
        }

        // 중복된 이름이 있는지 확인
        Set<String> uniqueNames = new HashSet<>(carNames);
        if (uniqueNames.size() != carNames.size()) {
            throw new IllegalArgumentException();
        }

        // 각 이름에 대한 길이 검사
        for (String name : carNames) {
            if (name.length() > 5 || name.isEmpty()) {
                throw new IllegalArgumentException();
            }
        }
    }

}