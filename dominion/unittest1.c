#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"

#define DEBUG 0
#define NOISY_TEST 1

int main() 
{
	assert (getCost(adventurer) == 6);
	assert (getCost(curse) == 0);
	assert (getCost(duchy) == 5);
	assert (getCost(province) == 8);
	assert (getCost(feast) == 4);
	assert (getCost(mine) == 5);
	assert (getCost(smithy) == 4);
	assert (getCost(baron) == 4);
	assert (getCost(minion) == 5);
	assert (getCost(cutpurse) == 4);
	assert (getCost(salvager) == 4);
	assert (getCost(treasure_map) == 4);
	assert (getCost(estate) == 2);
        assert (getCost(copper) == 0);
        assert (getCost(silver) == 3);
        assert (getCost(gold) == 6);
	assert (getCost(council_room) == 5);
        assert (getCost(gardens) == 4);
        assert (getCost(remodel) == 4);
        assert (getCost(village) == 3);
        assert (getCost(great_hall) == 3);
        assert (getCost(steward) == 3);
        assert (getCost(tribute) == 5);
        assert (getCost(ambassador) == 3);
	assert (getCost(embargo) == 2);
        assert (getCost(outpost) == 5);
        assert (getCost(sea_hag) == 4);	



	printf("All tests pass\n");


	return 0;
}
