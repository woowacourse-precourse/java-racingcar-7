package racingcar;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
        Racingcar r = new Racingcar();

        r.start();

        System.out.println("실행 결과");
        r.totalRace();
        r.winnersPrint();
//        try {
//            Racingcar r = new Racingcar();
//
//            r.start();
//
//            System.out.println("실행 결과");
//            r.totalRace();
//            r.winnersPrint();
//        } catch (Exception e) {
//            e.printStackTrace(); // 예외 스택 트레이스를 출력
//        }

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

    static final int MOVE_THRESHOLD = 4;
    static final int NAME_LENGTH_LIMIT = 5;


    void start() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String cars = readLine();
            setCarMove(cars);

            System.out.println("시도할 횟수는 몇 회인가요?");
            String attempts = readLine();
            setMoveCnt(attempts);

            System.out.println();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("입력된 값이 없습니다.");
        }
    }


    void setCarMove(final String text) {
        for(final String carName : text.split(",")) {
            if (carName.length() > NAME_LENGTH_LIMIT){
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            if (carName == null || carName.isEmpty()) {
                continue;
            }
            carMove.put(carName, 0);
        }

        if (carMove.isEmpty()) {
            throw new IllegalArgumentException("입력된 자동차가 없습니다.");
        }
    }

    void setMoveCnt(String text) {
        text = text.trim();
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("이동 횟수는 비어 있거나 공백일 수 없습니다.");
        }
        try {
            moveCnt = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("이동 횟수에 정수를 입력해야합니다.");
        }
    }

    void race() {
        for(Map.Entry<String, Integer> curCar : carMove.entrySet()) {
            int move = pickNumberInRange(0, 9);
            if (move >= MOVE_THRESHOLD) {
                curCar.setValue(curCar.getValue() + 1);
            }
        }
        raceResultPrint();
    }


    void totalRace() {
        for (int i = 0; i < moveCnt; i++) {
            race();
        }
    }

    void raceResultPrint() {
        for(Map.Entry<String, Integer> curCar : carMove.entrySet()) {
            String carName = curCar.getKey();
            int move = curCar.getValue();
            System.out.println(carName + " : " + "-".repeat(move));
        }
        System.out.println();
    }

    ArrayList<String> getWinners() {
        ArrayList<String> winners = new ArrayList<>();

        List<String> keySet = new ArrayList<>(carMove.keySet());
        keySet.sort((o1, o2) -> {
            int valueCompare = carMove.get(o2).compareTo(carMove.get(o1));
            if (valueCompare == 0) { // 값이 같은 경우 키 오름차순 정렬
                return o1.compareTo(o2);
            }
            return valueCompare;
        });

        int maxMove = 0;

        for (String key : keySet) {
            if(winners.size() == 0) {
                maxMove = carMove.get(key);
            }

            if (carMove.get(key) == maxMove) {
                winners.add(key);
            } else {
                break;
            }
        }

        return winners;
    }

    void winnersPrint() {
        ArrayList<String> winners = getWinners();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

}