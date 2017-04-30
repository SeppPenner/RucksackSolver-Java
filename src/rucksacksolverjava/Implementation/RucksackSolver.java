package rucksacksolverjava.Implementation;

import java.util.ArrayList;
import java.util.Comparator;
import rucksacksolverjava.Interfaces.IFileWriter;
import rucksacksolverjava.Interfaces.IRucksackSolver;
import rucksacksolverjava.Models.RucksackObject;
import rucksacksolverjava.Models.RucksackSolution;

public class RucksackSolver implements IRucksackSolver{
    private final IFileWriter fileWriter = new FileWriter();
    private ArrayList<RucksackObject> rucksackObjects;
    private int[][] valuesOfFunction;
    private final String fileNameTable;
    private final String fileNameSolution;

    public RucksackSolver(String fileNameTable, String fileNameSolution){
        this.fileNameTable = fileNameTable;
        this.fileNameSolution = fileNameSolution;
    }
    
    @Override
    public RucksackSolution solve(ArrayList<RucksackObject> rucksackObjects, int b){
        init(rucksackObjects);
        fillTable(b);
        return calculateSolution(b, "Dynamic Programming");
    }

    @Override
    public RucksackSolution solveFptas(ArrayList<RucksackObject> rucksackObjects, int b, int k){
        initFptas(rucksackObjects, k);
        fillTable(b);
        return calculateSolution(b, "Dynamic Programming with FPTAS");
    }

    private RucksackSolution calculateSolution(int b, String approach){
        RucksackSolution solution = getSolution(b);
        solution.Approach = approach;
        fileWriter.writeTableToFile(fileNameTable, valuesOfFunction);
        fileWriter.writeSolutionToFile(fileNameSolution, solution);
        return solution;
    }

    private void init(ArrayList<RucksackObject> rucksackObjects){
        this.rucksackObjects = rucksackObjects;
        Comparator<RucksackObject> comp = (p1, p2) -> Integer.compare( p1.Price, p2.Price);
        int maxPrice = rucksackObjects.stream().max(comp).get().Price;
        int n = rucksackObjects.size() * maxPrice;
        valuesOfFunction = new int[rucksackObjects.size() + 1][n];
    }

    private void initFptas(ArrayList<RucksackObject> rucksackObjects, int k){
        init(rucksackObjects);
        rucksackObjects.forEach((rucksackObject) -> {
            rucksackObject.Price /= k;
        });  
    }

    private RucksackSolution getSolution(int b){
        RucksackSolution best = new RucksackSolution();
        best.RucksackObjects = new ArrayList<>();
        for (int row = rucksackObjects.size(), col = b; row > 0; row--)
            if (valuesOfFunction[row][col] != valuesOfFunction[row - 1][col]){
                best.RucksackObjects.add(rucksackObjects.get(row - 1));
                col -= rucksackObjects.get(row - 1).Weight;
            }
        best.TotalWeight = getWeight(best.RucksackObjects);
        best.Value = getValue(best.RucksackObjects);
        return best;
    }

    private int getWeight(ArrayList<RucksackObject> items){
        return items.stream().mapToInt(i -> i.Weight).sum();
    }

    private int getValue(ArrayList<RucksackObject> items){
        return items.stream().mapToInt(i -> i.Price).sum();
    }

    private void fillTable(int b){
        for (int row = 1; row <= rucksackObjects.size(); row++){
            RucksackObject item = rucksackObjects.get(row - 1);
            for (int col = 0; col <= b; col++){
                if (item.Weight > col){
                    valuesOfFunction[row][col] = valuesOfFunction[row - 1][col];
                }
                else{
                    valuesOfFunction[row][col] = Math.max(valuesOfFunction[row - 1][ col],
                    valuesOfFunction[row - 1][ col - item.Weight] + item.Price);
                }    
            }
        }
    }
}