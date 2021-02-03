package com.tts;

package com.codegym.games.game2048;
import com.codegym.engine.cell.*;

public class Game2048 extends Game {
    private int[][]gameField = new int [SIDE][SIDE];

    private static final int SIDE = 4;

    @Override
    public void initialize(){
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }
    private void createGame(){
        createNewNumber();
        createNewNumber();
    };
    private void drawScene(){
        for (int x = 0; x < SIDE; x++){
            for (int y = 0; y < SIDE; y++){
                setCellColoredNumber(x, y, gameField[y][x]);
            }
        }

    }
    private void createNewNumber(){
        int x = getRandomNumber(SIDE);
        int y = getRandomNumber(SIDE);

        if (gameField[x][y]==0){
            int num = getRandomNumber(10);
            if (num == 9) {
                gameField[x][y]=4;
            }
            else{
                gameField[x][y]=2;
            }
        }
        else{
            createNewNumber();
        }
    }
    private Color getColorByValue(int value){
        switch(value){
            case 2:
                return Color.YELLOW;
            case 4:
                return Color.RED;
            case 8:
                return Color.BLACK;
            case 16:
                return Color.GREEN;
            case 32:
                return Color.PINK;
            case 64:
                return Color.ORANGE;
            case 128:
                return Color.BLUE;
            case 256:
                return Color.PURPLE;
            case 512:
                return Color.TAN;
            case 1024:
                return Color.AQUA;
            case 2048:
                return Color.MAGENTA;
            default:
                return Color.NONE;

        }
    }
    // private void setValueEx(int x, int y, Color cellColor, String value){
    //     // WE MIGHT NOT NEED THIS
    // }
    private void setCellColoredNumber(int x, int y, int value){
        Color color = getColorByValue(value);
        String stringThing;

        if (value > 0) {
            stringThing= "" + value;
        }
        else {
            stringThing= "";
        }

        setCellValueEx(x, y, color, stringThing);

    }

    private boolean compressRow(int[] row){
        int position =0;
        boolean result = false;
        for (int x = 0; x<row.length;x++){
            if(row[x]> 0){
                //for (int y = x+1; y < row.length; y++) {
                if (x!= position){
                    row[position]=row[x];
                    row[x]=0;
                    result=true;
                }
                position++;//(row[y]!=0){
                //int temp = row[y];
                //row[x] = row[y];
                // row[x] = temp;
                // result = true;
                // break;
            }
        }
        return result;
    }
}
    private boolean mergeRow(int[]row) {

        boolean changed = false;
        for (int i = 1; i <SIDE; i++){
            if (row[i-1] == row [i] && row[i] != 0) {
                row[i-1] = row[i] * 2;
                row[i] = 0;
                changed = true;
            }
        }
        return changed;
    }
    @Override
    public void onKeyPress(Key key) {
    switch(key) {
            case LEFT:
            moveLeft();
            break;
            case RIGHT:
            moveRight();
            break;
            case UP:
            moveUp();
            break;
            case DOWN:
            moveDown();
            break;
default:
        return;

        }
        }
private void moveLeft(){

        }
private void moveRight(){

        }
private void moveUp(){

        }
private void moveDown(){

        }
        }


