# CS611-<Assignment 3>## <Assignment 3>---------------------------------------------------------------------------WEI-TSE, KAOkaowt@bu.eduU00861032

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
	Battle.java: the battle scene
	Market.java: the market

Game(Package):
	RoundBasedGame.java: the base game of monster and hero
	-extends MonsterAndHeroGame.java: the game monster and hero
 
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
	Cell.java(interface): the unit of the map
	CommonSpace.java: common area in the map
	InvalidSpace.java: area in the map which is invalid
	MarketSpace.java: market in the map

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
1. Navigate to the directory "/611_Assignment_3/src" after unzipping the files2. Run the following instructions:javac Main.javajava Main

## Input/Output Example
---------------------------------------------------------------------------
*************************************************
**       Welcome to the Heroes & Monsters      **
*************************************************
How many Heroes will be in your party: 2
Here are warriors:
   Name                      HP              level      mana       str        agi        dex        money      exp       
[ 0] Gaerdal_Ironhand          100/100         1          100        700        500        600        1354       7/10      
[ 1] Sehanine_Monnbow          100/100         1          600        700        800        500        2500       8/10      
[ 2] Muamman_Duathall          100/100         1          300        900        500        750        2546       6/10      
[ 3] Flandal_Steelskin         100/100         1          200        750        650        700        2500       7/10      
[ 4] Undefeated_Yoj            100/100         1          400        800        400        700        2500       7/10      
[ 5] Eunoia_Cyn                100/100         1          400        700        800        600        2500       6/10      

Here are sorcerers:
   Name                      HP              level      mana       str        agi        dex        money      exp       
[ 6] Rillifane_Rallathil       100/100         1          1300       750        450        500        2500       9/10      
[ 7] Segojan_Earthcaller       100/100         1          900        800        500        650        2500       5/10      
[ 8] Reign_Havoc               100/100         1          800        800        800        800        2500       8/10      
[ 9] Reverie_Ashels            100/100         1          900        800        700        400        2500       7/10      
[10] Kalabar                   100/100         1          800        850        400        600        2500       6/10      
[11] Skye_Soar                 100/100         1          1000       700        400        500        2500       5/10      

Here are paladins:
   Name                      HP              level      mana       str        agi        dex        money      exp       
[12] Parzival                  100/100         1          300        750        650        700        2500       7/10      
[13] Sehanine_cool             100/100         1          300        750        700        700        2500       7/10      
[14] Skoraeus_Stonebones       100/100         1          250        650        600        350        2500       4/10      
[15] Garl_Glittergold          100/100         1          100        600        500        400        2500       5/10      
[16] Amaryllis_Astra           100/100         1          500        500        500        500        2500       5/10      
[17] Caliber_Heist             100/100         1          400        400        400        400        2500       8/10      

Which hero you want to select? Enter the number: 0
Gaerdal_Ironhand is joined to the party!!
Which hero you want to select? Enter the number: 6
Rillifane_Rallathil is joined to the party!!
This is your party: 
   Name                      HP              level      mana       str        agi        dex        money      exp       
[0]Gaerdal_Ironhand          100/100         1          100        700        500        600        1354       7/10      
[1]Rillifane_Rallathil       100/100         1          1300       750        450        500        2500       9/10      

P is your current location on the map: 
+---+---+---+---+---+---+---+---+---+---+---+---+
| D |   |   |   |   |   | M |   |   |   |   | D |
+---+---+---+---+---+---+---+---+---+---+---+---+
|   |   | D |   | M | D |   |   |   | D |   | M |
+---+---+---+---+---+---+---+---+---+---+---+---+
|   |   | M |   | M | D | D |   |   | D |   |   |
+---+---+---+---+---+---+---+---+---+---+---+---+
|   |   | D | M | M |   |   |   |   |   | D | D |
+---+---+---+---+---+---+---+---+---+---+---+---+
|   |   |   | M | M | M |   |   | M |   |   | D |
+---+---+---+---+---+---+---+---+---+---+---+---+
|   |   | D | M |   |   | M | M | M | M | M |   |
+---+---+---+---+---+---+---+---+---+---+---+---+
|   | D |   |   | M | M |   | D |   |   |   | D |
+---+---+---+---+---+---+---+---+---+---+---+---+
| P | D |   | D |   |   | M | D |   |   | D |   |
+---+---+---+---+---+---+---+---+---+---+---+---+
*P means where the part is, M means Market, D means dead end
which direction should the party go ?
[W/w] up
[A/a] left
[S/s] down
[D/d] right
[I/i] info
[Q/q] quit
Please enter:w
Your party encounter a group of Monster!!!!
*************** Battle Begin ! *****************
This is your party: 
   Name                      HP              level      mana       str        agi        dex        money      exp       
