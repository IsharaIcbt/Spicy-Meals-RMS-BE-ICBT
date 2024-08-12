/**
 * @author :  Dinuth Dheeraka
 * Created : 8/4/2023 11:48 AM
 */
package com.ceyentra.sm.constant;

public class ApplicationConstant {

    public static final String APPLICATION_ERROR_OCCURRED_MESSAGE = "Application Error Occurred.";

    /*s3 bucket meal images path */
    public static final String MEALS_S3_BUCKET_FOLDER = "meals/";
    public static final String FACILITY_S3_BUCKET_FOLDER = "facility/";

    public static final String API_BASE_URL = "/v1";
    public static final int COMMON_ERROR_CODE = 100;
    public static final int USER_NOT_FOUND = 404;
    public static final int UNAUTHORIZED_USER = 401;
    public static final int INVALID_EMAIL = 620;
    public static final int EMAILS_ARE_SAME = 703;
    public static final int OTP_TIME_OUT = 723;
    public static final int INVALID_OTP = 724;
}
