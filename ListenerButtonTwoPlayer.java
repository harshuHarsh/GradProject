package Connect4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerButtonTwoPlayer implements ActionListener
{
	int sum=0;
	
	public static int playerTurn=0;
	public  int count=0;
	CheckWin win=new CheckWin();
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
        try 
        {
          
            int flagplayerTurn=0;

            for(int i=Board.getBoardSize()-1; i>=0; --i)
            {
                for(int j=0; j<=Board.getBoardSize()-1; ++j)
                {
                    if( Connect4.buttons[i][j]== e.getSource()) 
                    {  
                       if(flagplayerTurn==0 && playerTurn%2==0) 
                       { 
                            for(int k=0; k<=Board.getBoardSize(); ++i)    
                            {
                                if(Board.gameBoard[i-k][j].getCoinState()==0 && playerTurn%2==0)
                                {
                                   Connect4.buttons[i-k][j].setIcon(Connect4.player1);          
                                   Board.gameBoard[i-k][j].setCoinAndRowPosition('R', i);  
                                   Board.gameBoard[i-k][j].setCoinState(1);
                                   count++;  
                                 
                                   win.checkforWinningPlayer(1);
                                  
                                   flagplayerTurn=1;   
                                   
                                   break; 
                                } 
                               
                            }

                            setCostumeToEmpty(i,j);  
                            System.out.println("Player 1 played!!!");
                            playerTurn++; 
                            break;
                        }

                       
                        if(flagplayerTurn==0 && playerTurn%2==1) 
                        { 
                            for(int k=0; k<=Board.getBoardSize(); ++i)
                            {
                                if(Board.gameBoard[i-k][j].getCoinState()==0 && playerTurn%2==1)
                                {
                                   Connect4.buttons[i-k][j].setIcon(Connect4.player2);           
                                   Board.gameBoard[i-k][j].setCoinAndRowPosition('B', i);    
                                   Board.gameBoard[i-k][j].setCoinState(2);          
                                   count++;
                                   win.checkforWinningPlayer(2);
                                   flagplayerTurn=1;
                                  
                                   break;
                                } 
                               
                            }
                            setCostumeToEmpty(i,j);
                            System.out.println("Player 2 played!!!");
                            playerTurn++;
                            break;
                        }

                    } 
                }        
            }              
            
       }
	    catch(Exception ex) 
	    { 
	        System.out.println(ex.getMessage());
	    }
       
	}
       
   	    public void setCostumeToEmpty(int rowPos, int columnPos)
   	    {
   	        try 
   	        {
   	           Board.gameBoard[rowPos-1][columnPos].setCoinState(0);    
   	        }   
   	        catch (Exception ex) 
   	        { 
   	        	System.out.println(ex.getMessage());
   		       
   	        }      
   	    }

}
