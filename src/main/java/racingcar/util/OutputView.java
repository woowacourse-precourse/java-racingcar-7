package racingcar.util;

public class OutputView {
    StringBuilder carMove = new StringBuilder();

    public void storeCarMove(String move) {
        carMove.append(move).append('\n');
    }

    public void printCarMove() {
        System.out.print(carMove.toString());
    }

    public void printWinner(String winner) {
        System.out.println("최종 우승자 : " + winner);
    }
}
