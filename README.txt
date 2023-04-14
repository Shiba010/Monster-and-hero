# CS611-Legends of Valor
## <Assignment 4>
---------------------------------------------------------------------------
WEI-TSE, KAO
kaowt@bu.edu
U00861032

Yichuan Philip Ma
yma03@bu.edu
U56263161

## Files
---------------------------------------------------------------------------
Main.java: Run the main code.

Characters(Package):
	Character.java(interface): interface for those characters to implement
	CharacterFactory.java: create characters

	Hero(Package):
		Hero.java: super class of those heros
		-extend Paladin.java: object of paladin
		-extend Sorcerer.java object of sorcerer
		-extend Warrior.java object of warrior

	Monster(Package):
		Monsters.java: super class of those monsters
		-extend Dragon.java: object of dragon
		-extend Exoskeleton.java: object of exoskeleton
		-extend Spirit.java: object of spirit

Events(Package):
	Event.java(interface): interface for those events to implement
	Market.java: the market

Game(Package):
	RoundBasedGame.java: the base game of monster and hero
	-extends LegendOfValorGame.java: the game of Legend of Valor
 
Items(Package):
	Consumable.java(interface): the interface which items are consumable can implement
	Equipable.java(interface): the interface which items are equitable can implement
	Item.java(interface): the interface those items can implement
	ItemFactory.java: product items
	Armory.java: object of armory
	Potions.java: object of potions
	Weaponry.java: object of weaponry

	Spells(Package):
		Spell.java: the super class of spell
		-extend FireSpell.java: object of fire spell
		-extend IceSpell.java: object of ice spell
		-extend LighteningSpell.java: object of lightening spell
 
Maps(Package):
	Map.java(interface): interface for maps to implement
	RandMap.java: create randomly distributed map
	RandomGenerator.java: generate random

Party(Package):
	Party.java: store the info of party

Players(Package):
	Player.java: store the info of player

Prompt(Package):
	AskPrompt.java: prompt for asking questions
	PrintPrompt.java: prompt for printing something

Space(Package):
	Cell: the unit of the map
	-extend InvalidSpace.java: area in the map which is invalid
	-extend BushSpace.java: bush landscape in the map
	-extend CaveSpace.java: cave landscape in the map
	-extend KoulouSpace.java: koulou landscape in the map
	-extend PlainSpace.java: plain landscape in the map
	-extend HeroNexusSpace.java: the nexus of heroes in the map
	-extend MonsterNexusSpace.java: the nexus of monsters in the map
	

Utility(Package):
	FileReader.java: read the txt files
	Scanner.java: scan the text

## Notes
---------------------------------------------------------------------------
1. I combine those text files for different types of heros to "Heros.txt".
2. I combine those text files for different types of monsters to "Monsters.txt".
3. I combine those text files for different types of spells to "Spells.txt".

## How to compile and run
---------------------------------------------------------------------------
1. Navigate to the directory "/611_Assignment_4/src" after unzipping the files
2. Run the following instructions:
javac Main.java
java Main

## Input/Output Example
---------------------------------------------------------------------------
In these examples, text wrapped in curly brackets are {inputs}. All others are
outputs.

### Initialization and first round
