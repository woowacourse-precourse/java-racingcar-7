package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        if(carNamesInput.isBlank()){
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }

        // Car이란 객체에 정보를 넣으면 좋을듯
        List<String> carNames = new ArrayList<>();
        for(String carName: carNamesInput.split(",")){
            if(carName.isBlank()) {
                throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
            } else if (carNames.contains(carName)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            } else if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            carNames.add(carName.strip());
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        String carMoveCountInput = Console.readLine();

        if(!isNumeric(carMoveCountInput)) {
            throw new IllegalArgumentException("횟수는 숫자만 가능합니다.");
        }
        // 원시타입은 써도 괜찮은가?
        int carMoveCount = Integer.parseInt(carMoveCountInput);
        if(carMoveCount > 80 || carMoveCount <= 0) {
            throw new IllegalArgumentException("횟수는 1 이상 80 이하의 숫자만 가능합니다.");
        }

        // 해쉬맵 말고 Car 객체의 필드(movedCount)로 관리하면 좋을듯
        Map<String, Integer> carMoved = new HashMap<>();
        // 초기화 하는 다른 방법이 있는가?
        for(String carName: carNames) {
            carMoved.put(carName, 0);
        }

        System.out.println("실행 결과");
        for(int i = 0; i < carMoveCount; i++) {
            for(String carName: carNames){
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                //들여쓰기 3 돌파
                if(randomNumber >= 4){
                    carMoved.put(carName, carMoved.get(carName) + 1);
                }
                System.out.println(carName + " : " + "-".repeat(carMoved.get(carName)));
            }
            System.out.println();
        }

        // 우승자 가리는 로직 이게 최선?
        Integer maxMovedCount = Collections.max(carMoved.values());
        List<String> winnerNames = new ArrayList<>();
        for(String carName: carNames){
            if(carMoved.get(carName).equals(maxMovedCount)){
                winnerNames.add(carName);
            }
        }

        String finalWinner = String.join(", ", winnerNames);
        System.out.println("최종 우승자 : " + finalWinner);
    }
}
