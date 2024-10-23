package racingcar;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedList;
import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = readLine();
        LinkedList<String> players = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();

        for (String n : names.split(",")) {
            players.add(n);
            result.add(0);
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        int times = Integer.parseInt(readLine());

        for(int i = 0; i < times; i++){
            for(int j = 0; j < players.size(); j++) {

                if(Randoms.pickNumberInRange(0, 9) >= 4){
                    int curr = result.get(j);
                    result.set(j, ++curr);
                }
            }
            for(int j = 0; j < players.size(); j++){
                System.out.print(players.get(j) + " : ");
                for(int k = 0; k < result.get(j); k++) {
                    System.out.print("- ");
                }
                System.out.println();
            }
            System.out.println();
        }
        int max = -1;
        int maxPos = 0;
        for(int i = 0; i < result.size(); i++){
            if(max < result.get(i)){
                max = result.get(i);
                maxPos = i;
            }
        }
        System.out.println("최종 우승자 : " + players.get(maxPos));
    }
}
