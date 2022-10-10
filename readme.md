[![Gitpod Ready-to-Code](https://img.shields.io/badge/Gitpod-Ready--to--Code-blue?logo=gitpod)](https://gitpod.stud.ntnu.no/#https://gitlab.stud.idi.ntnu.no/it1901/groups-2022/gr2208/gr2208)

# Group gr2208 repository
## Hyttebok Prosjekt 

### Beskrivelse av prosjektet 
Prosjektet vårt går ut på at vi skal lage en hyttebok hvor man kan loggføre besøk på hytta. Loggen skal være tilknyttet både en person og ett tidspunkt, slik at vi kan hente ut tidligere loggføriringer knyttet til tid eller person. 

### Kjøring av prosjeketet
Før man kan åpne prosjektet for første gang må man kjøre `mvn clean install` fra hytte-mappa på rotnivå.

Prosjektet må kjøres fra fxui-modulen, ved å kjøre `cd fxui` fra hytte-mappa, etterfulgt av `mvn javafx:run`.

### Prosjektstruktur 

På rotnivået har vi mappene _docs_, _hytte_ og en _readme_
 fil. 
 
Inne i *docs*  mappen har vi ny mappe struktur hvor vi vil få en ny mappe per innlevering. Til nå ligger det to mapper der, *realease1* og *release2*, der dokumentasjonen på første og andre innlevering ligger.

I mappen *hytte* har vi fire strukturen som er byggd opp slik: 


#### 1. *hytte* --> *pom.xml* 
Hoved-pom.xml til prosjektet. Gjør slik at maven kan bygge prosjektet, og inneholder konfigurasjoner til maven-plugins som brukes av flere moduler.

#### 2.  *hytte* --> *core*
Dette er mappen for core-modulen til prosjektet. Den inneholder kjernelogikk, og logikk for lesing og skriving til json-filer.
I tillegg inneholder modulen tester for klassene sine.
I mappen finner vi en *pom.xml*, som blant annet konfigurerer plugins for denne modulen.

#### 3. *hytte* --> *fxui*
Dette er mappen for fxui-modulen til prosjektet. Den inneholder brukergrensesnittet, i form av *hytte.fxml*, samt tilhørende app- og controller-funksjonalitet.
*pom.xml* definerer igjen plugins og konfigurasjoner til modulen.

#### 4. *hytte* --> *config*
Mappen inneholder konfigurasjonsfiler for maven-pluginsene Checkstyle og Spotbugs. 
De brukes for å endre hva som testes ved bruk av kommandoen `mvn verify`

 
