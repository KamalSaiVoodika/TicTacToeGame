import java.util.*;     //importing packages
public class TicTacToeGame    //class name
{
  static String[] slot;
  Scanner s = new Scanner(System.in);  //scanner class
  TicTacToeGame() //constructor
  {
      System.out.println("\n\n\tWelcome To The World of \"Tic-Tac-Toe Game\" by \"Kamal Sai Voodika\" !!\n\t");
      slot = new String[100];
      for (int i = 0; i < 10; i++) {
          slot[i] = String.valueOf(i+1);
      }
      this.printBoard();
      int m=0,a;
      String player1 , player2 , res="no";
      System.out.print("\n\nEnter Player 1 Name :  ");
      player1 = s.nextLine();
      System.out.print("\n\nEnter Player 2 Name :  ");
      player2 = s.nextLine();
      while (true)
      {
          m++;
          System.out.print("\n\nHey.. "+player1+" Give the location of \"X\" : ");
          a= valid_Location(s.nextInt(),player1);
          slot[a-1]="X";
          if (m>=3)
            res=checkWin();
          this.printBoard();
          if (res.equals("X"))
          {
              this.printWin(player1);
              break;
          }
          else if(res.equals("O")) {
              this.printWin(player2);
              break;
          }
          if (m==5){
              System.out.println("\n\n\t\t\t*********IT'S A DRAW!!**********\n\n");
              break;
          }
          System.out.print("\n\nHey.."+player2+" Give the location of \"O\" : ");
          a= valid_Location(s.nextInt(),player2);
          slot[a-1]="O";
          if (m>=3)
            res=this.checkWin();
          this.printBoard();
          if (res.equals("X")){
              this.printWin(player1);
              break;
          }
          else if (res.equals("O")){
              this.printWin(player2);
              break;
          }
      }
    }
  void printBoard()  //Method for printing board
  {
      int k=0;
      System.out.println("");
      for(int i=0;i<7;i++)
      {
        System.out.print("\t\t\t\t");
          for(int j=0;j<7;j++)
          {
              if (i%2==0)
                System.out.print("--");
              else if(j%2==0)
                System.out.print(" | ");
              else
                System.out.print(slot[k++]);
          }
          System.out.println("");
      }
  }
  String checkWin()     //method to check the win
	{
    int a=0,b=0,c=0;
		for (int i = 0; i < 8; i++) {
			String win = null;
			switch (i)
      {
			case 0:
				      win = slot[0] + slot[1] + slot[2];
              a=0;
              b=1;
              c=2;
				      break;
			case 1:
				      win = slot[3] + slot[4] + slot[5];
              a=1;
              b=4;
              c=5;
				      break;
			case 2:
				      win = slot[6] + slot[7] + slot[8];
              a=6;
              b=7;
              c=8;
				      break;
			case 3:
				      win = slot[0] + slot[3] + slot[6];
              a=0;
              b=3;
              c=6;
				      break;
			case 4:
				      win = slot[1] + slot[4] + slot[7];
              a=1;
              b=4;
              c=7;
				      break;
			case 5:
				      win = slot[2] + slot[5] + slot[8];
              a=2;
              b=5;
              c=8;
				      break;
			case 6:
				      win = slot[0] + slot[4] + slot[8];
              a=0;
              b=4;
              c=8;
				      break;
			case 7:
				      win = slot[2] + slot[4] + slot[6];
              a=2;
              b=4;
              c=6;
				      break;
			}
			if (win.equals("XXX"))
      {
        slot[a]="\"X\"";
        slot[b]="\"X\"";
        slot[c]="\"X\"";
				return "X";
			}
			else if (win.equals("OOO"))
      {
        slot[a]="\"O\"";
        slot[b]="\"O\"";
        slot[c]="\"O\"";
				return "O";
			}
		}
    return "no";
  }
  int valid_Location(int a , String t)  //method for checking valid location
  {
    while ((a>=1&&a<=9)&&(!slot[a-1].equals(String.valueOf(a)))||(a>9||a<1))
    {
        printBoard();
        System.out.print("\n\nHey.."+t+" Enter Valid/Empty location :  ");
        a = s.nextInt();
    }
    return a;
  }
  void printWin(String P)    //method for printing win
  {
    System.out.println("\n\n\t\t**********Congrats.. "+P+" You Won!!**********\n\n");
  }
  public static void main(String[] args)  //main method where execution starts
  {
    TicTacToeGame NewGame = new TicTacToeGame();  //creation of object
  }
}
