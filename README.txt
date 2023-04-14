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

A4 uml.png: The UML diagram for our program and design

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
*************************************************
**       Welcome to the Legends of Valor      **
*************************************************
Here are warriors:
   Name                      HP              level      mana       str        agi        dex        money      exp
[ 0] Gaerdal_Ironhand          100/100         1          100        700        500        600        1354       7/10
[ 1] Sehanine_Monnbow          100/100         1          600        700        800        500        2500       8/10
[ 2] Muamman_Duathall          100/100         1          300        900        500        750        2546       6/10
[ 3] Flandal_Steelskin         100/100         1          200        750        650        700        2500       7/10
[ 4] Undefeated_Yoj            100/100         1          400        800        400        700        2500       7/10
[ 5] Eunoia_Cyn                100/100         1          400        700        800        600        2500       6/10
[ 6] Super_Mario               100/100         1          250        1000       500        650        2500       8/10
[ 7] Crown_Prince_Poo          100/100         1          500        1000       600        700        2500       6/10

Here are sorcerers:
   Name                      HP              level      mana       str        agi        dex        money      exp
[ 8] Rillifane_Rallathil       100/100         1          1300       750        450        500        2500       9/10
[ 9] Segojan_Earthcaller       100/100         1          900        800        500        650        2500       5/10
[10] Reign_Havoc               100/100         1          800        800        800        800        2500       8/10
[11] Reverie_Ashels            100/100         1          900        800        700        400        2500       7/10
[12] Kalabar                   100/100         1          800        850        400        600        2500       6/10
[13] Skye_Soar                 100/100         1          1000       700        400        500        2500       5/10
[14] Ness                      100/100         1          1100       800        600        600        2500       6/10
[15] Paula_Polestar            100/100         1          1200       700        750        750        2500       6/10

Here are paladins:
   Name                      HP              level      mana       str        agi        dex        money      exp
[16] Parzival                  100/100         1          300        750        650        700        2500       7/10
[17] Sehanine_cool             100/100         1          300        750        700        700        2500       7/10
[18] Skoraeus_Stonebones       100/100         1          250        650        600        350        2500       4/10
[19] Garl_Glittergold          100/100         1          100        600        500        400        2500       5/10
[20] Amaryllis_Astra           100/100         1          500        500        500        500        2500       5/10
[21] Caliber_Heist             100/100         1          400        400        400        400        2500       8/10
[22] Queen_Peach               100/100         1          600        800        750        800        2500       8/10
[23] Jeff_Andonuts             100/100         1          150        700        550        600        2500       6/10

You can choose 3 heroes in the game.
Please choose a hero!
Which hero you want to select? Enter the number: {6}
Super_Mario is joined to the party!!
You can choose 3 heroes in the game.
Please choose a hero!
Which hero you want to select? Enter the number: {22}
Queen_Peach is joined to the party!!
You can choose 3 heroes in the game.
Please choose a hero!
Which hero you want to select? Enter the number: {15}
Paula_Polestar is joined to the party!!
 N-N-N  N-N-N  X-X-X  N-N-N  N-N-N  X-X-X  N-N-N  N-N-N
|   M ||     ||XXXXX||   M ||     ||XXXXX||   M ||     |
 N-N-N  N-N-N  X-X-X  N-N-N  N-N-N  X-X-X  N-N-N  N-N-N
 P-P-P  B-B-B  X-X-X  B-B-B  K-K-K  X-X-X  B-B-B  B-B-B
|     ||     ||XXXXX||     ||     ||XXXXX||     ||     |
 P-P-P  B-B-B  X-X-X  B-B-B  K-K-K  X-X-X  B-B-B  B-B-B
 K-K-K  C-C-C  X-X-X  C-C-C  P-P-P  X-X-X  C-C-C  C-C-C
|     ||     ||XXXXX||     ||     ||XXXXX||     ||     |
 K-K-K  C-C-C  X-X-X  C-C-C  P-P-P  X-X-X  C-C-C  C-C-C
 K-K-K  C-C-C  X-X-X  K-K-K  B-B-B  X-X-X  K-K-K  B-B-B
|     ||     ||XXXXX||     ||     ||XXXXX||     ||     |
 K-K-K  C-C-C  X-X-X  K-K-K  B-B-B  X-X-X  K-K-K  B-B-B
 C-C-C  B-B-B  X-X-X  K-K-K  P-P-P  X-X-X  K-K-K  P-P-P
