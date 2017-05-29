#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include <assert.h>
#include "dominion.h"
#include "rngs.h"


int main()
{
    	struct gameState state;

    	int turn = 0,
    		s = 0,
		i = 0;

    	for (i = 0; i < 20; i++)
    	{
        	state.whoseTurn = turn;
        	s = whoseTurn(&state);
        	assert(s==turn);
        	turn++;
   	 }

	printf("%s","All tests pass\n");
	return 0;
}

