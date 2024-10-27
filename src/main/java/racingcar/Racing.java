package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Racing {

    String[] cars; // car들의 이름 저장
    int[] loc; // 레이싱 카들의 현재 위치

    // 레이싱 카들의 이름 받아 지정, 시작 레이스 초기화
    public Racing(String racingName) {

        cars = racingName.split(","); // car들의 이름을 저장
        loc = new int[cars.length]; // 차의 개수대로 시작점 생성
    }

    // 레이싱 start!
    public void run(String try_num) {

        for(int i=0; i< Integer.parseInt(try_num); i++) {
            for (int j=0; j< cars.length; j++) {
                goStop(j); // 수행
            }
            nowProgress(); // 현재 상황 출력
        }
    }

    // 현재 레이싱 카 전진 or 멈춤 행동시키는 함수
    public void goStop(int i) {

        int rand = Random(); // 랜덤으로 숫자 하나 생성

        if(rand >= 4) { // 4 이상일 때
            loc[i] += 1; // 전진
        }
    }

    public void nowProgress() {
        for (int j=0; j< cars.length; j++) {
            System.out.printf("%s : %s\n", cars[j], "-".repeat(loc[j]));
        }
        System.out.println();
    }

    // 랜덤 함수 하나 반환
    private int Random() {
        return Randoms.pickNumberInRange(0, 9);
    }

    // 최고 전진 횟수 구하기
    private int findMaxProgress() {
        int max=0;

        // 최고 간 횟수 찾기
        for (int i=0; i< cars.length; i++) {
            if(loc[i] > max) {
                max = loc[i];
            }
        }

        return max;
    }

    // 우승자 얻기
    public void win() {

        // 최고 전진 횟수 찾기
        int max = findMaxProgress();

        // 우승자 찾기
        StringBuilder whoWin = new StringBuilder();

        for (int i=0; i< cars.length; i++) {
            if(loc[i] == max) {
                whoWin.append(cars[i]).append(", ");
            }
        }

        // 마지막에 추가된 ", " 제거
        if (!whoWin.isEmpty()) {
            whoWin.setLength(whoWin.length() - 2); // ", "의 길이인 2를 빼줌
        }

        String winner = whoWin.toString(); // 최종 문자열로 변환
        System.out.println("최종 우승자 : "+ winner);
    }

}
