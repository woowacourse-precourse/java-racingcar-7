package racingcar;

import racingcar.Input.Read;
import racingcar.Input.Split;
import racingcar.Input.Validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Application {

    // 매번 값을 수정해야 하기 때문에 조회, 수정이 많아서 Map 자료형 선택
    // 다른 클래스에서 접근해야 하기 때문에 public static으로 선언
    public static String [][] carMap;
    public static int len = 0;

    // 우승자를 담을 리스트 선언, 초기화하기
    public static ArrayList<String> resultArr = new ArrayList<>();

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 자동차 이름 입력 요청 문자열 출력
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        // 입력 받기
        String cars = Read.read();

        // 빈 문자열일 경우 예외 발생 시키기
        Validation.isNull(cars);

        // 입력 받은 문자열 쉼표 기준으로 나누기
        String [] carArray = Split.splitByComma(cars);

        // 각 자동차 이름이 유효한지 확인
        for (String car : carArray) {
            // 총 자동차의 개수 세기
            len++;

            // 자동차의 이름 값이 비었는지 확인
            Validation.isNull(car);

            // 자동차의 이름 길이가 5가 넘는지 확인
            Validation.lengthOver5(car);
        }

        // 시도 횟수 입력 요청 문자열 출력
        System.out.println("시도할 횟수는 몇 회인가요?");

        // 입력 받기
        int movenumber = Integer.parseInt(Read.read());
        if (movenumber < 0) {
            throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
        }

        // 결과값을 저장할 2차원 배열 선언하기
        carMap = new String[len][2];

        // 배열의 첫 번째 열에 자동차의 이름, 두 번째 열에 빈 문자열을 저장
        for (int i=0;i<len;i++) {
            carMap[i][0] = carArray[i];
            carMap[i][1] = "";
        }

        // 시도 횟수만큼 이동하기
        for (int i=0;i<movenumber;i++) {
            Race.move();
            Print.output();
            System.out.println();
        }

        // 결과 출력 전 문자열
        System.out.print("최종 우승자 : ");

        // 문자열의 최대 길이 찾기
        Result.findMax();

        // 최종 우승자 찾기
        Result.judge();

        // 우승자 출력하기
        Print.printWinner();

        // 공동 우승자 출력하기
        Print.together();
    }
}
