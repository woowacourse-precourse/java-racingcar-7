package racingcar;

public class Controller {
  String carNames;
  int countsValue;
  private String winner;
  private int moves;

  // [x] 자동차 이름, 시도 횟수 주입
  public Controller(String carNames, int countsValue) {
    this.carNames = carNames;
    this.countsValue = countsValue;
  }

  // [] 시도 횟수만큼 각 자동차 전진
  public void moveForwardCars(int playCounts) {

  }
  // [] 0~9 랜덤값을 생성하여 결과가 4이상인 경우 전진을 결정한다
  public boolean moveOrNot(int countsValue) {
    return countsValue >= 4;
  }

  // [] 실행 결과를 내림차순으로 정렬
  private void setMoveCountsTest(String carNames, int countsValue) {

  }


  public int getMoves() {
    return moves;
  }
  // [x] 실행 결과 저장
  public void setMoves(int moves) {
    this.moves = moves;
  }

  // [] 최종 우승자 저장
  private void admitWinner() {

  }

  // [] 저장 내용 전달
  public String reverseOrderResult() {
    return "null";
  }

  // [] 최종 우승자 전달
  public String getWinner() {
    return winner;
  }



}
