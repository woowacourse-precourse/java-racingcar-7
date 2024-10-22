package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Viewer {
    private final String carInputString = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String tryInputString = "시도할 횟수는 몇 회인가요?";
    private final String outputString = "최종 우승자 : ";
    private String carInput;
    private int tryInput;
    private List<String> carList;

    public void carInputToCarList() {
        this.carList = Arrays.asList(carInput.split(","));
    }

    public void readInput() {
        readCarInput();
        readTryInput();
    }

    public void readCarInput() {
        System.out.println(carInputString);
        this.carInput = Console.readLine();
    }

    public void readTryInput() {
        System.out.println(tryInputString);
        this.tryInput = Integer.parseInt(Console.readLine());
    }

    public String getCarInput() {
        return this.carInput;
    }

    public int getTryInput() {
        return this.tryInput;
    }
}
