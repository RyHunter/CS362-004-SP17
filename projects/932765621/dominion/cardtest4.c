#include "dominion.h" 
#include "dominion_helpers.h"
#include <string.h> 
#include <stdio.h> 
#include <assert.h> 
#include "rngs.h"
#include <stdlib.h>

int testAdventurer()
{
    struct gameState state;
    int treasure = 0,
        currPlayer = 0,
	z=20,
	temp = array[z];

    Adventurer(&state,currPlayer,treasure,silver,temp,z);
    
    assert (treasure >= 2);

    return treasure;

}

int main()
{
    testAdventurer();
    return 0;
}
