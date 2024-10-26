# java-racingcar-precourse

## 🌈 기능 목록

### 입력

- [ ] 경주할 자동차 이름 입력받기
    - [ ] 쉼표로 구분하기
    - [ ] 이름은 5자 이하만
    - [ ] 이름은 영어와 한글만으로 이루어져야 한다
- [ ] 몇 번 이동할지 입력받기
    - [ ] 숫자가 아닌 경우 확인
    - [ ] 음수인 경우 확인

### 자동차 경주

- [ ] 각 자동차에 이름 부여하기
- [ ] 각 자동차마다 0~9 무작위 값이 4이상이면 전진하기
- [ ] 우승자 구하기

### 출력

- [ ] 차수별 실행 결과 출력하기
- [ ] 최종 우승자 출력하기

## 😅 애매해서 생각해 본 내용

### 입력

- [x] 자동차 이름이 `""`(빈 문자열)이라면?<br>
  -> 빈 문자열의 경우는 이름이 없다고 판단하는 게 맞는 거 같다.<br>
- [x] 자동차 이름이 공백 문자로만 이루어져 있거나 이모지라면?<br>
  -> `String`은 내부적으로 UTF-16으로 저장된다고 한다.<br>
  Java의 `char`가 2바이트를 차지하는 이유이기도 하다.<br>
  2바이트로는 `65536(2^16)`개의 문자를 표현할 수 있다. 16진수로 표현하면 FFFF까지 표현가능하다<br>
  한글의 유니코드는 AC00~D7A3 범위를 가지고 있어, `char` 하나로 표현이 가능하다. (`char ch = '차';`은 가능하다)<br>
  그래서, `String`에 한글 1개 쓴다면 길이 또한 1이 된다.<br>
  하지만, 이모지의 유니코드는 2바이트 표현 범위를 넘어가기 때문에 UTF-16에서는 `Surrogate Pair`규칙을 활용해 2바이트 2개를 붙여 4바이트로 표현한다.<br>
  `"🚗".length()`가 2인 이유이다. (또한, `char`2개가 필요하기 때문에 `char ch = '🚗';`이 `Too many characters in character literal`에러가 생기는
  이유이기도 하다.)<br>
  이모지 1개가 길이가 2로 취급되어 `이름은 5자 이하만 가능`이라는 조건을 확인할 때 문제가 될 거라고 생각했다.<br>
  분명 이모지 3개만 썼는데, 5자가 넘었다는 에러를 띄울테니 말이다.<br>
  이러한 이유로, 자동차 이름은 **영어와 한글만**으로 이루어져야 한다는 제약을 정하게 되었다.<br>
- [x] 자동차 이름이 똑같다면?<br>
  -> 현실에도 동명이인이 있으므로, 그냥 출력하면 될 거 같다.<br>
  출력되는 순서가 다르니 구별이 쉽진 않지만 가능하다.<br>
- [x] 시도 횟수가 음수거나 0이면?<br>
  -> 음수는 잘못된 입력이라는 부분에 이견이 없을 듯 하다.<br>
  0은 자동차 모두 우승자가 되는 행복한 경우여서 괜찮은 입력인 거 같다.<br>

### Reference

- https://stackoverflow.com/questions/9699071/what-is-the-javas-internal-represention-for-string-modified-utf-8-utf-16
- https://stackoverflow.com/questions/64213394/string-encoding-with-emoji-in-java
- https://stackoverflow.com/questions/38345372/why-does-a-string-containing-a-single-emoji-like-have-a-length-of-2
- https://blog.hoseung.me/2022-08-25-emoji-and-unicode
- https://namu.wiki/w/%ED%98%84%EB%8C%80%20%ED%95%9C%EA%B8%80%EC%9D%98%20%EB%AA%A8%EB%93%A0%20%EA%B8%80%EC%9E%90/%EC%9C%A0%EB%8B%88%EC%BD%94%EB%93%9C
