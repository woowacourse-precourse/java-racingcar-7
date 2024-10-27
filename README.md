# java-racingcar-precourse

# 2주차 racingcar

# 구현 기능 목록
* view
  * InputView : 입력에 대한 역할을 수행하는 클래스
  * OutputView : 출력에 대한 역할을 수행하는 클래스
* util
  * RandomNumber : 랜덤값을 생성하는 클래스
  * SplitName : 이름을 , 를 기준으로 분리하는 클래스
* domain
  * Car : 차에 이름과 이동에 대한 기능을 가지는 클래스
  * CarName : 자동차들의 이름에 대한 검증을 진행하는 클래스
  * Cars : 자동차들을 리스트로 관리하는 클래스
  * Racing : 레이싱 게임(이동)에 대한 클래스
  * TryCount : 시도 횟수에 대한 클래스. 자연수가 아닌 값이 들어오면 예외처리를 해준다.
* controller
  * RacingController : Model 과 View 를 조정하는 컨트롤러 클래스