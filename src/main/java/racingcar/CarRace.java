package racingcar;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;

public class CarRace {

    public static List<String> start(String cars, int moveAttempts){
        String[] carNames = cars.split(",");

        // 입력값에 포함될 수 있는 공백 제거
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].strip();
        }

        // 자동차명과 각각의 이동거리를 Map에 보관
        Map<String, String> carMap  = new HashMap<>();

        // 출발 전이므로 각 자동차의 이동거리를 ""으로 초기화
        for (int i = 0; i < carNames.length; i++) {
            carMap.put(carNames[i], "");
        }

        // 주어진 이동횟수만큼 반복하며 전진 시도
        for (int i = 0; i < moveAttempts; i++) {
            move(carMap, carNames); // 전진 조건 만족 시, 한 칸("-") 전진
            printRaceStaus(carMap); // 모든 자동차들이 자신의 턴을 다 사용하면 현재 레이스 현황을 출력
        }

        // 가장 멀리 이동한 자동차를 List에 담아 반환한다.
        return determineRaceWinners(carMap, carNames);
    }

    /**
     * carNames 배열에 담긴 참가 자동차들의 수만큼 반복
     * 각 자동차에 대하여 canMove() 메서드 실행 -> 전진 또는 멈춤을 판단하는 메서드
     * 메서드 실행 결과가 true 일때, 한 칸 전진 ( false인 경우, 그 자리에 멈춤 )
     *
     * @param carMap : key -> 자동차명 , value -> 이동 거리
     * @param carNames : 참가 자동차들을 담은 배열
     */
    private static void move(Map<String, String> carMap, String[] carNames){
        for (int i = 0; i < carNames.length; i++) {
            if (canMove()) {
                // 전진 조건 만족 시, 기존 이동거리에 "-" 추가
                carMap.put(carNames[i], carMap.get(carNames[i]) + "-");
            }
        }
    }

    /**
     *
     * @return : 0부터 9사이의 값을 임의로 추출할때, 그 값이 4 이상인 경우 true 반환
     */
    private static boolean canMove(){
        return Randoms.pickNumberInRange(0, 9) > 4;
    }

    /**
     * 자동차 경주 진행 현황
     * 자동차들이 모두 한번씩 턴을 사용할 때마다 진행 현황을 출력
     *
     * @param carMap : key -> 자동차명 , value -> 이동 거리
     */
    private static void printRaceStaus(Map<String, String> carMap){
        System.out.println("실행 결과");
        for (String str : carMap.keySet()) {
            System.out.println(str + " : " + carMap.get(str));
        }
        System.out.println();
    }

    /**
     * 모든 턴이 종료되었을 때, 최종 우승자를 판단하기 위한 메서드
     *
     *
     * @param carMap : key -> 자동차명 , value -> 이동 거리
     * @param carNames : 참가 자동차들을 담은 배열
     * @return 우승자를 List 형태로 반환
     */
    private static List<String> determineRaceWinners(Map<String, String> carMap, String[] carNames){
        // 각 자동차의 이동 거리를 숫자로 저장하기 위한 새로운 Map<String, Integer> 생성
        Map<String, Integer> carsWithMoveCount = new HashMap<>();

        // 자동차 이름을 key로, 이동 거리(기존에 이동거리를 표현한 문자열의 길이)를 value로 지정
        for (int i = 0; i < carMap.size(); i++) {
            carsWithMoveCount.put(carNames[i], carMap.get(carNames[i]).length());
        }

        // value만 따로 분리해서 최대값을 구한다
        Collection<Integer> values = carsWithMoveCount.values();
        Integer max = Collections.max(values);

        // 우승자를 담기 위한 List
        List<String> winner = new ArrayList<>();
        // 최댓값과 일치하는 이동 거리(int)를 가진 자동차명을 List에 추가
        for (int i = 0; i < carMap.size(); i++) {
            if(carMap.get(carNames[i]).length() == max){
                winner.add(carNames[i]);
            }
        }

        return winner;
    }

    /**
     * 우승자의 목록을 받아 알맞은 출력 형태로 변환하는 메서드
     *
     * @param winner : determineRaceWinner() 메서드의 반환 값
     */
    public static void printFinalWinners(List<String> winner){
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winner.size(); i++) {
            System.out.print(winner.get(i));
            if (i != winner.size() - 1){
                System.out.print(", ");
            }
        }
    }
}
