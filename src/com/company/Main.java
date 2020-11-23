package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here


        StringBuffer stringBuffer = new StringBuffer();

        try ( FileReader fileReader = new FileReader(".\\src\\text.txt");

              BufferedReader bufferedReader = new BufferedReader(fileReader);

              Scanner scanner = new Scanner(bufferedReader);
        )
        {

           while (scanner.hasNext())
           {
              stringBuffer.append(scanner.nextLine());
           }
        }
        catch (FileNotFoundException fileNotFoundException)
        {
            fileNotFoundException.printStackTrace();
        }
        catch (IOException ioException)
        {
            ioException.printStackTrace();
        }

        List<String> tokens = TextProcessor.process(stringBuffer.toString());

        Scanner scanner = new Scanner(System.in);

        String word = null;

        System.out.println(Arrays.toString(tokens.toArray()));

        do {
             word = scanner.next();

            if(TextProcessor.find(tokens, word))
            {
                System.out.println("found " + word);

                try (FileWriter fileWriter = new FileWriter(".\\src\\result.txt", true))
                {
                    fileWriter.append(word + "\n");

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            else
            {
                System.out.println("not found " + word);
            }
        }
        while (!word.equals("exit"));

       // System.out.println(Arrays.toString(list.toArray()));

       // System.out.println(Arrays.toString(tokens.toArray()));



    }
}
