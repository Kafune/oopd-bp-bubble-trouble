# Waterworld inclusief OOPG; de OOPD Game Engine

In deze repository staat een demo, gebaseerd op de OOPD Processing Game Engine. Het kan als startpunt dienen bij het maken van het beroepsproduct voor OOPD.

## Inleiding

Waterworld is een demo en gebaseerd op OOPG, de OOPD Processing Game Engine. Deze engine biedt 
alle basisfunctionaliteit die nodig is om een 2D spel te maken. Waterworld kan hierbij als 
voorbeeld dienen hoe een dergelijk project inhoudelijk moet worden opgezet. Ook kan het gebruikt 
worden om in te zien hoe de functionaliteit van de engine moet worden aangesproken.

## OOPG

Voor het werken met OOPG is verder meer informatie beschikbaar.

* De broncode van OOPG:   [Broncode](https://github.com/HANICA-OOPD/waterworld-and-oopg) 
* De Wiki van OOPG: [Wiki](https://github.com/HANICA/oopg/wiki)
* De volledige Javadoc van OOPG: [Javadoc](http://hanica.github.io/oopg/) 

Als je met deze code verder gaat voor je eindproduct  pas dan op dat je GEEN game engine code aanpast.
Én dat je geen ongebruikte Waterworld code laat staan, en alles netjes hernoemt naar goede namen voor je eigen project.

Overrides van OOPG functionaliteit moeten in je eigen code (NIET in de `/oopg/` folder).

## Aan de slag

Download als zip en pak hem uit op de plek waar je je project wilt hebben staan (of gebruik git). Je hebt nu een project
dat in zowel Eclipse als IntelliJ te importeren is.

## JDK
Momenteel is OOPG niet bruikbaar met JDK versies later dan 1.8. Zorg er dus voor dat in je IDE gebruik wordt gemaakt van een JDK1.8 of ouder.

### Eclipse
Kies menu `File` -> `Import...` en dan Maven -> `Existing Maven Projects` en selecteer vervolgens de map waar de waterworld map staat (bijvoorbeeld je download folder).

#### Run de voorbeeld game
Blader in het geimporteerde project in Eclipse naar WaterWorld.java, rechtsklik en selecteer `Run as` -> `Java Application`.

### IntelliJ
Kies menu `Open...` en selecteer vervolgens de waterworld map.

#### Run de voorbeeld game
Blader in het geimporteerde project in IntelliJ naar `WaterWorld.java`, rechtsklik en selecteer `Run WaterWorld.main()`.
