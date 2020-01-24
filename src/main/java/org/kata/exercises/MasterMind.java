package org.eclipse.che.examples;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MasterMind{

    static String[] colors = {"Red", "Green", "Yellow", "Purple", "Blue", "Brown", "Black", "White", "Orange", "Gray"};
    final static int number = 4;
    static String[] colorTable = new String[number];

    public static void main(String[] args){
        
        for(int i=0;i<number;i++){
            String color = chooseColor();
            colorTable[i] = color;
        }

        

         
    }

    private static String chooseColor(){
        Random rand = new Random();
        final int randomIndex = rand.nextInt(colors.length);
        return colors[randomIndex];
    }

    private static int tellRightPlaced(String input){
        List<String> colorsTableAl = Arrays.asList(colorTable);
        if(colorsTableAl.contains(input)){
            return 1;
        }else{
            return 0;
        }
    }

}
