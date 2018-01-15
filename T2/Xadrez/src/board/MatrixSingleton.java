package board;

import peca.Bispo;
import peca.Cavalo;
import peca.Dama;
import peca.Peao;
import peca.Rei;
import peca.Torre;

public class MatrixSingleton 
{
	static private Tile[][] boardMatrix = null;

	private MatrixSingleton()
	{
		
		MatrixSingleton.boardMatrix = new Tile[8][8];

		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				boardMatrix[i][j] = new Tile();
			}
		}
	
		// Create White
		boardMatrix[0][7].piece = new Torre('b');
		boardMatrix[1][7].piece = new Cavalo('b');
		boardMatrix[2][7].piece = new Bispo('b');
		boardMatrix[4][7].piece = new Rei('b');
		boardMatrix[3][7].piece = new Dama('b');
		boardMatrix[5][7].piece = new Bispo('b');
		boardMatrix[6][7].piece = new Cavalo('b');
		boardMatrix[7][7].piece = new Torre('b');
		
		for(int i = 0; i < 8; i++)
		{
			boardMatrix[i][6].piece = new Peao('b');
		}
		
		// Create Black
		boardMatrix[0][0].piece = new Torre('p');
		boardMatrix[1][0].piece = new Cavalo('p');
		boardMatrix[2][0].piece = new Bispo('p');
		boardMatrix[4][0].piece = new Rei('p');
		boardMatrix[3][0].piece = new Dama('p');
		boardMatrix[5][0].piece = new Bispo('p');
		boardMatrix[6][0].piece = new Cavalo('p');
		boardMatrix[7][0].piece = new Torre('p');
		
		for(int i = 0; i < 8; i++)
		{
			boardMatrix[i][1].piece = new Peao('p');
		}
	}
	
	public static Tile[][] getMatrix()
	{
		if(MatrixSingleton.boardMatrix == null)
			new MatrixSingleton();
		
		return MatrixSingleton.boardMatrix;
	}

}
