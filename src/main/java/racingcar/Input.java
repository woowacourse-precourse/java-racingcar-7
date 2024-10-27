package racingcar;
import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;

public class Input {

    HashMap<String, Integer> map = new HashMap<>();

    protected HashMap<String, Integer> getCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String temp[]=input.split(",");

        for(int i=0; i<temp.length; i++){ // car 목록 초기화
            map.put(temp[i], 0);
        }
        return map;
    }

    protected int getNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int input = Integer.parseInt(Console.readLine());
        return input;
    }
}
