


#include "SudokuSolver.h"

int[][] *boardArray = NULL;

int getBoard(int[ARRAY_LENGTH][ARRAY_LENGTH] board)
{
	*boardArray = malloc(sizeof(int) * 81);
	setBoardToNull();
}

void setBoardToNull()
{
	int i,j;
	for(i = 0; i < ARRAY_LENGTH + 1; i++)
	{
		for(j=0; j<ARRAY_LENGTH+1; j++)
		{
			boardArray[i][j] = NULL;
		}
	}
}

int printBoard() {
	int i, j;
	if(*boardArray != NULL)
	{
		for(i = 0; i < ARRAY_LENGTH+1; i++)
		{
			for(j = 0; j < ARRAY_LENGTH+1; j++)
			{
				if(boardArray[i][j] == NULL)
				{
					break;
				} else
				{
					printf("%i|", boardArray[i][j]);
				}
			}
			printf("\n");
		}
	}
}


void clearData()
{
	int i, j;
	for(i=0; i<ARRAY_LENGTH; i++)
	{
		for(j=0; j<ARRAY_LENGTH; j++)
		{
			free(boardArray[i][j]);
		}
	}
	free(boardArray);
}



