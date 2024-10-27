package racingcar;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final String CARNAMES_INPUTMESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분";
    private static final String COUNT_INPUTMESSAGE = "시도할 횟수는 몇 회인가요?";

    public static void main(String[] args) {
        String carNames = getCarNames();
        int count = getCount();


    }

    private static int getCount() {
        System.out.println(COUNT_INPUTMESSAGE);
        String CountInputValue = Console.readLine();
        int count = validateCountInputValue(CountInputValue);
        return count;
    }

    //count 숫자 검증 메서드
    private static int validateCountInputValue(String CountInputValue) {
        try {
            int count = Integer.parseInt(CountInputValue);
            if (count <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이여야 합니다.");
            }
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 문자열이 아닌 숫자여야 합니다.");
        }
    }

    private static String getCarNames() {
        System.out.println(CARNAMES_INPUTMESSAGE);
        String carNames = Console.readLine();
        //차이름이 5자 이하인지 검사
        return carNames;
    }
}
