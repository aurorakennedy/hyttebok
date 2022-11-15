## Hyttebok - Release3 dokumentasjon

I denne øvingen har vi utvidet funksjonaliteten til prosjektet, og implementert rest-server ved å bruke Spring Boot.
Link til Milestone 3 i gitlab:
https://gitlab.stud.idi.ntnu.no/it1901/groups-2022/gr2208/gr2208/-/milestones/3#tab-issues

### Modularisering

Vi har nå fått en ny modul _restapi_, i tillegg til allerede eksisterende _core_ og _fxui_.
_restapi_-modulen bruker Spring Boot til å kjøre en lokale server, og all persistens foregår nå gjennom denne modulen. REST-API-dokumentasjonens kan leses i _restDok.md_ 

### Arkitektur

Fortsatt lite logikk i kontroller-klassene. Følger Model-View-Controller prinsippet. 
Persistensen er som nevnt flyttet fra _fxui_ til _restapi_, ettersom det kun er REST-serveren som nå bruker disse klassene.

### Kodekvalitet og testing

Alle modulene testes.
Testdekningsgraden blir fortsatt rapportert med Jacoco.
Prosjektet bruker nå også pluginsene Checkstyle og Spotbugs, og vi har ryddet opp i koden tilsvarende deres tilbakemeldinger. Konfigurasjonsfilene til checkstyle ligger i _hytte_ --> _config_ --> _checkstyle.config.xml_.

### Struktur

Som nevnt, har en del strukturielle ting endret seg, og vi har laget tre diagrammer for å illustrere den oppdaterte arkitekturen.
Klassediagram:
SKRIVE HVILKE KLASSER VI IKKE INKLUDERTE
![Example](/docs/release3/DiagramClassR3.png)
Pakkediagram:
![Example](/docs/release3/DiagramPackage.png)
Sekvensdiagram:
![Example](/docs/release3/DiagramSequence.png)

### Valg knyttet til arbeidsvaner, arbeidsflyt og kodekvalitet

#### Arbeidsvaner og arbeidsflyt

Vi har fortsatt å bruke klare mål og Scrum-arbeidsvaner til å drive arbeidet effektivt fremover. Vi har god arbeidsflyt både på møtene og individuelt hjemme, noe som kan skyldes ryddig fordeling av arbeidsoppgaver.

#### Kodekvalitet

Bruker fortsatt Checkstyle, Spotbugs og Jacoco. 
Det er gjort noen endringer i Checkstyle-konfigurasjonen, dvs vi har skrudd av et par moduler til.
Vi valgte å ikke konfigurere SpotBugs, så konfigurasjonsfilen til Spotbugs som tidligere lå i _hytte/config/spotbugs_ er slettet.
