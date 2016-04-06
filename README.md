# jvm
### Zad 1
Witualna maszyna Javy ma ustaloną (z możliwością modyfikowania), ograniczoną wielkość pamięci. W przedstawionym przykładzie program zgłasza wyjątek OutOfMemoryError, ponieważ dodając obiekty do array listy w nieskończonej pętli następuje moment, w którym pamięć ta się kończy.

Uruchamianie
```
mvn exec:java
```

### Zad 2
Własny ClassLoader, który dynamiczne ładuje klasy pobierane z serwera RESTowego napisanego w Node.js

Serwer podmienia pliki .class podczas każdego zapytania o klasę 

Uruchamianie serwera
```
npm install
node server.js
```
Uruchomienie projektu z poziomu IDE (klasa App.java)


### Zad 3
Dokładny opis w pliku raport.pdf

Uruchamianie
```
mvn exec:java
```

### Zad 4
Prosty konwerter POJO to JSON

![alt tag](https://github.com/lipek92/jvm/tree/master/zad4/json.png)

Uruchamianie
```
mvn exec:java
```

### Zad 6

Program pokazuje, że SimpleDateFormat nie jest thread safe. Zaprezentowano również rozwiązanie tego problemu i zapewnienie thread-safety poprzez wykorzystanie klasy ThreadLocal.

Poniżej przykładowe wyniki pokazujące brak thread safe bez modyfikacji:

```
Sat Aug 01 00:00:00 CEST 1992
Sat Aug 01 00:00:00 CEST 1992
Sat Aug 01 00:00:00 CEST 1992
Sat Aug 01 00:00:00 CEST 1992
Sat Aug 01 00:00:00 CEST 1992
Sat Aug 01 00:00:00 CEST 1992
Sat Aug 01 00:00:00 CEST 1992
Sat Aug 01 00:00:00 CEST 1992
Sat Aug 01 00:00:00 CEST 1992
Sat Aug 01 00:00:00 CEST 1992
Sat Aug 01 00:00:00 CEST 1992
Tue Jan 13 00:00:00 CET 1998
Sat Aug 01 00:00:00 CEST 1992
Fri Jul 31 00:00:00 CEST 1992
Sat Aug 01 00:00:00 CEST 1992
Sat Aug 01 00:00:00 CEST 1992
Sat Aug 01 00:00:00 CEST 1992
Sat Aug 01 00:00:00 CEST 1992
Sat Aug 01 00:00:00 CEST 1992
Sun Aug 01 00:00:00 CET 1
```

Uruchamianie
```
mvn exec:java
```