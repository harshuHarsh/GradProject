package Connect4;

public class Coin {
    
    private char CoinPos;
    private int  rowPosition;
    private int  CoinState;
 
  
    public Coin()
    {
      CoinPos = ' ';
      rowPosition  =  0; 
      CoinState = 0;
    } 
    
   
    public Coin( char newCoinPos,  int newRowPosition)
    {
      CoinPos = newCoinPos;
      rowPosition  =  newRowPosition;  
    }
    
    public void setCoinAndRowPosition( char newCoinPos, int newRowPosition)
    {
      CoinPos =  newCoinPos;
      rowPosition  =  newRowPosition;  
    }

  
    public void  setCoinState(int newCoinState)
    {
        CoinState = newCoinState;     
       
    }
    
   
    public int getCoinState()
    {
        return CoinState;
    }
    
  
    public char getCoinPos() 
    {
      return CoinPos;      
    }


 
   
    
}