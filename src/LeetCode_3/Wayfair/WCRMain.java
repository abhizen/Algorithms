package Wayfair;

import java.util.Vector;
import java.util.Scanner;



public class WCRMain {

    static Vector<String> result=new Vector<String>();
    public static void main(String[] args) {

        Vector<Vector<String>> mainList=new Vector<Vector<String>>();

        Scanner scan=new Scanner(System.in);
        int num=0;
        System.out.println("Enter the number of vectors you want to have:");
        num=scan.nextInt();

        if(num== 0)
            return;

        for(int i=0;i<num;i++)
        {
            Vector<String> list1=new Vector<String>();
            int numOfWords=0;
            System.out.println("Enter the number of words you want to put in vector# "+(i+1));
            numOfWords=scan.nextInt();
            for(int j=0;j<numOfWords;j++)
            {
                System.out.println("enter word# "+(j+1));
                list1.add(scan.next());
            }
            mainList.add(list1);
        }

//		Collections.sort(mainList, new Comparator<Vector<String>>() {
//
//			@Override
//			public int compare(Vector<String> o1, Vector<String> o2) {
//				// TODO Auto-generated method stub
//				return o1.size()-o2.size();
//			}
//
//		});



        for(int i=0;i<mainList.size();i++)
        {
            getAllPermutations(mainList.get(i));
        }

        System.out.println("result is:");
        for(int i=0;i<result.size();i++)
        {
            System.out.println(result.get(i));
        }

        System.out.println("Count is:"+result.size());



    }

    public static void getAllPermutations(Vector<String> list)
    {
        if(result.size()==0)
        {
            for(String ch:list)
                result.add(ch);
        }
        else
        {
            Vector<String> temp=new Vector<String>();
            for(int i=0;i<result.size();i++)
            {
                for(int j=0;j<list.size();j++)
                {
                    temp.add(result.get(i)+" "+list.get(j));
                }
            }

            result=temp;
        }
    }

}