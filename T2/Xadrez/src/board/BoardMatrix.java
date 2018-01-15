package board;
import java.awt.Image;
import java.util.ArrayList;

import peca.*;


public class BoardMatrix
{
	public Tile[][] boardMatrix;
		
	public BoardMatrix()
	{		
		boardMatrix = MatrixSingleton.getMatrix();
	}
	
	public Peca swap(Coordinate to, Coordinate from)
	{
		Peca p = boardMatrix[to.getX()][to.getY()].piece;
		boardMatrix[to.getX()][to.getY()].piece = boardMatrix[from.getX()][from.getY()].piece;
		boardMatrix[to.getX()][to.getY()].piece.hasMoved = true;
		boardMatrix[from.getX()][from.getY()].piece = null;		
		return p;
	}
	
	public void swap(int toX, int toY, int fromX, int fromY)
	{
		boardMatrix[toX][toY].piece = boardMatrix[fromX][fromY].piece;
		boardMatrix[toX][toY].piece.hasMoved = true;
		boardMatrix[fromX][fromY].piece = null;
	}
	
	public char getPieceColor(int x, int y)
	{
		return boardMatrix[x][y].piece.getColor();
	}
	
	public char getPieceColor(Coordinate c)
	{
		return boardMatrix[c.getX()][c.getY()].piece.getColor();
	}	
	
	public Peca getPiece(int x, int y)
	{
		return boardMatrix[x][y].piece;
	}
	
	public Peca getPiece(Coordinate c)
	{
		return boardMatrix[c.getX()][c.getY()].piece;
	}	
	
	public boolean isEmpty (int x, int y)
	{
		if(boardMatrix[x][y].piece == null)
			return true;
		
		return false;
	}
	
	public boolean isEmpty (Coordinate c)
	{
		if( boardMatrix[c.getX()][c.getY()].piece == null )
			return true;
		
		return false;
	}

	public boolean isHighlighted (int x, int y)
	{
		return boardMatrix[x][y].highlighted;
	}
	
	public boolean isHighlighted (Coordinate c)
	{
		return boardMatrix[c.getX()][c.getY()].highlighted;
	}
	
	public void highlight (int x, int y)
	{
		boardMatrix[x][y].highlighted = true;
	}
	
	public void highlight (Coordinate c)
	{
		boardMatrix[c.getX()][c.getY()].highlighted = true;
	}
	
	public void highlight (ArrayList<Coordinate> l)
	{
		for(int i = 0; i < l.size(); i++)
		{
			highlight(l.get(i));
		}
	}
	
	public void unHighlightAll()
	{
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				boardMatrix[i][j].highlighted = false;
			}
		}
	}
	
	public Image getSprite(int x, int y)
	{
		return boardMatrix[x][y].piece.getSprite(); 
	}
	
	public Image getSprite(Coordinate c)
	{
		return boardMatrix[c.getX()][c.getY()].piece.getSprite();
	}
	
	public boolean hasMoved(Coordinate c)
	{
		return boardMatrix[c.getX()][c.getY()].piece.hasMoved;
	}
	
	public boolean hasMoved(int x, int y)
	{
		return boardMatrix[x][y].piece.hasMoved;
	}
	
	public void setPiece(Coordinate c, Peca p)
	{
		boardMatrix[c.getX()][c.getY()].piece = p;
	}
}
