package rucksacksolverjava.Models;

import java.util.ArrayList;

public class RucksackSolution{
    public String Approach;
    
    public ArrayList<RucksackObject> RucksackObjects;

    public double TotalWeight;

    public double Value;

    @Override
    public String toString(){
        String output = Approach + " | value: " + Value + ", total weight: " + TotalWeight + System.getProperty("line.separator");
        for(RucksackObject rucksackObject : RucksackObjects){
            output = output + rucksackObject.toString() + System.getProperty("line.separator");
        }
        return output;
    }
}