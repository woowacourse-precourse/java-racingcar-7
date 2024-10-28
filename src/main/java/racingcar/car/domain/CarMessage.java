package racingcar.car.domain;

public class CarMessage {
    public static final String ENTER_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public static void printMessage() {
        System.out.println(ENTER_NAME);
    }
}
