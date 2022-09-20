## Hyttebok – prosjektdokumentasjon

Vi bestemte oss for å lage en hyttebok, både fordi vi selv har interesse av en slik applikasjon, men også fordi vi tenkte at skalerbarheten i implementasjon er praktisk. Vi starter med et helt grunnleggende og minimalt program, som lett kan utvides etter oppgavens utvikling.

### Hvordan vi har løst oppgaven og valg vi har tatt:

Vi har jobbet oss sakte men sikkert gjennom oppgaveteksten, og laget issues til hvert enkelt problem. Deretter har vi enkeltvis jobbet med hver våre issues frem til neste møte. Vi har valgt å bruke Gitlab aktivt ved å bruke issues, milestones og releases, og det har hjulpet oss med å holde oversikt over hva som måtte gjøres og hvem som hadde ansvar for hva.

<br /><br />

**Oppstart:**

Vi startet med å klone utdelt «repository» og skrive en fungerende pom-fil for å konfigurere maven. Vi lagde to brukercaser for å se hvilken funksjonalitet vi hadde behov for og brukte dette som utgangspunkt til å lage konkrete issues.

<br />

**Underveis:**

Deretter startet vi med å lage en enkel logikk i Post og PostList klassen. Post-klassen er et innlegg i hytteboka og PostList er en samling av de eksisterende innleggene. Siden lagde vi hytteApp og HytteController som kjører appen og henter dataen skrevet inn ved kjøring av appen. Vi lagde også tester til Post-klassen, slik at vi dekket 24% av metodene i prosjektet. Deretter implementerte vi HytteSave, som gjorde det mulig å skrive til fil.

Vi skrev også de to readme filene, og la inn brukercasene her.

<br />

**Final touch:**

Til slutt konfigurerte vi GitPod-funksjonaliteten og testet dekningsgraden av test-funksjonaliteten i appen. Dette krevde mye arbeid, som selv teknisk studentassistent slet med å hjelpe oss med, men til slutt klarte vi gjennom mvn verify å få Jacoco til å vise dekningsrapporten.
