/**
 * Created by abhinit on 2/12/16.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpiralMatrix {
    public static void main(String[] args){
        Scanner scan =  new Scanner(System.in);
        String line = null;
        List<String> list = new ArrayList();

        while(scan.hasNextLine()){
            line = scan.nextLine();

            list.add(line);
        }

        char[][] input = null;

        for(int i=0;i<list.size();i++){
            line = list.get(i);
            String[] arr = line.split("[\\s]+");
            if(i==0){
                input = new char[list.size()][arr.length];
            }
            for(int j=0;j<arr.length;j++){
                input[i][j] = arr[j].charAt(0);
            }
        }

        List<Character> output = spiralOrder(input);
    }

    public static List<Character> spiralOrder(char[][] matrix) {

        if(matrix==null || matrix.length==0){
            return new ArrayList();
        }
        List<Character> list = new ArrayList();
        traverse(matrix,0,matrix[0].length-1,0,matrix.length-1,list);
        return list;
    }

    private static void traverse(char[][] matrix,int westEnd,int eastEnd,int northEnd,int southEnd,List<Character> list){


        if(westEnd==eastEnd && northEnd==southEnd){
            list.add(matrix[northEnd][eastEnd]);
            return;
        }
        else if(westEnd>eastEnd || northEnd>southEnd)
            return;

        for(int i=westEnd;i<eastEnd;i++){

            list.add(matrix[northEnd][i]);
        }


        for(int i=northEnd;i<southEnd;i++){
            list.add(matrix[i][eastEnd]);
        }
        if(northEnd==southEnd && westEnd!=eastEnd){
            list.add(matrix[northEnd][eastEnd]);
        }

        if(northEnd!=southEnd){
            for(int i=eastEnd;i>westEnd;i--){
                list.add(matrix[southEnd][i]);
            }
            if(westEnd==eastEnd){
                list.add(matrix[southEnd][eastEnd]);
            }
        }

        if(eastEnd!=westEnd){
            for(int i=southEnd;i>northEnd;i--){
                list.add(matrix[i][westEnd]);
            }
        }

        traverse(matrix,westEnd+1,eastEnd-1,northEnd+1,southEnd-1,list);
    }
}
