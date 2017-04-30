package rucksacksolverjava.Implementation;

import java.util.ArrayList;
import rucksacksolverjava.Interfaces.IRucksackSolver;
import rucksacksolverjava.Models.RucksackObject;

public class Main{
    private static IRucksackSolver rucksackSolver;
    
    public static void main(String args[]){
        String filePath = "C:\\Users\\tim\\Documents\\Git\\RucksackSolverJava\\";
        rucksackSolver = new RucksackSolver(filePath + "Table.csv", filePath + "Solution.txt");
        rucksackSolver.solve(getRucksackObjects(), 645);
        rucksackSolver.solveFptas(getRucksackObjects(), 645, 10);
    }
    
    private static ArrayList<RucksackObject> getRucksackObjects(){
        ArrayList<RucksackObject> rucksackObjects = new ArrayList<>();
        rucksackObjects.add(new RucksackObject(232, 153));
        rucksackObjects.add(new RucksackObject(73, 54));
        rucksackObjects.add(new RucksackObject(201, 191));
	rucksackObjects.add(new RucksackObject(50, 66));	
        rucksackObjects.add(new RucksackObject(141, 239));
        rucksackObjects.add(new RucksackObject(79, 137));
        rucksackObjects.add(new RucksackObject(48, 148));
	rucksackObjects.add(new RucksackObject(38, 249));	
        return rucksackObjects;
    }
}