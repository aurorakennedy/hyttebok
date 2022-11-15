## Hyttebok - Release3 dokumentasjon

I denne øvingen har vi utvidet funksjonaliteten til prosjektet, og **\*\***\_\_**\*\***rest-server.
Link til Milestone 3 i gitlab:
https://gitlab.stud.idi.ntnu.no/it1901/groups-2022/gr2208/gr2208/-/milestones/3#tab-issues

### Modularisering

Vi har nå fått en ny modul _vrfergr_, i tillegg til allerede eksisterende _core_ og _fxui_.**\*\***\_\_**\*\***

### Arkitektur

Fortsatt lite logikk i kontroller-klassene. Følger Model-View-Controller prinsippet. **\*\*\*\***\_\_**\*\*\*\***

### Kodekvalitet og testing

Samme som i release 2, derfor kanskje ikke nødvendig????

Alle modulene testes.
Testdekningsgraden blir fortsatt rapportert med Jacoco.
Prosjektet bruker nå også pluginsene Checkstyle og Spotbugs, og vi har ryddet opp i koden tilsvarende deres tilbakemeldinger. Konfigurasjonsfilene til disse ligger i _hytte_ --> _config_.

### Struktur

Som nevnt, har en del strukturielle ting endret seg, og vi har laget tre diagrammer for å illustrere den oppdaterte arkitekturen.
Klassediagram:
![Example](/docs/release3/DiagramClassR3.png)
Pakkediagram:
![Example](/docs/release3/DiagramPackage.png)
Sekvensdiagram:
![Example](/docs/release3/DiagramSequence.png)

### Valg knyttet til arbeidsvaner, arbeidsflyt og kodekvalitet

#### Arbeidsvaner og arbeidsflyt

Vi har fortsatt å bruke klare mål og Scrum-arbeidsvaner til å drive arbeidet effektivt fremover. Vi har god arbeidsflyt både på møtene og individuelt hjemme, noe som kan skyldes ryddig fordeling av arbeidsoppgaver.

#### Kodekvalitet

Bruker fortsatt Checkstyle, Spotbugs og Jacoco. Har vi endret Spotbugs nå? Sto om det i dokumentasjon 2...**\_\_**
