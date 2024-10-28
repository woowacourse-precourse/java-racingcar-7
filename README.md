# java-racingcar-precourse

## 구현 목표
이 프로그램은 여러 대의 자동차가 주어진 횟수 동안 경주하는 자동차 경주 게임입니다. 각 자동차는 정해진 조건에 따라 전진할 수 있으며, 경주가 끝난 후 최종 우승자를 출력합니다.

## 프로젝트 구조
- src/main/java
  └── com.example.racing
      ├── Application.java            // 프로그램 실행의 시작점
      ├── controller
      │   └── RacingController.java   // 게임 실행 및 사용자 입력 관리
      ├── model
      │   ├── Car.java                // 자동차 클래스
      │   ├── Race.java               // 게임 경주 관련 로직 클래스
      │   └── RaceResult.java         // 경주 결과와 우승자 관리
      └── service
          └── RacingService.java      // 게임의 비즈니스 로직 처리a

## 입출력 요구 사항
입력: 경주할 자동차 이름과 이동 횟수
출력: 각 턴의 경주 결과와 최종 우승자

## 실행 예시
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

## 구현할 기능 목록
1. 자동차 이름 입력 및 유효성 검사 기능
쉼표(,)로 구분된 자동차 이름 목록을 입력받습니다.
각 자동차 이름은 최대 5자 이하로 제한됩니다.
잘못된 형식의 이름이 입력되면 IllegalArgumentException을 발생시킵니다.
2. 이동 횟수 입력 및 유효성 검사 기능
시도할 이동 횟수를 정수로 입력받습니다.
잘못된 값이 입력될 경우 IllegalArgumentException을 발생시킵니다.
3. 자동차 전진 기능
각 턴마다 각 자동차의 이동 여부를 결정합니다.
0에서 9 사이의 랜덤 숫자가 4 이상일 때 자동차가 전진합니다.
camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange() 메서드를 사용합니다.
4. 경주 실행 및 결과 출력 기능
각 턴의 경주 결과를 출력합니다. 예를 들어 pobi : -- 형태로 자동차의 이름과 이동 거리 표시.
경주가 끝난 후 최종 우승자를 구하여 출력합니다.
5. 최종 우승자 결정 기능
가장 멀리 이동한 자동차(들)를 우승자로 결정합니다.
우승자가 여러 명일 경우 쉼표(,)로 구분하여 표시합니다.
6. 예외 처리 기능
잘못된 입력값이 들어올 경우 IllegalArgumentException을 발생시키고 애플리케이션을 종료합니다.

## 예외 처리
잘못된 이름이 포함된 경우
예: 이름 길이가 5자를 초과한 경우
숫자가 아닌 이동 횟수가 입력된 경우
예: "abc", "-1"

## 테스트 케이스
