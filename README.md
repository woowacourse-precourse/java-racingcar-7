# 과제2 - 자동차 경주
## 구현 기능 목록
<hr>

### 입력 
**기능** : 입력받은 문자열 쉼표(,) 기준으로 분리하여 자동차 객체 생성
<br>
1. 경주할 자동차 이름 입력
    - 쉼표(,) 기준으로 구분
    - 이름은 1~5자 조건 판단
      - 이름이 0 또는 5자 초과할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료
2. 자동차 객체 생성하여 자동차 객체 리스트에 저장
3. 시도할 횟수 입력 (= 게임 진행 횟수 )
    - 숫자가 아닐 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료
<hr>

### 자동차 경주 게임
**기능** : 한 게임 당 참가한 자동차마다 무작위 값 부여하여 전진 또는 멈춤
1. 사용자가 입력한 시도할 횟수만큼 게임 진행
2. 자동차마다 0~9까지 무작위 값 부여
   - camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()활용
   - 값이 4이상일 경우에만 전진
     - 전진인 경우 참가자 거리 업데이트

<hr>

### 출력
**기능** : 각 게임 후 결과 출력과 경주 종료 후 우승자 출력
- 각 게임 후 모든 자동차가 전진한 횟수 출력
- 우승자 출력
    - 여러 명일 경우 쉼표(,)로 구분
<hr>

`Application.class` : 어플리케이션 시작 클래스
<br>

`Racingcar.class` :  자동차 경주 시작 클래스
 - splitInputValue() : 입력받은 문자열 쉼표(,) 기준으로 분리 메소드
 - start() : 자동차 경주 게임 실행 메소드
 - startGames() : 게임 횟수에 맞게 게임 객체 생성 및 실행
 - printGameResult() : 게임 후 전진한 횟수 출력 메소드
 - findWinner() : 우승자 찾기 메소드
<br>
   
`Car.class` : 자동차 클래스
 - updateDistance() : 전진 시 거리 +1 메소드
<br>

`Game.class` : 한 게임 작동 기능 클래스
 - updateCarMove() : 무작위 값에 따라 전진 또는 멈춤 실행 메소드
 - start() : 각 자동차별 게임 진행 메소드
<br>

`RandomNumber.class` : 무작위 값 클래스
 - make() : 무작위 값 생성 메소드
 - isNotLessThanFour() : 4이상인지 아닌지 판단 메소드
 - start() : 무작위 값 기능 시작 메소드
<br>

`ErrorValidator.class` : 조건 확인 및 에러 처리 클래스
 - carName() : 자동차 이름이 1~5자인지 판단 메소드 -> 조건에 부합하지 않을 경우 에러 발생
 - gameCount() : 게임 횟수를 정수로 형 병환 검증 메소드
   <br>

`Contants.class` : 상수들을 모아서 관리하는 클래스