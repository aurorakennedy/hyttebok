[![Gitpod Ready-to-Code](https://img.shields.io/badge/Gitpod-Ready--to--Code-blue?logo=gitpod)](https://gitpod.stud.ntnu.no/#https://gitlab.stud.idi.ntnu.no/it1901/groups-2022/gr2208/gr2208)

# Group gr2208 repository

## Hyttebok Prosjekt

### Beskrivelse av prosjektet

Prosjektet vårt går ut på at vi skal lage en hyttebok hvor man kan loggføre besøk på hytta. Loggen skal være tilknyttet både en person og ett tidspunkt.

### Kjøring av prosjeketet

<br>
Før man kan åpne prosjektet for første gang må man kjøre `mvn clean install` fra hytte-mappa på rotnivå.
<br> <br>

Prosjektet bruker en Spring Boot server som kjører lokalt, som tar seg av persistensen. Denne kjøres må fra restapi-modulen i en egen terminal, ved skrive `mvn spring-boot:run`.
Man er avhengig av at serveren kjører for å kunne lese og skrive til fil, da all persistens foregår gjennom denne.
<br>


Selve appen må kjøres fra fxui-modulen, ved å kjøre `cd fxui` fra hytte-mappa, etterfulgt av `mvn javafx:run`.


<br>

### Prosjektstruktur

På rotnivået har vi mappene _docs_, _hytte_ og en _readme_
fil.

Inne i _docs_ mappen har vi ny mappe struktur hvor vi vil få en ny mappe per innlevering. Vi har nå tre mapper der, _realease1_, _release2_, og _release3_ der dokumentasjonen på hver innlevering ligger

I mappen _hytte_ har vi seks strukturen som er byggd opp slik:

#### 1. _hytte_ --> _pom.xml_

Hoved-pom.xml til prosjektet. Gjør slik at maven kan bygge prosjektet, og inneholder konfigurasjoner til maven-plugins som brukes av flere moduler.

#### 2. _hytte_ --> _core_

Dette er mappen for core-modulen til prosjektet. Den inneholder kjernelogikk, og logikk for lesing og skriving til json-filer.
I tillegg inneholder modulen tester for klassene sine.
I mappen finner vi en _pom.xml_, som blant annet konfigurerer plugins for denne modulen.

#### 3. _hytte_ --> _fxui_

Dette er mappen for fxui-modulen til prosjektet. Den inneholder brukergrensesnittet, i form av _hytte.fxml_, samt tilhørende app- og controller-funksjonalitet.
_pom.xml_ definerer igjen plugins og konfigurasjoner til modulen.

#### 3. _hytte_ --> _restapi_

Dette er mappen for restapi-modulen til prosjektet. Den inneholder kjernen av REST-APIen, og bruker Spring Boot.
RestAppplication brukes til å starte serveren, og RestAppController styrer hvordan serveren håndterer POST- og GET-requests. Mer detaljer finnes i _docs_ --> _release3_ --> _restDok.md_.

#### 4. _hytte_ --> _config_

Mappen inneholder konfigurasjonsfiler for maven-pluginsene Checkstyle og Spotbugs.
De brukes for å endre hva som testes ved bruk av kommandoen `mvn verify`

#### 5. _hytte_ --> _readme.md_

Beskriver hva appen handler om og hva den er ment å gjøre når den er ferdig.

#### 6. _hytte_ --> _doc_resources_

Inneholder ressurser til _readme.md_ filen. Ekempelbilder og brukerhistorier.
