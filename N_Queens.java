
///FAVOURITE QUESTION>>>>.................



import java.util.*;
public class N_Queens {

    public static boolean isSafe(int row,int col,char[][] boards)
    {

        int i;

        //horizontal
        for(i=0;i<boards.length;i++)
        {
            if(boards[row][i]=='Q')
            {
                return false;
            }
        }

        //vertical
        for(i=0;i<boards.length;i++)
        {
            if(boards[i][col]=='Q')
            {
                return false;
            }
        }
        

        //upper right
        for(int r=row,c=col;r>=0 && c<boards.length; r--,c++)
        {
            if(boards[r][c]=='Q')
            {
                return false;
            }
        }


        //upper left
        for(int r=row,c=col;r>=0 && c>=0; r--,c--)
        {
             if(boards[r][c]=='Q')
            {
                return false;
            }

        }

        //lower right
        for(int r=row,c=col;r<boards.length && c<boards.length; r++,c++)
        {
         if(boards[r][c]=='Q')
            {
                return false;
            }   
        }

        //lower left
         for(int r=row,c=col;r<boards.length && c>=0; r++,c--)
        {
         if(boards[r][c]=='Q')
            {
                return false;
            }   
        }

        return true;


    }




    public static void saveBoards(char[][] boards,List<String> allboards)
    {
       // a logic to get ..Q. 
       allboards.clear();   /// nice move hahahhahhahha


       for(int j=0;j<boards.length;j++)
       {
               String s="";

        for(int i=0;i<boards.length;i++)
        {
            if(boards[i][j]=='Q')
            {
                s=s+'Q';
            }
            else
            {
                s=s+'.';
            }
        }

        allboards.add(s);
       }

       System.out.println(allboards);

    }



    public static void helper(int n,char[][] boards,List<String> allBoards,int col)
    {
        if(col==boards.length)
        {
           saveBoards(boards,allBoards);
           return;
        }
         for(int row=0;row<boards.length; row++)  //keeping the coloum as constant it cheecks row wis esuppose if 2nd row doesnot have any safe postion then it goes back to the previous calls for again placing the first queen
         {
            if(isSafe(row,col,boards))
            {
                boards[row][col]='Q';
                helper(n-1,boards,allBoards,col+1);
                boards[row][col]='.';
            }
         }
    }
    public static void main(String[] args)
    {
        int n=4;

        List<String> allBoards= new ArrayList<>();
        char[][] boards=new char[4][4];
        helper(n,boards,allBoards,0);
    }
}
