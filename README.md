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
