[![Gitpod Ready-to-Code](https://img.shields.io/badge/Gitpod-Ready--to--Code-blue?logo=gitpod)](https://gitpod.stud.ntnu.no/#https://gitlab.stud.idi.ntnu.no/it1901/groups-2022/gr2208/gr2208)

# Group gr2208 repository
## Hyttebok Prosjekt 

### Beskrivelse av prosjektet 
Prosjektet vårt går ut på at vi skal lage en hyttebok hvor man kan loggføre besøk på hytta. Loggen skal være tilknyttet både en person og ett tidspunkt, slik at vi kan hente ut tidligere loggføriringer knyttet til tid eller person. 

### Prosjektstruktur 

På rotnivået har vi mappen, _docs_, _hytte_ og en _readme_
 fil. 
 
Inne i *docs*  mappen har vi ny mappe struktur hvor vi vil få en ny mappe per innlevering. Til nå ligger det en mappe der som heter *release1*, hvor det ligger en dokumentasjon på hva vi har gjort til første innlevering. 

I mappen *hytte* har vi fire strukturen som er byggd opp slik: 


#### 1. *hytte* --> *pom.xml* 
Gjør slik at  javafx run og maven test fungerer. 

#### 2.  *hytte* --> *scr* --> *main* --> *java* --> *gruppe08* --> *hytte*

I hytte mappen er det til nå tre klasser. 
- *post.java* her skal vi implementere logikken til en loggføring i boka. 
- *hytteApp.java* får appen til å kjøre. 
- *hytteController.java* kobler sammen fxml'en og java koden. 


#### 3. *hytte* --> *scr* --> *main* --> *resources* --> *gruppe08* --> *hytte*

Her har vi en fil.
- *hytte.fxml* lager vi i scenebilder, er frontend delen av prosjektet. 

#### 4. *hytte* --> *scr* --> *test* --> *java* --> *gruppe08* --> *hytte*

Test mappen inneholder per nå kun en klasse som vi skal teste. 

- *postTest.java* skal teste post klassen. 

 