|     ||     ||XXXXX||     ||     ||XXXXX||     ||     |
 C-C-C  B-B-B  X-X-X  K-K-K  P-P-P  X-X-X  K-K-K  P-P-P
 P-P-P  B-B-B  X-X-X  C-C-C  P-P-P  X-X-X  C-C-C  P-P-P
|     ||     ||XXXXX||     ||     ||XXXXX||     ||     |
 P-P-P  B-B-B  X-X-X  C-C-C  P-P-P  X-X-X  C-C-C  P-P-P
 K-K-K  K-K-K  X-X-X  P-P-P  P-P-P  X-X-X  C-C-C  B-B-B
|     ||     ||XXXXX||     ||     ||XXXXX||     ||     |
 K-K-K  K-K-K  X-X-X  P-P-P  P-P-P  X-X-X  C-C-C  B-B-B
 N-N-N  N-N-N  X-X-X  N-N-N  N-N-N  X-X-X  N-N-N  N-N-N
|     ||H1   ||XXXXX||     ||H2   ||XXXXX||     ||H3   |
 N-N-N  N-N-N  X-X-X  N-N-N  N-N-N  X-X-X  N-N-N  N-N-N
This is your party:
   Name                      HP              level      mana       str        agi        dex        money      exp
[0]Super_Mario               100/100         1          250        1000       500        650        2500       8/10
[1]Queen_Peach               100/100         1          600        800        750        800        2500       8/10
[2]Paula_Polestar            100/100         1          1200       700        750        750        2500       6/10

What will Super_Mario (H1) do?
COMMANDS:
[W/w] up; [A/a] left; [S/s] down; [D/d] right
[T/t] teleport; [R/r] recall; [P/p] use potion; [E/e] equip weapon or armor; [I/i] info; [Pa] pass turn; [Q/q] quit
[M/m] Market
{w}
Super_Mario Str increase 20
What will Queen_Peach (H2) do?
COMMANDS:
[W/w] up; [A/a] left; [S/s] down; [D/d] right
[T/t] teleport; [R/r] recall; [P/p] use potion; [E/e] equip weapon or armor; [I/i] info; [Pa] pass turn; [Q/q] quit
[M/m] Market
{w}
What will Paula_Polestar (H3) do?
COMMANDS:
[W/w] up; [A/a] left; [S/s] down; [D/d] right
[T/t] teleport; [R/r] recall; [P/p] use potion; [E/e] equip weapon or armor; [I/i] info; [Pa] pass turn; [Q/q] quit
[M/m] Market
{w}
Paula_Polestar Dex increase 20
End of turn

Super_Mario regain MP HP
Queen_Peach regain MP HP
Paula_Polestar regain MP HP
 N-N-N  N-N-N  X-X-X  N-N-N  N-N-N  X-X-X  N-N-N  N-N-N
|     ||     ||XXXXX||     ||     ||XXXXX||     ||     |
 N-N-N  N-N-N  X-X-X  N-N-N  N-N-N  X-X-X  N-N-N  N-N-N
 P-P-P  B-B-B  X-X-X  B-B-B  K-K-K  X-X-X  B-B-B  B-B-B
|   M ||     ||XXXXX||   M ||     ||XXXXX||   M ||     |
 P-P-P  B-B-B  X-X-X  B-B-B  K-K-K  X-X-X  B-B-B  B-B-B
 K-K-K  C-C-C  X-X-X  C-C-C  P-P-P  X-X-X  C-C-C  C-C-C
|     ||     ||XXXXX||     ||     ||XXXXX||     ||     |
 K-K-K  C-C-C  X-X-X  C-C-C  P-P-P  X-X-X  C-C-C  C-C-C
 K-K-K  C-C-C  X-X-X  K-K-K  B-B-B  X-X-X  K-K-K  B-B-B
|     ||     ||XXXXX||     ||     ||XXXXX||     ||     |
 K-K-K  C-C-C  X-X-X  K-K-K  B-B-B  X-X-X  K-K-K  B-B-B
 C-C-C  B-B-B  X-X-X  K-K-K  P-P-P  X-X-X  K-K-K  P-P-P
