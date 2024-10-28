package racingcar.view;

import racingcar.dto.RacingCarDTO;

import java.util.List;
import java.util.Map;

public class OutputView {

    /**
     * Print The result Of Each RaceCar Update Distance
     * Input : RacingCarDTO
     * Return : X
     */
    public static void printEachDistanceByRandomMovement(RacingCarDTO racingCarDTO){

        // 1. racingCarDTO 내부의 Map 데이터를 가져온다.
        Map<String, Integer> racingCarData = racingCarDTO.getRacingCarData();

        // 2. 각 racingCarData에 맞춰서 순서대로 출력 함수를 돌린다.
        for (Map.Entry<String, Integer> eachRacingCarData : racingCarData.entrySet()) {
            String NameOfEachRacingCar = eachRacingCarData.getKey();
            int distanceOfEachRacingCar = eachRacingCarData.getValue();

            // 각 차량의 이동 거리만큼 "-"를 반복해서 출력
            System.out.println(NameOfEachRacingCar + " : " + "-".repeat(distanceOfEachRacingCar));
        }
    }

    /**
     * Print The Winner Of Racing Game
     * Input : RacingCarDTO
     * Return : X
     */
    public static void printWinnerOfRacing(RacingCarDTO racingCarDTO) {

        // 1. racingCarDTO 내부의 Map 데이터를 가져온다.
        Map<String, Integer> racingCarData = racingCarDTO.getRacingCarData();

        // 2. 최대 distance 값을 찾는다.
        int maxDistance = racingCarData.values()
                .stream()
                .max(Integer::compareTo)
                .orElse(0);

        // 3. 우승자의 이름을 String[] 배열에 저장한다.
        List<String> winnersList = racingCarData.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == maxDistance)
                .map(Map.Entry::getKey)  // 이름을 추출
                .toList();  // 리스트로 변환

        String[] winnersArray = winnersList.toArray(new String[0]); // 배열로 변환

        // 4. 배열을 기반으로 이름을 출력한다.
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winnersArray.length; i++) {
            System.out.print(winnersArray[i]);
            if (i < winnersArray.length - 1) {
                System.out.print(", ");  // 마지막 이름이 아닐 때만 ", " 출력
            }
        }
    }
}
