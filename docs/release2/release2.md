## Hyttebok - Release2 dokumentasjon

Det har blitt gjort relativt store endringer i prosjektet, selv om selve funksjonaliteten til applikasjonen ikke er utvidet noe særlig.
Link til Milestone 2 i gitlab:
https://gitlab.stud.idi.ntnu.no/it1901/groups-2022/gr2208/gr2208/-/milestones/2#tab-issues

### Modularisering

Vi har delt prosjektet inn i to hovedmoduler, _core_ og _fxui_.
_Core_ inneholder kjernelogikken til prosjektet.
_Fxui_ inneholder brukergrensesnitt, samt controller- app- og lagringsklasser.

Parent-pom.xml ligger i _hytte_.
Begge modulene har hver sin pom.xml-fil som definerer hvilke maven-plugins som skal brukes.

### Arkitektur

Kjernelogikken, ui-et og persistensen er skilt fra hverandre i passende klasser. Svært lite logikk ligger i kontroller-klasse _HytteController_.

For persistens brukes JSON, med Jackson.
Hovedklassene for lesing og lagring til fil finnes i fxui-modulen i _hytte_ --> _fxui_ --> _src_ --> _main_ --> _java_ --> _hytte_ --> _ui_.  
Støtteklassene for Jackson-bruk ligger i _hytte_ --> _core_ --> _src_ --> _main_ --> _java_ --> _hytte_ --> _json_

Applikasjonen vår bruker implisitt lagring, ettersom tidligere innlegg i hytteboka skal hentes automatisk når programmet åpnes.

### Kodekvalitet og testing

Alle modulene testes.
Testdekningsgraden blir fortsatt rapportert med Jacoco.
Prosjektet bruker nå også pluginsene Checkstyle og Spotbugs, og vi har ryddet opp i koden tilsvarende deres tilbakemeldinger. Konfigurasjonsfilene til disse ligger i _hytte_ --> _config_.
Noen av modulene i Checkstyle har vi skrudd av, ettersom vi konkluderte med at de gjorde koden mer uryddig, og dermed virket mot sin hensikt.

### Klasser

Prosjektet har som nevnt fått flere nye klasser, som brukes for lesing og skriving til fil.

Klassediagram på nåværende tidspunkt:
![Example](../../hytte/doc_resources/klasseDiagram.png)
