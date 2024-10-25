# java-racingcar-precourse

# 자동차 경주

## 🎯 기능 요구 사항

- 초간단 자동차 경주 게임을 구현

- 주어진 횟수 동안 n대의 자동차는 전진 또는 정지
- 각 자동차에 이름 부여
  - 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
  - 자동차 이름
    - 쉼표(,)를 기준으로 구분
    - 5자 이하만 가능
- 사용자는 몇 번의 이동을 할 것인지를 입력
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 
- 우승자는 한 명 이상일 수 있음
  - 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우
    - 구분자를 기준으로 분리한 각 숫자의 합을 반환
    - 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6

- 잘못된 값을 입력할 경우
    - `IllegalArgumentException`을 발생시킨 후 애플리케이션 종료

## ✏️ 입출력 요구사항

### 입력

- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)

        pobi,woni,jun

- 시도할 횟수

        5

### 출력

- 차수별 실행 결과

      pobi : --
      woni : ----
      jun : ---

- 단독 우승자 안내 문구

      최종 우승자 : pobi

- 공동 우승자 안내 문구

      최종 우승자 : pobi, jun

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

## 🚩 프로그래밍 요구 사항

- JDK 21 버전에서 실행
- 프로그램 실행의 시작점은 Application의 main()
- build.gradle 파일은 변경 불가
- 제공된 라이브러리 이외의 외부 라이브러리는 사용 금지
- 프로그램 종료 시 System.exit()를 호출 불가
- 프로그래밍 요구 사항에서 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동 금지
- 자바 코드 컨벤션을 지키면서 프로그래밍
- 원칙: [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java)
- indent(인덴트, 들여쓰기) depth는 3이 넘지 않아야 함 (2까지만 허용)
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2임
    힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 됨
- 3항 연산자 금지
- 함수(또는 메서드)가 한 가지 일만 하도록 구현

## 라이브러리
- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현
  - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용
    - 사용 예시
        - 0에서 9까지의 정수 중 한 개의 정수 반환
      
                Randoms.pickNumberInRange(0, 9);
    
  - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용

## 패키지 구조

- 계층형 구조
    - controller
    - service
    - dto
    - domain

## 구현 체크 리스트

1. 입력 받기
2. 
3. 
4. 
5. 
6. 
7. 
8. 
9. 
10. 
11. 출력