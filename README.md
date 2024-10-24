# java-racingcar-precourse

## 자동차 경주

## 구현 기능 목록

- [x] 자동차 이름 입력 요구 문구를 출력한다.
- [x] 이름 문자열을 입력 받는다.
- [x] 횟수 입력 요구 문구를 출력한다.
- [x] 횟수를 입력 받는다.
- [x] 이름 문자열을 통해, 이름과 전진 횟수를 가지는 n대의 자동차를 만든다.
- [x] 실행 결과 안내 문구를 출력한다.
- [x] 주어진 횟수 동안 반복하여, n대의 자동차를 전진하거나 멈춘다.
    - 전진 조건 : 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우
- [x] 차수별 실행 결과를 출력한다.
- [x] 전진 횟수가 가장 많은 우승자를 구한다.
    - 우승자는 한 명 이상 가능
- [ ] 우승자 안내 문구를 출력한다.
    - 우승자가 여러 명일 경우 쉼표(,) 이용하여 구분

### Exception

- 사용자가 잘못된 값을 입력할 경우, `IllegalArgumentException` 발생
    - [ ] 자동차 이름 입력(쉼표(,) 기준으로 구분)
        1. 입력이 없는 경우
        2. 쉼표(,)가 포함되지 않은 경우
        3. 자동차 이름이 없거나, 5자를 초과하는 경우
        4. 이름에 알파벳이나 한글 이외의 문자(숫자나 특수문자)가 포함된 경우
    - [ ] 횟수 입력
        1. 입력이 없는 경우
        2. 숫자가 아닌 경우
        3. 양수가 아닌 경우

### 입출력 예시

### 입력

- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
    ```
    pobi,woni,jun
    ```

- 시도할 횟수
    ```
    5
    ```

### 출력

- 자동차 이름 입력 요구 문구
    ```
    경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
    ```

- 횟수 입력 요구 문구
    ```
    시도할 횟수는 몇 회인가요?
    ```

- 실행 결과 안내 문구
    ```
    실행 결과
    ```  

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

### 실행 결과

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

