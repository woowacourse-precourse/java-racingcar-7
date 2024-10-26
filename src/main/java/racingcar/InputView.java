package racingcar;

public class InputView {


    public static String[] inputCar(final String carName) throws IllegalAccessException {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = carName.split(",");

        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalAccessException("자동차 이름의 글자 수가 초과하였습니다.");
            }
        }

        return carNames;


    }

    public static int inputCount (final String inputCountNum){
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(inputCountNum);
    }
}
