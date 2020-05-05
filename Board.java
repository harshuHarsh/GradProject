package Connect4;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class Board 
{
	protected static Coin gameBoard[][];	
	protected static int size;	
	public static int numberOfPlayer;
	
	public static void createBoard()
    {
      
        gameBoard = new Coin[Board.getBoardSize()][Board.getBoardSize()];
        for (int i = 0; i <Board.getBoardSize(); i++)
        {
            for (int j = 0; j <Board.getBoardSize(); j++)
            {
                gameBoard [i][j]=new Coin();
            }
        }
    } 
	
	public static void createButtons() 
	{
		
		for (int i = getBoardSize() - 2; i >= 0; i--) {
			for (int j = getBoardSize() - 1; j >= 0; j--) {
				gameBoard[i][j].setCoinState(-1);
			}
		}
		Connect4.addButtonsToBoard(); 
	}

	

	public static void setBoardSize(int newSize) {
		size = newSize;
	}

	public static int getBoardSize()
	{
		return size;
	}

	public static void playerNumberAndBoardSize() 
	{
		
		String playerNumber = JOptionPane.showInputDialog("Enter Player Number: 1 or 2");
		String boardSize = JOptionPane.showInputDialog("Enter Size of the Connect4 Board");
		numberOfPlayer = Integer.parseInt(playerNumber);
		int sizeOfBoard = Integer.parseInt(boardSize);
		
		if (sizeOfBoard < 4) 
		{
			JFrame frameInputError = new JFrame("empty");
			JOptionPane.showMessageDialog(frameInputError,"Board Size should be greater than 4","Error on Size",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}

		Board.setBoardSize(sizeOfBoard); 
	}

}
