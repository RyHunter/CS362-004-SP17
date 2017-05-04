#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h> 
#include <stdio.h> 
#include <assert.h> 
#include "rngs.h"
#include <stdlib.h>

//Checks Village card

//Number of actions at the end 
//Should be num of actions in the 
//beginning + 2

void testVillage()
{
    struct gameState state;
    int start_actions = state.numActions,
        end_actions = 0,
	handPos = 0,
	start_cards = handCard(handPos, &state); 
        
	cardEffect(village,0,0,0,&state,handPos,0);
	
	int end_cards = handCard(handPos, &state);

        end_actions = state.numActions;

        assert (end_actions == (start_actions+2));
	printf("%s", "Test 1 of 2 Passed\n");

	assert (start_cards == end_cards);
	printf("%s", "Test 2 of 2 Passed \n");

}

int main()
{
    testVillage();
    return 0;
}

