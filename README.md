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
