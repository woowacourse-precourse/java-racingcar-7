# java-racingcar-precourse

- [ ] 경주할 자동차 이름(쉼표 기준으로 구분) 입력받기
- [ ] 쉼표로 구분할 수 없거나 이름이 5자가 넘는다면 IllegalArgumentException 예외 발생
- [ ] Map<K, V> 생성: K는 이름(String), V는 전진 횟수(StringBuilder)
- [ ] 시도할 횟수 입력받기
- [ ] 숫자가 아닌 값을 입력받을 경우 IllegalArgumentException 예외 발생
<br/>

- [ ] Map의 keySet() 메서드로 이름(key)을 모두 순회하면서 0에서 9 사이 무작위 값을 구하기
- [ ] 무작위 값이 4 이상일 경우 전진: Map에서 이름(key)에 해당하는 StringBuilder(value)에 append("-")
- [ ] 실행 결과 출력 후 위 과정을 입력받은 시도 횟수만큼 반복
<br/>

- [ ] 최종 우승자 찾기: Map의 keySet() 메서드로 이름(key)을 모두 순회하면서 StringBuilder(value)의 길이가 가장 긴 이름(key) 선택
- [ ] 최종 우승자 출력: 우승자가 여러명일 경우 쉼표(,)를 이용하여 구분 -> String.join() 메서드 사용
