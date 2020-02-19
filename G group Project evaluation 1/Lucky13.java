import java.util.*;
import java.lang.*;

class Lucky13{
        static int arr[][];
        static boolean flag=false;
        static String player[]=new String[2];
        static String turn;
        public static void create(int n)
        {
            arr=new int[n][n];
            for(int i=0;i<arr.length;i++)
            {
                for(int j=0;j<arr[i].length;j++)
                {
                    arr[i][j]=0;
                }
            }
        }
        public static void print(){
            for(int i=0;i<arr.length;i++)
            {
                for(int j=0;j<arr.length;j++)
                {
                    System.out.print(arr[i][j]+"  ");
                }
                System.out.println();
            }
        }
        public static boolean check(int x,int y)
        {
            int sumh[]={0,0},sumv[]={0,0};
            if(x==1 || x==2)
                    {
                        if(y==1 || y==2)
                        {
                        sumh[1]+=arr[x][y]+arr[x][y-1]+arr[x][y+1];
                        sumv[1]+=arr[x][y]+arr[x+1][y]+arr[x-1][y];
                        }
                        else
                        sumv[1]+=arr[x][y]+arr[x+1][y]+arr[x-1][y];
                    }
            if(x<2)
            {
                
                if(y<2)
                {
                    for(int i=0;i<3;i++)
                    {
                         sumh[0]+=arr[x+i][y];
                         sumv[0]+=arr[x][y+i];
                    }
                    
                }
                else
                {
                    for(int i=0;i<3;i++)
                    {
                         sumh[0]+=arr[x+i][y];
                         sumv[0]+=arr[x][y-i];
                    }
                }
            }
            else
            {
                if(y<2)
                {
                    for(int i=0;i<3;i++)
                    {
                         sumh[0]+=arr[x-i][y];
                         sumv[0]+=arr[x][y+i];
                    }
                }
                else
                {
                    for(int i=0;i<3;i++)
                    {
                         sumh[0]+=arr[x-i][y];
                         sumv[0]+=arr[x][y-i];
                    }
                }
            }
            if(sumh[0]==13 || sumv[0]==13 || sumh[1]==13 || sumv[1]==13)
                return true;
            else
                return false;
        }
        public static void input(){
            Scanner sc=new Scanner(System.in);
            System.out.print("Rolling the dice(Y/N) :");
            char ans=sc.next().charAt(0);
            if(ans=='Y' || ans=='y')
            {
                int num=(int)(Math.random()*6+1);
                System.out.println(num);
                int x,y;
                int count=0;
                try_again:while(count==0)
                {
                System.out.println("Enter the location to enter the number : ");
                x=sc.nextInt();
                y=sc.nextInt();
                if(x<arr.length && y<arr.length && arr[x][y]==0)
                {
                    arr[x][y]=num;
                    print();
                    flag=check(x,y);
                    count++;
                }
                else
                {
                 System.out.println("Wrong location try again");
                 continue try_again;
                }
                }
                if(flag==false)
                {
                    if(turn==player[0])
                        turn=player[1];
                    else
                        turn=player[0];
                        System.out.println(turn+" turn");
                }
                
            }
            else
            {
                System.out.println(turn+" left the game");
                if(turn==player[0])
                    turn=player[1];
                else
                    turn=player[0];
                flag=true;
            }
            
        }
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        System.out.println("------------------------Lucky Thirteen------------------------\n                       A game for 2 players");
        System.out.println("The object of this game is to be the first player to make a line of 3 numbers that add up to 13.");
        System.out.println("Player take turns to throw a dice and write the number anywhere on the grid");
        System.out.println("Players have to try to make a line of 3 numbers that add up to 13. The line\ncan be vertical or horizontal and it can be made up of numbers written by each\n player. The winner is the first person who creates a line adding up to 13.");
        System.out.print("\nPress Y to enter the game : ");
        char perm=scan.next().charAt(0);
        if(perm=='Y'||perm=='y')
        {
        System.out.println("Welcome to the Lucky13 Game \nEnter the name of the two players");
        player[0]=scan.next();
        player[1]=scan.next();
        turn=player[0];
        int n=4,f=0;
            create(n);
            System.out.println(turn+" turn");
            print();
            while(flag==false)
            {
                f=0;
                for(int i=0;i<4;i++)
                {
                    for(int j=0;j<4;j++)
                    {
                        if(arr[i][j]==0)
                        {
                            f=1;
                            break;
                        }
                    }
                    if(f==1)
                    break;
                }
                if(f==1)
                input();
                else
                break;
            }
            if(flag==true)
            System.out.println(turn+" wins.");
            else
            System.out.println("No one wins. Game Over");
        }
    }
}