|     ||     ||XXXXX||     ||     ||XXXXX||     ||     |
 C-C-C  B-B-B  X-X-X  K-K-K  P-P-P  X-X-X  K-K-K  P-P-P
 P-P-P  B-B-B  X-X-X  C-C-C  P-P-P  X-X-X  C-C-C  P-P-P
|     ||     ||XXXXX||     ||     ||XXXXX||     ||     |
 P-P-P  B-B-B  X-X-X  C-C-C  P-P-P  X-X-X  C-C-C  P-P-P
 K-K-K  K-K-K  X-X-X  P-P-P  P-P-P  X-X-X  C-C-C  B-B-B
|     ||H1   ||XXXXX||     ||H2   ||XXXXX||     ||H3   |
 K-K-K  K-K-K  X-X-X  P-P-P  P-P-P  X-X-X  C-C-C  B-B-B
 N-N-N  N-N-N  X-X-X  N-N-N  N-N-N  X-X-X  N-N-N  N-N-N
|     ||     ||XXXXX||     ||     ||XXXXX||     ||     |
 N-N-N  N-N-N  X-X-X  N-N-N  N-N-N  X-X-X  N-N-N  N-N-N
...

### Check Hero Info
What will Super_Mario (H1) do?
COMMANDS:
[W/w] up; [A/a] left; [S/s] down; [D/d] right
[T/t] teleport; [R/r] recall; [P/p] use potion; [E/e] equip weapon or armor; [I/i] info; [Pa] pass turn; [Q/q] quit
{i}
Super_Mario               100/100         1          275        1020       500        650        2500       8/10
What will Super_Mario (H1) do?
...

### Market
What will Queen_Peach (H2) do?
COMMANDS:
[W/w] up; [A/a] left; [S/s] down; [D/d] right
[T/t] teleport; [R/r] recall; [P/p] use potion; [E/e] equip weapon or armor; [I/i] info; [Pa] pass turn; [Q/q] quit
[M/m] Market
{m}
Queen_Peach goes in to Market!
*************************************************
**           Welcome to the Market             **
*************************************************
What would Queen_Peach want to do?
[A/a] buy items
[S/s] sell items
[L/l] leave
Please Enter: {a}
Here are Weapons:
     name       price      level      damage_val      requireHands
[ 0] Sword      500        1          800             1
[ 1] Bow        300        2          500             2
[ 2] Scythe     1000       6          1100            2
[ 3] Axe        550        5          850             1
[ 4] TSwords    1400       8          1600            2
[ 5] Dagger     200        1          250             1

Here are Armors:
     name                 price      level      reduction
[ 6] Platinum_Shield      150        1          200
[ 7] Breastplate          350        3          600
[ 8] Full_Body_Armor      1000       8          1100
[ 9] Wizard_Shield        1200       10         1500
[10] Guardian_Angel       1000       10         1000

Here are Potions:
     name                 price      level      attribute_increase   attributes
[11] Healing_Potion       250        1          100                  [Health]
[12] Magic_Potion         350        2          100                  [Mana]
[13] Luck_Elixir          500        4          65                   [Agility]
[14] Mermaid_Tears        850        5          100                  [Health, Mana, Strength, Agility]
[15] Ambrosia             1000       8          150                  [Health, Mana, Strength, Dexterity, Defense, Agility]

Here are Spells:
     name                 price      level      damage     mana_cost  spellType
[16] Flame_Tornado        700        4          850        300        FireSpell
[17] Breath_of_Fire       350        1          450        100        FireSpell
[18] Heat_Wave            450        2          600        150        FireSpell
[19] Lava_Comet           800        7          1000       550        FireSpell
[20] Hell_Storm           600        3          950        600        FireSpell
[21] PK_Fire              500        5          900        450        FireSpell
[22] Snow_Cannon          500        2          650        250        IceSpell
[23] Ice_Blade            250        1          450        100        IceSpell
[24] Frost_Blizzard       750        5          850        350        IceSpell
[25] Arctic_Storm         700        6          800        300        IceSpell
[26] PK_Freeze            600        7          1000       400        IceSpell
[27] Lightning_Dagger     400        1          500        150        LightingSpell
[28] Thunder_Blast        750        4          950        400        LightingSpell
[29] Electric_Arrows      550        5          650        200        LightingSpell
[30] Spark_Needles        500        2          600        200        LightingSpell
[31] PK_Thunder           650        6          1100       400        LightingSpell

