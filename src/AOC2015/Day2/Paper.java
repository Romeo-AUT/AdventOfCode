package src.AOC2015.Day2;

import java.io.*;

public class Paper {
    public static void main(String[] args){
        Paper p = new Paper();
        System.out.println(p.getSquareFeet(p.getAreas()));
    }

    public int[] getAreas(){
        String path = "input.txt";
        int[] areas = new int[0];
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            String line = "";
            int count = 0;

            while((line = reader.readLine()) != null){
                int smallest;
                int overall;
                int area1;
                int area2;
                int area3;
                String[] tempS = line.split("x");
                areas = java.util.Arrays.copyOf(areas, count + 1);
                overall = 2 * (area1 = Integer.parseInt(tempS[0]) * Integer.parseInt(tempS[1])) + 2 * (area2 = Integer.parseInt(tempS[1]) * Integer.parseInt(tempS[2])) + 2 * (area3 = Integer.parseInt(tempS[0]) * Integer.parseInt(tempS[2]));
                if(area1 <= area2 && area1 <= area3)
                    smallest = area1;
                else if(area2 <= area1 && area2 <= area3)
                    smallest = area2;
                else
                    smallest = area3;
                areas[count++] = overall + smallest;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return areas;
    }

    public int getSquareFeet(int[] areas){
        int temp = 0;
        for(int i = 0; i < areas.length; i++){
            temp += areas[i];
        }
        return temp;
    }
}