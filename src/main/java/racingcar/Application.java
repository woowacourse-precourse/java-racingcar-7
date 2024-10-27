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

            // 이름에 대한 길이 제한조건으로 예외 던지기
            String[] carList = cars.split(",");
            for (String s : carList) {
                if (s.length()>5) throw new IllegalArgumentException("Wrong Input, car name length should be under 6");
            }

            // 각 자동차의 이동횟수 저장할 변수 선언 및 초기화
            Map<String, Integer> result = new HashMap<>();
            for (String s : carList) {
                result.put(s,0);
            }

            // 각 단계별로 경기 진행 후 결과 도출
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

            // 우승자 점수 구하기
            List<String> winners = new ArrayList<>();
            int max=0;
            for (String s : result.keySet()) {
                if (max <= result.get(s)) {
                    max = result.get(s);
                }
            }

            // 우승자 점수에 해당하는 사람울 최종 출력 변수에 추가
            for (String s : result.keySet()) {
                if (max == result.get(s)) winners.add(s);
            }

            // 2명 이상이 우승자 일때 콤마로 연결한 후 출력
            String join = String.join(", ", winners);
            System.out.println("최종 우승자 : "+join);

        } catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }

    }
}