Which item do Queen_Peach wants to buy? current remain money 2500
If you don't want to buy, press [L/l]: leave, [I/i] see all items. Please Enter the number:
[L/l]: leave
[I/i] see all items
Please Enter the number: {17}
Queen_Peach successfully spent 350 dollar on Breath_of_Fire
Does Queen_Peach still have items to buy?
[S/s] stay in the market
[L/l] leave. Please enter:
Please enter: {l}
What will Queen_Peach (H2) do?
...

### Equip Armour
What will Paula_Polestar (H3) do?
COMMANDS:
[W/w] up; [A/a] left; [S/s] down; [D/d] right
[T/t] teleport; [R/r] recall; [P/p] use potion; [E/e] equip weapon or armor; [I/i] info; [Pa] pass turn; [Q/q] quit
[M/m] Market
{e}

 Here are equipments Paula_Polestar have:
Here are Armors:
     name                 price      level      reduction
[ 0] Platinum_Shield      150        1          200

Which equipment should Paula_Polestar equip?
[I/i] info
[L/l] leave
[Q/q] quit
Please Enter the number: {0}
Paula_Polestar equips Platinum_Shield
...

### Use Potion
What will Super_Mario (H1) do?
COMMANDS:
[W/w] up; [A/a] left; [S/s] down; [D/d] right
[T/t] teleport; [R/r] recall; [P/p] use potion; [E/e] equip weapon or armor; [I/i] info; [Pa] pass turn; [Q/q] quit
[At] attack the monster
[Sp] use spell on monster
{p}

Here are Super_Mario have:
Here are Potions:
     name                 price      level      attribute_increase   attributes
[ 0] Strength_Potion      200        1          75                   [Strength]

Which Potion should Super_Mario use?
[I/i] info
[L/l] leave
[Q/q] quit
Please Enter the number: {0}

Super_Mario use Strength_Potion potion

Super_Mario Str increase 75
...

### Use Spell


### Attack
What will Super_Mario (H1) do?
COMMANDS:
[W/w] up; [A/a] left; [S/s] down; [D/d] right
[T/t] teleport; [R/r] recall; [P/p] use potion; [E/e] equip weapon or armor; [I/i] info; [Pa] pass turn; [Q/q] quit
[At] attack the monster
[Sp] use spell on monster
{at}
Super_Mario attacks Casper and causes 48 damage!
Casper now has only left 52 HP
...

### Teleport
 N-N-N  N-N-N  X-X-X  N-N-N  N-N-N  X-X-X  N-N-N  N-N-N
|     ||     ||XXXXX||     ||     ||XXXXX||     ||     |
 N-N-N  N-N-N  X-X-X  N-N-N  N-N-N  X-X-X  N-N-N  N-N-N
 P-P-P  B-B-B  X-X-X  B-B-B  K-K-K  X-X-X  B-B-B  B-B-B
|     ||     ||XXXXX||     ||     ||XXXXX||     ||     |
 P-P-P  B-B-B  X-X-X  B-B-B  K-K-K  X-X-X  B-B-B  B-B-B
 K-K-K  C-C-C  X-X-X  C-C-C  P-P-P  X-X-X  C-C-C  C-C-C
|   M ||     ||XXXXX||   M ||     ||XXXXX||   M ||     |
 K-K-K  C-C-C  X-X-X  C-C-C  P-P-P  X-X-X  C-C-C  C-C-C
 K-K-K  C-C-C  X-X-X  K-K-K  B-B-B  X-X-X  K-K-K  B-B-B
|     ||     ||XXXXX||     ||     ||XXXXX||     ||     |
 K-K-K  C-C-C  X-X-X  K-K-K  B-B-B  X-X-X  K-K-K  B-B-B
 C-C-C  B-B-B  X-X-X  K-K-K  P-P-P  X-X-X  K-K-K  P-P-P
|     ||     ||XXXXX||     ||     ||XXXXX||     ||     |
 C-C-C  B-B-B  X-X-X  K-K-K  P-P-P  X-X-X  K-K-K  P-P-P
 P-P-P  B-B-B  X-X-X  C-C-C  P-P-P  X-X-X  C-C-C  P-P-P
