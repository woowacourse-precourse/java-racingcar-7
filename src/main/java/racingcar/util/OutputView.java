package racingcar.util;

public class OutputView {
    StringBuilder carMove = new StringBuilder();

    public void storeCarMove(String move) {
        carMove.append(move).append('\n');
    }

    public void printCarMove() {
        System.out.println(carMove.toString());
    }


}
