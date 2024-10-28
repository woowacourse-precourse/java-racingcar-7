# java-racingcar-precourse
## 🚘 프로그램 소개
초간단 자동차 경주 게임
### 입력
- 경주할 자동차 이름 (이름은 쉼표(,) 기준으로 구분)
- 시도할 횟수
### 출력
- 차수별 실행 결과
- 우승자 안내 문구
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

## 🛠️ 구현 기능 목록
### 입력
- ```camp.nextstep.edu.missionutils.Console```의 ```readLine()```으로 입력을 받는다.
  - 경주할 자동차 이름 (쉼표(,)로 구분)
  - 시도할 횟수
- 잘못된 입력을 받을 시 ```IllegalArgumentException```를 발생시킨다.
  - 애플리케이션이 종료된다.
### 기능
- 사용자가 입력한 이름의 자동차를 생성한다.
- 사용자가 입력한 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 전진하는 조건은 0에서 9 사이의 무작위 값이 4 이상일 경우이다.
  - Random 값 추출은 ```camp.nextstep.edu.missionutils.Randoms```의 ```pickNumberInRange()```를 활용한다.
### 출력
- 자동차가 이동할 때마다 결과를 출력한다.
- 주어진 횟수가 끝난 후 우승자를 출력한다.
  - 우승자가 여러 명일 경우 쉼표(,)로 구분하여 출력한다.
