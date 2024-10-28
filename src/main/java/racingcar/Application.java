package racingcar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String pureInput = getInputCarNames();
        ArrayList<String> carName = new ArrayList<>(List.of(pureInput.split(",")));
        validateCarNames(carName);

        Integer playNum = getPlayNumber();
    }

    private static Integer getPlayNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        Integer num;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            num = Integer.parseInt(br.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("시도 횟수로 숫자만 가능합니다.");
        }
        return num;
    }

    private static void validateCarNames(ArrayList<String> carName) {
        for (int i = 0; i < carName.size(); i++) {
            checkLengthUnder6(carName.get(i));
            checkIsBlank(carName.get(i));
            checkNameDuplicate(carName);
        }
    }

    private static void checkNameDuplicate(ArrayList<String> carName) {
        if (isDuplicates(carName)) {
            throw new IllegalArgumentException("차 이름이 중복됩니다.");
        }
    }


    public static boolean isDuplicates(List<String> list) {
        Set<String> set = new HashSet<>(list);
        return set.size() < list.size();
    }


    private static void checkLengthUnder6(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("차의 이름은 5자 이하여야합니다.");
        }
    }

    private static void checkIsBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("차의 이름으로 공백은 불가능합니다");
        }
    }

    private static String getInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String carNames;
        try {
            carNames = br.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다.");
        }
        return carNames;
    }
}
