/**
 * @author :  Dinuth Dheeraka
 * Created : 8/4/2023 12:04 PM
 */
package com.ceyentra.sm.constant;

public class OAuth2Constant {
    public static final String ADMIN_CLIENT_ID = "ADMIN";
    public static final String STAFF_CLIENT_ID = "STAFF";
    public static final String USER_CLIENT_ID = "USER";
    public static final String CLIENT_SECRET = "";
    public static final String GRANT_TYPE_PASSWORD = "password";
    public static final String AUTHORIZATION_CODE = "authorization_code";
    public static final String REFRESH_TOKEN = "refresh_token";
    public static final String IMPLICIT = "implicit";
    public static final String SCOPE_READ = "read";
    public static final String SCOPE_WRITE = "write";
    public static final String TRUST = "trust";
    public static final int ACCESS_TOKEN_VALIDITY_SECONDS = 60 * 60 * 24 * 30;
    public static final int REFRESH_TOKEN_VALIDITY_SECONDS = 60 * 60 * 24 * 30;
    public static final String TOKEN_SIGN_IN_KEY = "D0HE63E26R556A5K6E3A72357538782F413F4D28H7EB4BE250R45A675K6BA970";
}
