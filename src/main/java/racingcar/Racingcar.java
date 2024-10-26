package racingcar;
import camp.nextstep.edu.missionutils.*;


public class Racingcar {
    private String[] carNames;
    private int count;

    public void start(){
        input();
    }

    public void input(){
        System.out.println("경주할 자동차의 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String rawCarName = Console.readLine();
        carNames = rawCarName.split(",");

        System.out.println("시도할 횟수는 몇 회인가요?");
        String count = Console.readLine();
        this.count = Integer.parseInt(count);


    }



}
