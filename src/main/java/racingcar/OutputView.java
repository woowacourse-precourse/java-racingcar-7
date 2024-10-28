package racingcar;

public class OutputView {
    public void printResult(String[] name) {
        System.out.println("최종 우승자 : ");
        for (String n : name)
        {
            System.out.println(n);
        }
    }
}