|     ||     ||XXXXX||     ||H2   ||XXXXX||     ||H3   |
 P-P-P  B-B-B  X-X-X  C-C-C  P-P-P  X-X-X  C-C-C  P-P-P
 K-K-K  K-K-K  X-X-X  P-P-P  P-P-P  X-X-X  C-C-C  B-B-B
|     ||     ||XXXXX||     ||     ||XXXXX||     ||     |
 K-K-K  K-K-K  X-X-X  P-P-P  P-P-P  X-X-X  C-C-C  B-B-B
 N-N-N  N-N-N  X-X-X  N-N-N  N-N-N  X-X-X  N-N-N  N-N-N
|     ||H1   ||XXXXX||     ||     ||XXXXX||     ||     |
 N-N-N  N-N-N  X-X-X  N-N-N  N-N-N  X-X-X  N-N-N  N-N-N
...
What will Super_Mario (H1) do?
COMMANDS:
[W/w] up; [A/a] left; [S/s] down; [D/d] right
[T/t] teleport; [R/r] recall; [P/p] use potion; [E/e] equip weapon or armor; [I/i] info; [Pa] pass turn; [Q/q] quit
[M/m] Market
{t}
Where do you want to teleport?
please enter the position(x, y)?
{4 2}
...
 N-N-N  N-N-N  X-X-X  N-N-N  N-N-N  X-X-X  N-N-N  N-N-N
|     ||     ||XXXXX||     ||     ||XXXXX||     ||     |
 N-N-N  N-N-N  X-X-X  N-N-N  N-N-N  X-X-X  N-N-N  N-N-N
 P-P-P  B-B-B  X-X-X  B-B-B  K-K-K  X-X-X  B-B-B  B-B-B
|     ||     ||XXXXX||     ||     ||XXXXX||     ||     |
 P-P-P  B-B-B  X-X-X  B-B-B  K-K-K  X-X-X  B-B-B  B-B-B
 K-K-K  C-C-C  X-X-X  C-C-C  P-P-P  X-X-X  C-C-C  C-C-C
|     ||     ||XXXXX||   M ||H1   ||XXXXX||     ||     |
 K-K-K  C-C-C  X-X-X  C-C-C  P-P-P  X-X-X  C-C-C  C-C-C
 K-K-K  C-C-C  X-X-X  K-K-K  B-B-B  X-X-X  K-K-K  B-B-B
|   M ||     ||XXXXX||     ||     ||XXXXX||   M ||     |
 K-K-K  C-C-C  X-X-X  K-K-K  B-B-B  X-X-X  K-K-K  B-B-B
 C-C-C  B-B-B  X-X-X  K-K-K  P-P-P  X-X-X  K-K-K  P-P-P
|     ||     ||XXXXX||     ||     ||XXXXX||     ||     |
 C-C-C  B-B-B  X-X-X  K-K-K  P-P-P  X-X-X  K-K-K  P-P-P
 P-P-P  B-B-B  X-X-X  C-C-C  P-P-P  X-X-X  C-C-C  P-P-P
|     ||     ||XXXXX||     ||     ||XXXXX||     ||     |
 P-P-P  B-B-B  X-X-X  C-C-C  P-P-P  X-X-X  C-C-C  P-P-P
 K-K-K  K-K-K  X-X-X  P-P-P  P-P-P  X-X-X  C-C-C  B-B-B
|     ||     ||XXXXX||     ||H2   ||XXXXX||     ||H3   |
 K-K-K  K-K-K  X-X-X  P-P-P  P-P-P  X-X-X  C-C-C  B-B-B
 N-N-N  N-N-N  X-X-X  N-N-N  N-N-N  X-X-X  N-N-N  N-N-N
|     ||     ||XXXXX||     ||     ||XXXXX||     ||     |
 N-N-N  N-N-N  X-X-X  N-N-N  N-N-N  X-X-X  N-N-N  N-N-N
...

### Recall
 N-N-N  N-N-N  X-X-X  N-N-N  N-N-N  X-X-X  N-N-N  N-N-N
|     ||     ||XXXXX||     ||     ||XXXXX||     ||     |
 N-N-N  N-N-N  X-X-X  N-N-N  N-N-N  X-X-X  N-N-N  N-N-N
 B-B-B  K-K-K  X-X-X  K-K-K  P-P-P  X-X-X  B-B-B  C-C-C
