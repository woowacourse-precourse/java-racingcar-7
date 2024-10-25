package racingcar.view;

import java.util.List;

public class UserResponseView {
    public static final void INPUT_CARS_NAME_MESSAGE(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    public static final void INPUT_NUMBER_MESSAGE(){
        System.out.println("시도할 횟수는 몇 회인가요?");
    }
    public static void racingOutput(List<String> carName, List<Integer> start){
        String distance = "";
        for(int i=0; i<carName.size(); i++){
            distance = "-".repeat(start.get(i));
            System.out.printf("%s : %s\n", carName.get(i), distance);
        }
    }
    public static void finalWinner(String winner){
        System.out.printf("최종 우승자 : %s", winner);
    }
    public static void finalWinner(List<String> winners){
        System.out.print("최종 우승자 : ");
        for(String winner : winners){
            if(winners.indexOf(winner) == winners.size()-1){
                System.out.printf("%s", winner);
            }else{
                System.out.printf("%s, ", winner);
            }
        }
    }
    public static final void inputTypeError(){
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }
}
