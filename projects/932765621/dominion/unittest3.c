#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include "assert.h"
#include "dominion.h"
#include "rngs.h"

//Checks that game is successfully initialized
//
//In the first case, the correct number of players is passed
//Function should successfully initialize
//
//In the second case, wrong numbers are passed
//So game should fail to initialize

int main()
{
    	struct gameState state;
    	int k[10] = {1,2,3,4,5,6,7,8,9,10};

	int i = 0;

	for (i=2;i<5;i++)
	{
		int f = initializeGame(i,k,5,&state);
		assert(f==0);
	}	

	i = 0;

	printf("%s", "Test 1 of 3 Pass\n");

	for (i=5;i<50;i++)
	{
		int g = initializeGame(i,k,5,&state);
		assert(g!=0);
	}

	printf("%s", "Test 2 of 3 Pass\n");

	int h = initializeGame(1,k,5,&state);
	assert (h!=0);
		
	printf("%s", "Test 3 of 3 Pass\n");
	
    	return 0;
}

