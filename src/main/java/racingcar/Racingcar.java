package racingcar;

/*
* 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후
* 무작위 값이 4 이상일 경우이다.
* */
/*
* 배열이 아닌 리스트를 이용해야함 - HashMap사용
* */

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.List;

public class Racingcar {
    // 자동차 이름 입력받기
    public static List<String> readNamesInput(){
        String nameInput = Console.readLine();
        List<String> names = List.of(nameInput.split(","));
        return names;
    }
    // 총 이동횟수 입력받기
    public static int readNumInput(){
        int numInput = Integer.parseInt(Console.readLine()); // 나중에 분리
        return numInput;
    }
    // 랜덤 정수 받기
    public static void raceCars(List<String> carNames, int totalRounds){
        HashMap<String, Integer> carPositions = new HashMap<>();
        // 총 이동횟수(totalRounds) 게임 진행
        for(int round = 0; round<totalRounds; round++){
            // 차의 개수만큼 랜덤정수 받기
            for(){
                int randomnumber = Randoms.pickNumberInRange(0, 9);
                    if (randomnumber >= 4) {
                        // 전진
                }
            }
        }
    }
}
