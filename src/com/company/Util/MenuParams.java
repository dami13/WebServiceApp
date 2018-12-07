package com.company.Util;

// Rewrite to singleton?!
public class MenuParams {
    public final static String CLAIM_PARAM = "-i";
    public final static String CREATE_NOTE_PARAM = "-c";
    public final static String SUBJECT_PARAM = "-s";
    public final static String BODY_PARAM = "-b";
    public final static String TOPIC_PARAM = "-t";
    public final static String AUTHOR_PARAM = "-a";
    public final static String USERNAME_PARAM = "-u";
    public final static String PASSWORD_PARAM = "-p";
    public final static String HELP_PARAM = "-help";

    public final static String CLAIM_INFO = CLAIM_PARAM + " claimNumber[String] - Print info about claim with claim number";
    public final static String CREATE_NOTE_INFO = CREATE_NOTE_PARAM + " require: -b [string] -a [string]  - Create note";
    public final static String SUBJECT_INFO = SUBJECT_PARAM + " subject[String]";
    public final static String BODY_INFO = BODY_PARAM + " body[String]";
    public final static String TOPIC_INFO = TOPIC_PARAM + " topic[String]";
    public final static String AUTHOR_INFO = AUTHOR_PARAM + " author[public id]";
    public final static String USERNAME_INFO = USERNAME_PARAM + " claimNumber[String] - Set authentication username";
    public final static String PASSWORD_INFO = PASSWORD_PARAM + " claimNumber[String] - Set authentication password";
    public final static String HELP_INFO = HELP_PARAM + " claimNumber[String] - Set authentication password";
}
