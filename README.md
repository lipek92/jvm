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
Prosty konwerter POJO to JSON.
- obsługuje pola publiczne i prywatne
- obsługuje tablice
- nie obsługuje kolekcji, zagnieżdzeń obiektów

####Dane maszyny, na której był przeprowadzony test:
```
CPU: Intel® CoreTM i7-2630QM CPU @ 2.00GHz × 8
Dysk: SSD GOODRAM C40
OS: Ubuntu 14.04.4 LTS
Java version: 1.8.0_74
VM version: 64-Bit Server VM (build 25.74-b02, mixed mode)
```
####Przebieg testu:
Program iterował dziesięciokrotnie w pętli. W każdej iteracji zostały wywołane dwie metody 100 000 razy. Pierwsza z nich dokonywała parsowania obiektu na JSON przy pomocy biblioteki Jackson, a druga przy pomocy konwertera napisanego przeze mnie. Skrajne wyniki zostały odrzucone, a pozostałe uśrednione. Rezultat poniżej. 

Wykres przedstawia porównanie średniego czasu (w sekundach) parsowania obiektu do JSONa poprzez bibliotekę Jakson i konwerter stworzony przeze mnie, wypadający nieco gorzej.  
![alt tag](https://github.com/lipek92/jvm/blob/master/zad4/json.png)

Aplikacja została uruchomiona w środowski Eclipse.

Uruchamianie
```
mvn exec:java
```
<<<<<<< HEAD

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
=======
>>>>>>> 056d25dbbc68f90064907ce141b6325feaf3b8f0
