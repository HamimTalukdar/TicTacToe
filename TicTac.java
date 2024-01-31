package TicTacToe;

import java.util.Scanner;

public class TicTac {
    char[][] arr = new char[3][3];
    char player = 'o';
     
    TicTac(){
        char k = '1';
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++, k++){
                arr[i][j] = k;
            }
        }
     }

     public boolean insert(char defaultChar, char player){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(arr[i][j]==defaultChar){
                    arr[i][j] = player;
                    return true;
                }
            }
        }
        return false;
     }

     public boolean isFull(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(arr[i][j]!='x' && arr[i][j]!='o'){
                    return false;
                }
            }
        }
        return true;
     }

     public boolean Display(char ch){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(arr[i][j]=='x'|| arr[i][j]=='o'){
                    System.out.print(arr[i][j]);
                }else if(ch=='n'){
                    System.out.print(arr[i][j]);
                }else{
                    System.out.print(" ");
                }
                if(j==0||j==1){
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if(i==0||i==1){
                for(int k=0; k<3; k++){
                System.out.print("---");
            }
            System.out.println();
            }
        }
        System.out.println("\n");
        return winCheck(ch);
     }

     public boolean winCheck(char ch){
        for(int i=0; i<3; i++){
            if(arr[i][0]==ch && arr[i][1]==ch && arr[i][2]==ch){
                return true;
            }

            if(arr[0][i]==ch && arr[1][i]==ch && arr[2][i]==ch){
                return true;
            }
        }

        if(arr[0][0]==ch && arr[1][1]==ch && arr[2][2]==ch){
            return true;
        }

        if(arr[0][2]==ch && arr[1][1]==ch && arr[2][0]==ch){
            return true;
        }

        return false;
     }

     public void playGame(){
        Scanner scan = new Scanner(System.in);
        while(1==1){
            if(Display(player)){
                System.out.println("Player "+player+" win !!!");
                break;
            }
            if(isFull()){
                System.out.println("<-- Game Draw ---> \n");
                break;
            }
            if(player=='o'){
                player = 'x';
            }else{
                player = 'o';
            }
            
            System.out.print("Player ("+player+") : ");
            char a = scan.next().charAt(0);
            while(!insert(a, player)){
                System.out.print("Cantami koiro na vi\nAbar chalo player ("+player+") : ");
                a = scan.next().charAt(0);
            }
            System.out.println();
        }
     }

     public static void main(String[] args) {
        TicTac Oishi = new TicTac();
        Oishi.Display('n');
        System.out.println("Enter number according to table cell-number : \n\n");
        Oishi.playGame();
     }
}