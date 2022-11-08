
**REST-Tjenesten**

### Beskrivelsen av tjenesten

REST-tjenesten vår består i hovedsak av tre klasser: RestApplication, RestAppController, og HytteRequests. 

RestApplication bruke til å kjøre en Spring Boot server, og RestAppController bestemmer hvordan denne serveren skal håndtere GET- og POST-forespørsler til http://localhost:8080/hytte.
GET-forespørsler håndteres ved at kontrolleren bruker HytteRead til å hente et serialisert PostList objekt fra fil. Deretter sender svarer den med en streng som inneholder dette objektet.
Ved POST-forespørsler vil serveren ta i mot en serialisert PostList, opprette et HytteSave-objekt, og bruke dette til å lagre den mottatte strengen.
Serveren responderer med true hvis lagringen går som forventet.

Det er HytteRequests som brukes til å sende disse GET- og POST-forespørslene. 
postRequest() tar i mot et postList objekt, og skriver det om til en streng. Deretter opprettes det en http-post-forespørsel, som sendes til serveren. 
getRequest() oppretter en http-post-forespørsel, og sender denne til serveren. Responsen desersialiseres til et PostList-objekt, som returneres.

HytteRequests brukes av HytteController til å sende og motta PostList objekter til og fra serveren. Den fungerer altså som et bindeledd mellom fxui-modulen og REST-serveren.

Serveren håndterer kun POST- og GET-forespørsler, og kun til url'en http://localhost:8080/hytte. 