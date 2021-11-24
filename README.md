# Alien GUI game

Very basic console/GUI game written in Java. This was my school work during third semester. The game is inspired
by [Zork](https://en.wikipedia.org/wiki/Zork). The base for GUI was taken from my work in second semester [here](https://github.com/marek-mikula/alien-console-adventure).

Author: [Marek Mikula](https://github.com/marek-mikula)

## Story

You are one of the main control technics on the Nostromo ship owned by space-mining company Weyland-Yutani. The Nostromo
serves a as mother ship for miners who work on the planet LV178 not too far to Nostromo. There are two groups of miners,
the first one is on the planet working, the second is resting on the mother ship. Every month there is a change between
these two groups. The day were just yesterday. You are waking up after a long day shift on the mother ship Nostromo.
Something is not right. You've been woken up by an emergency siren and a smell of burnt plastic. You should go to
command bridge and find out what is going on.

## Game modes

Available game modes are `text` and `gui`. For both modes there are different commands available (see list bellow). Mode can be
passed as a first argument when starting the game.

## How to play

You can play the game only using predefined commands. To list all available commands, use `help` command in the `text`
mode.

## Available commands

| Command name | Signature | Description | Availability
|---|---|---|---|
| Help | ```help``` | Lists all available commands. | `gui`,`text` |
| Search | ```search``` | Searches the current room and shows list of available items. | `gui`,`text` |
| Pick | ```pick {itemNumber}``` | Picks an item in the current room. | `gui`,`text` |
| Drop | ```drop {itemNumber}``` | Drops an item from inventory. | `gui`,`text` |
| Go | ```go {roomNumber OR "back"}``` | Moves Ellen to a different room. ```back``` keyword can be used. | `gui`,`text` |
| Inventory | ```inventory``` | Lists all items in the inventory. | `text` |
| Interact | ```interact {itemNumber}``` | Interacts with an item in the current room. For example terminals, etc. | `gui`,`text` |
| Map | ```map``` | Shows the map of the game, current room and possible exits. | `text` |
| Open | ```open {roomNumber} {itemNumber}``` | Opens the connection between rooms with an item from the inventory. | `gui`,`text` |
| Clear | ```clear``` | Clears the GUI console output. | `gui` |

## GUI

### GUI template

<pre>
+---------------------------------------------------------------------------+
| MenuBar                                                                   |
+-------------------------------------+-------------------------------------+
| List of exits                       |                                     |
+-------------------------------------+                                     |
| Inventory                           |                                     |
+-------------------------------------+                                     |
| Console output                      |                 Map                 |
|                                     |   +----------+                      |
|                                     |   | Player   |                      |
+------------------+------------------+   | Position |                      |
| Command bar                         |   +----------+                      |
+-------------------------------------+-------------------------------------+
</pre>

### GUI components schema

<pre>
+-------------------------------------------------------------------------------+
| VBox                                                                          |
| +---------------------------------------------------------------------------+ |
| | MenuBar                                                                   | |
| | +------------------+ +------------------+                                 | |
| | | Menu + MenuItems | | Menu + MenuItems |                                 | |
| | +------------------+ +------------------+                                 | |
| +---------------------------------------------------------------------------+ |
| +---------------------------------------------------------------------------+ |
| | HBox                                                                      | |
| | +----------------------------------+ +----------------------------------+ | |
| | | VBox                             | | AnchorPane                       | | |
| | | +------------------------------+ | | +-----------------+              | | |
| | | | TitledPane                   | | | | ImageView (map) |              | | |
| | | | +--------------------------+ | | | +-----------------+              | | |
| | | | | ListView                 | | | | +----------------------+         | | |
| | | | +--------------------------+ | | | | ImageView (position) |         | | |
| | | +------------------------------+ | | +----------------------+         | | |
| | | +------------------------------+ | |                                  | | |
| | | | TitledPane                   | | |                                  | | |
| | | | +--------------------------+ | | |                                  | | |
| | | | | FlowPane                 | | | |                                  | | |
| | | | +--------------------------+ | | |                                  | | |
| | | +------------------------------+ | |                                  | | |
| | | +------------------------------+ | |                                  | | |
| | | | TextArea                     | | |                                  | | |
| | | |                              | | |                                  | | |
| | | +------------------------------+ | |                                  | | |
| | | +------------------------------+ | |                                  | | |
| | | | TextField                    | | |                                  | | |
| | | |                              | | |                                  | | |
| | | +------------------------------+ | |                                  | | |
| | +----------------------------------+ +----------------------------------+ | |
| +---------------------------------------------------------------------------+ |
+-------------------------------------------------------------------------------+
</pre>

## Terminal GUI

If the user enters the terminal mode, new window will pop up simulating a terminal.

## Terminal GUI template

<pre>
+-------------------------------------+
| +---------------------------------+ |
| | List of possible options        | |
| |                                 | |
| |                                 | |
| +---------------------------------+ |
| +---------------------------------+ |
| | Terminal output                 | |
| |                                 | |
| |                                 | |
| +---------------------------------+ |
| +---------------------------------+ |
| | Terminal inout field            | |
| +---------------------------------+ |
+-------------------------------------+
</pre>

## Terminal GUI components schema

<pre>
+---------------------------------+
| VBox                            |
| +-----------------------------+ |
| | ListView                    | |
| |                             | |
| +-----------------------------+ |
| +-----------------------------+ |
| | TextArea                    | |
| |                             | |
| +-----------------------------+ |
| +-----------------------------+ |
| | TextField                   | |
| +-----------------------------+ |
+---------------------------------+
</pre>

## Door code GUI

If the user needs to enter a code to door, new small window will pop up.

## Door code GUI template

<pre>
+-----------------------------+
| +-------------------------+ |
| | Code output field       | |
| +-------------------------+ |
| +-------------------------+ |
| | +-----+ +-----+ +-----+ | |
| | | B7  | | B8  | | B9  | | |
| | +-----+ +-----+ +-----+ | |
| | +-----+ +-----+ +-----+ | |
| | | B4  | | B5  | | B6  | | |
| | +-----+ +-----+ +-----+ | |
| | +-----+ +-----+ +-----+ | |
| | | B1  | | B2  | | B3  | | |
| | +-----+ +-----+ +-----+ | |
| | +---------------------+ | |
| | | Enter button        | | |
| | +---------------------+ | |
| +-------------------------+ |
+-----------------------------+
</pre>

## Terminal GUI components schema

<pre>
+---------------------------------+
| VBox                            |
| +-----------------------------+ |
| | TextField                   | |
| +-----------------------------+ |
| +-----------------------------+ |
| | GridPane                    | |
| | +--------+ +--------+       | |
| | | Button | | Button |       | |
| | +--------+ +--------+ ...   | |
| +-----------------------------+ |
+---------------------------------+
</pre>