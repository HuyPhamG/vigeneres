import java.io.*;
import java.lang.String;

public class vigenere 
{
  // input file name
  public static void main(String[] args) 
  {
    try {
        reader(args[0], args[1]);
    } catch (Exception e) {
        e.printStackTrace();
    }
  }
  // reading file
  public static void reader(String key, String text) throws Exception 
  { 
    // variables
    String buffers = "";
    String buffers2 = "";
    File file = new File(text);
    File file2 = new File(key); 
    
    BufferedReader br = new BufferedReader(new FileReader(file));
    BufferedReader br2 = new BufferedReader(new FileReader(file2)); 
    
    String string;
    String string2; 
    // adding text into strings
    while ((string = br.readLine()) != null) 
      buffers = buffers + string;
    
    while ((string2 = br2.readLine()) != null) 
      buffers2 = buffers2 + string2;
    
    // closing reader
    br.close();
    br2.close();
    // calling cipher
    cipher(buffers2, buffers); 
  }
   
  
  // text edit function
  public static String textedit(String str)
  {
    // removing non-letters
    String newString = str.replaceAll("[^a-zA-Z]","");
    // coverting letters to lowercase
    String lowString = newString.toLowerCase();
    // 512 of text
    if (lowString.length() == 512)
      return lowString;
    // pad with x until 512
    while ((lowString.length()) < 512)
      lowString = lowString + 'x';

    return lowString;
   
  }
  // key edit function
  public static String keyedit(String key)
  {
    // removing non-letters
    String newString = key.replaceAll("[^a-zA-Z]","");
    // storing original length
    int originalLen = key.length();
    String lowString = newString.toLowerCase();
    // 512 of key
    if (lowString.length() == 512)
      return lowString;
    // filling up key
    while ((lowString.length()) < 512)
    {
      for (int i = 0; i < originalLen; i++)
       if (lowString.length() < 512)
        lowString = lowString + lowString.charAt(i);
    }

    return lowString;
  }
  // cipher 
  public static void cipher(String key, String str)
  {
    // echo key
    // 80 letters per line
    System.out.println("Vigenere Key:");
    System.out.println();
    int counter = 0;
    while (key.length() - counter > 80)
    {
      String keyprint = key.substring(counter, counter+80);
      System.out.println(keyprint);
      counter = counter + 80;
        
    }
    String keyprint = key.substring(counter);
    System.out.println(keyprint);
    System.out.println();

    // echo text
    // 80 letters per line
    System.out.println("Plaintext:");
    System.out.println();
    counter = 0;
    while (str.length() - counter > 80)
    {
      String textprint = str.substring(counter, counter+80);
      System.out.println(textprint);
      counter = counter + 80;
        
    }
    String textprint = str.substring(counter);
    System.out.println(textprint);
    System.out.println();

    // calling the key and text edit 
    String text = textedit(str);
    String bigkey = keyedit(key);
    String finals = "";
    int c = 0;

    // applying the cipher
    for (int i = 0; i < 512; i++)
    {
      c = (((text.charAt(i) - 'a') + (bigkey.charAt(i) - 'a')) % 26) + 'a' ;
      finals = finals + (char)c;
    }

    // printing ciphertext
    // 80 per line
    System.out.println("Ciphertext:");
    System.out.println();
    counter = 0;
    while (finals.length() - counter > 80)
    {
      String cipherprint = finals.substring(counter, counter+80);
      System.out.println(cipherprint);
      counter = counter + 80;
        
    }
    String cipherprint = finals.substring(counter);
    System.out.println(cipherprint);
    System.out.println();
  }
} 