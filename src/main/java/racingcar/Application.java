package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println(IOMessage.INPUT_CAR_NAMES);
        String carNames = readLine();

        System.out.println(IOMessage.INPUT_TRY_COUNT);
        String inputTryCount = readLine();

        boolean validInput = isValidName(carNames) && isValidTryCount(inputTryCount);

        if (validInput) {
            int tryCount = Integer.parseInt(inputTryCount);
            Map<String, StringBuilder> resultMap = createResultMap(carNames);
            startGame(tryCount, resultMap);
        }
    }

    public static boolean isValidName(String carNames) {
        validateStartEnd(carNames);

        String[] namesByComma = carNames.split(IOMessage.COMMA_SEPARATOR);
        validateDuplication(namesByComma);

        for (String name : namesByComma) {
            validateEmpty(name);
            validateLength(name);
        }

        return true;
    }

    public static void validateStartEnd(String carNames) {
        if (carNames.startsWith(",") || carNames.endsWith(",")) {
            throw new IllegalArgumentException("맨 앞 또는 뒤 이름이 없다.");
        }
    }

    public static void validateDuplication(String[] namesByComma) {
        Set<String> names = new HashSet<>(Arrays.stream(namesByComma).toList());

        if (namesByComma.length != names.size()) {
            throw new IllegalArgumentException("중복된 이름을 사용했다.");
        }
    }

    public static void validateLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름 길이가 5를 초과했다.");
        }
    }

    public static void validateEmpty(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("빈 값이다.");
        }
    }

    public static boolean isValidTryCount(String inputTryCount) {
        validateNumberFormat(inputTryCount);
        validateBound(inputTryCount);

        return true;
    }

    public static void validateNumberFormat(String inputTryCount) {
        if(!inputTryCount.matches("[1-9]+")) {
            throw new IllegalArgumentException("숫자가 아닌 문자가 있다.");
        }
    }

    public static void validateBound(String inputTryCount) {
        if (Integer.parseInt(inputTryCount) < 0) {
            throw new IllegalArgumentException("int 범위를 초과했다.");
        }
    }

    public static Map<String, StringBuilder> createResultMap(String carNames) {
        String[] namesByComma = carNames.split(IOMessage.COMMA_SEPARATOR);
        Map<String, StringBuilder> resultMap = new LinkedHashMap<>();

        for (String name : namesByComma) {
            resultMap.put(name, new StringBuilder());
        }

        return resultMap;
    }

    public static void startGame(int tryCount, Map<String, StringBuilder> resultMap) {
        for (int i = 0; i < tryCount; i++) {
            saveMovementInMap(resultMap);
            System.out.println(createRaceResult(resultMap));
        }
    }

    public static void saveMovementInMap(Map<String, StringBuilder> resultMap) {
        for (String name : resultMap.keySet()) {
            int randomNumber = createRandomNumber();
            appendMovementSignByRandom(resultMap, name, randomNumber);
        }
    }

    public static int createRandomNumber() {
        return Randoms.pickNumberInRange(RandomConstant.RANDOM_RANGE_START, RandomConstant.RANDOM_RANGE_END);
    }

    public static void appendMovementSignByRandom(Map<String, StringBuilder> resultMap, String name, int randomNumber) {
        if (randomNumber >= RandomConstant.MOVEMENT_START_VALUE) {
            resultMap.get(name).append(IOMessage.MOVEMENT_SIGN);
        }
    }

    public static String createRaceResult(Map<String, StringBuilder> resultMap) {
        StringBuilder result = new StringBuilder();

        for (String name : resultMap.keySet()) {
            String movement = resultMap.get(name).toString();
            result.append(IOMessage.buildRaceResult(name, movement)).append("\n");
        }

        return result.toString();
    }
}
