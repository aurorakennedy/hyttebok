
# REST-Tjenesten

## Beskrivelsen av tjenesten

REST-tjenesten vår består i hovedsak av tre klasser: RestApplication, RestAppController, og HytteRequests. 

### Server-siden
RestApplication bruke til å starte en Spring Boot server, og RestAppController bestemmer hvordan denne serveren skal håndtere GET- og POST-forespørsler til http://localhost:8080/hytte.

GET-forespørsler håndteres ved at kontrolleren bruker HytteRead til å hente et PostList objekt fra fil, som er serialisert med PostModule. 
Deretter sender svarer den med en serialisert streng som inneholder dette objektet.
Formatet på GET-forespørselen er en enkel HTTP-GET.

Ved POST-forespørsler vil serveren ta i mot en serialisert PostList, opprette et HytteSave-objekt, og bruke dette til å lagre den mottatte strengen til fil.
Serveren responderer med true hvis lagringen går som forventet.
Bodyen til POST-forespørselen må altså være et PostList-objekt, som er serialisert ved hjelp av PostModule. Hvis ikke vil serveren ikke være i stand til å deserialisere strengen og lagre den til fil.


Serveren håndterer kun POST- og GET-forespørsler, og kun til url'en http://localhost:8080/hytte. 

### HytteRequests
Det er HytteRequests som brukes til å sende disse GET- og POST-forespørslene. 

postRequest() tar i mot et postList objekt, og skriver det om til en streng. Deretter opprettes det en http-post-forespørsel, som sendes til serveren. 

getRequest() oppretter en http-post-forespørsel, og sender denne til serveren. Responsen desersialiseres til et PostList-objekt, som returneres.

HytteRequests brukes av HytteController til å sende og motta PostList objekter til og fra serveren. Den fungerer altså som et bindeledd mellom fxui-modulen og REST-serveren.