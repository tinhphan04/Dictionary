/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package slangdictionary;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tinh.pv
 */
public class SlangDictionary {
    /**
     * @param args the command line arguments
     */
    public static Scanner options = new Scanner(System.in);
    
    public static void main(String[] args) {
        // TODO code application logic here
        Functions.GetSlangFromFile();
        if(Functions.slangWord.isEmpty())
        {
            Functions.GetSlangFromFileDefault();
            Functions.updateFile();
        }
        Menu();
        
    }
    
    public static void Menu()
    {
        System.out.println("1. Search by SlangWord ");
        System.out.println("2. Search by Definition ");
        System.out.println("3. Show history ");
        System.out.println("4. Add SlangWord ");
        System.out.println("5. Edit SlangWord ");
        System.out.println("6. Delete SlangWord ");
        System.out.println("7. Reset to default ");
        System.out.println("8. Random SlangWord ");
        System.out.println("9. Minigame find Definition ");
        System.out.println("10. Minigame find SlangWord ");
        System.out.println("11. Clear History");
        System.out.println("E. Exit ");
        System.out.println("Please Choice:  ");
        String choice = options.nextLine();
        
        if(choice.equals("1"))
        {
           Functions.Find();
        }
        else if(choice.equals("2"))
        {
            Functions.FindDefinition();
        }
        else if(choice.equals("3"))
        {
            Functions.GetHistory();
        }
        else if(choice.equals("4"))
        {
            Functions.AddSlangWord();
        }
        else if(choice.equals("5"))
        {
            Functions.EditSlangWord();
        }
        else if(choice.equals("6"))
        {
            Functions.DeleteSlangWord();
        }
        else if(choice.equals("7"))
        {
            Functions.ResetSlang();
        }
        else if(choice.equals("8"))
        {
            Functions.RandomSlangWord(); 
        }
        else if(choice.equals("9"))
        {
            Functions.GameRandomSlang();
        }
        else if(choice.equals("E"))
        {
            System.exit(0);
        }
    }
    
    public static void ShowMenuAfterFunction()
    {
        System.out.println("Please press M to show Menu or E to exit program.");
        String choice = new Scanner(System.in).nextLine();
        if(choice.toUpperCase().equals("M")){
            Menu();
        }
        else if(choice.toUpperCase().equals("E")){
            System.exit(0);
        }
    }
    
    
    
}
