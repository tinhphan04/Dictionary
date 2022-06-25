/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slangdictionary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import static slangdictionary.SlangDictionary.ShowMenuAfterFunction;

/**
 *
 * @author tinh.pv
 */
public class Functions {
    
    public static HashMap<String, List<String>> slangWord = new HashMap<String, List<String>>();
    public static Scanner keyword = new Scanner(System.in);
    public static List<String> historyFind = new ArrayList<String>();
    
    
    public static void GetSlangFromFile(){
     try
     {
        File f = new File("slangout.txt");
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
    
    public static void GetSlangFromFileDefault(){
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
        System.out.print("Please type word you want to find: ");
        String input = keyword.nextLine();
        List<String> result = slangWord.get(input);
        //Lưu từ khóa tìm kiếm và history
        historyFind.add(input);
        System.out.print(input + " is mean: ");
        System.out.println(result);
        ShowMenuAfterFunction();
    }
    
    public static void FindDefinition()
    {
        System.out.println("Please type definition you want to find: ");
        String input = keyword.nextLine();
        //Lưu từ khóa tìm kiếm và history
        historyFind.add(input);
        List<String> answer = new ArrayList();
        for (String i: slangWord.keySet())
        {
            if (i.contains(input))
            {
                answer.add(i);
            }
        }
        System.out.print(input + " are mean: ");
        System.out.println(answer);
        ShowMenuAfterFunction();
    }
    
    public static void GetHistory()
    {
        System.out.println("Your history search: ");
        for (String string : historyFind) {
            System.out.println(string);
        }
        ShowMenuAfterFunction();
    }
    
    public static void AddSlangWord()
    {
        System.out.println("Please type Slagword you want to create: ");
        String input = keyword.nextLine();
        System.out.println("Please type mean of Slagword: ");
        String mean= keyword.nextLine();
        List<String> value=new ArrayList();
        value.add(mean);
        
        boolean isExists = false;
        
        for (String i: slangWord.keySet())
        {
            if (i.equals(input))
            {
                isExists = true;
            }
        }
        if (!isExists)
        {
            slangWord.put(input, value);
            updateFile();
            System.out.println("Add New Slangword Successfully");
        }
        else
        {
            System.out.println("Slagword is already not create new.");
        }
        ShowMenuAfterFunction();
    }
    
    static void EditSlangWord(){
        System.out.print("Please type Slagword you want to edit: ");
        String input = keyword.nextLine();
        
        boolean isExists = false;
        
        for (String i: slangWord.keySet())
        {
            if (i.equals(input))
            {
                isExists = true;
            }
        }
        if (!isExists)
        {
            System.out.println("This slangword dont't exist");
            ShowMenuAfterFunction();
        }
        else{
            System.out.println("Please type mean of Slagword: ");
            String mean= keyword.nextLine();
            List<String> value=new ArrayList();
            value.add(mean);
            slangWord.replace(input, value);
            updateFile();
            System.out.println("Edit Slagword Successfully");
            ShowMenuAfterFunction();
        }
    }
    
    static void DeleteSlangWord()
    {
        System.out.println("Please type Slang you want to delete: ");
        String input = keyword.nextLine();
        boolean isExists = false;
        
        for (String i: slangWord.keySet())
        {
            if (i.equals(input))
            {
                isExists = true;
            }
        }
        if(isExists)
        {
            System.out.println("Are you sure want to delete it (Y/N)? ");
            String confirm = keyword.nextLine().toUpperCase();
            
            if (confirm.equals("Y"))
            {
                slangWord.remove(input);
                updateFile();
                System.out.println("Delete Slangword Successfully");
                ShowMenuAfterFunction();
            }
            else{
                ShowMenuAfterFunction();
            }
        }
        else{
            System.out.println("Slangword not exists");
            ShowMenuAfterFunction();
        }
    }
    
    public static void ResetSlang()
    {
        slangWord.clear();
        GetSlangFromFileDefault();
        updateFile();
        ShowMenuAfterFunction();
    }
    
    public static void updateFile()
    {
        try {
            File f = new File("slangout.txt");
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            for (String i: slangWord.keySet())
            {
                fw.write(i +"`");
                List<String> temp= slangWord.get(i);
                for (int t=0;t<temp.size();t++)
                {
                    fw.write(temp.get(t));
                    if (t+1<temp.size()) fw.write("|");
                }
                fw.write("\n");
            }
            fw.close();
            bw.close();
        }
        catch (Exception ex) {
            System.out.println("Error: "+ex);
        }
    }
    
    public static void RandomSlangWord(){
        int count=0;
        Random rd = new Random();
        int ramdNum = rd.nextInt(slangWord.size());
        String key = "";
        for (String i: slangWord.keySet())
        {
            if (count == ramdNum)
            {
                key = i;
                break;
            }else count++;
        }
        System.out.print("Your random Slangword is : ");
        System.out.println(key);
        System.out.print("And it mean:   ");
        List<String> value = Functions.slangWord.get(key);
        System.out.println(value);
    }
}
