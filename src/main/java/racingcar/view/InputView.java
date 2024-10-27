package racingcar.view;
import camp.nextstep.edu.missionutils.Console;
public class InputView {
    private static final InputView instance = new InputView();

    private InputView() {}

    public static InputView getInstance() {
        return instance;
    }

    public String[] getVehicleName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        //입력 받기
        String result = Console.readLine();

        result = result.replace(" ",""); //공백 제거
        // 경주에 참여하는 자동차들의 이름 배열 반환

        return result.split(",");
    }

    public int getMoveCount(){
        System.out.println("시도할 횟수는 몇 회인가요?");

        String result = Console.readLine();

        return Integer.parseInt(result);
    }
}