|   M ||H2   ||XXXXX||   M ||H1   ||XXXXX||   M ||     |
 B-B-B  K-K-K  X-X-X  K-K-K  P-P-P  X-X-X  B-B-B  C-C-C
 P-P-P  P-P-P  X-X-X  C-C-C  P-P-P  X-X-X  B-B-B  P-P-P
|     ||     ||XXXXX||     ||     ||XXXXX||     ||     |
 P-P-P  P-P-P  X-X-X  C-C-C  P-P-P  X-X-X  B-B-B  P-P-P
 C-C-C  B-B-B  X-X-X  P-P-P  B-B-B  X-X-X  K-K-K  C-C-C
|     ||     ||XXXXX||     ||     ||XXXXX||     ||     |
 C-C-C  B-B-B  X-X-X  P-P-P  B-B-B  X-X-X  K-K-K  C-C-C
 K-K-K  P-P-P  X-X-X  B-B-B  K-K-K  X-X-X  K-K-K  P-P-P
|     ||     ||XXXXX||     ||     ||XXXXX||     ||     |
 K-K-K  P-P-P  X-X-X  B-B-B  K-K-K  X-X-X  K-K-K  P-P-P
 K-K-K  B-B-B  X-X-X  B-B-B  C-C-C  X-X-X  P-P-P  B-B-B
|     ||     ||XXXXX||     ||     ||XXXXX||     ||     |
 K-K-K  B-B-B  X-X-X  B-B-B  C-C-C  X-X-X  P-P-P  B-B-B
 C-C-C  C-C-C  X-X-X  K-K-K  K-K-K  X-X-X  C-C-C  C-C-C
|     ||     ||XXXXX||     ||     ||XXXXX||     ||H3   |
 C-C-C  C-C-C  X-X-X  K-K-K  K-K-K  X-X-X  C-C-C  C-C-C
 N-N-N  N-N-N  X-X-X  N-N-N  N-N-N  X-X-X  N-N-N  N-N-N
|     ||     ||XXXXX||     ||     ||XXXXX||     ||     |
 N-N-N  N-N-N  X-X-X  N-N-N  N-N-N  X-X-X  N-N-N  N-N-N
...
What will Super_Mario (H1) do?
COMMANDS:
[W/w] up; [A/a] left; [S/s] down; [D/d] right
[T/t] teleport; [R/r] recall; [P/p] use potion; [E/e] equip weapon or armor; [I/i] info; [Pa] pass turn; [Q/q] quit
[At] attack the monster
[Sp] use spell on monster
{r}
...
 N-N-N  N-N-N  X-X-X  N-N-N  N-N-N  X-X-X  N-N-N  N-N-N
|     ||     ||XXXXX||     ||     ||XXXXX||     ||     |
 N-N-N  N-N-N  X-X-X  N-N-N  N-N-N  X-X-X  N-N-N  N-N-N
 B-B-B  K-K-K  X-X-X  K-K-K  P-P-P  X-X-X  B-B-B  C-C-C
|   M ||H2   ||XXXXX||     ||     ||XXXXX||     ||     |
 B-B-B  K-K-K  X-X-X  K-K-K  P-P-P  X-X-X  B-B-B  C-C-C
 P-P-P  P-P-P  X-X-X  C-C-C  P-P-P  X-X-X  B-B-B  P-P-P
|     ||     ||XXXXX||   M ||     ||XXXXX||   M ||     |
 P-P-P  P-P-P  X-X-X  C-C-C  P-P-P  X-X-X  B-B-B  P-P-P
 C-C-C  B-B-B  X-X-X  P-P-P  B-B-B  X-X-X  K-K-K  C-C-C
|     ||     ||XXXXX||     ||     ||XXXXX||     ||     |
 C-C-C  B-B-B  X-X-X  P-P-P  B-B-B  X-X-X  K-K-K  C-C-C
 K-K-K  P-P-P  X-X-X  B-B-B  K-K-K  X-X-X  K-K-K  P-P-P
|     ||     ||XXXXX||     ||     ||XXXXX||     ||     |
 K-K-K  P-P-P  X-X-X  B-B-B  K-K-K  X-X-X  K-K-K  P-P-P
 K-K-K  B-B-B  X-X-X  B-B-B  C-C-C  X-X-X  P-P-P  B-B-B
