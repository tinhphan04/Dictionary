/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slangdictionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tinh.pv
 */
public class Functions {
    public static HashMap<String, List<String>> word = new HashMap<String, List<String>>();
    public static Scanner keyword= new Scanner(System.in);
    
    public static void GetSlangFromFile(){
     try
     {
        File f=new File("slang.txt");
        FileReader fr=new FileReader(f);
        BufferedReader br=new BufferedReader(fr);
        String line;
        while((line=br.readLine())!=null)
        {
            if (line.contains("`"))
            {
                String[] s=line.split("`");
                String[] tmp=s[1].split("\\|");
                List<String> temp=Arrays.asList(tmp);
                word.put(s[0],temp);
            }
        }
        fr.close();
        br.close();
    }
    catch (Exception ex)
    {
        System.out.println("ERROR"+ex);
    }
    }
    
    public static void Find()
    {
        //clearScreen();
        System.out.print("What word u want to find: ");
        String check=keyword.nextLine();
        //check=check.toUpperCase();
        List<String> test=word.get(check);
        //historySlangWord.add(check);
        System.out.println(test);
        //pauseScreen();
        //Menu();
    }
}
