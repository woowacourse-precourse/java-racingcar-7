package racingcar;

public class Frontend {

  private Input input;
  private Controller controller;
  public Frontend(Controller controller) {
    this.controller = controller;
  }


  // 출력 문구 생성
  private void generatePrintMessage() {
    String result = "실행 결과";
    String carNames = input.getInputCarNames();
  }

  // 자동차 경주 실행 결과 출력
  public void printResult() {
    System.out.println(controller.reverseOrderResult());
  }
  // 최종 우승자 출력
  public void printWinner() {
    System.out.println(controller.getWinner());
  }

}