|     ||     ||XXXXX||     ||     ||XXXXX||     ||H3   |
 K-K-K  B-B-B  X-X-X  B-B-B  C-C-C  X-X-X  P-P-P  B-B-B
 C-C-C  C-C-C  X-X-X  K-K-K  K-K-K  X-X-X  C-C-C  C-C-C
|     ||     ||XXXXX||     ||     ||XXXXX||     ||     |
 C-C-C  C-C-C  X-X-X  K-K-K  K-K-K  X-X-X  C-C-C  C-C-C
 N-N-N  N-N-N  X-X-X  N-N-N  N-N-N  X-X-X  N-N-N  N-N-N
|     ||H1   ||XXXXX||     ||     ||XXXXX||     ||     |
 N-N-N  N-N-N  X-X-X  N-N-N  N-N-N  X-X-X  N-N-N  N-N-N
...

### Pass Turn
What will Super_Mario (H1) do?
COMMANDS:
[W/w] up; [A/a] left; [S/s] down; [D/d] right
[T/t] teleport; [R/r] recall; [P/p] use potion; [E/e] equip weapon or armor; [I/i] info; [Pa] pass turn; [Q/q] quit
{pa}
Passing Super_Mario's turn.
What will Queen_Peach (H2) do?
...

### Losing a game
Natsunomeryu has reached the Heroes' Nexus.
Monsters win!
GAME OVER

### Winning a game
 N-N-N  N-N-N  X-X-X  N-N-N  N-N-N  X-X-X  N-N-N  N-N-N
|     ||     ||XXXXX||     ||     ||XXXXX||     ||     |
 N-N-N  N-N-N  X-X-X  N-N-N  N-N-N  X-X-X  N-N-N  N-N-N
 B-B-B  K-K-K  X-X-X  K-K-K  P-P-P  X-X-X  B-B-B  C-C-C
|     ||H2   ||XXXXX||     ||     ||XXXXX||     ||     |
 B-B-B  K-K-K  X-X-X  K-K-K  P-P-P  X-X-X  B-B-B  C-C-C
 P-P-P  P-P-P  X-X-X  C-C-C  P-P-P  X-X-X  B-B-B  P-P-P
|     ||     ||XXXXX||H1   ||     ||XXXXX||     ||     |
 P-P-P  P-P-P  X-X-X  C-C-C  P-P-P  X-X-X  B-B-B  P-P-P
 C-C-C  B-B-B  X-X-X  P-P-P  B-B-B  X-X-X  K-K-K  C-C-C
|     ||     ||XXXXX||     ||     ||XXXXX||     ||     |
 C-C-C  B-B-B  X-X-X  P-P-P  B-B-B  X-X-X  K-K-K  C-C-C
 K-K-K  P-P-P  X-X-X  B-B-B  K-K-K  X-X-X  K-K-K  P-P-P
|     ||     ||XXXXX||     ||     ||XXXXX||   M ||H3   |
 K-K-K  P-P-P  X-X-X  B-B-B  K-K-K  X-X-X  K-K-K  P-P-P
 K-K-K  B-B-B  X-X-X  B-B-B  C-C-C  X-X-X  P-P-P  B-B-B
|     ||     ||XXXXX||     ||     ||XXXXX||     ||     |
 K-K-K  B-B-B  X-X-X  B-B-B  C-C-C  X-X-X  P-P-P  B-B-B
 C-C-C  C-C-C  X-X-X  K-K-K  K-K-K  X-X-X  C-C-C  C-C-C
|     ||     ||XXXXX||     ||     ||XXXXX||     ||     |
 C-C-C  C-C-C  X-X-X  K-K-K  K-K-K  X-X-X  C-C-C  C-C-C
 N-N-N  N-N-N  X-X-X  N-N-N  N-N-N  X-X-X  N-N-N  N-N-N
|     ||     ||XXXXX||     ||     ||XXXXX||     ||     |
 N-N-N  N-N-N  X-X-X  N-N-N  N-N-N  X-X-X  N-N-N  N-N-N
...
What will Queen_Peach (H2) do?
COMMANDS:
[W/w] up; [A/a] left; [S/s] down; [D/d] right
[T/t] teleport; [R/r] recall; [P/p] use potion; [E/e] equip weapon or armor; [I/i] info; [Pa] pass turn; [Q/q] quit
{w}
Queen_Peach Str increase -20
Queen_Peach has reached the Monsters' Nexus.
YOU WIN!
See you next time
