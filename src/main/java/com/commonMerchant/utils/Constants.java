package com.commonMerchant.utils;

public class Constants {

    public static final long ACCESS_TOKEN_VALIDITY_SECONDS  = 5*60*60;
    public static final String SIGNING_KEY                  = "";
    public static final String AUTHORITIES_KEY              = "authorities";

    // RESPONSE MESSAGE GENERIC TYPES
    public static final String STATUS                       = "status";
    public static final String MESSAGE                      = "message";
    public static final String TOKEN                        = "token";

    public static final String CREATED                        = "CREATED";
    public static final String UPDATED                        = "UPDATED";
    public static final String MAINTENANCE                    = "MAINTENANCE";

    // PASSWORD VALIDATION
    public static final String PASSWORD_TOO_SHORT           = "Password must contain at least 8 characters.";
    public static final String PASSWORD_TOO_LONG            = "Password must contain at most 30 characters";
    public static final String PASSWORD_UPPER_CASE          = "Password must contain at least 1 upper case.";
    public static final String PASSWORD_LOWER_CASE          = "Password must contain at least 1 lower case.";
    public static final String PASSWORD_DIGIT               = "Password must contain at least 1 digit.";
    public static final String PASSWORD_ALPHABETIC          = "Password must contain at least 1 alphabetic character.";
}
