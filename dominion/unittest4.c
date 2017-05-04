#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include "assert.h"
#include "dominion.h"
#include "rngs.h"

//Checks that the right hand is played 

//Creates a new game state object
//Creates a 'hand' variable for a player
//Calls handCard 
//Compares the two values 

//Results should be equal to pass

void testHandCard()
{
    srand(time(NULL));

    int handPos=0,
        currentPlayer = 0,
        handNum = rand();

	struct gameState state;

	state.hand[currentPlayer][handPos] = handNum;
	state.whoseTurn = 0;

    	assert(handCard(handPos, &state) == handNum);

	printf("%s\n", "Test passed");
}


int main()
{
    testHandCard();
    return 0;
}

