#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h> 
#include <stdio.h> 
#include <assert.h> 
#include "rngs.h"
#include <stdlib.h>


void testSmithy()
{
    struct gameState state;
    int handPos = 0;
    int currPlayer = 0;

    int start = state.deckCount[currPlayer];
    int end = 0;

    _smithy(currPlayer, &state, handPos);
    end = state.deckCount[currPlayer];
    
    assert (end == (start+3));
    printf("%s", "Test Passed");

}

int main()
{
    testSmithy();
    return 0;
}
