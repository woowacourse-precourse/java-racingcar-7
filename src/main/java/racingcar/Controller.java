package racingcar;

public class Controller {
  String carNames;
  int countsValue;

  // [x] 자동차 이름, 시도 횟수 주입
  public Controller(String carNames, int countsValue) {
    this.carNames = carNames;
    this.countsValue = countsValue;
  }



  // [] 시도 횟수만큼 각 자동차 전진
  private void moveForwardCars(int playCounts) {

  }
  // [] 0~9 랜덤값을 생성하여 결과가 4이상인 경우 전진을 결정한다
  private void moveOrNot(int playCounts) {}
  // [] 실행 결과를 내림차순으로 정렬
  private void setMoveCountsTest() {}
  // [] 실행 결과 저장
  // [] 최종 우승자 저장
  // [] 저장 내용 전달
  // [] 최종 우승자 전달

}
