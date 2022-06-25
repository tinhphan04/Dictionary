/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slangdictionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import static slangdictionary.SlangDictionary.ShowMenuAfterFunction;

/**
 *
 * @author tinh.pv
 */
public class Functions {
    
    public static HashMap<String, List<String>> slangWord = new HashMap<String, List<String>>();
    public static Scanner keyword= new Scanner(System.in);
    public static List<String> historyFind = new ArrayList<String>();
    
    public static void GetSlangFromFile(){
     try
     {
        File f = new File("slang.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine())!=null)
        {
            //Dòng dữ liệu phải tồn tại ký tự "`" để phân biệt key và value
            if (line.contains("`"))
            {
                String[] rs = line.split("`");
                String[] temp = rs[1].split("\\|");
                List<String> mean = Arrays.asList(temp);
                slangWord.put(rs[0],mean);
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
        System.out.print("Please type your word do you find: ");
        String check=keyword.nextLine();
        List<String> test=slangWord.get(check);
        //historySlangWord.add(check);
        System.out.println(test);
        ShowMenuAfterFunction();
    }
    
    
}
