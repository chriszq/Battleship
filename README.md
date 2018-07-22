# Battleship AI Strategy
The `HuntTargetBot` will randomly search for a target on the board to hit until it hits a Ship. Upon doing so it will add the North, South, East and West points relative it and add it to a stack (provided each of the points are not out of bounds, have been already been hit, are already in the stack, etc.)

Using this strategy instead of pure random guessing can significantly reduce the number of steps it takes for the bot to sink an entire fleet.