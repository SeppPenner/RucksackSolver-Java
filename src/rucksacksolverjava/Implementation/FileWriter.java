package rucksacksolverjava.Implementation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import rucksacksolverjava.Interfaces.IFileWriter;
import rucksacksolverjava.Models.RucksackSolution;

public class FileWriter implements IFileWriter{

    private final DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH24:mm:ss-SSS");
    
    @Override
    public void writeTableToFile(String fileName, int[][] table) {
        try {
            createFileIfNotExists(fileName);
            writeLine(fileName, getCurrentDateFormatted()+":");
            write(fileName, "alpha,");
            int dimensionX = table.length;
            int dimensionY = table[0].length;
            for (int row = 0; row < dimensionX - 2; row++){
                if (row == dimensionX - 3){
                    writeLine(fileName, Integer.toString(row + 1));
                } 
                else{
                    write(fileName, Integer.toString(row + 1) + ",");
                }  
            }
            for (int col = 0; col < dimensionY; col++){
                for (int row = 1; row < dimensionX; row++){
                    if (row == 1){
                        write(fileName, col + ",");
                    } 
                    else if (row == dimensionX - 1){
                        writeLine(fileName, Integer.toString(table[row][col]));
                    }
                    else{
                        write(fileName, Integer.toString(table[row][col]) + ",");
                    }
                }
            }
        }catch (Exception e) {
            System.err.println(e);
        }                 
    }

    @Override
    public void writeSolutionToFile(String fileName, RucksackSolution solution) {
        try {
            createFileIfNotExists(fileName);
            writeLine(fileName, getCurrentDateFormatted()+":");
            writeLine(fileName, solution.toString());
        }
        catch(Exception e){
            System.err.println(e);
        }
    }
    
    private void createFileIfNotExists(String fileName) throws IOException{
        File f = new File(fileName);
        if(!f.exists() && !f.isDirectory()) {
            if (f.createNewFile()){
                System.out.println("File is created!");
            }
        }
    }
    
    private String getCurrentDateFormatted(){
        return df.format(new Date());
    }
    
    private void write(String fileName, String text) throws IOException{
        Files.write(Paths.get(fileName), text.getBytes(), StandardOpenOption.APPEND);
    }
    
    private void writeLine(String fileName, String text) throws IOException{
        Files.write(Paths.get(fileName), text.getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(fileName), System.getProperty("line.separator").getBytes(), StandardOpenOption.APPEND);
    }
}