package com.company;

import com.company.API.WebserviceApi;
import com.company.Data.Note;

import static com.company.Util.MenuParams.*;

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
            switch (args[i].toLowerCase()) {
                case CLAIM_INFO:
                    printClaimInfo(args[i+1]);
                    break;
                case CREATE_NOTE_PARAM:
                    addNote(createNote(args, i));
                    break;
                case USERNAME_PARAM:
                    WebserviceApi.UserName = args[i+1];
                    break;
                case PASSWORD_PARAM:
                    WebserviceApi.Password = args[i+1];
                    break;
                case HELP_PARAM:
                    showHelp();
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
        return WebserviceApi.getInstance().tryPost("d");
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

    private static void showHelp() {
        System.out.println("Commands: ");
        System.out.println("----------- ");
        System.out.println(CLAIM_INFO);
        System.out.println(CREATE_NOTE_INFO);
        System.out.println(SUBJECT_INFO);
        System.out.println(BODY_INFO);
        System.out.println(TOPIC_INFO);
        System.out.println(AUTHOR_INFO);
        System.out.println(USERNAME_INFO);
        System.out.println(PASSWORD_INFO);
    }
}