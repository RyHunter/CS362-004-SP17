#include "dominion.h" 
#include "dominion_helpers.h" 
#include <string.h> 
#include <stdio.h> 
#include <assert.h> 
#include "rngs.h" 
#include <stdlib.h>



void testCouncil()
{
    struct gameState state;
    int cards_start = 0,
        cards_end = 0,
        buys_start = 0,
        buys_end = 0;

    	_council_room(&state,0);
	
    	cards_end = state.deckCount[0];
 	buys_end = state.numBuys;

    	assert (buys_end == (buys_start+1));
	printf("%s\n", "Test 1 of 2 Passed");

	assert (cards_end == (cards_start+4));
        printf("%s\n", "Test 2 of 2 Passed");

}

int main()
{
    testCouncil();
    return 0;
}
