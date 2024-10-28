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
                // 진행 과정 출력
                System.out.print(carName[j] + ": ");
                for(int k=0; k<move[j]; k++){
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }

        // 최고거리 체크
        int max = 0;

        for(int i=0; i<move.length; i++){
            if(move[i] > max){
                max = move[i];
            }
        }

        // 1등 체크하기
        String[] victoryCarName = new String[carName.length];

        for(int i=0, j=0; i<victoryCarName.length; i++){
            if(move[i] == max){
                victoryCarName[j] = carName[i];
                j++;
            }
        }

        // 최종 우승자 출력
        String victoryCar = "";
        for(int i=0; i<victoryCarName.length; i++){
            if(victoryCarName[i] == null){
                break;
            }

            victoryCar += victoryCarName[i] + ", ";
        }

        System.out.println("최종우승자 : " + victoryCar);
    }


}
