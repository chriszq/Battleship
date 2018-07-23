# Battleship Bot Strategy
The `HuntTargetBot` will randomly search for a target on the board to hit until it hits a Ship. Upon doing so it will add the Northern, Southern, Eastern and Western points relative to it and add them to a stack (provided each point is not out of bounds, have been already been hit, already in the stack, etc.)

Using this strategy instead of pure random guessing can noticeably reduce the number of steps it takes for the bot to sink an entire fleet.

# Example
```
     0 1 2 3 4 5 6 7 8 9
_______________________
0 | - - - - - - - - - -
1 | - - - - - - - - - -
2 | o o o - o - - - - -
3 | - - - o o - - - - -
4 | - - - o o - - - - -
5 | - - - o o - - - - -
6 | - - - o o - - - - -
7 | - - - - - - - - - -
8 | - - - o o - - - - -
9 | - - - o o o - - - -
```
## Using the HuntTargetBot
See all the steps [here](https://gist.githubusercontent.com/chriszq/1b51a8c5ff210e4858fa4499e90f4b9a/raw/5027241f778a94cdd3c4e17a9d90d7e5a0a0f4b3/BattleshipHuntTargetBotDemo.txt)
```
stack: []
randoming target...
    0 1 2 3 4 5 6 7 8 9
_______________________
0 | - - - - - - - - - -
1 | - - - - - - - - - -
2 | o o o - o - - - - -
3 | - - - o ! - - - - -
4 | - - - o o - - - - -
5 | - - - o o - - - - -
6 | - - - o o - - - - -
7 | - - - - - - - - - -
8 | - - - o o - - - - -
9 | - - - o o o - - - -

stack: [java.awt.Point[x=4,y=4], java.awt.Point[x=4,y=2], java.awt.Point[x=5,y=3], java.awt.Point[x=3,y=3]]
popping target from stack...
    0 1 2 3 4 5 6 7 8 9
_______________________
0 | - - - - - - - - - -
1 | - - - - - - - - - -
2 | o o o - o - - - - -
3 | - - - ! ! - - - - -
4 | - - - o o - - - - -
5 | - - - o o - - - - -
6 | - - - o o - - - - -
7 | - - - - - - - - - -
8 | - - - o o - - - - -
9 | - - - o o o - - - -

stack: [java.awt.Point[x=4,y=4], java.awt.Point[x=4,y=2], java.awt.Point[x=5,y=3], java.awt.Point[x=3,y=4], java.awt.Point[x=3,y=2], java.awt.Point[x=2,y=3]]

...

stack: [java.awt.Point[x=2,y=2]]
popping target from stack...
bot2 has sunk bot1's Submarine
    0 1 2 3 4 5 6 7 8 9
_______________________
0 | x - - x - - x x x x
1 | x x - x x x x - x x
2 | @ @ @ x @ x x - x -
3 | x x x @ @ x - x x x
4 | x - x @ @ x x x - x
5 | x - x @ @ x x - x x
6 | - x x @ @ x x - x x
7 | x - x x x - x - - x
8 | x - x @ @ x x x - -
9 | - - x @ @ @ x x x x
```
That took 76 shots

## Using the Random Bot
See all the steps [here](https://gist.githubusercontent.com/chriszq/1b51a8c5ff210e4858fa4499e90f4b9a/raw/5027241f778a94cdd3c4e17a9d90d7e5a0a0f4b3/BattleshipRandomBotDemo.txt)
```
    0 1 2 3 4 5 6 7 8 9
_______________________
0 | - - - - - - - - - -
1 | - - - - x - - - - -
2 | o o o - o - - - - -
3 | - - - o o - - - - -
4 | - - - o o - - - - -
5 | - - - o o - - - - -
6 | - - - o o - - - - -
7 | - - - - - - - - - -
8 | - - - o o - - - - -
9 | - - - o o o - - - -

    0 1 2 3 4 5 6 7 8 9
_______________________
0 | - - - - - - - - - -
1 | - - x - x - - - - -
2 | o o o - o - - - - -
3 | - - - o o - - - - -
4 | - - - o o - - - - -
5 | - - - o o - - - - -
6 | - - - o o - - - - -
7 | - - - - - - - - - -
8 | - - - o o - - - - -
9 | - - - o o o - - - -

    0 1 2 3 4 5 6 7 8 9
_______________________
0 | - - - - - - - - - -
1 | - - x - x - - - - -
2 | o o o - o - - - - -
3 | - - - o o - - - - -
4 | - - - o o - - - - -
5 | - - - o o - - - - -
6 | - - - o o x - - - -
7 | - - - - - - - - - -
8 | - - - o o - - - - -
9 | - - - o o o - - - -

...

bot2 has sunk your Battleship
    0 1 2 3 4 5 6 7 8 9
_______________________
0 | x x x x x x x x x x
1 | x x x x x x x x x x
2 | @ @ @ x @ - x x x x
3 | x x x @ @ x x x x x
4 | x x x @ @ x x x x x
5 | x - x @ @ x x x x x
6 | x x x @ @ x x x x x
7 | x x x x x x - - x x
8 | x - x @ @ x x x x x
9 | x x x @ @ @ x x x x
```
That took 95 steps, 19 steps more than the `HuntTargetBot`.
