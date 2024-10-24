🚗 자동차 경주
---
+ 주어진 횟수 동안 랜덤으로 전진하는 n대의 자동차에 대해 우승자를 구한다.

🔎 요구 사항
---  
초간단 자동차 경주 게임을 구현한다.
+ 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
+ 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
+ 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
+ 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
+ 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
+ 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
+ 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
+ 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

▶ 프로그램 실행 예시
---
### ⌨ 입력
+ 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
+ 시도할 횟수
### 🖨 출력 
+ 차수별 실행 결과
+ 단독 우승자 안내 문구
+ 공동 우승자 안내 문구

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

🛠 구현 기능 목록
---
### ⌨ 자동차 이름 입력
+ [ ] 경주할 자동차 이름을 입력받는다.
+ [ ] 이름은 쉼표(,)를 기준으로 구분한다.
+ [ ] 이름 앞뒤에 공백이 들어있을 경우 제거한다.
### ✅ 자동차 이름 입력 검증
+ [ ] 자동차 이름이 5자 이하인지 검증한다.
+ [ ] 자동차 이름의 중복 여부 검증한다.
+ [ ] 자동차 이름이 공백인지 검증한다.

### ⌨ 이동 횟수 입력
+ [ ] 이동 횟수를 입력받는다.
### ✅ 이동 횟수 입력 검증
+ [ ] 1 이상의 정수인지 검증한다.
+ [ ] `int` 범위 내의 값이 들어오는지 검증한다.

### 🖨 출력  
+ [ ] 경주할 자동차 입력을 요구하는 메시지를 출력한다.
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
```
+ [ ] 이동 횟수 입력을 요구하는 메시지를 출력한다.
```
시도할 회수는 몇회인가요?
```
+ [ ] 각 차수별 실행 결과를 출력한다.
```
pobi : --
woni : ---
jun : ---
```
+ [ ] 우승자 안내 문구를 출력한다. 우승자는 여러 명이 될 수 있으며, 이때 쉼표(,)를 이용하여 구분한다.
```
최종 우승자 : pobi, jun
```

### 📝 비즈니스 로직
#### 랜덤 값 추출 로직
+ [ ] 0에서 9까지의 정수 중 한 개의 정수를 반환한다.
#### 자동차 전진 로직
+ [ ] 무작위 값이 4 이상일 경우 자동차가 한칸 전진한다.
#### 우승자 추출 로직
+ [ ] 제일 많이 전진한 n명의 우승자를 가려낸다.
