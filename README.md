# 자동차 경주

## 기능 요구 사항
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 각 자동차에 이름을 부여할 수 있다.
  * 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
  * 이름은 쉼표(,)를 기준으로 구분하며 5자 이하만 가능하다.
* 전진하는 조건은 0~9 사이의 무작위 값을 구하고 값이 4 이상일 경우이다.
* 경주 게임 완료 후 우승자 알려줌.
  * 우승자는 한 명 이상일 수 있다.
  * 여러 명일 경우 쉼표(,)로 구분
* 잘못된 값을 입력할 경우 IllegalArgumentException 을 발생시킨 후 종


## 프로그래밍 요구 사항 2
* 프로그래밍 요구 사항 1 포함
* indent depth <= 2
* 3항 연산자 금지
* 메서드가 한 가지 일만 하도록 만들기
* JUnit 5, AssertJ 를 이용하여 테스트 코드 만들기.


## 라이브러리
* Randoms, Console API 를 사용하기
  * Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
    * 0에서 9까지의 정수 중 한 개의 정수 반환
      Randoms.pickNumberInRange(0, 9);
  * 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

## 기능 구현 목표
* 자동차 이름 입력 받기(',' 로 구분)
* 0 ~ 9 사이의 랜덤값 생성기
* 랜덤값 결과 4 이상일 경우 전진하는 기능
* 각 자동차의 현재 위치를 '-'로 표시
* 우승자 선정
* 테스트 코드 작성
* 예외 상황(발생 시 -> 프로그램 종료)
    * 자동차 이름 입력 없을 때
    * 자동차 이름 5자 초과 입력 시
    * ',' 입력 후 엔터(ex: pobi,woo,shin,)
    * ','가 연속 입력 되었을 때(pobi,,shin)
    * 시도할 횟수가 0 이하인 경우




## 프로젝트 구성 계획

### Main(domain)
* Car
* RandomGenerator
* FindWinningCar
### View
* InputView
* OutputView
### Controller
* CarRacingController




