#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h> 
#include <stdio.h> 
#include <assert.h> 
#include "rngs.h"
#include <stdlib.h>

//Checks that playing Smithy 
//adds 3 cards to player's hand
//
//Compares hand before Smithy 
//to hand after Smithy
//
//Player should have +3 cards

void testSmithy()
{
    struct gameState state;
    int handPos = 0;
    int currPlayer = 0;

    int start = state.deckCount[currPlayer];
    int end = 0;

    Smithy(&state, currPlayer, handPos);
    end = state.deckCount[currPlayer];
    
    assert (end == (start+3));
    printf("%s", "Test Passed");

}

int main()
{
    testSmithy();
    return 0;
}

