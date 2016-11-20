package com.geekhub.homework5.task1;

import com.geekhub.homework5.task1.source.*;

import java.io.IOException;
import java.util.Scanner;

public class TranslatorController {

    public static void main(String[] args) throws IOException, SourceLoadingException {
        //initialization
        SourceLoader sourceLoader = new SourceLoader();
        Translator translator = new Translator(new URLSourceProvider());

        Scanner scanner = new Scanner(System.in);
        String command = scanner.next();
        while (!"exit".equals(command)) {
            //TODO: add exception handling here to let user know about it and ask him to enter another path to translation
            //So, the only way to stop the application is to do that manually or type "exit"
            try {
                String source = sourceLoader.loadSource(command);
                String translation = translator.translate(source);

                System.out.println("Original: " + source);
                System.out.println("Translation: " + translation);
            }catch (SourceLoadingException | NullPointerException e){
                System.out.println("The file by the entered path does not exist. Please, try again: ");
            }
            command = scanner.next();
        }
    }
}
