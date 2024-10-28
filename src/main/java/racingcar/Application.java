package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String carNameText;
        int tryNum;

        // 입력받기
        System.out.println("경주할 자동차 이름을 입력하세요.");
        carNameText = Console.readLine();
        System.out.println("횟수를 입력하세요.");
        tryNum = Integer.parseInt(Console.readLine());

        // 배열에 저장
        String[] carName = carNameText.split(",");
        int[] move = new int[carName.length];

        // 난수 생성후 조건에 따라 전진하기
        for(int i=0; i<tryNum; i++){
            for(int j=0; j<carName.length; j++){
                if(Randoms.pickNumberInRange(0, 9) > 4){
                    move[j]++;
                }
            }
        }

        // 최고거리 체크
        int max = 0;

        for(int i=0; i<move.length; i++){
            if(move[j] > max){
                max = move[j];
            }
        }
        


    }


}
