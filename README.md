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

### Zad 7

Aplikacja RESTful postawiona na Jersey'u.

Po uruchomieniu wg. poniższej instrukcji wchodzimy na wybraną stronę:
- http://localhost:8080/myapp/time/xxx 
- http://localhost:8080/myapp/time2/xxx

gdzie xxx jest parametrem określającym ilość mikrosekund na jaką testowo usypiamy wątek (w drugim przypadku wartość zostanie pomnożona *2).
Na stronie powinna się pojawić odpowiedź postaci: ReqTime: xxx.

Agent przekazuje do logów parametr z jakim została wykonana metoda oraz czas jej wykonania.

Uruchamianie
```
mvn compile
mvn assembly:assembly
mvn exec:exec
```

### Zad 11
Test wydajnościowy porównujący różne metody serializacji i deserializacji obiektów

####Dane maszyny, na której był przeprowadzony test:
```
CPU: Intel® CoreTM i7-2630QM CPU @ 2.00GHz × 8
Dysk: SSD GOODRAM C40
OS: Ubuntu 14.04.4 LTS
Java version: 1.8.0_74
VM version: 64-Bit Server VM (build 25.74-b02, mixed mode)
```
####Przebieg testu:
Program iterował dziesięciokrotnie w pętli. W każdej iteracji program dokonywał serializacji i deserializacji listy obiektów typu Login przy pomocy 5 różnych metod. Test został przeprowadzony kolejno dla 1, 1000 i 10 000 obiektów. 

```
NUMBER OF OBJECTS: 1
class com.lipek.serializable.Serializer procesing time: 16
class com.lipek.serializable.Jackson procesing time: 264
class com.lipek.serializable.GsonConverter procesing time: 54
class com.lipek.serializable.JAXB procesing time: 263
class com.lipek.serializable.Externalizer procesing time: 5
NUMBER OF OBJECTS: 1000
class com.lipek.serializable.Serializer procesing time: 174
class com.lipek.serializable.Jackson procesing time: 66
class com.lipek.serializable.GsonConverter procesing time: 96
class com.lipek.serializable.JAXB procesing time: 373
class com.lipek.serializable.Externalizer procesing time: 290
NUMBER OF OBJECTS: 10000
class com.lipek.serializable.Serializer procesing time: 1134
class com.lipek.serializable.Jackson procesing time: 116
class com.lipek.serializable.GsonConverter procesing time: 400
class com.lipek.serializable.JAXB procesing time: 584
class com.lipek.serializable.Externalizer procesing time: 1576
```

Wykres przedstawia porównanie średniego czasu serializacji i deserializacji różnymi metodami w zależności od liczby obiektów 
![alt tag](https://github.com/lipek92/jvm/blob/master/zad11/wykres.png)

####Wnioski:
Serializable i Externalizable bardzo dobrze radzą sobie w przypadku małej ilości danych, jednak przy większej czas gwałtownie rośnie. 
W przypadku JAXB czas serializacji dla 1 obiektu jest duży, ale przy zwiększaniu ich liczby rośnie powoli.
Dla Gsona wynik dla 1 obiektu jest nieco gorszy niż dla Serializable i Externalizable, ale z wzrostem liczby obiektów zyskuje przewagę.
Ciekawy wynik jest w przypadku Jacksona, gdzie średni czas serializacji dla 1000 obiektów jest znacznie niższy niż dla 1.

Jak widać wybór najlepszego serializatora zależy od ilości danych do przetworzenia.

Uruchamianie
```
mvn exec:java
```

=======
