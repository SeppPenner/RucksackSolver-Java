package rucksacksolverjava.Interfaces;

import java.util.ArrayList;
import rucksacksolverjava.Models.RucksackObject;
import rucksacksolverjava.Models.RucksackSolution;

public interface IRucksackSolver{
    RucksackSolution solve(ArrayList<RucksackObject> rucksackObjects, int b);

    RucksackSolution solveFptas(ArrayList<RucksackObject> rucksackObjects, int b, int k);
}