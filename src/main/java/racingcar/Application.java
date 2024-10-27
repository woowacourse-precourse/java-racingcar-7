package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    private static final String CARNAMES_INPUTMESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String COUNT_INPUTMESSAGE = "시도할 횟수는 몇 회인가요?";

    private static final String ERROR_COUNT_MUST_BE_POSITIVE = "시도 횟수는 1 이상이어야 합니다.";
    private static final String ERROR_COUNT_MUST_BE_NUMBER = "시도 횟수는 문자열이 아닌 숫자여야 합니다.";
    private static final String ERROR_CARNAMES_REQUIRED = "반드시 자동차 이름을 입력하셔야 합니다";
    private static final String ERROR_CARNAME_CANNOT_BE_EMPTY = "자동차 이름은 빈 값이 될 수 없습니다.";
    private static final String ERROR_CARNAME_MAX_LENGTH = "자동차 이름은 5자 이하로 입력해주세요";


    public static void main(String[] args) {
        String[] carNames = getCarNames();
        int count = getCount();

        int[] carPositions = new int[carNames.length];

        raceStart(count, carNames, carPositions);


    }

    private static int getCount() {
        System.out.println(COUNT_INPUTMESSAGE);
        String countInputValue = Console.readLine();
        return validateCountInputValue(countInputValue);
    }

    private static int validateCountInputValue(String CountInputValue) {
        try {
            int count = Integer.parseInt(CountInputValue);
            if (count <= 0) {
                throw new IllegalArgumentException(ERROR_COUNT_MUST_BE_POSITIVE);
            }
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_COUNT_MUST_BE_NUMBER);
        }
    }

    private static String[] getCarNames() {
        System.out.println(CARNAMES_INPUTMESSAGE);
        String carNamesValue = Console.readLine();
        return splitAndValidateCarNames(carNamesValue);
    }

    private static void validateCarNames(String[] carNamesArray) {
        for (int i = 0; i < carNamesArray.length; i++) {
            // 공백 제거 후 배열에 다시 할당
            carNamesArray[i] = carNamesArray[i].trim();
            String name = carNamesArray[i];
            if (name.isEmpty()) {
                throw new IllegalArgumentException(ERROR_CARNAME_CANNOT_BE_EMPTY);
            }
            if (name.length() > 5) {
                throw new IllegalArgumentException(ERROR_CARNAME_MAX_LENGTH);
            }
        }
    }

    private static String[] splitAndValidateCarNames(String carNamesValue) {
        if (carNamesValue == null || carNamesValue.isEmpty()) {
            throw new IllegalArgumentException(ERROR_CARNAMES_REQUIRED);
        }
        String[] carNamesArray = carNamesValue.split(",");
        validateCarNames(carNamesArray);
        return carNamesArray;
    }

    private static void raceStart(int count, String[] carNames, int[] carPositions) {
        for (int i = 0; i < count; i++) {
            carMove(carNames, carPositions);
            printCarPositions(carNames, carPositions);
        }
    }

    private static void carMove(String[] carNames, int[] carPositions) {
        for (int i = 0; i < carNames.length; i++) {
            int randomValue = Randoms.pickNumberInRange(0,9);
            if (randomValue >=4) {
                carPositions[i]++;
            }
        }
    }

    private static void printCarPositions(String[] carNames, int[] carPositions) {
        for (int i = 0; i < carNames.length; i++) {
            System.out.println(carNames[i] + " : " + "-".repeat(carPositions[i]));
        }
        System.out.println();
    }

}