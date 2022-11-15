## Hyttebok - Release3 dokumentasjon

I denne øvingen har vi utvidet funksjonaliteten til prosjektet, og implementert rest-server ved å bruke Spring Boot.
Link til Milestone 3 i gitlab:
https://gitlab.stud.idi.ntnu.no/it1901/groups-2022/gr2208/gr2208/-/milestones/3#tab-issues

### Modularisering

Vi har nå fått en ny modul _restapi_, i tillegg til allerede eksisterende _core_ og _fxui_.
_restapi_-modulen bruker Spring Boot til å kjøre en lokal server, og all persistens foregår nå gjennom denne modulen. REST-API-dokumentasjonens kan leses i _restDok.md_

### Arkitektur

Fortsatt lite logikk i kontroller-klassene. Følger Model-View-Controller prinsippet.
Persistensen er som nevnt flyttet fra _fxui_ til _restapi_, ettersom det kun er REST-serveren som nå bruker disse klassene.

### Struktur

Som nevnt, har en del strukturielle ting endret seg, og vi har laget tre diagrammer for å illustrere den oppdaterte strukturen.

**Klassediagrammet** beskriver den overordnede strukturen over klassene som er med i prosjektet. Som vi ser i diagrammet, har klassene automatisk gruppert seg litt etter modulene; _fxui_ nederst til venstre. _core_ øverst i diagrammet og _restapi_ nederst til høyre. Likevel kan man se sammenhengen mellom de ulike klassene tydelig.
Vi har valgt å ikke ha med serializers og deserializers, siden dette ville ført til 4 nye klasser i mellom PostModule og Hytte-Read og -Save, noe som ville gjort diagrammet mindre oversiktlig.
![Example](/docs/release3/DiagramClassR3.png)

**Pakkediagrammet** viser en mindre spesifikk oversikt over hva koden inneholder. Her er det kun fokus på de tre store grupperingene; _fxui_, _restapi_, og _core_, og sammenhengene mellom disse.
![Example](/docs/release3/DiagramPackage.png)

**Sekvensdiagrammet** viser hvordan koden reagerer i et spesifikt tilfelle. Vi har valgt tilfellet der brukeren vil lese tidligere innlegg. Det starter derfor med at en _user_ trykker på "Se tidligere" knappen som er plassert på forsiden når appen åpnes. I diagrammet kan man se hvordan koden reagerer på denne operasjonen.
![Example](/docs/release3/DiagramSequence.png)

### Valg knyttet til arbeidsvaner, arbeidsflyt og kodekvalitet

#### Arbeidsvaner og arbeidsflyt

Vi har fortsatt å bruke klare mål og Scrum-arbeidsvaner til å drive prosjektet effektivt fremover. Vi har god arbeidsflyt både på møtene og individuelt hjemme, noe som kan skyldes ryddig fordeling av arbeidsoppgaver. Ellers gjør vi stort sett det samme som tidligere, så dere kan lese mer om dette i release 2.

#### Kodekvalitet

Bruker fortsatt Checkstyle, Spotbugs og Jacoco.
Det er gjort noen endringer i Checkstyle-konfigurasjonen, dvs vi har skrudd av et par moduler til.
Vi valgte å ikke konfigurere SpotBugs, så konfigurasjonsfilen til Spotbugs, som tidligere lå i _hytte/config/spotbugs_, er nå slettet.
