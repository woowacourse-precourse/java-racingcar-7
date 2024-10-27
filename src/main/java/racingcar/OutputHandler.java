package racingcar;

import java.util.List;

public class OutputHandler {

    public static void outputStartInfo(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void outputAskTryValue(){
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void outputRacingRecult(String result){
        System.out.println(result);
    }

    public static void ouputRacingWinner(List<String> winnerList){
        StringBuilder winner = new StringBuilder();
        int lastIndex = winnerList.size() - 1;
        winner.append("최종 우승자 : ");

        for(int i = 0; i < winnerList.size(); i++){
            winner.append(winnerList.get(i));
            if(lastIndex != i){
                winner.append(", ");
            }
        }

        System.out.println(winner);
    }

}
