package Connect4;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CheckWin extends Board
{
	public static boolean flag=true;
	public static int count=0;
	public static int  h=0;
	 public  void checkforWinningPlayer(int winner)
	 {
		
	        for(int i=0; i<getBoardSize(); i++)
	        {         
	            for(int j=0; j<getBoardSize(); j++)
	            {     
	                if(Board.gameBoard[i][j].getCoinState() == winner)
	                {    
	                   
	                    if(i+3<getBoardSize())
	                    {
	                    	
	                    	// check win for horizontal 
	                        if(gameBoard[i+1][j].getCoinState() == winner && gameBoard[i+2][j].getCoinState() == winner && gameBoard[i+3][j].getCoinState() == winner)  
	                        {
	                            if(winner==1)
	                                declareWinner(1);
	                            if(winner==2)
	                                declareWinner(2);
	                            
	                            // i want to keep track of values for draw match
	                           count=1;
	                           
	                        }
	                        if(winner!=1 || winner !=2)
	                        {
	                        
		                        if(i==0 && count==0 )
		                        {
		                        	
		                        	     for (int p = 0; p <Board.getBoardSize(); p++)
		                                 {
		                        	    	 
		                                     if((gameBoard [0][p].getCoinState()==0)||  (gameBoard [0][p].getCoinState()==-1) )
		                                     {
		                                    	 h=h+1;
		                                    	 
		                                     }
		                                 }
		                        	     
		                        	     if(h==0)
		                        	     {
		                        	    	 declareWinner(0);
		                        	    	 
		                        	     }
		                        	     h=0;
		                             }
	                         	}
	                        }
	                       
	                    
	                  
	                 // check win for vertical   
	                    if(j + 3 <getBoardSize())
	                    { 
	                        if(gameBoard[i][j+1].getCoinState() == winner && gameBoard[i][j+2].getCoinState() == winner && gameBoard[i][j+3].getCoinState() == winner)
	                        { 
	                            if(winner==1)
	                                declareWinner(1);
	                            if(winner==2)
	                                declareWinner(2);
	                            count=1;
		                           
	                           
	                        }
	                        
	                        if(winner!=1 || winner !=2)
	                        {
	                        
	                        
			                        if(i==0 && count==0 )
			                        {
			                        	
			                        	     for (int p = 0; p <Board.getBoardSize(); p++)
			                                 {
			                        	    	 
			                                     if((gameBoard [0][p].getCoinState()==0)||  (gameBoard [0][p].getCoinState()==-1))
			                                     {
			                                    	 h=h+1;
			                                    	 
			                                     }
			                                 }
			                        	     
			                        	     if(h==0)
			                        	     {
			                        	    	 declareWinner(0);
			                        	    	 
			                        	     }
			                             }
			                          h=0;
	                        	}
	                        }
	                    

	                    //check for diagonal forward
	                    if(i  < getBoardSize()- 3 && j<getBoardSize()-3)
	                    {
	                        if(gameBoard[i+1][j+1].getCoinState() == winner && gameBoard[i+2][j+2].getCoinState() == winner && gameBoard[i+3][j+3].getCoinState() == winner)
	                        {  
	                            if(winner==1)
	                                declareWinner(1);
	                            if(winner==2)
	                                declareWinner(2);
	                            count=1;
		                           
	                         
	                        }
	                        if(winner!=1 || winner !=2)
	                        {
	                        
		                        if(i==0 && count==0 )
		                        {
		                        	
		                        	     for (int p = 0; p <Board.getBoardSize(); p++)
		                                 {
		                        	    	
		                                     if((gameBoard [0][p].getCoinState()==0) ||  (gameBoard [0][p].getCoinState()==-1))
		                                     {
		                                    	 h=h+1;
		                                    	 
		                                     }
		                                 }
		                        	     
		                        	     if(h==0)
		                        	     {
		                        	    	 declareWinner(0);
		                        	    	 
		                        	     }
		                             }
		                           h=0;
	                        	}
	                        }
	                       
	                    

	                    //check for diagonal backward
	                    if(i  < getBoardSize()- 3 && j - 3 >= 0 )
	                    {
	                        if(gameBoard[i+1][j-1].getCoinState() == winner && gameBoard[i+2][j-2].getCoinState() == winner && gameBoard[i+3][j-3].getCoinState() == winner)
	                        {
	                            if(winner==1)
	                                declareWinner(1);
	                            if(winner==2)
	                                declareWinner(2);
	                            count=1;
		                           
	                        } 
	                        if(winner!=1 || winner !=2)
	                        {
	                        
		                        if(i==0 && count==0 )
		                        {
		                        	     for (int p = 0; p <Board.getBoardSize(); p++)
		                                 {
		                        	    	
		                                     if((gameBoard [0][p].getCoinState()==0)||  (gameBoard [0][p].getCoinState()==-1))
		                                     {
		                                    	 h=h+1;
		                                    	 
		                                     }
		                                 }
		                        	     
		                        	     if(h==0)
		                        	     {
		                        	    	 declareWinner(0);
		                        	    	 
		                        	     }
		                        	     h=0;
		                             }
	                        	}
	                        }
	                }
	            }
	        }
	        
	 }
	 
	                    
	                  
	  
	   
  
    public void declareWinner(int checkforWinningPlayer)
    {
        JFrame framedeclareWinner = new JFrame();       
        if(checkforWinningPlayer==1)
        {
             JOptionPane.showMessageDialog(framedeclareWinner,
             "\nPlayer 1 WON THE GAME!!!",
             "End Game",
             JOptionPane.INFORMATION_MESSAGE);
            
            System.exit(0);
            
        }
        if(checkforWinningPlayer==2)
        {
             JOptionPane.showMessageDialog(framedeclareWinner,
             "\nPlayer 2 WON THE GAME!!!",
             "End Game",
             JOptionPane.INFORMATION_MESSAGE); 
             
             System.exit(0);
            
        }
        if(checkforWinningPlayer==0)
        {
             JOptionPane.showMessageDialog(framedeclareWinner,
             "\n DRAW GAME!!!",
             "End Game",
             JOptionPane.INFORMATION_MESSAGE); 
             
             System.exit(0);
            
        }
        

        
    }
  
}
