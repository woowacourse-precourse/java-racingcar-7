package racingcar;
import java.util.Scanner;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        Scanner testInput = new Scanner(System.in); // 스캐너 기능 추가

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"); // 질문 출력
        String carName = (testInput.nextLine()).replaceAll("\\s+", ""); // 콘솔 입력 및 띄어쓰기 제거
        if (!carName.contains(",")) {   // 쉼표(,)로 구분 안할시 오류 메세지후 종료
            throw new IllegalArgumentException();
        }
        String[] listOfCar = carName.split(","); // "," 기준 나누기

        for (int i = 0; i < listOfCar.length; i++) { // 배열 다시하기, 이름이 5글자 넘어가는지 확인
            if (i == listOfCar.length - 1 && listOfCar[i].length() <= 5) { // 마지막 글자는 ","안붙임
                System.out.println(listOfCar[i]);
            } else if  (i != listOfCar.length - 1 && listOfCar[i].length() <= 5)  {
                System.out.print(listOfCar[i] + ",");
            } else {
                throw new IllegalArgumentException();
            }
        }
        for (int j = 0; j < listOfCar.length; j++) {    // 출력을 위해 " : " 추가
            listOfCar[j] += " : ";
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        String strRound = testInput.nextLine(); // 콘솔 입력란 추가 및 이동회수 입력
        int round = Integer.parseInt(strRound); // 문자열 정수로 변경
        if (round <= 0) { // 양수가 아닐때 오류 출력 후 종료
            throw new IllegalArgumentException();
        }

        System.out.println();
        System.out.println("실행 결과");
        for (int f = 0; f < round; f++) {
            moveCars(listOfCar);
        }

        // "-" 개수 카운트한 배열 만들기
        int[] eachDashCounts = new int[listOfCar.length];
        for (int k = 0; k < listOfCar.length; k++) {
            eachDashCounts[k] = countDashes(listOfCar[k]); // 각 자동차의 "-" 개수를 카운트
        }

        // 제일 많은 카운트 수 확인
        int max = 0;
        for (int count : eachDashCounts) {  // 배열별로 카운트를 반복하여 확인
            if (count > max) {
                max = count; // 제일 높은 카운트 기록
            }
        }

        // 제일 많은 카운트 수 = 인덱스 일치
        StringBuilder winnerCar = new StringBuilder();
        int winnerCarCount = 0;
        for (int l = 0; l < listOfCar.length; l++) {
            if (eachDashCounts[l] == max && winnerCarCount == 0) {
                winnerCar.append(onlyCarName(listOfCar[l]));
                winnerCarCount++;
            }
            else if (eachDashCounts[l] == max && winnerCarCount > 0) {
                winnerCar.append(", ").append(onlyCarName(listOfCar[l]));
            }

        }

        System.out.println("최종 우승자 : " + winnerCar);
    }


    // 랜덤숫자로 전진하는 메소드
    private static void moveCars (String[]listOfCar) {
        for (int m = 0; m < listOfCar.length; m++) {
            int randomTry = Randoms.pickNumberInRange(0, 9);
            if (randomTry >= 4) {
                System.out.println(listOfCar[m] += "-");
            }
            else {
                System.out.println(listOfCar[m]);
            }
        }
        System.out.println();
    }

    // "-"를 찾을 수 있는 메소드
    private static int countDashes(String index) {
        int count = 0; // "-" 개수 초기화
        for (char dash : index.toCharArray()) { // 문자열을 문자로 분해해서 배열
            if (dash == '-') {
                count++; // "-" 발견 시 카운트 증가
            }
        }
        return count; // 카운트 반환
    }

    // 마지막 배열 인덱스에서 "-"를 제외한 자동차 이름 메소드
    private static String onlyCarName(String listOfCar) {
        return listOfCar.substring(0,listOfCar.indexOf(" : "));
    }
}