package racingcar.handler;

public class OutputHandler {

    public static void executeResultOutput(){
        System.out.println("실행 결과");
    }

    public void gameResult(String result){
        System.out.println("최종 우승자 : " + result);
    }
}
