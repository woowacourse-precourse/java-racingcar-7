package racingcar.View;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;


public class InputView {
    private final static String INPUT_CAR_NAMES="경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String INPUT_GAME_COUNT="시도할 횟수는 몇 회인가요?";

    public static String Car_names(){
        System.out.println(INPUT_CAR_NAMES);
        String CarNames = Console.readLine();
        CheckCarName(CarNames);
        return CarNames;
    }
    public static int Game_count(){
        System.out.println(INPUT_GAME_COUNT);
        int count=parseInt(Console.readLine());
        CheckCount(count);
        return count;
    }
    private static void CheckCount(int count){
        if(count<0) throw new IllegalArgumentException("Error: 실행 횟수는 음수가 아닌 양수여야합니다.");
    }
    private static void CheckCarName(String CarNames){
        if(CarNames.length()>5) throw new IllegalArgumentException("Eroor: 자동차 이름은 5자 이하만 가능합니다.");
    }
}
