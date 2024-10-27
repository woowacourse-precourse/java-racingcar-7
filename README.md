# 자동차 경주

<br>

# 목표
- 일단 굴러가는 코드를 만들고 리팩토링하기(처음부터 완벽하게 짜려 하지 말기)
- 우테코 1주차 피드백 반영하기(메소드 이름, 공백 라인 활용, 주석, java api 활용, array 대신 collection 활용)
- 우테코 가이드라인 잘 살펴보기 (프로그래밍 요구사항, git convention 등)

<br>

## 기능 목록
**초간단 자동차 경주 게임을 구현한다.**

### 입력 기능
- 경주할 자동차 이름과 시도할 횟수를 입력 받는다.

### 경주 기능
1. 전진 기능
    - 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.

2. 우승자 선정 기능
    - 입력 받은 시도 횟수에 도달해서 레이스가 중지되면 우승자를 선정한다.

### 출력 기능
- 차수별 실행 결과와 마지막에 우승자 안내 문구를 출력한다.

### 예외 처리
- 예외가 발생한 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되도록 예외 처리를 한다.
    - 잘못된 형식을 입력 받은 경우, 시도 횟수에 문자를 입력 받은 경우, 공백을 입력 받은 경우
    - 이름에 특수문자가 포함된 경우(하이픈(-)은 제외한다.) 이름이 5자 이하인 경우

<br>

## 입출력 요구 사항

**입력**
- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
- 시도할 횟수

**출력**
- 차수별 실행 결과
- 단독 우승자 안내 문구(or 공동 우승자 안내 문구)

**실행 결과 예시**
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