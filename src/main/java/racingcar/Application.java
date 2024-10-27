package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
    private static final Pattern RACING_CAR_NAME_REGEX_PATTERN = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]{0,4}$");
    private static final Pattern TRY_COUNT_REGEX_PATTERN = Pattern.compile("^[1-9][0-9]*$");
    private static final int MOVE_FORWARD_THRESHOLD = 4;
    private static final int RANDOM_LOWER_BOUND = 0;
    private static final int RANDOM_UPPER_BOUND = 9;
    private static final String MOVE_MARK = "-";

    public static void main(String[] args) {
        // 경주할 자동차 이름 입력 받고, 유효성 검증
        String racingCarNameInput = inputString("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> racingCars = Arrays.asList(racingCarNameInput.split(","));
        validateRacingCars(racingCars);

        // 시도 횟수를 문자열로 입력 받고, 유효성 검증 이후 정수로 변환
        String tryCountInput = inputString("시도할 횟수는 몇 회인가요?");
        validateTryCount(tryCountInput);
        int tryCount = Integer.parseInt(tryCountInput);

        // 자동차 경주 게임 수행
        playRacingCarGame(tryCount, racingCars);
    }

    private static void playRacingCarGame(int tryCount, List<String> racingCars) {
        // 자동차 이름을 키로 하고, 이동 거리를 값으로 하는 맵 초기화
        HashMap<String, Integer> racingCarsDistance = new HashMap<>();
        racingCars.forEach(racingCar -> racingCarsDistance.put(racingCar, 0));

        // 자동차 경주 게임의 라운드를 시도 횟수만큼 수행
        System.out.println("\n실행 결과");
        for (int i = 0; i < tryCount; i++) {
            playRacingCarRound(racingCars, racingCarsDistance);
        }

        // 자동차 경주 게임의 우승자를 선정 및 출력
        List<String> winners = findWinners(racingCars, racingCarsDistance);
        showWinners(winners);
    }

    private static void playRacingCarRound(List<String> racingCars, HashMap<String, Integer> racingCarsDistance) {
        for (String racingCar : racingCars) {
            int randomValue = Randoms.pickNumberInRange(RANDOM_LOWER_BOUND, RANDOM_UPPER_BOUND);

            if (canMoveForward(randomValue)) {
                int updatedScore = racingCarsDistance.get(racingCar) + 1;
                racingCarsDistance.put(racingCar, updatedScore);
            }
        }
        showRoundResult(racingCars, racingCarsDistance);
    }

    private static List<String> findWinners(List<String> racingCars, HashMap<String, Integer> racingCarsDistance) {
        List<String> winners = new ArrayList<>();
        int max = findMaxDistance(racingCars, racingCarsDistance);

        for (String racingCar : racingCars) {
            if (max == racingCarsDistance.get(racingCar)) {
                winners.add(racingCar);
            }
        }
        return winners;
    }

    private static int findMaxDistance(List<String> racingCars, HashMap<String, Integer> racingCarsDistance) {
        int max = -1;

        for (String racingCar : racingCars) {
            if (max < racingCarsDistance.get(racingCar)) {
                max = racingCarsDistance.get(racingCar);
            }
        }
        return max;
    }

    private static void showWinners(List<String> winners) {
        String winnersJoinedByComma = String.join(",", winners);
        System.out.printf("최종 우승자 : %s", winnersJoinedByComma);
    }

    private static void showRoundResult(List<String> racingCars, HashMap<String, Integer> racingCarsDistance) {
        for (String racingCar : racingCars) {
            String track = MOVE_MARK.repeat(racingCarsDistance.get(racingCar));
            System.out.printf("%s : %s\n", racingCar, track);
        }
        System.out.println();
    }

    private static boolean canMoveForward(int randomValue) {
        return randomValue >= MOVE_FORWARD_THRESHOLD;
    }

    private static String inputString() {
        return inputString(null);
    }

    private static String inputString(String message) {
        if (message == null) {
            return Console.readLine();
        }
        System.out.println(message);
        return Console.readLine();
    }

    private static void validateRacingCars(List<String> racingCars) {
        if (racingCars.size() != new HashSet<>(racingCars).size()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 존재합니다.");
        }
        racingCars.forEach(Application::validateRacingCar);
    }

    private static void validateRacingCar(String racingCar) {
        if (!RACING_CAR_NAME_REGEX_PATTERN.matcher(racingCar).matches()) {
            throw new IllegalArgumentException("자동차 이름은 영문자로 시작하고, 영문자와 숫자로만 구성되어야 하며, 5글자 이하여야 합니다.");
        }
    }

    private static void validateTryCount(String tryCountInput) {
        if (!TRY_COUNT_REGEX_PATTERN.matcher(tryCountInput).matches()) {
            throw new IllegalArgumentException("시도 횟수는 숫자로만 구성되어야 하며, 0일 수 없습니다.");
        }
    }
}
