package com.company;

import com.company.Data.Note;

public class Main {

    public static void main(String[] args) {
	    System.out.println("Hello World");
        System.out.println(args.length);

        if(args.length > 0){
            tryGetParams(args);
        }
    }

    private static void tryGetParams(String[] args) {
        try {
            getParams(args);
        } catch (NumberFormatException e) {
            System.err.println("Argument" + args[0] + " wrong type");
            System.exit(1);
        }
        catch ( ArrayIndexOutOfBoundsException e){
            System.err.println("Missing argument");
            System.exit(1);
        }
    }

    private static void getParams(String[] args) {
        for(int i=0; i < args.length; i++) {
            switch (args[i]) {
                case "-s":
                    printClaimInfo(args[++i]);
                    //Integer.parseInt(args[0]);
                    break;
                case "-c":
                    addNote(createNote(args, i));
                    break;
            }
        }
    }

    private static void printClaimInfo(String claimNumber) {
        System.out.println(claimNumber);
        //todo
        StringBuilder sb = new StringBuilder();
        sb.append(getDescription(claimNumber));
        sb.append("\n");
        sb.append(getClaimSummary(claimNumber));
        System.out.println(sb.toString());
    }

    private static String getDescription(String claimNumber){

        return "e";
    }

    private static String getClaimSummary(String claimNumber){

        return "e";
    }

    private static Note createNote(String[] args, int i) {
        Note n = new Note();
        n.setSubject(args[++i]);
        n.setBody(args[++i]);
        n.setTopic(args[++i]);
        n.setSubject(args[++i]);
        return n;
    }

    private static boolean addNote(Note note){
        //TODO
        return true;
    }
}