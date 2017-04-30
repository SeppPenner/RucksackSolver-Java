package rucksacksolverjava.Models;

public class RucksackObject{
    
    public RucksackObject(int price, int weight){
        Price = price;
        Weight = weight;
    }
    
    public int Price;

    public int Weight;
    
    @Override
    public String toString(){
        return "RucksackObject: Price: " + Price + " | Weight: " + Weight;
    }
}