[0]Gaerdal_Ironhand          100/100         1          100        700        500        600        1354       7/10      
[1]Rillifane_Rallathil       100/100         1          1300       750        450        500        2500       9/10      

Here are Monsters: 
   Monster's Name       level      HP              damage     defense    dodge_ability 
[0]Blinky               1          100/100         450        350        35        
[1]BigBad-Wolf          1          100/100         150        250        15        

>>>>>>>>>>> Heroes' Turn start <<<<<<<<<<<<
=================Gaerdal_Ironhand's turn=======================
It's Gaerdal_Ironhand's turn! What would Gaerdal_Ironhand want to do?
[A/a] attack
[S/s] Use Spells & Potions
[E/e] equip
[I/i] Party info
[MI] Monster info
[Q/q] Quit Game
Please Enter: a
Here are the Monsters
   Monster's Name       level      HP              damage     defense    dodge_ability 
[0]Blinky               1          100/100         450        350        35        
[1]BigBad-Wolf          1          100/100         150        250        15        

Choose a monster to attack
[MI] monster info
[L/l] choose another action
[Q/q] quit game
Please Enter the number: 0
Gaerdal_Ironhand attacks Blinky and causes 17 damage!
Blinky now has only left 83 HP 

=================Rillifane_Rallathil's turn=======================
It's Rillifane_Rallathil's turn! What would Rillifane_Rallathil want to do?
[A/a] attack
[S/s] Use Spells & Potions
[E/e] equip
[I/i] Party info
[MI] Monster info
[Q/q] Quit Game
Please Enter: A
Here are the Monsters
   Monster's Name       level      HP              damage     defense    dodge_ability 
[0]Blinky               1          83/100          450        350        35        
[1]BigBad-Wolf          1          100/100         150        250        15        

Choose a monster to attack
[MI] monster info
[L/l] choose another action
[Q/q] quit game
Please Enter the number: 0
Rillifane_Rallathil attacks Blinky
Blinky successfully dodges

>>>>>>>>>>> Monster's Turn start <<<<<<<<<<<<
Blinky attacks Gaerdal_Ironhand and causes 22 damage!
Gaerdal_Ironhand now has only left 78 HP 

BigBad-Wolf attacks Rillifane_Rallathil and causes 7 damage!
Rillifane_Rallathil now has only left 93 HP 

>>>>>>>>>>> Heroes' Turn start <<<<<<<<<<<<
=================Gaerdal_Ironhand's turn=======================
It's Gaerdal_Ironhand's turn! What would Gaerdal_Ironhand want to do?
[A/a] attack
[S/s] Use Spells & Potions
[E/e] equip
[I/i] Party info
[MI] Monster info
[Q/q] Quit Game
Please Enter: I
   Name                      HP              level      mana       str        agi        dex        money      exp       
[0]Gaerdal_Ironhand          78/100          1          100        700        500        600        1354       7/10      
[1]Rillifane_Rallathil       93/100          1          1300       750        450        500        2500       9/10      

It's Gaerdal_Ironhand's turn! What would Gaerdal_Ironhand want to do?
[A/a] attack
[S/s] Use Spells & Potions
[E/e] equip
[I/i] Party info
[MI] Monster info
[Q/q] Quit Game
Please Enter: q
Quit the game!
 Game OVer!!!
This round ends
See you next time

