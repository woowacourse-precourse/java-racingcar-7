package racingcar.view;

public class OutputView {
    public static void gameStart(){
        System.out.println("실행 결과");
    }

    public static void roundResult(String result){
        System.out.println(result);
    }

    public static void gameResult(String winner){
        System.out.println("최종 우승자 : " + winner);
    }

}
