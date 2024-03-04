

//** ATTACK!!!
//receive clicked button and coords.
//call battleships, who has a method for this, and will return data.
//based on bool, turn off button and make buttons either red or white.
// if red, mark cord ATTACKED.
// well figure out where htat variable goes...**/



package org.example;

import javafx.scene.control.Button;

import java.util.ArrayList;

public class ButtonSyntax extends TwoPlayerBoards{
    private Battleships access;
    private int across;
    private int down;
    private Button currentButton;

    public ButtonSyntax(){
        across = 0;
        down = 0;

    }
    public ButtonSyntax(int across, int down){
        super(stage);
        this.across = across;
        this.down= down;
    }

    /**this keeps the button were looking at up to date.**/
    public Button buttonFind(Button button, int down, int across){
        this.across = across;
        this.down = down;
        currentButton = button;
    }
    public void setAcross(int across){
        this.across = across;
    }
    public int getAcross(){
        return across;
    }

    public int getDown(){// r/accidentallyfunny
        return down;
    }
    public Button getCurrentButton(){
        return currentButton;
    }
    public void setDown(int down){
        this.down = down;
    }
    /**instructions for how buttons and "inside" setup will work
    NOT Labels/Instructions!!!
    ensures buttons will not be clicked multiple times, disables buttons when finished, etc.*/
    //NOTE: confer w group before copy-pasting for other ships.
    public void setupCarrier(int player){
        boolean colored = false;
        Battleships access = new Battleships();
        ArrayList<Button> carrierList = new ArrayList<>();//list of carrier slot buttons
        ArrayList<Integer> carrierListInt = new ArrayList<>();
        int i = 0;
        do{
            if(i>=1&& across==carrierList.indexOf(i-1)/**now... how to get them to only press buttons in a plus shape. **/(across == carrierList.get(i) || across == carrierList.get(i) + 1 || across == carrierList.get(i) - 1)
                    && (down == carrierList.get(i - 1) || down == carrierList.get(i - 1) + 1 || down == carrierList.get(i - 1) - 1)){// i have no idea if this is going to work.
                if (!colored) {
                    currentButton.setStyle("-fx-background-color: rgb(255, 0, 0);");
                    carrierList.add(currentButton);
                    carrierListInt.add(across, down);
                    colored = true;
                }
                if (colored)
                    currentButton.setStyle("-fx-background-color: rgb(0, 0, 0);");
                carrierList.remove(currentButton);
                carrierListInt.remove(across);
                carrierListInt.remove(down);

                colored = false;
                i--;//forces the player to choose again.
            }
        }while(i<5);
        //SENDING TO BATTLESHIP
        Button[][] arrayCarrier = new Button[8][8];//switch to an array to send out.
        for(int j = 0; j<5; j++){
            //a;; the even numbers will have button/across.
            //odd has down...
           int row = carrierListInt.indexOf(j);
           int col = carrierListInt.indexOf(j+1);//and these are the button's coords!
            Button placeholder = arrayCarrier[col][row];

        }
        if (player==1){
            access.setPlayerOneCarrier(arrayCarrier);
        }
        else{
            access.setPlayerTwoCarrier(arrayCarrier);
        }
        disableButtons(arrayCarrier);

    }

    public void setupBattleship(int player){

    }
    public void setUpCruiser(int player){

    }
    public void setUpSubmarine(int player){

    }
    public void setUpDestroyer(int player){

    }
/** disableButtons for button Disablement**/
/** NOTE: CHECK TO SEE IF THIS WILL DISABLE ALL THE BUTTONS. I ONLY WANT SPECIFIC BUTTONS**/
    public void disableButtons(Button[][] coords){
        //.setDisable()
        for (int column = 0; column<coords.length;column++){
            for (int row = 0; row<coords[column].length;row++){
                /** desus this is bad...**/
                if (coords[column][row]!=-1){//-1 will represent an empty cell
                    coords[column][row].setDisable(true);//this isnt disabling a button. you just game the coords. dumbass. SET A BUTTOn
                }
            }
        }
    }

    public void attackClickButtons(){

    }
}