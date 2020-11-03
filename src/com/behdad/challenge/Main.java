package com.behdad.challenge;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static boolean inProcessing = true;
    private static Scanner keyboard;

    public static void main(String[] args) {
        keyboard = new Scanner(System.in);
        MenuUtility.showMenu(true,0);
    }

    private static class MenuUtility {

        private MenuUtility() throws IllegalAccessException {
            throw new IllegalAccessException("unable to create object of this type");
        }

        public static void showMenu(boolean clear ,int whichMenu) {
            clear(clear);
            while(inProcessing) {
                switch (whichMenu) {
                    case -1 -> noAction();
                    case 0 -> showMainMenu();
                    case 1 -> showHelpMenu();
                    case 2, 3 -> showModelMenu();
                    case 21 -> addCityMenu();
                    case 22 -> addRoadMenu();
                    case 31 -> deleteCityMenu();
                    case 32 -> deleteRoadMenu();
                    case 4 -> showPathMenu();
                    case 5 -> inProcessing = false;
//                    default -> showError();
                }
                processAction(whichMenu);
            }
        }

        public static void processAction(int preAction){
            try {
                int option = readInput();
                boolean clear = false;
                String choice = "" + option;
                if(preAction == 2  || preAction == 3) {
                    choice = "" + preAction + option;
                    clear = true;
                }
                option = Integer.valueOf(choice);
                showMenu(clear,option);
            } catch (InputValidationException e) {
                showError();
                MenuUtility.showMenu(false,-1);
            }
        }

        private static void showError() {
            System.out.println("Invalid input. Please enter 1 for more info.");
        }

        private static void noAction() {
        }

        private static void clear(boolean clear) {
            if(clear) {
                try {
                    if (System.getProperty("os.name").contains("Windows"))
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    else
                        Runtime.getRuntime().exec("clear");
                } catch (IOException | InterruptedException ex) {
                }
            }
        }

        private static void showMainMenu() {
            System.out.println("");
            System.out.println("Main Menu - Select an action:");
            System.out.println("1. Help");
            System.out.println("2. Add");
            System.out.println("3. Delete");
            System.out.println("4. Path");
            System.out.println("5. Exit");
        }

        private static void showHelpMenu() {
            System.out.println("Select a number from shown menu and enter. For example 1 is for help.");
        }

        private static final String REGEX = "[1-5]";
        private static int readInput() throws InputValidationException {
            int input = 0;
            boolean b = keyboard.hasNextLine();
            if(b){
                String s = keyboard.nextLine();
                if(s.matches(REGEX)){
                    input = Integer.valueOf(s);
                }else{
                    throw new InputValidationException();
                }
            }
            return input;
        }

        private static void showModelMenu() {
            System.out.println("Select model:");
            System.out.println("1. City");
            System.out.println("2. Road");
        }

        private static void showPathMenu() {
            System.out.println("get path base on : <SourceCityId>:<DestinationCityId>");
        }

        private static void addRoadMenu() {
        }

        private static void addCityMenu() {
        }

        private static void deleteRoadMenu() {
        }

        private static void deleteCityMenu() {

        }

    }
}
