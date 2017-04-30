package rucksacksolverjava.Interfaces;

import rucksacksolverjava.Models.RucksackSolution;

public interface IFileWriter{
    void writeTableToFile(String fileName, int[][] table);

    void writeSolutionToFile(String fileName, RucksackSolution solution);
}