package racingcar;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
        Racingcar r = new Racingcar();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        r.setCarMove(readLine());
        System.out.println("시도할 횟수는 몇 회인가요?");
        r.setMoveCnt(readLine());

        System.out.println("실행 결과");
        r.totalRace();
        System.out.println(r.getWinners());
    }
}

//n대의 자동차 입력받고 저장하기
//주어진 횟수(이동 횟수) 입력받고 저장하기
//자동차 전진 또는 멈춤(랜덤값)
//차수별 실행 결과 출력하기
//우승자 출력하기
//예외 처리
class Racingcar {
    HashMap<String, Integer> carMove = new HashMap<String, Integer>(); // (자동차 이름: 현재 위치)
    int moveCnt;

    void setCarMove(final String text) {
        for(final String carName : text.split(",")) {
            carMove.put(carName, 0);
        }
    }

    void setMoveCnt(final String text) {
        moveCnt = Integer.parseInt(text);
    }

    void race() {
        for(Map.Entry<String, Integer> curCar : carMove.entrySet()) {
            curCar.setValue(curCar.getValue() + pickNumberInRange(0, 9)); // 10까지 범위인지를 모르겠음.
        }
        raceResultPrint();
    }

    void totalRace() {
        for (int i = 0; i < moveCnt; i++) {
            race();
        }
    }

    void raceResultPrint() {
//        System.out.println("실행 결과");
        for(Map.Entry<String, Integer> curCar : carMove.entrySet()) {
            String carName = curCar.getKey();
            int move = curCar.getValue();
            System.out.println(carName + ":" + "-".repeat(move));
        }
        System.out.println();
    }

    ArrayList<String> getWinners() {
        ArrayList<String> winners = new ArrayList<>();
//        String[] winners = new String[] {};

        List<String> keySet = new ArrayList<>(carMove.keySet());
        keySet.sort((o1, o2) -> carMove.get(o2).compareTo(carMove.get(o1)));
//        keySet.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return carMove.get(o1).compareTo(carMove.get(o2));
//            }
//        });
//
//        for (String key : keySet) {
//            System.out.print("Key : " + key);
//            System.out.println(", Val : " + carMove.get(key));
//        }

        int maxMove = 0;

        for (String key : keySet) {
            if(winners.size() == 0) {
                winners.add(key);
                maxMove = carMove.get(key);
            } else {
                if (carMove.get(key) == maxMove) {
                    winners.add(key);
                } else {
                    break;
                }
            }

            System.out.print("Key : " + key);
            System.out.println(", Val : " + carMove.get(key));
        }

        return winners;
    }


    // sort 하고 뒤에꺼랑 앞에꺼랑 같으면 걔도 출력 while 문 써서 우승자 출력.
    // 우승자 출력시 오름차순으로 해야하나? 그러면 key 정렬 조건으로 오름차순 쓰면 됨.
    // value는 큰 값이 우선, 값이 같을 경우 key는 오름차순으로 정렬
    // 우승자 출력시 값이 같으면 계속 출력.

}