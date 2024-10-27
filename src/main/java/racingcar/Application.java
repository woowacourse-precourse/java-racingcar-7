package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String input = Console.readLine();

    String[] racingCarArray = input.split(",");

    List<String> racingCarList = new ArrayList<>();

    try {
        for (String racingCar : racingCarArray) {
            racingCar = racingCar.trim();
            if (racingCar.length()>5){
                throw new IllegalArgumentException("이름은 5글자를 넘을 수 없습니다.");
            }
            racingCarList.add(racingCar);
        }

        int attempts = inputNum();  // 시도할 횟수 입력
        System.out.println();
        racingGameStart(racingCarList, attempts);  // 레이싱 게임 시작

    } catch (IllegalArgumentException e){
        System.out.println(e.getMessage());
        throw e;
        }
    }

    //시도 횟수 입력
    private static int inputNum() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String num = Console.readLine();
        return Integer.parseInt(num);
    }

    //난수 생성 후 전진 여부 결정
    private static boolean moveOrNah(){
        int randNum = Randoms.pickNumberInRange(0,9);
        //System.out.println("코인 값:" + randNum);
        return randNum >= 4;
    }

    // 레이싱 게임 시작
    private static void racingGameStart(List<String> racingCarList, int num) {
        List<StringBuilder> positions = new ArrayList<>();
        for (int i = 0; i < racingCarList.size(); i++) {
            positions.add(new StringBuilder());  // 각 자동차의 전진 상태를 저장할 StringBuilder 리스트 생성
        }

        System.out.println("실행 결과");
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < racingCarList.size(); j++) {
                if (moveOrNah()) {
                    positions.get(j).append("-");  // 전진할 경우 '-' 추가
                }
                System.out.println(racingCarList.get(j) + " : " + positions.get(j));
            }
            System.out.println();
        }
        printWinner(racingCarList, positions);
    }

    // 최종 우승자 출력하기
    private static void printWinner(List<String> racingCarList, List<StringBuilder> positions) {
        int maxPosition = 0;
        for (StringBuilder position : positions) {
            if (position.length() > maxPosition) {
                maxPosition = position.length();
            }
        }

        List<String> winners = new ArrayList<>();
        for(int i = 0; i < racingCarList.size(); i++){
            if (positions.get(i).length() == maxPosition){
                winners.add(racingCarList.get(i));
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }


}