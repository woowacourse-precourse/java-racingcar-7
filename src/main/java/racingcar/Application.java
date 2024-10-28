package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int tr = Integer.parseInt(Console.readLine());

        String[] Cars = input.split(",");
        for (String a : Cars) {
            if (a.length() > 5) {
                throw new IllegalArgumentException("이름이 6자이상임");
            }
        }

        Map<String, Integer> hm = new HashMap<>();

        ArrayList<String> answer = new ArrayList<>();

        System.out.println("실행 결과");

        while (tr-- > 0) {
            updateWholeCarposition(Cars, hm);
            printRoundResult(Cars, hm);
            System.out.println();
        }
    }

    //게임진행 구현
    public static void updateWholeCarposition(String[] Cars, Map<String, Integer> hm){
        for (String tmp : Cars) {
            updateCarposition(tmp, hm);
        }
    }

    public static void updateCarposition(String tmp, Map<String, Integer> hm){
        Integer randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum >= 4) {
            hm.put(tmp, hm.getOrDefault(tmp, 0) + 1);
        }
    }

    //4. 각 라운드마다 진행상황 출력
    private static void printRoundResult(String[] Cars, Map<String, Integer> hm) {
        for (String k : Cars) {
            System.out.print(k + " : " + printMove(hm.getOrDefault(k, 0)) + '\n');
        }
    }

    public static String printMove(int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

}
