package src.AOC2015.Day1;

import java.io.*;

public class Floor{
    public static void main(String[] args){
        Floor f = new Floor();
        System.out.println(f.getFloor(f.getZeichen()));
    }

    public String getZeichen(){
        String path = "input.txt";
        String temp = "";
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = reader.readLine()) != null){
                temp += line;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return temp;
    }

    public int getFloor(String zeichen){
        int floor = 0;
        for(int i = 0; i < zeichen.length(); i++){
            if(zeichen.charAt(i) == '(')
                floor++;
            else
                floor --;
            if(floor == -1)
                return i + 1;
        }
        return floor;
    }
}