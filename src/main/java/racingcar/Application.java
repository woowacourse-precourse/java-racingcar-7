package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    public static void main(String[] args) {

        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String cars = Console.readLine();

            System.out.println("시도할 횟수는 몇 회인가요?");
            int tryN = Integer.parseInt(Console.readLine());

            String[] carList = cars.split(",");
            for (String s : carList) {
                if (s.length()>5) throw new IllegalArgumentException("illegal");
            }

            // 각 자동차의 이동횟수 저장할 변수 선언 및 초기화
            Map<String, Integer> result = new HashMap<>();
            for (String s : carList) {
                result.put(s,0);
            }

            System.out.println("실행 결과");
            for (int k=0; k<tryN; k++){
                for (String car : carList) {

                    String move = "";
                    Integer howMuchMove = result.get(car);
                    int number = Randoms.pickNumberInRange(0, 9);

                    if (number>=4) {
                        howMuchMove++;
                        result.put(car,howMuchMove);
                    }
                    for (int i=0; i<howMuchMove; i++){
                        move = move+"-";
                    }
                    System.out.println(car + " : "+ move);
                }
                System.out.println();
            }

            List<String> winners = new ArrayList<>();
            int max=0;
            for (String s : result.keySet()) {
                if (max <= result.get(s)) {
                    max = result.get(s);
                }
            }

            for (String s : result.keySet()) {
                if (max == result.get(s)) winners.add(s);
            }

            String join="";
            for (String winner : winners) {
                System.out.println("max is "+max + " and winner is "+winner +" ");
                join = String.join(", ", winners);
            }

            System.out.println("최종 우승자 : "+join);

        } catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }

    }
}
