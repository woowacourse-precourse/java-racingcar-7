package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingManager {

    private String input = "";
    private int NUMBER;
    private String[] inputCars;
    private List<Car> carList = new ArrayList<>();
    private int MAX_POSITION;
    private List<String> names = new ArrayList<>();


    RacingManager(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        this.input = Console.readLine(); // 사용자 입력을 받는 메소드
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            this.NUMBER = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자를 입력하지 않았습니다.");
        }
        splitInputCars();
    }

    private void splitInputCars() {
        this.inputCars = input.split(",");
    }

    public void runRacing() {
    }
}
