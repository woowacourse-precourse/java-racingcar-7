## 기능 요구 사항
-- -
초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.


## 입출력 요구 사항
입력
- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
```
pobi,woni,jun
```
출력
- 차수별 실행 결과
```
pobi : --
woni : ----
jun : ---
```
- 단독 우승자 안내 문구
```
최종 우승자 : pobi
```
- 공동 우승자 안내 문구
```
최종 우승자 : pobi, jun
```
### 실행 결과 예시
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 횟수는 몇 회인가요?
5

실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun
```

## 프로그래밍 요구 사항
- indent depth가 3이 넘지 않도록 구현하기 (2까지 허용)
- 3항 연산자 사용하지 않기
- 함수가 하나의 일만 하도록 작게 만들기
- JUnit 5와 AssertJ로 정리한 기능 목록이 정상 동작했는지 테스트코드 작성하기
- Random값 추출 - `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()` 활용하기
- 사용자 입력값 - `camp.nextstep.edu.missionutils.Console`의 `readLine()` 활용하기 

## 구현할 기능 목록
### 입력
- [x] 사용자는 경주 할 자동차 이름을 입력받는 기능
- [x] 사용자는 몇 번의 이동을 할 것인지를 입력받는 기능

### 레이싱 게임
- [x] 자동차는 이름으로 n대 자동차 객체 생성
- [x] 전진하는 조건에 맞춰서 전진 또는 멈춤 기능
- [ ] 입력받은 횟수만큼 게임 실행 기능
- [ ] 게임 진행 후 우승자 출력 기능


### 예외처리
- [ ] 자동차 이름 5글자 이상인 경우
- [ ] 자동차 이름을 쉼표로 구분하지 않은 경우
- [ ] 몇 번을 이동할 건지 입력할 때 숫자가 아닌 경우



