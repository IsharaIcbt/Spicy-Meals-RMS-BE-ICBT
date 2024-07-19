/**
 * @author :  Dinuth Dheeraka
 * Created : 8/11/2023 2:16 AM
 */
package com.ceyentra.sm.constant;

import com.ceyentra.sm.dto.SampleRequestDTO;
import com.ceyentra.sm.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class EmailTemplateConstant {

    public static final String NEW_USER_ACCOUNT_CREDENTIAL_EMAIL_SUBJECT = "Welcome to JKL Sample Request System.";
    public static final String SEND_USER_PASSWORD_RESET_OTP_EMAIL_SUBJECT = "Use this OTP to reset your password.";
    public static final String SEND_USER_RESET_PASSWORD_EMAIL_SUBJECT = "Your password has been reset.";
    public static final String SEND_NEW_SAMPLE_REQUEST_EMAIL_SUBJECT = "New sample request : ID ";
    public static final String SEND_BUYER_SAMPLE_REQUEST__DECLINED_EMAIL_SUBJECT = "Sample request declined : ID ";
    public static final String SEND_BUYER_SAMPLE_REQUEST_ACCEPTED_EMAIL_SUBJECT = "Sample request accepted : ID ";

    public String sendUserAccountDetailsTemplate(UserDTO userDTO) {
        return "<!DOCTYPE html>\n" +
                "\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <title></title>\n" +
                "    <meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\"/>\n" +
                "    <meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\"/>\n" +
                "    <!--[if mso]>\n" +
                "    <xml>\n" +
                "        <o:OfficeDocumentSettings>\n" +
                "            <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
                "            <o:AllowPNG/>\n" +
                "        </o:OfficeDocumentSettings>\n" +
                "    </xml><![endif]--><!--[if !mso]><!-->\n" +
                "    <link href=\"https://fonts.googleapis.com/css?family=Noto+Serif\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
                "    <link href=\"https://fonts.googleapis.com/css2?family=Inter&family=Work+Sans:wght@700&display=swap\" rel=\"stylesheet\"\n" +
                "          type=\"text/css\"/>\n" +
                "    <link href=\"https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;600;700;800;900\"\n" +
                "          rel=\"stylesheet\" type=\"text/css\"/><!--<![endif]-->\n" +
                "    <style>\n" +
                "        * {\n" +
                "            box-sizing: border-box;\n" +
                "        }\n" +
                "\n" +
                "        body {\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "        }\n" +
                "\n" +
                "        a[x-apple-data-detectors] {\n" +
                "            color: inherit !important;\n" +
                "            text-decoration: inherit !important;\n" +
                "        }\n" +
                "\n" +
                "        #MessageViewBody a {\n" +
                "            color: inherit;\n" +
                "            text-decoration: none;\n" +
                "        }\n" +
                "\n" +
                "        p {\n" +
                "            line-height: inherit\n" +
                "        }\n" +
                "\n" +
                "        .desktop_hide,\n" +
                "        .desktop_hide table {\n" +
                "            mso-hide: all;\n" +
                "            display: none;\n" +
                "            max-height: 0px;\n" +
                "            overflow: hidden;\n" +
                "        }\n" +
                "\n" +
                "        .image_block img + div {\n" +
                "            display: none;\n" +
                "        }\n" +
                "\n" +
                "        @media (max-width: 550px) {\n" +
                "            .desktop_hide table.icons-inner {\n" +
                "                display: inline-block !important;\n" +
                "            }\n" +
                "\n" +
                "            .icons-inner {\n" +
                "                text-align: center;\n" +
                "            }\n" +
                "\n" +
                "            .icons-inner td {\n" +
                "                margin: 0 auto;\n" +
                "            }\n" +
                "\n" +
                "            .mobile_hide {\n" +
                "                display: none;\n" +
                "            }\n" +
                "\n" +
                "            .row-content {\n" +
                "                width: 100% !important;\n" +
                "            }\n" +
                "\n" +
                "            .stack .column {\n" +
                "                width: 100%;\n" +
                "                display: block;\n" +
                "            }\n" +
                "\n" +
                "            .mobile_hide {\n" +
                "                min-height: 0;\n" +
                "                max-height: 0;\n" +
                "                max-width: 0;\n" +
                "                overflow: hidden;\n" +
                "                font-size: 0px;\n" +
                "            }\n" +
                "\n" +
                "            .desktop_hide,\n" +
                "            .desktop_hide table {\n" +
                "                display: table !important;\n" +
                "                max-height: none !important;\n" +
                "            }\n" +
                "\n" +
                "            .row-4 .column-1 {\n" +
                "                padding: 5px 25px !important;\n" +
                "            }\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body style=\"margin: 0; background-color: #fff; padding: 0; -webkit-text-size-adjust: none; text-size-adjust: none;\">\n" +
                "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"nl-container\" role=\"presentation\"\n" +
                "       style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fff;\" width=\"100%\">\n" +
                "    <tbody>\n" +
                "    <tr>\n" +
                "        <td>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-1\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ede9e9;\" width=\"100%\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\"\n" +
                "                               role=\"presentation\"\n" +
                "                               style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fff; border-bottom: 0 solid #efeef4; border-left: 0 solid #efeef4; border-radius: 0; border-right: 0px solid #efeef4; border-top: 0 solid #efeef4; color: #000; width: 530px; margin: 0 auto;\"\n" +
                "                               width=\"530\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td class=\"column column-1\"\n" +
                "                                    style=\"font-weight: 400; text-align: left; mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffffff; border-bottom: 1px solid transparent; border-left: 1px solid transparent; border-right: 1px solid transparent; border-top: 1px solid transparent; padding-top: 10px; vertical-align: top;\"\n" +
                "                                    width=\"100%\">\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"icons_block block-1\"\n" +
                "                                           role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\"\n" +
                "                                                style=\"vertical-align: middle; color: #4f5aba; font-family: 'Noto Serif', Georgia, serif; font-size: 24px; letter-spacing: 0px; padding-bottom: 5px; padding-top: 5px; text-align: center;\">\n" +
                "                                                <table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"alignment\"\n" +
                "                                                       role=\"presentation\"\n" +
                "                                                       style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
                "                                                    <tr>\n" +
                "                                                        <td style=\"vertical-align: middle; text-align: center; padding-top: 10px; padding-bottom: 0px; padding-left: 20px; padding-right: 20px;\">\n" +
                "                                                            <a href=\"https://www.example.com\"\n" +
                "                                                               style=\"text-decoration: none;\" target=\"_self\"><img\n" +
                "                                                                    align=\"center\" alt=\"new year celebration\"\n" +
                "                                                                    class=\"icon\" height=\"64\"\n" +
                "                                                                    src=\"https://jkl.ceyentra.lk/srs/templateresources/jkl-logo.png\"\n" +
                "                                                                    style=\"display: block; height: auto; margin: 0 auto; border: 0;\"\n" +
                "                                                                    width=\"49\"/></a></td>\n" +
                "                                                    </tr>\n" +
                "                                                </table>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"heading_block block-2\"\n" +
                "                                           role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\" style=\"padding-top:10px;text-align:center;width:100%;\">\n" +
                "                                                <h1 style=\"margin: 0; color: #1a2028; direction: ltr; font-family: 'Roboto', Tahoma, Verdana, Segoe, sans-serif; font-size: 36px; font-weight: 700; letter-spacing: 1px; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0;\">\n" +
                "                                                    <span class=\"tinyMce-placeholder\">John Keells PLC</span></h1>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                    <table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"paragraph_block block-3\"\n" +
                "                                           role=\"presentation\"\n" +
                "                                           style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\">\n" +
                "                                                <div style=\"color:#68d268;direction:ltr;font-family:Inter, sans-serif;font-size:20px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:center;mso-line-height-alt:24px;\">\n" +
                "                                                    <p style=\"margin: 0;\">Congratulations !</p>\n" +
                "                                                </div>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                    <table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"paragraph_block block-4\"\n" +
                "                                           role=\"presentation\"\n" +
                "                                           style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\">\n" +
                "                                                <div style=\"color:#101112;direction:ltr;font-family:Inter, sans-serif;font-size:14px;font-weight:700;letter-spacing:0px;line-height:120%;text-align:center;mso-line-height-alt:16.8px;\">\n" +
                "                                                    <p style=\"margin: 0;\">Your account has been created successfully </p>\n" +
                "                                                </div>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"image_block block-5\"\n" +
                "                                           role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\" style=\"width:100%;padding-right:0px;padding-left:0px;\">\n" +
                "                                                <div align=\"center\" class=\"alignment\" style=\"line-height:10px\"><img\n" +
                "                                                        src=\"https://jkl.ceyentra.lk/srs/templateresources/tea-picker.png\"\n" +
                "                                                        style=\"display: block; height: auto; border: 0; max-width: 185px; width: 100%;\"\n" +
                "                                                        width=\"185\"/></div>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-2\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ede9e9;\" width=\"100%\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\"\n" +
                "                               role=\"presentation\"\n" +
                "                               style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fff; color: #000; width: 530px; margin: 0 auto;\"\n" +
                "                               width=\"530\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td class=\"column column-1\"\n" +
                "                                    style=\"font-weight: 400; text-align: left; mso-table-lspace: 0pt; mso-table-rspace: 0pt; padding-bottom: 15px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n" +
                "                                    width=\"100%\"><!--[if mso]>\n" +
                "                                    <style>#list-r1c0m0 ul {\n" +
                "                                        margin: 0 !important;\n" +
                "                                        padding: 0 !important;\n" +
                "                                    }\n" +
                "\n" +
                "                                    #list-r1c0m0 ul li {\n" +
                "                                        mso-special-format: bullet;\n" +
                "                                    }\n" +
                "\n" +
                "                                    #list-r1c0m0 .levelOne li {\n" +
                "                                        margin-top: 0 !important;\n" +
                "                                    }\n" +
                "\n" +
                "                                    #list-r1c0m0 .levelOne {\n" +
                "                                        margin-left: -20px !important;\n" +
                "                                    }\n" +
                "\n" +
                "                                    #list-r1c0m0 .levelTwo li {\n" +
                "                                        margin-top: 0 !important;\n" +
                "                                    }\n" +
                "\n" +
                "                                    #list-r1c0m0 .levelTwo {\n" +
                "                                        margin-left: 10px !important;\n" +
                "                                    }\n" +
                "\n" +
                "                                    #list-r1c0m0 .levelThree li {\n" +
                "                                        margin-top: 0 !important;\n" +
                "                                    }\n" +
                "\n" +
                "                                    #list-r1c0m0 .levelThree {\n" +
                "                                        margin-left: 40px !important;\n" +
                "                                    }\n" +
                "\n" +
                "                                    #list-r1c0m0 .levelFour li {\n" +
                "                                        margin-top: 0 !important;\n" +
                "                                    }\n" +
                "\n" +
                "                                    #list-r1c0m0 .levelFour {\n" +
                "                                        margin-left: 70px !important;\n" +
                "                                    }</style><![endif]-->\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"list_block block-1\"\n" +
                "                                           id=\"list-r1c0m0\" role=\"presentation\"\n" +
                "                                           style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\"\n" +
                "                                                style=\"padding-bottom:10px;padding-left:30px;padding-right:30px;padding-top:10px;\">\n" +
                "                                                <div class=\"levelThree\" style=\"margin-left: 60px;\">\n" +
                "                                                    <ul class=\"leftList\"\n" +
                "                                                        style=\"margin-top: 0; margin-bottom: 0; padding: 0; padding-left: 20px; font-weight: 400; text-align: left; color: #101112; direction: ltr; font-family: Roboto,Tahoma,Verdana,Segoe,sans-serif; font-size: 14px; letter-spacing: 0; line-height: 180%; mso-line-height-alt: 25.2px; list-style-type: disc;\">\n" +
                "                                                        <li style=\"margin-bottom: 0; text-align: left;\"><strong>Portal\n" +
                "                                                            Link  : </strong> <a href=\"https://jkl.ceyentra.lk/srs/\">jkl.ceyentra.lk/srs</a>\n" +
                "                                                        </li>\n" +
                "                                                        <li style=\"margin-bottom: 0; text-align: left;\"><strong>E Mail \n" +
                "                                                            :</strong>  " + userDTO.getEmail() + "\n" +
                "                                                        </li>\n" +
                "                                                        <li style=\"margin-bottom: 0; text-align: left;\"><strong>Password \n" +
                "                                                            :</strong>  " + userDTO.getPassword() + "</li>\n" +
                "                                                    </ul>\n" +
                "                                                </div>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-3\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ede9e9;\" width=\"100%\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\"\n" +
                "                               role=\"presentation\"\n" +
                "                               style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fff; border-radius: 0; color: #000; width: 530px; margin: 0 auto;\"\n" +
                "                               width=\"530\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td class=\"column column-1\"\n" +
                "                                    style=\"font-weight: 400; text-align: left; mso-table-lspace: 0pt; mso-table-rspace: 0pt; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n" +
                "                                    width=\"100%\">\n" +
                "                                    <table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"divider_block block-1\"\n" +
                "                                           role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\">\n" +
                "                                                <div align=\"center\" class=\"alignment\">\n" +
                "                                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                                           role=\"presentation\"\n" +
                "                                                           style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                "                                                           width=\"100%\">\n" +
                "                                                        <tr>\n" +
                "                                                            <td class=\"divider_inner\"\n" +
                "                                                                style=\"font-size: 1px; line-height: 1px; border-top: 1px solid #dddddd;\">\n" +
                "                                                                <span> </span></td>\n" +
                "                                                        </tr>\n" +
                "                                                    </table>\n" +
                "                                                </div>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-4\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ede9e9; background-size: auto;\"\n" +
                "                   width=\"100%\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\"\n" +
                "                               role=\"presentation\"\n" +
                "                               style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-size: auto; background-color: #88b44e; border-radius: 0; color: #000; width: 530px; margin: 0 auto;\"\n" +
                "                               width=\"530\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td class=\"column column-1\"\n" +
                "                                    style=\"font-weight: 400; text-align: left; mso-table-lspace: 0pt; mso-table-rspace: 0pt; padding-bottom: 10px; padding-left: 10px; padding-right: 10px; padding-top: 10px; vertical-align: middle; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n" +
                "                                    width=\"100%\">\n" +
                "                                    <table border=\"0\" cellpadding=\"5\" cellspacing=\"0\" class=\"paragraph_block block-1\"\n" +
                "                                           role=\"presentation\"\n" +
                "                                           style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\">\n" +
                "                                                <div style=\"color:#ffffff;direction:ltr;font-family:'Roboto', Tahoma, Verdana, Segoe, sans-serif;font-size:11px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:center;mso-line-height-alt:13.2px;\">\n" +
                "                                                    <p style=\"margin: 0; margin-bottom: 16px;\">www.johnkeellstea.com</p>\n" +
                "                                                    <p style=\"margin: 0; margin-bottom: 16px;\">Finally House, 186 ,\n" +
                "                                                        Vauxhall Street, Colombo 2 , Srilanka</p>\n" +
                "                                                    <p style=\"margin: 0;\">+94 112 30 6000</p>\n" +
                "                                                </div>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "    </tbody>\n" +
                "</table><!-- End -->\n" +
                "</body>\n" +
                "</html>";
    }

    public String sendUserNewPasswordTemplate(String password) {
        return "<!DOCTYPE html>\n" +
                "\n" +
                "<html lang=\"en\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:v=\"urn:schemas-microsoft-com:vml\">\n" +
                "<head>\n" +
                "<title></title>\n" +
                "<meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\"/>\n" +
                "<meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\"/><!--[if mso]><xml><o:OfficeDocumentSettings><o:PixelsPerInch>96</o:PixelsPerInch><o:AllowPNG/></o:OfficeDocumentSettings></xml><![endif]--><!--[if !mso]><!-->\n" +
                "<link href=\"https://fonts.googleapis.com/css?family=Noto+Serif\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
                "<link href=\"https://fonts.googleapis.com/css2?family=Inter&family=Work+Sans:wght@700&display=swap\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
                "<link href=\"https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;600;700;800;900\" rel=\"stylesheet\" type=\"text/css\"/><!--<![endif]-->\n" +
                "<style>\n" +
                "\t\t* {\n" +
                "\t\t\tbox-sizing: border-box;\n" +
                "\t\t}\n" +
                "\n" +
                "\t\tbody {\n" +
                "\t\t\tmargin: 0;\n" +
                "\t\t\tpadding: 0;\n" +
                "\t\t}\n" +
                "\n" +
                "\t\ta[x-apple-data-detectors] {\n" +
                "\t\t\tcolor: inherit !important;\n" +
                "\t\t\ttext-decoration: inherit !important;\n" +
                "\t\t}\n" +
                "\n" +
                "\t\t#MessageViewBody a {\n" +
                "\t\t\tcolor: inherit;\n" +
                "\t\t\ttext-decoration: none;\n" +
                "\t\t}\n" +
                "\n" +
                "\t\tp {\n" +
                "\t\t\tline-height: inherit\n" +
                "\t\t}\n" +
                "\n" +
                "\t\t.desktop_hide,\n" +
                "\t\t.desktop_hide table {\n" +
                "\t\t\tmso-hide: all;\n" +
                "\t\t\tdisplay: none;\n" +
                "\t\t\tmax-height: 0px;\n" +
                "\t\t\toverflow: hidden;\n" +
                "\t\t}\n" +
                "\n" +
                "\t\t.image_block img+div {\n" +
                "\t\t\tdisplay: none;\n" +
                "\t\t}\n" +
                "\n" +
                "\t\t@media (max-width:550px) {\n" +
                "\t\t\t.desktop_hide table.icons-inner {\n" +
                "\t\t\t\tdisplay: inline-block !important;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.icons-inner {\n" +
                "\t\t\t\ttext-align: center;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.icons-inner td {\n" +
                "\t\t\t\tmargin: 0 auto;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.mobile_hide {\n" +
                "\t\t\t\tdisplay: none;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.row-content {\n" +
                "\t\t\t\twidth: 100% !important;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.stack .column {\n" +
                "\t\t\t\twidth: 100%;\n" +
                "\t\t\t\tdisplay: block;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.mobile_hide {\n" +
                "\t\t\t\tmin-height: 0;\n" +
                "\t\t\t\tmax-height: 0;\n" +
                "\t\t\t\tmax-width: 0;\n" +
                "\t\t\t\toverflow: hidden;\n" +
                "\t\t\t\tfont-size: 0px;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.desktop_hide,\n" +
                "\t\t\t.desktop_hide table {\n" +
                "\t\t\t\tdisplay: table !important;\n" +
                "\t\t\t\tmax-height: none !important;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.row-4 .column-1 {\n" +
                "\t\t\t\tpadding: 5px 25px !important;\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t</style>\n" +
                "</head>\n" +
                "<body style=\"margin: 0; background-color: #fff; padding: 0; -webkit-text-size-adjust: none; text-size-adjust: none;\">\n" +
                "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"nl-container\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fff;\" width=\"100%\">\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td>\n" +
                "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ede9e9;\" width=\"100%\">\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td>\n" +
                "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fff; border-bottom: 0 solid #efeef4; border-left: 0 solid #efeef4; border-radius: 0; border-right: 0px solid #efeef4; border-top: 0 solid #efeef4; color: #000; width: 530px; margin: 0 auto;\" width=\"530\">\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; background-color: #ffffff; border-bottom: 1px solid transparent; border-left: 1px solid transparent; border-right: 1px solid transparent; border-top: 1px solid transparent; padding-top: 10px; vertical-align: top;\" width=\"100%\">\n" +
                "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"icons_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                "<tr>\n" +
                "<td class=\"pad\" style=\"vertical-align: middle; color: #4f5aba; font-family: 'Noto Serif', Georgia, serif; font-size: 24px; letter-spacing: 0px; padding-bottom: 5px; padding-top: 5px; text-align: center;\">\n" +
                "<table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"alignment\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
                "<tr>\n" +
                "<td style=\"vertical-align: middle; text-align: center; padding-top: 10px; padding-bottom: 0px; padding-left: 20px; padding-right: 20px;\"><a href=\"https://www.example.com\" style=\"text-decoration: none;\" target=\"_self\"><img align=\"center\" alt=\"logo\" class=\"icon\" height=\"64\" src=\"https://jkl.ceyentra.lk/srs/templateresources/jkl-logo.png\" style=\"display: block; height: auto; margin: 0 auto; border: 0;\" width=\"49\"/></a></td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"heading_block block-2\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                "<tr>\n" +
                "<td class=\"pad\" style=\"padding-top:10px;text-align:center;width:100%;\">\n" +
                "<h1 style=\"margin: 0; color: #1a2028; direction: ltr; font-family: 'Roboto', Tahoma, Verdana, Segoe, sans-serif; font-size: 36px; font-weight: 700; letter-spacing: 1px; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0;\"><span class=\"tinyMce-placeholder\">John Keells PLC</span></h1>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"paragraph_block block-3\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
                "<tr>\n" +
                "<td class=\"pad\" style=\"padding-bottom:10px;padding-left:10px;padding-right:10px;padding-top:20px;\">\n" +
                "<div style=\"color:#101112;direction:ltr;font-family:Inter, sans-serif;font-size:14px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:center;mso-line-height-alt:16.8px;\">\n" +
                "<p style=\"margin: 0; margin-bottom: 3px;\">Your password has been reset. Please, use the bellow password login to the system.</p>\n" +
                "</div>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"image_block block-4\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                "<tr>\n" +
                "<td class=\"pad\" style=\"width:100%;padding-right:0px;padding-left:0px;\">\n" +
                "<div align=\"center\" class=\"alignment\" style=\"line-height:10px\"><img src=\"https://jkl.ceyentra.lk/srs/templateresources/forgot-password.png\" style=\"display: block; height: auto; border: 0; max-width: 185px; width: 100%;\" width=\"185\"/></div>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"heading_block block-5\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                "<tr>\n" +
                "<td class=\"pad\">\n" +
                "<h3 style=\"margin: 0; color: #262626; direction: ltr; font-family: Inter, sans-serif; font-size: 14px; font-weight: 700; letter-spacing: normal; line-height: 150%; text-align: center; margin-top: 0; margin-bottom: 0;\"><span class=\"tinyMce-placeholder\">Your New Password </span></h3>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-2\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ede9e9;\" width=\"100%\">\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td>\n" +
                "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fff; border-radius: 0; color: #000; width: 530px; margin: 0 auto;\" width=\"530\">\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; background-color: #ffffff; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"25%\">\n" +
                "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"empty_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                "<tr>\n" +
                "<td class=\"pad\">\n" +
                "<div></div>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</td>\n" +
                "<td class=\"column column-2\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; border-bottom: 2px solid #88B44E; border-left: 2px solid #88B44E; border-right: 2px solid #88B44E; border-top: 2px solid #88B44E; vertical-align: top;\" width=\"50%\">\n" +
                "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"heading_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                "<tr>\n" +
                "<td class=\"pad\">\n" +
                "<h1 style=\"margin: 0; color: #88b44e; direction: ltr; font-family: 'Roboto', Tahoma, Verdana, Segoe, sans-serif; font-size: 21px; font-weight: 700; letter-spacing: 5px; line-height: 200%; text-align: center; margin-top: 0; margin-bottom: 0;\"><span class=\"tinyMce-placeholder\">" + password + "</span></h1>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</td>\n" +
                "<td class=\"column column-3\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"25%\">\n" +
                "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"empty_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                "<tr>\n" +
                "<td class=\"pad\">\n" +
                "<div></div>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-3\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ede9e9;\" width=\"100%\">\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td>\n" +
                "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fff; border-radius: 0; color: #000; width: 530px; margin: 0 auto;\" width=\"530\">\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"100%\">\n" +
                "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"divider_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                "<tr>\n" +
                "<td class=\"pad\">\n" +
                "<div align=\"center\" class=\"alignment\">\n" +
                "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                "<tr>\n" +
                "<td class=\"divider_inner\" style=\"font-size: 1px; line-height: 1px; border-top: 1px solid #dddddd;\"><span> </span></td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</div>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-4\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ede9e9; background-size: auto;\" width=\"100%\">\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td>\n" +
                "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-size: auto; background-color: #88b44e; border-radius: 0; color: #000; width: 530px; margin: 0 auto;\" width=\"530\">\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 10px; padding-left: 10px; padding-right: 10px; padding-top: 10px; vertical-align: middle; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"100%\">\n" +
                "<table border=\"0\" cellpadding=\"5\" cellspacing=\"0\" class=\"paragraph_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
                "<tr>\n" +
                "<td class=\"pad\">\n" +
                "<div style=\"color:#ffffff;direction:ltr;font-family:'Roboto', Tahoma, Verdana, Segoe, sans-serif;font-size:11px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:center;mso-line-height-alt:13.2px;\">\n" +
                "<p style=\"margin: 0; margin-bottom: 16px;\">www.johnkeellstea.com</p>\n" +
                "<p style=\"margin: 0; margin-bottom: 16px;\">Finally House, 186 , Vauxhall Street, Colombo 2 , Srilanka</p>\n" +
                "<p style=\"margin: 0;\">+94 112 30 6000</p>\n" +
                "</div>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-5\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td>\n" +
                "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000; width: 530px; margin: 0 auto;\" width=\"530\">\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table><!-- End -->\n" +
                "</body>\n" +
                "</html>";
    }

    public String sendUserOTPTemplate(int OTP) {
        return "<!DOCTYPE html>\n" +
                "\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <title></title>\n" +
                "    <meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\"/>\n" +
                "    <meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\"/>\n" +
                "    <!--[if mso]>\n" +
                "    <xml>\n" +
                "        <o:OfficeDocumentSettings>\n" +
                "            <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
                "            <o:AllowPNG/>\n" +
                "        </o:OfficeDocumentSettings>\n" +
                "    </xml><![endif]--><!--[if !mso]><!-->\n" +
                "    <link href=\"https://fonts.googleapis.com/css?family=Noto+Serif\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
                "    <link href=\"https://fonts.googleapis.com/css2?family=Inter&family=Work+Sans:wght@700&display=swap\" rel=\"stylesheet\"\n" +
                "          type=\"text/css\"/>\n" +
                "    <link href=\"https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;600;700;800;900\"\n" +
                "          rel=\"stylesheet\" type=\"text/css\"/><!--<![endif]-->\n" +
                "\t<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n" +
                "\t<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n" +
                "\t<link href=\"https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500&display=swap\" rel=\"stylesheet\">\n" +
                "    <style>\n" +
                "        * {\n" +
                "            box-sizing: border-box;\n" +
                "        }\n" +
                "\n" +
                "        body {\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "        }\n" +
                "\n" +
                "        a[x-apple-data-detectors] {\n" +
                "            color: inherit !important;\n" +
                "            text-decoration: inherit !important;\n" +
                "        }\n" +
                "\n" +
                "        #MessageViewBody a {\n" +
                "            color: inherit;\n" +
                "            text-decoration: none;\n" +
                "        }\n" +
                "\n" +
                "        p {\n" +
                "            line-height: inherit\n" +
                "        }\n" +
                "\n" +
                "        .desktop_hide,\n" +
                "        .desktop_hide table {\n" +
                "            mso-hide: all;\n" +
                "            display: none;\n" +
                "            max-height: 0px;\n" +
                "            overflow: hidden;\n" +
                "        }\n" +
                "\n" +
                "        .image_block img + div {\n" +
                "            display: none;\n" +
                "        }\n" +
                "\n" +
                "        @media (max-width: 620px) {\n" +
                "            .desktop_hide table.icons-inner {\n" +
                "                display: inline-block !important;\n" +
                "            }\n" +
                "\n" +
                "            .icons-inner {\n" +
                "                text-align: center;\n" +
                "            }\n" +
                "\n" +
                "            .icons-inner td {\n" +
                "                margin: 0 auto;\n" +
                "            }\n" +
                "\n" +
                "            .mobile_hide {\n" +
                "                display: none;\n" +
                "            }\n" +
                "\n" +
                "            .row-content {\n" +
                "                width: 100% !important;\n" +
                "            }\n" +
                "\n" +
                "            .stack .column {\n" +
                "                width: 100%;\n" +
                "                display: block;\n" +
                "            }\n" +
                "\n" +
                "            .mobile_hide {\n" +
                "                min-height: 0;\n" +
                "                max-height: 0;\n" +
                "                max-width: 0;\n" +
                "                overflow: hidden;\n" +
                "                font-size: 0px;\n" +
                "            }\n" +
                "\n" +
                "            .desktop_hide,\n" +
                "            .desktop_hide table {\n" +
                "                display: table !important;\n" +
                "                max-height: none !important;\n" +
                "            }\n" +
                "\n" +
                "            .row-4 .column-1 {\n" +
                "                padding: 5px 25px !important;\n" +
                "            }\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body style=\"margin: 0; background-color: #fff; padding: 0; -webkit-text-size-adjust: none; text-size-adjust: none;\">\n" +
                "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"nl-container\" role=\"presentation\"\n" +
                "       style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fff;\" width=\"100%\">\n" +
                "    <tbody>\n" +
                "    <tr>\n" +
                "        <td>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-1\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ede9e9;\" width=\"100%\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\"\n" +
                "                               role=\"presentation\"\n" +
                "                               style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fff; border-radius: 0; color: #000; border-bottom: 0 solid #efeef4; border-left: 0 solid #efeef4; border-right: 0px solid #efeef4; border-top: 0 solid #efeef4; width: 600px; margin: 0 auto;\"\n" +
                "                               width=\"600\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td class=\"column column-1\"\n" +
                "                                    style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; background-color: #ffffff; border-bottom: 1px solid transparent; border-left: 1px solid transparent; border-right: 1px solid transparent; border-top: 1px solid transparent; padding-top: 10px; vertical-align: top;\"\n" +
                "                                    width=\"100%\">\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"icons_block block-1\"\n" +
                "                                           role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\"\n" +
                "                                                style=\"vertical-align: middle; color: #4f5aba; font-family: 'Noto Serif', Georgia, serif; font-size: 24px; letter-spacing: 0px; padding-bottom: 10px; padding-top: 10px; text-align: center;\">\n" +
                "                                                <table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"alignment\"\n" +
                "                                                       role=\"presentation\"\n" +
                "                                                       style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
                "                                                    <tr>\n" +
                "                                                        <td style=\"vertical-align: middle; text-align: center; padding-top: 10px; padding-bottom: 0px; padding-left: 20px; padding-right: 20px;\">\n" +
                "                                                            <a href=\"https://www.example.com\"\n" +
                "                                                               style=\"text-decoration: none;\" target=\"_self\"><img\n" +
                "                                                                    align=\"center\" alt=\"new year celebration\"\n" +
                "                                                                    class=\"icon\" height=\"64\"\n" +
                "                                                                    src=\"https://jkl.ceyentra.lk/srs/templateresources/jkl-logo.png\"\n" +
                "                                                                    style=\"display: block; height: auto; margin: 0 auto; border: 0;\"\n" +
                "                                                                    width=\"49\"/></a></td>\n" +
                "                                                    </tr>\n" +
                "                                                </table>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"heading_block block-2\"\n" +
                "                                           role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\" style=\"padding-top:10px;text-align:center;width:100%;\">\n" +
                "                                                <h1 style=\"margin: 0; color: #1a2028; direction: ltr; font-family: 'Roboto', Tahoma, Verdana, Segoe, sans-serif; font-size: 36px; font-weight: 700; letter-spacing: 1px; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0;\">\n" +
                "                                                    <span class=\"tinyMce-placeholder\">John Keells PLC</span></h1>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"paragraph_block block-3\"\n" +
                "                                           role=\"presentation\"\n" +
                "                                           style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\"\n" +
                "                                                style=\"padding-bottom:10px;padding-left:10px;padding-right:10px;padding-top:20px;\">\n" +
                "                                                <div style=\"color:#101112;direction:ltr;font-family:Inter, sans-serif;font-size:14px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:center;mso-line-height-alt:16.8px;\">\n" +
                "                                                    <p style=\"margin: 0; margin-bottom: 3px;\">Enter the validation code\n" +
                "                                                        we just sent</p>\n" +
                "                                                    <p style=\"margin: 0;\">you on your email address</p>\n" +
                "                                                </div>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"image_block block-4\"\n" +
                "                                           role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\" style=\"width:100%;padding-right:0px;padding-left:0px;\">\n" +
                "                                                <div align=\"center\" class=\"alignment\" style=\"line-height:10px\"><img\n" +
                "                                                        src=\"https://jkl.ceyentra.lk/srs/templateresources/forgot-password.png\"\n" +
                "                                                        style=\"display: block; height: auto; border: 0; max-width: 239px; width: 100%;\"\n" +
                "                                                        width=\"239\"/></div>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                    <table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"heading_block block-5\"\n" +
                "                                           role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\">\n" +
                "                                                <h3 style=\"margin: 0; color: #88b44e; direction: ltr; font-family: Inter, sans-serif; font-size: 14px; font-weight: 500; letter-spacing: normal; line-height: 150%; text-align: center; margin-top: 0; margin-bottom: 0;\">\n" +
                "                                                    <img src=\"https://jkl.ceyentra.lk/srs/templateresources/icon-lock.png\" style=\"margin-bottom: -2px;\" /> Forget Password Pin</h3>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-2\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ede9e9; background-size: auto;\"\n" +
                "                   width=\"100%\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "\n" +
                "\n" +
                "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-2\" role=\"presentation\"\n" +
                "       style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ede9e9; background-size: auto;\"\n" +
                "       width=\"100%\">\n" +
                "    <tbody>\n" +
                "    <tr>\n" +
                "        <td>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fff; background-size: auto; border-radius: 0; color: #000; width: 600px; margin: 0 auto;\" width=\"600\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td class=\"column column-center\" colspan=\"4\"\n" +
                "                        style=\"mso-table-lspace: 0pt;  mso-table-rspace: 0pt; font-weight: 400; text-align: center; vertical-align: top; padding-bottom: 5px; padding-top: 5px;\">\n" +
                "                        <!-- Start of OTP Divs -->\n" +
                "                        <div style=\"display: flex; justify-content: center; gap: 12px !important; align-items: center; margin-left: auto; margin-right: auto; max-width: 220px;\">\n" +
                "                            <div class=\"otp-div\" style=\"border: 2px solid #88B44E; margin-left:4px !important; border-radius: 5px; padding: 15px; width: 50px;\">\n" +
                "                                <p style=\"color: #88b44e; font-family: Inter, sans-serif; font-size: 14px; font-weight: 700; letter-spacing: 0px; line-height: 120%; margin: 0;\">" + String.valueOf(OTP).charAt(0) + "</p>\n" +
                "                            </div>\n" +
                "                            <div class=\"otp-div\" style=\"border: 2px solid #88B44E; margin-left:4px !important; border-radius: 5px; padding: 15px; width: 50px;\">\n" +
                "                                <p style=\"color: #88b44e; font-family: Inter, sans-serif; font-size: 14px; font-weight: 700; letter-spacing: 0px; line-height: 120%; margin: 0;\">" + String.valueOf(OTP).charAt(1) + "</p>\n" +
                "                            </div>\n" +
                "                            <div class=\"otp-div\" style=\"border: 2px solid #88B44E; margin-left:4px !important; border-radius: 5px; padding: 15px; width: 50px;\">\n" +
                "                                <p style=\"color: #88b44e; font-family: Inter, sans-serif; font-size: 14px; font-weight: 700; letter-spacing: 0px; line-height: 120%; margin: 0;\">" + String.valueOf(OTP).charAt(2) + "</p>\n" +
                "                            </div>\n" +
                "                            <div class=\"otp-div\" style=\"border: 2px solid #88B44E; margin-left:4px !important; border-radius: 5px; padding: 15px; width: 50px;\">\n" +
                "                                <p style=\"color: #88b44e; font-family: Inter, sans-serif; font-size: 14px; font-weight: 700; letter-spacing: 0px; line-height: 120%; margin: 0;\">" + String.valueOf(OTP).charAt(3) + "</p>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                        <!-- End of OTP Divs -->\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-3\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #EDE9E9;\" width=\"100%\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\"\n" +
                "                               role=\"presentation\"\n" +
                "                               style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fff; border-radius: 0; color: #000; width: 600px; margin: 0 auto;\"\n" +
                "                               width=\"600\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td class=\"column column-1\"\n" +
                "                                    style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n" +
                "                                    width=\"100%\">\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"paragraph_block block-1\"\n" +
                "                                           role=\"presentation\"\n" +
                "                                           style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\">\n" +
                "                                                <div style=\"color:#101112;direction:ltr;font-family:Inter, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:left;mso-line-height-alt:19.2px;\">\n" +
                "                                                     \n" +
                "                                                </div>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-4\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ede9e9; background-size: auto;\"\n" +
                "                   width=\"100%\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\"\n" +
                "                               role=\"presentation\"\n" +
                "                               style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-size: auto; border-radius: 0; color: #000; background-color: #88b44e; width: 600px; margin: 0 auto;\"\n" +
                "                               width=\"600\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td class=\"column column-1\"\n" +
                "                                    style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 10px; padding-left: 10px; padding-right: 10px; padding-top: 10px; vertical-align: middle; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n" +
                "                                    width=\"100%\">\n" +
                "                                    <table border=\"0\" cellpadding=\"5\" cellspacing=\"0\" class=\"paragraph_block block-1\"\n" +
                "                                           role=\"presentation\"\n" +
                "                                           style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\">\n" +
                "                                                <div style=\"color:#ffffff;direction:ltr;font-family:'Roboto', Tahoma, Verdana, Segoe, sans-serif;font-size:11px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:center;mso-line-height-alt:13.2px;\">\n" +
                "                                                    <p style=\"margin: 0; margin-bottom: 16px;\">www.johnkeellstea.com</p>\n" +
                "                                                    <p style=\"margin: 0; margin-bottom: 16px;\">Finally House, 186 ,\n" +
                "                                                        Vauxhall Street, Colombo 2 , Srilanka</p>\n" +
                "                                                    <p style=\"margin: 0;\">+94 112 30 6000</p>\n" +
                "                                                </div>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-5\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; background-color: #EDE9E9; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"  class=\"row-content stack\"\n" +
                "                               role=\"presentation\"\n" +
                "                               style=\"mso-table-lspace: 0pt;  mso-table-rspace: 0pt; color: #000; width: 600px; margin: 0 auto;\"\n" +
                "                               width=\"600\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td class=\"column column-1\"\n" +
                "                                    style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n" +
                "                                    width=\"100%\">\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"icons_block block-1\"\n" +
                "                                           role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\"\n" +
                "                                                style=\"vertical-align: middle; color: #9d9d9d; font-family: inherit; font-size: 15px; padding-bottom: 5px; padding-top: 5px; text-align: center;\">\n" +
                "                                                <table cellpadding=\"0\" cellspacing=\"0\" role=\"presentatio\"\n" +
                "                                                       style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                "                                                       width=\"100%\">\n" +
                "                                                    <tr>\n" +
                "                                                        <td class=\"alignment\"\n" +
                "                                                            style=\"vertical-align: middle; text-align: center;\">\n" +
                "                                                            <!--[if vml]>\n" +
                "                                                            <table align=\"left\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                                                   role=\"presentation\"\n" +
                "                                                                   style=\"display:inline-block;padding-left:0px;padding-right:0px;mso-table-lspace: 0pt;mso-table-rspace: 0pt;\">\n" +
                "                                                            <![endif]-->\n" +
                "                                                            <!--[if !vml]><!-->\n" +
                "                                                            <table cellpadding=\"0\" cellspacing=\"0\" class=\"icons-inner\"\n" +
                "                                                                   role=\"presentation\"\n" +
                "                                                                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; display: inline-block; margin-right: -4px; padding-left: 0px; padding-right: 0px;\">\n" +
                "                                                                <!--<![endif]-->\n" +
                "                                                            </table>\n" +
                "                                                        </td>\n" +
                "                                                    </tr>\n" +
                "                                                </table>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "    </tbody>\n" +
                "</table><!-- End -->\n" +
                "</body>\n" +
                "</html>";
    }

    public String sendBuyerSampleRequestAcceptedTemplate(UserDTO userDTO, SampleRequestDTO sampleRequestDTO) {

        String comment = sampleRequestDTO.getSampleRoomEmployeeComment() == null ? sampleRequestDTO.getManagerComment() : sampleRequestDTO.getSampleRoomEmployeeComment();

        return "<!DOCTYPE html>\n" +
                "\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <title></title>\n" +
                "    <meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\"/>\n" +
                "    <meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\"/>\n" +
                "    <!--[if mso]>\n" +
                "    <xml>\n" +
                "        <o:OfficeDocumentSettings>\n" +
                "            <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
                "            <o:AllowPNG/>\n" +
                "        </o:OfficeDocumentSettings>\n" +
                "    </xml><![endif]--><!--[if !mso]><!-->\n" +
                "    <link href=\"https://fonts.googleapis.com/css?family=Noto+Serif\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
                "    <link href=\"https://fonts.googleapis.com/css2?family=Inter&family=Work+Sans:wght@700&display=swap\" rel=\"stylesheet\"\n" +
                "          type=\"text/css\"/>\n" +
                "    <link href=\"https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;600;700;800;900\"\n" +
                "          rel=\"stylesheet\" type=\"text/css\"/><!--<![endif]-->\n" +
                "    <style>\n" +
                "        * {\n" +
                "            box-sizing: border-box;\n" +
                "        }\n" +
                "\n" +
                "        body {\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "        }\n" +
                "\n" +
                "        a[x-apple-data-detectors] {\n" +
                "            color: inherit !important;\n" +
                "            text-decoration: inherit !important;\n" +
                "        }\n" +
                "\n" +
                "        #MessageViewBody a {\n" +
                "            color: inherit;\n" +
                "            text-decoration: none;\n" +
                "        }\n" +
                "\n" +
                "        p {\n" +
                "            line-height: inherit\n" +
                "        }\n" +
                "\n" +
                "        .desktop_hide,\n" +
                "        .desktop_hide table {\n" +
                "            mso-hide: all;\n" +
                "            display: none;\n" +
                "            max-height: 0px;\n" +
                "            overflow: hidden;\n" +
                "        }\n" +
                "\n" +
                "        .image_block img + div {\n" +
                "            display: none;\n" +
                "        }\n" +
                "\n" +
                "        @media (max-width: 620px) {\n" +
                "            .desktop_hide table.icons-inner {\n" +
                "                display: inline-block !important;\n" +
                "            }\n" +
                "\n" +
                "            .icons-inner {\n" +
                "                text-align: center;\n" +
                "            }\n" +
                "\n" +
                "            .icons-inner td {\n" +
                "                margin: 0 auto;\n" +
                "            }\n" +
                "\n" +
                "            .mobile_hide {\n" +
                "                display: none;\n" +
                "            }\n" +
                "\n" +
                "            .row-content {\n" +
                "                width: 100% !important;\n" +
                "            }\n" +
                "\n" +
                "            .stack .column {\n" +
                "                width: 100%;\n" +
                "                display: block;\n" +
                "            }\n" +
                "\n" +
                "            .mobile_hide {\n" +
                "                min-height: 0;\n" +
                "                max-height: 0;\n" +
                "                max-width: 0;\n" +
                "                overflow: hidden;\n" +
                "                font-size: 0px;\n" +
                "            }\n" +
                "\n" +
                "            .desktop_hide,\n" +
                "            .desktop_hide table {\n" +
                "                display: table !important;\n" +
                "                max-height: none !important;\n" +
                "            }\n" +
                "\n" +
                "            .row-6 .column-1 {\n" +
                "                padding: 5px 25px !important;\n" +
                "            }\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body style=\"margin: 0; background-color: #fff; padding: 0; -webkit-text-size-adjust: none; text-size-adjust: none;\">\n" +
                "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"nl-container\" role=\"presentation\"\n" +
                "       style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fff;\" width=\"100%\">\n" +
                "    <tbody>\n" +
                "    <tr>\n" +
                "        <td>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-1\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ede9e9;\" width=\"100%\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\"\n" +
                "                               role=\"presentation\"\n" +
                "                               style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fff; border-bottom: 0 solid #efeef4; border-left: 0 solid #efeef4; border-radius: 0; border-right: 0px solid #efeef4; border-top: 0 solid #efeef4; color: #000; width: 600px; margin: 0 auto;\"\n" +
                "                               width=\"600\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td class=\"column column-1\"\n" +
                "                                    style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; background-color: #ffffff; border-bottom: 1px solid transparent; border-left: 1px solid transparent; border-right: 1px solid transparent; border-top: 1px solid transparent; padding-top: 10px; vertical-align: top;\"\n" +
                "                                    width=\"100%\">\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"icons_block block-1\"\n" +
                "                                           role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\"\n" +
                "                                                style=\"vertical-align: middle; color: #4f5aba; font-family: 'Noto Serif', Georgia, serif; font-size: 24px; letter-spacing: 0px; padding-bottom: 10px; padding-top: 10px; text-align: center;\">\n" +
                "                                                <table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"alignment\"\n" +
                "                                                       role=\"presentation\"\n" +
                "                                                       style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
                "                                                    <tr>\n" +
                "                                                        <td style=\"vertical-align: middle; text-align: center; padding-top: 10px; padding-bottom: 0px; padding-left: 20px; padding-right: 20px;\">\n" +
                "                                                            <a href=\"https://www.example.com\"\n" +
                "                                                               style=\"text-decoration: none;\" target=\"_self\"><img\n" +
                "                                                                    align=\"center\" alt=\"new year celebration\"\n" +
                "                                                                    class=\"icon\" height=\"64\"\n" +
                "                                                                    src=\"https://jkl.ceyentra.lk/srs/templateresources/jkl-logo.png\"\n" +
                "                                                                    style=\"display: block; height: auto; margin: 0 auto; border: 0;\"\n" +
                "                                                                    width=\"49\"/></a></td>\n" +
                "                                                    </tr>\n" +
                "                                                </table>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"heading_block block-2\"\n" +
                "                                           role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\" style=\"padding-top:10px;text-align:center;width:100%;\">\n" +
                "                                                <h1 style=\"margin: 0; color: #1a2028; direction: ltr; font-family: 'Roboto', Tahoma, Verdana, Segoe, sans-serif; font-size: 36px; font-weight: 700; letter-spacing: 1px; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0;\">\n" +
                "                                                    <span class=\"tinyMce-placeholder\">John Keells PLC</span></h1>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"paragraph_block block-3\"\n" +
                "                                           role=\"presentation\"\n" +
                "                                           style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\"\n" +
                "                                                style=\"padding-bottom:10px;padding-left:10px;padding-right:10px;padding-top:20px;\">\n" +
                "                                                <div style=\"color:#e2e624;direction:ltr;font-family:Inter, sans-serif;font-size:16px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:center;mso-line-height-alt:19.2px;\">\n" +
                "                                                    <p style=\"margin: 0;\">Congratulations !</p>\n" +
                "                                                </div>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"image_block block-4\"\n" +
                "                                           role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\" style=\"width:100%;padding-right:0px;padding-left:0px;\">\n" +
                "                                                <div align=\"center\" class=\"alignment\" style=\"line-height:10px\"><img\n" +
                "                                                        src=\"https://jkl.ceyentra.lk/srs/templateresources/congratulations.png\"\n" +
                "                                                        style=\"display: block; height: auto; border: 0; max-width: 239px; width: 100%;\"\n" +
                "                                                        width=\"239\"/></div>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-2\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ede9e9;\" width=\"100%\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\"\n" +
                "                               role=\"presentation\"\n" +
                "                               style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fff; border-radius: 0; color: #000; width: 600px; margin: 0 auto;\"\n" +
                "                               width=\"600\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td class=\"column column-1\"\n" +
                "                                    style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n" +
                "                                    width=\"100%\">\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"heading_block block-1\"\n" +
                "                                           role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\" style=\"text-align:center;width:100%;\">\n" +
                "                                                <h1 style=\"margin: 0; color: #5e5873; direction: ltr; font-family: Inter, sans-serif; font-size: 16px; font-weight: 700; letter-spacing: normal; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0;\">\n" +
                "                                                    <span class=\"tinyMce-placeholder\">COMMENT</span></h1>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-3\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ede9e9;\" width=\"100%\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\"\n" +
                "                               role=\"presentation\"\n" +
                "                               style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fff; border-radius: 0; color: #000; width: 600px; margin: 0 auto;\"\n" +
                "                               width=\"600\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td class=\"column column-1\"\n" +
                "                                    style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n" +
                "                                    width=\"100%\">\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"paragraph_block block-1\"\n" +
                "                                           role=\"presentation\"\n" +
                "                                           style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\"\n" +
                "                                                style=\"padding-bottom:10px;padding-left:40px;padding-right:40px;padding-top:10px;\">\n" +
                "                                                <div style=\"color:#5e5873;direction:ltr;font-family:Inter, sans-serif;font-size:14px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:center;mso-line-height-alt:16.8px;\">\n" +
                "                                                    <p style=\"margin: 0;\">\"" + comment + "\"</p>\n" +
                "                                                </div>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-4\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #eaeaea;\" width=\"100%\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\"\n" +
                "                               role=\"presentation\"\n" +
                "                               style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fff; border-radius: 0; color: #000; width: 600px; margin: 0 auto;\"\n" +
                "                               width=\"600\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td class=\"column column-1\"\n" +
                "                                    style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 10px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n" +
                "                                    width=\"100%\">\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"paragraph_block block-1\"\n" +
                "                                           role=\"presentation\"\n" +
                "                                           style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\" style=\"padding-bottom:5px;padding-top:5px;\">\n" +
                "                                                <div style=\"color:#262626;direction:ltr;font-family:Inter, sans-serif;font-size:14px;font-weight:700;letter-spacing:0px;line-height:120%;text-align:center;mso-line-height-alt:16.8px;\">\n" +
                "                                                    <p style=\"margin: 0; margin-bottom: 3px;\">Our warmest\n" +
                "                                                        congratulations to you.</p>\n" +
                "                                                    <p style=\"margin: 0;\">We accepted your request. Well done!</p>\n" +
                "                                                </div>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-5\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ede9e9;\" width=\"100%\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\"\n" +
                "                               role=\"presentation\"\n" +
                "                               style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fff; color: #000; width: 600px; margin: 0 auto;\"\n" +
                "                               width=\"600\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td class=\"column column-1\"\n" +
                "                                    style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 15px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n" +
                "                                    width=\"100%\">\n" +
                "                                    <table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"button_block block-1\"\n" +
                "                                           role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\">\n" +
                "                                                <div align=\"center\" class=\"alignment\"><!--[if mso]>\n" +
                "                                                    <v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\"\n" +
                "                                                                 xmlns:w=\"urn:schemas-microsoft-com:office:word\"\n" +
                "                                                                 style=\"height:42px;width:156px;v-text-anchor:middle;\"\n" +
                "                                                                 arcsize=\"10%\" stroke=\"false\" fillcolor=\"#88b44e\">\n" +
                "                                                        <w:anchorlock/>\n" +
                "                                                        <v:textbox inset=\"0px,0px,0px,0px\">\n" +
                "                                                            <center style=\"color:#ffffff; font-family:Tahoma, Verdana, sans-serif; font-size:16px\">\n" +
                "                                                    <![endif]-->\n" +
                "\n" +
                "                                                    <div style=\"text-decoration:none; cursor: pointer;  display:inline-block;color:black;border: 2px solid #88B44E;border-radius:4px;width:auto;padding:5px 20px;font-family:'Roboto', Tahoma, Verdana, Segoe, sans-serif;font-size:16px;text-align:center;mso-border-alt:none;word-break:keep-all;\">\n" +
                "                                                        <a style=\"line-height: 32px;\">Request Accepted</a>\n" +
                "                                                    </div>\n" +
                "\n" +
                "                                                    <!--[if mso]></center></v:textbox></v:roundrect><![endif]-->\n" +
                "                                                </div>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-6\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ede9e9; background-size: auto;\"\n" +
                "                   width=\"100%\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\"\n" +
                "                               role=\"presentation\"\n" +
                "                               style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #88b44e; background-size: auto; border-radius: 0; color: #000; width: 600px; margin: 0 auto;\"\n" +
                "                               width=\"600\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td class=\"column column-1\"\n" +
                "                                    style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 10px; padding-left: 10px; padding-right: 10px; padding-top: 10px; vertical-align: middle; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n" +
                "                                    width=\"100%\">\n" +
                "                                    <table border=\"0\" cellpadding=\"5\" cellspacing=\"0\" class=\"paragraph_block block-1\"\n" +
                "                                           role=\"presentation\"\n" +
                "                                           style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\">\n" +
                "                                                <div style=\"color:#ffffff;direction:ltr;font-family:'Roboto', Tahoma, Verdana, Segoe, sans-serif;font-size:11px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:center;mso-line-height-alt:13.2px;\">\n" +
                "                                                    <p style=\"margin: 0; margin-bottom: 16px;\">www.johnkeellstea.com</p>\n" +
                "                                                    <p style=\"margin: 0; margin-bottom: 16px;\">Finally House, 186 ,\n" +
                "                                                        Vauxhall Street, Colombo 2 , Srilanka</p>\n" +
                "                                                    <p style=\"margin: 0;\">+94 112 30 6000</p>\n" +
                "                                                </div>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "    </tbody>\n" +
                "</table><!-- End -->\n" +
                "</body>\n" +
                "</html>";
    }

    public String sendBuyerSampleRequestDeclinedTemplate(UserDTO userDTO, SampleRequestDTO sampleRequestDTO) {

        String comment = sampleRequestDTO.getManagerComment() == null ? sampleRequestDTO.getSampleRoomEmployeeComment() : sampleRequestDTO.getManagerComment();

        return "<!DOCTYPE html>\n" +
                "\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <title></title>\n" +
                "    <meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\"/>\n" +
                "    <meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\"/>\n" +
                "    <!--[if mso]>\n" +
                "    <xml>\n" +
                "        <o:OfficeDocumentSettings>\n" +
                "            <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
                "            <o:AllowPNG/>\n" +
                "        </o:OfficeDocumentSettings>\n" +
                "    </xml><![endif]--><!--[if !mso]><!-->\n" +
                "    <link href=\"https://fonts.googleapis.com/css?family=Noto+Serif\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
                "    <link href=\"https://fonts.googleapis.com/css2?family=Inter&family=Work+Sans:wght@700&display=swap\" rel=\"stylesheet\"\n" +
                "          type=\"text/css\"/>\n" +
                "    <link href=\"https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;600;700;800;900\"\n" +
                "          rel=\"stylesheet\" type=\"text/css\"/><!--<![endif]-->\n" +
                "    <style>\n" +
                "        * {\n" +
                "            box-sizing: border-box;\n" +
                "        }\n" +
                "\n" +
                "        body {\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "        }\n" +
                "\n" +
                "        a[x-apple-data-detectors] {\n" +
                "            color: inherit !important;\n" +
                "            text-decoration: inherit !important;\n" +
                "        }\n" +
                "\n" +
                "        #MessageViewBody a {\n" +
                "            color: inherit;\n" +
                "            text-decoration: none;\n" +
                "        }\n" +
                "\n" +
                "        p {\n" +
                "            line-height: inherit\n" +
                "        }\n" +
                "\n" +
                "        .desktop_hide,\n" +
                "        .desktop_hide table {\n" +
                "            mso-hide: all;\n" +
                "            display: none;\n" +
                "            max-height: 0px;\n" +
                "            overflow: hidden;\n" +
                "        }\n" +
                "\n" +
                "        .image_block img + div {\n" +
                "            display: none;\n" +
                "        }\n" +
                "\n" +
                "        @media (max-width: 620px) {\n" +
                "            .desktop_hide table.icons-inner {\n" +
                "                display: inline-block !important;\n" +
                "            }\n" +
                "\n" +
                "            .icons-inner {\n" +
                "                text-align: center;\n" +
                "            }\n" +
                "\n" +
                "            .icons-inner td {\n" +
                "                margin: 0 auto;\n" +
                "            }\n" +
                "\n" +
                "            .mobile_hide {\n" +
                "                display: none;\n" +
                "            }\n" +
                "\n" +
                "            .row-content {\n" +
                "                width: 100% !important;\n" +
                "            }\n" +
                "\n" +
                "            .stack .column {\n" +
                "                width: 100%;\n" +
                "                display: block;\n" +
                "            }\n" +
                "\n" +
                "            .mobile_hide {\n" +
                "                min-height: 0;\n" +
                "                max-height: 0;\n" +
                "                max-width: 0;\n" +
                "                overflow: hidden;\n" +
                "                font-size: 0px;\n" +
                "            }\n" +
                "\n" +
                "            .desktop_hide,\n" +
                "            .desktop_hide table {\n" +
                "                display: table !important;\n" +
                "                max-height: none !important;\n" +
                "            }\n" +
                "\n" +
                "            .row-6 .column-1 {\n" +
                "                padding: 5px 25px !important;\n" +
                "            }\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body style=\"margin: 0; background-color: #fff; padding: 0; -webkit-text-size-adjust: none; text-size-adjust: none;\">\n" +
                "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"nl-container\" role=\"presentation\"\n" +
                "       style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fff;\" width=\"100%\">\n" +
                "    <tbody>\n" +
                "    <tr>\n" +
                "        <td>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-1\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ede9e9;\" width=\"100%\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\"\n" +
                "                               role=\"presentation\"\n" +
                "                               style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fff; border-bottom: 0 solid #efeef4; border-left: 0 solid #efeef4; border-radius: 0; border-right: 0px solid #efeef4; border-top: 0 solid #efeef4; color: #000; width: 600px; margin: 0 auto;\"\n" +
                "                               width=\"600\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td class=\"column column-1\"\n" +
                "                                    style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; background-color: #ffffff; border-bottom: 1px solid transparent; border-left: 1px solid transparent; border-right: 1px solid transparent; border-top: 1px solid transparent; padding-top: 10px; vertical-align: top;\"\n" +
                "                                    width=\"100%\">\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"icons_block block-1\"\n" +
                "                                           role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\"\n" +
                "                                                style=\"vertical-align: middle; color: #4f5aba; font-family: 'Noto Serif', Georgia, serif; font-size: 24px; letter-spacing: 0px; padding-bottom: 10px; padding-top: 10px; text-align: center;\">\n" +
                "                                                <table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"alignment\"\n" +
                "                                                       role=\"presentation\"\n" +
                "                                                       style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
                "                                                    <tr>\n" +
                "                                                        <td style=\"vertical-align: middle; text-align: center; padding-top: 10px; padding-bottom: 0px; padding-left: 20px; padding-right: 20px;\">\n" +
                "                                                            <a href=\"https://www.example.com\"\n" +
                "                                                               style=\"text-decoration: none;\" target=\"_self\"><img\n" +
                "                                                                    align=\"center\" alt=\"new year celebration\"\n" +
                "                                                                    class=\"icon\" height=\"64\"\n" +
                "                                                                    src=\"https://jkl.ceyentra.lk/srs/templateresources/jkl-logo.png\"\n" +
                "                                                                    style=\"display: block; height: auto; margin: 0 auto; border: 0;\"\n" +
                "                                                                    width=\"49\"/></a></td>\n" +
                "                                                    </tr>\n" +
                "                                                </table>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"heading_block block-2\"\n" +
                "                                           role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\" style=\"padding-top:10px;text-align:center;width:100%;\">\n" +
                "                                                <h1 style=\"margin: 0; color: #1a2028; direction: ltr; font-family: 'Roboto', Tahoma, Verdana, Segoe, sans-serif; font-size: 36px; font-weight: 700; letter-spacing: 1px; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0;\">\n" +
                "                                                    <span class=\"tinyMce-placeholder\">John Keells PLC</span></h1>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"image_block block-3\"\n" +
                "                                           role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\" style=\"width:100%;padding-right:0px;padding-left:0px;\">\n" +
                "                                                <div align=\"center\" class=\"alignment\" style=\"line-height:10px\"><img\n" +
                "                                                        src=\"https://jkl.ceyentra.lk/srs/templateresources/sorry.png\"\n" +
                "                                                        style=\"display: block; height: auto; border: 0; max-width: 239px; width: 100%;\"\n" +
                "                                                        width=\"239\"/></div>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-2\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ede9e9;\" width=\"100%\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\"\n" +
                "                               role=\"presentation\"\n" +
                "                               style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fff; border-radius: 0; color: #000; width: 600px; margin: 0 auto;\"\n" +
                "                               width=\"600\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td class=\"column column-1\"\n" +
                "                                    style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n" +
                "                                    width=\"100%\">\n" +
                "                                    <table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"heading_block block-1\"\n" +
                "                                           role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\">\n" +
                "                                                <h3 style=\"margin: 0; color: #5e5873; direction: ltr; font-family: Inter, sans-serif; font-size: 16px; font-weight: 700; letter-spacing: normal; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0;\">\n" +
                "                                                    <span class=\"tinyMce-placeholder\">COMMENT</span></h3>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-3\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ede9e9;\" width=\"100%\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\"\n" +
                "                               role=\"presentation\"\n" +
                "                               style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fff; color: #000; width: 600px; margin: 0 auto;\"\n" +
                "                               width=\"600\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td class=\"column column-1\"\n" +
                "                                    style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 15px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n" +
                "                                    width=\"100%\">\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"paragraph_block block-1\"\n" +
                "                                           role=\"presentation\"\n" +
                "                                           style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\"\n" +
                "                                                style=\"padding-bottom:10px;padding-left:40px;padding-right:40px;padding-top:10px;\">\n" +
                "                                                <div style=\"color:#5e5873;direction:ltr;font-family:Inter, sans-serif;font-size:14px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:center;mso-line-height-alt:16.8px;\">\n" +
                "                                                    <p style=\"margin: 0;\">\"" + comment + "\"</p>\n" +
                "                                                </div>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-4\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #eaeaea;\" width=\"100%\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\"\n" +
                "                               role=\"presentation\"\n" +
                "                               style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fff; border-radius: 0; color: #000; width: 600px; margin: 0 auto;\"\n" +
                "                               width=\"600\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td class=\"column column-1\"\n" +
                "                                    style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 10px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n" +
                "                                    width=\"100%\">\n" +
                "                                    <table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"paragraph_block block-1\"\n" +
                "                                           role=\"presentation\"\n" +
                "                                           style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\">\n" +
                "                                                <div style=\"color:#1a2028;direction:ltr;font-family:Inter, sans-serif;font-size:14px;font-weight:700;letter-spacing:0px;line-height:120%;text-align:center;mso-line-height-alt:16.8px;\">\n" +
                "                                                    <p style=\"margin: 0; margin-bottom: 3px;\">We are extremely sorry and\n" +
                "                                                        regret to inform you that</p>\n" +
                "                                                    <p style=\"margin: 0;\">we have to declined your request.</p>\n" +
                "                                                </div>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-5\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ede9e9;\" width=\"100%\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\"\n" +
                "                               role=\"presentation\"\n" +
                "                               style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fff; color: #000; width: 600px; margin: 0 auto;\"\n" +
                "                               width=\"600\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td class=\"column column-1\"\n" +
                "                                    style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 15px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n" +
                "                                    width=\"100%\">\n" +
                "                                    <table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"button_block block-1\"\n" +
                "                                           role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\">\n" +
                "                                                <div align=\"center\" class=\"alignment\">\n" +
                "                                                    <!--[if mso]>\n" +
                "                                                    <v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\"\n" +
                "                                                                 xmlns:w=\"urn:schemas-microsoft-com:office:word\"\n" +
                "                                                                 style=\"height:42px;width:163px;v-text-anchor:middle;\"\n" +
                "                                                                 arcsize=\"10%\" stroke=\"false\" fillcolor=\"#e64341\">\n" +
                "                                                        <w:anchorlock/>\n" +
                "                                                        <v:textbox inset=\"0px,0px,0px,0px\">\n" +
                "                                                            <center style=\"color:#ffffff; font-family:Tahoma, Verdana, sans-serif; font-size:16px\">\n" +
                "                                                    <![endif]-->\n" +
                "                                                    <div style=\"text-decoration:none;display:inline-block;color:rgba(0,0,0,0.17);background-color:#fff;border-radius:4px;width:auto;border:1px solid #FD494D;font-weight:400;padding:5px 20px;font-family:'Roboto', Tahoma, Verdana, Segoe, sans-serif;font-size:16px;text-align:center;mso-border-alt:none;word-break:keep-all;outline:2px solid #FD494D;\">\n" +
                "                                                        <a href=\"#\" style=\"text-decoration:none;color:black;\">\n" +
                "                                                            <span style=\"font-size:16px;line-height: 32px;\">Request Declined</span>\n" +
                "                                                        </a>\n" +
                "                                                    </div>\n" +
                "                                                    <!--[if mso]></center></v:textbox></v:roundrect><![endif]-->\n" +
                "                                                </div>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-6\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ede9e9; background-size: auto;\"\n" +
                "                   width=\"100%\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\"\n" +
                "                               role=\"presentation\"\n" +
                "                               style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #88b44e; background-size: auto; border-radius: 0; color: #000; width: 600px; margin: 0 auto;\"\n" +
                "                               width=\"600\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td class=\"column column-1\"\n" +
                "                                    style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 10px; padding-left: 10px; padding-right: 10px; padding-top: 10px; vertical-align: middle; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n" +
                "                                    width=\"100%\">\n" +
                "                                    <table border=\"0\" cellpadding=\"5\" cellspacing=\"0\" class=\"paragraph_block block-1\"\n" +
                "                                           role=\"presentation\"\n" +
                "                                           style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\">\n" +
                "                                                <div style=\"color:#ffffff;direction:ltr;font-family:'Roboto', Tahoma, Verdana, Segoe, sans-serif;font-size:11px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:center;mso-line-height-alt:13.2px;\">\n" +
                "                                                    <p style=\"margin: 0; margin-bottom: 16px;\">www.johnkeellstea.com</p>\n" +
                "                                                    <p style=\"margin: 0; margin-bottom: 16px;\">Finally House, 186 ,\n" +
                "                                                        Vauxhall Street, Colombo 2 , Srilanka</p>\n" +
                "                                                    <p style=\"margin: 0;\">+94 112 30 6000</p>\n" +
                "                                                </div>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "    </tbody>\n" +
                "</table><!-- End -->\n" +
                "</body>\n" +
                "</html>";
    }

    public String sendSampleRequestToManagerTemplate(SampleRequestDTO sampleRequestDTO) {

        return "<!DOCTYPE html>\n" +
                "\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <title></title>\n" +
                "    <meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\"/>\n" +
                "    <meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\"/>\n" +
                "    <!--[if mso]>\n" +
                "    <xml>\n" +
                "        <o:OfficeDocumentSettings>\n" +
                "            <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
                "            <o:AllowPNG/>\n" +
                "        </o:OfficeDocumentSettings>\n" +
                "    </xml><![endif]--><!--[if !mso]><!-->\n" +
                "    <link href=\"https://fonts.googleapis.com/css?family=Noto+Serif\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
                "    <link href=\"https://fonts.googleapis.com/css2?family=Inter&family=Work+Sans:wght@700&display=swap\" rel=\"stylesheet\"\n" +
                "          type=\"text/css\"/>\n" +
                "    <link href=\"https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;600;700;800;900\"\n" +
                "          rel=\"stylesheet\" type=\"text/css\"/><!--<![endif]-->\n" +
                "    <style>\n" +
                "        * {\n" +
                "            box-sizing: border-box;\n" +
                "        }\n" +
                " a {\n" +
                "            color: white!important;\n" +
                "            text-decoration: none!important;\n" +
                "        }" +
                "\n" +
                "        body {\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "        }\n" +
                "\n" +
                "        a[x-apple-data-detectors] {\n" +
                "            color: inherit !important;\n" +
                "            text-decoration: inherit !important;\n" +
                "        }\n" +
                "\n" +
                "        #MessageViewBody a {\n" +
                "            color: inherit;\n" +
                "            text-decoration: none;\n" +
                "        }\n" +
                "\n" +
                "        p {\n" +
                "            line-height: inherit\n" +
                "        }\n" +
                "\n" +
                "        .desktop_hide,\n" +
                "        .desktop_hide table {\n" +
                "            mso-hide: all;\n" +
                "            display: none;\n" +
                "            max-height: 0px;\n" +
                "            overflow: hidden;\n" +
                "        }\n" +
                "\n" +
                "        .image_block img + div {\n" +
                "            display: none;\n" +
                "        }\n" +
                "\n" +
                "        @media (max-width: 620px) {\n" +
                "            .desktop_hide table.icons-inner {\n" +
                "                display: inline-block !important;\n" +
                "            }\n" +
                "\n" +
                "            .icons-inner {\n" +
                "                text-align: center;\n" +
                "            }\n" +
                "\n" +
                "            .icons-inner td {\n" +
                "                margin: 0 auto;\n" +
                "            }\n" +
                "\n" +
                "            .mobile_hide {\n" +
                "                display: none;\n" +
                "            }\n" +
                "\n" +
                "            .row-content {\n" +
                "                width: 100% !important;\n" +
                "            }\n" +
                "\n" +
                "            .stack .column {\n" +
                "                width: 100%;\n" +
                "                display: block;\n" +
                "            }\n" +
                "\n" +
                "            .mobile_hide {\n" +
                "                min-height: 0;\n" +
                "                max-height: 0;\n" +
                "                max-width: 0;\n" +
                "                overflow: hidden;\n" +
                "                font-size: 0px;\n" +
                "            }\n" +
                "\n" +
                "            .desktop_hide,\n" +
                "            .desktop_hide table {\n" +
                "                display: table !important;\n" +
                "                max-height: none !important;\n" +
                "            }\n" +
                "\n" +
                "            .row-4 .column-1 {\n" +
                "                padding: 5px 25px !important;\n" +
                "            }\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body style=\"margin: 0; background-color: #fff; padding: 0; -webkit-text-size-adjust: none; text-size-adjust: none;\">\n" +
                "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"nl-container\" role=\"presentation\"\n" +
                "       style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fff;\" width=\"100%\">\n" +
                "    <tbody>\n" +
                "    <tr>\n" +
                "        <td>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-1\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ede9e9;\" width=\"100%\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\"\n" +
                "                               role=\"presentation\"\n" +
                "                               style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fff; border-bottom: 0 solid #efeef4; border-left: 0 solid #efeef4; border-radius: 0; border-right: 0px solid #efeef4; border-top: 0 solid #efeef4; color: #000; width: 600px; margin: 0 auto;\"\n" +
                "                               width=\"600\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td class=\"column column-1\"\n" +
                "                                    style=\"font-weight: 400; text-align: left; mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffffff; border-bottom: 1px solid transparent; border-left: 1px solid transparent; border-right: 1px solid transparent; border-top: 1px solid transparent; vertical-align: top;\"\n" +
                "                                    width=\"100%\">\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"icons_block block-1\"\n" +
                "                                           role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\"\n" +
                "                                                style=\"vertical-align: middle; color: #4f5aba; font-family: 'Noto Serif', Georgia, serif; font-size: 24px; letter-spacing: 0px; padding-bottom: 5px; padding-top: 10px; text-align: center;\">\n" +
                "                                                <table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"alignment\"\n" +
                "                                                       role=\"presentation\"\n" +
                "                                                       style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
                "                                                    <tr>\n" +
                "                                                        <td style=\"vertical-align: middle; text-align: center; padding-top: 10px; padding-bottom: 0px; padding-left: 20px; padding-right: 20px;\">\n" +
                "                                                            <a href=\"https://www.example.com\"\n" +
                "                                                               style=\"text-decoration: none;\" target=\"_self\"><img\n" +
                "                                                                    align=\"center\" alt=\"new year celebration\"\n" +
                "                                                                    class=\"icon\" height=\"64\"\n" +
                "                                                                    src=\"https://jkl.ceyentra.lk/srs/templateresources/jkl-logo.png\"\n" +
                "                                                                    style=\"display: block; height: auto; margin: 0 auto; border: 0;\"\n" +
                "                                                                    width=\"49\"/></a></td>\n" +
                "                                                    </tr>\n" +
                "                                                </table>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"heading_block block-2\"\n" +
                "                                           role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\" style=\"padding-top:10px;text-align:center;width:100%;\">\n" +
                "                                                <h1 style=\"margin: 0; color: #1a2028; direction: ltr; font-family: 'Roboto', Tahoma, Verdana, Segoe, sans-serif; font-size: 36px; font-weight: 700; letter-spacing: 1px; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0;\">\n" +
                "                                                    <span class=\"tinyMce-placeholder\">John Keells PLC</span></h1>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"heading_block block-3\"\n" +
                "                                           role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\"\n" +
                "                                                style=\"padding-bottom:10px;padding-top:25px;text-align:center;width:100%;\">\n" +
                "                                                <h2 style=\"margin: 0; color: #1a2028; direction: ltr; font-family: 'Noto Serif', Georgia, serif; font-size: 20px; font-weight: 700; letter-spacing: normal; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0;\">\n" +
                "                                                    <span class=\"tinyMce-placeholder\">Sample Request</span></h2>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"image_block block-4\"\n" +
                "                                           role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\" style=\"width:100%;padding-right:0px;padding-left:0px;\">\n" +
                "                                                <div align=\"center\" class=\"alignment\" style=\"line-height:10px\"><img\n" +
                "                                                        src=\"https://jkl.ceyentra.lk/srs/templateresources/tea-picker.png\"\n" +
                "                                                        style=\"display: block; height: auto; border: 0; max-width: 239px; width: 100%;\"\n" +
                "                                                        width=\"239\"/></div>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-2\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ede9e9;\" width=\"100%\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\"\n" +
                "                               role=\"presentation\"\n" +
                "                               style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fff; border-radius: 0; color: #000; width: 600px; margin: 0 auto;\"\n" +
                "                               width=\"600\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td class=\"column column-1\"\n" +
                "                                    style=\"font-weight: 400; text-align: left; mso-table-lspace: 0pt; mso-table-rspace: 0pt; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n" +
                "                                    width=\"100%\">\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"paragraph_block block-1\"\n" +
                "                                           role=\"presentation\"\n" +
                "                                           style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\"\n" +
                "                                           width=\"100%\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td class=\"pad\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"text-align: center; vertical-align: middle; padding-right: 20px; padding-left: 20px\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display: inline-block; border: 2px solid #88B44E; padding: 10px 20px 10px 20px; margin-top: 10px;\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#101112;direction:ltr;font-family:Inter, sans-serif;font-size:14px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:center;mso-line-height-alt:16.8px;\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"margin: 0; line-height: 30px;\"><img src=\"https://jkl.ceyentra.lk/srs/templateresources/icon-user.png\" alt=\"image user\" style=\"margin-right: 8px; vertical-align: middle;\"/> " + sampleRequestDTO.getBuyer().getName() + "</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"margin: 0; line-height: 24px;\"><img src=\"https://jkl.ceyentra.lk/srs/templateresources/icon-time.png\" alt=\"image user\" style=\"margin-right: 8px; vertical-align: middle;\"/>" + new SimpleDateFormat("hh:mm a").format(sampleRequestDTO.getRequestedDate()) + " - " + new SimpleDateFormat("dd/MM/yyyy").format(sampleRequestDTO.getRequestedDate()) + "" + "</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\n" +
                "\n" +
                "\t\t\t\t\t\t\t\t\t</table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-3\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ede9e9;\" width=\"100%\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\"\n" +
                "                               role=\"presentation\"\n" +
                "                               style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fff; color: #000; width: 600px; margin: 0 auto;\"\n" +
                "                               width=\"600\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td class=\"column column-1\"\n" +
                "                                    style=\"font-weight: 400; text-align: left; mso-table-lspace: 0pt; mso-table-rspace: 0pt; padding-bottom: 10px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n" +
                "                                    width=\"100%\"><!--[if mso]>\n" +
                "                                    <style>#list-r2c0m0 ol li {\n" +
                "                                        mso-special-format: number;\n" +
                "                                        text-align: -webkit-match-parent;\n" +
                "                                        display: list-item;\n" +
                "                                    }\n" +
                "\n" +
                "                                    #list-r2c0m0 .levelOne li {\n" +
                "                                        margin-top: 0 !important;\n" +
                "                                    }\n" +
                "\n" +
                "                                    #list-r2c0m0 .levelOne {\n" +
                "                                        margin-left: -20px !important;\n" +
                "                                    }\n" +
                "\n" +
                "                                    #list-r2c0m0 .levelTwo li {\n" +
                "                                        margin-top: 0 !important;\n" +
                "                                    }\n" +
                "\n" +
                "                                    #list-r2c0m0 .levelTwo {\n" +
                "                                        margin-left: 10px !important;\n" +
                "                                    }\n" +
                "\n" +
                "                                    #list-r2c0m0 .levelThree li {\n" +
                "                                        margin-top: 0 !important;\n" +
                "                                    }\n" +
                "\n" +
                "                                    #list-r2c0m0 .levelThree {\n" +
                "                                        margin-left: 40px !important;\n" +
                "                                    }</style><![endif]-->\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"list_block block-1\"\n" +
                "                                           id=\"list-r2c0m0\" role=\"presentation\"\n" +
                "                                           style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\"\n" +
                "                                                style=\"padding-bottom:10px;padding-left:30px;padding-right:30px;padding-top:10px;\">\n" +
                "                                                <div class=\"levelTwo\" style=\"margin-left: 30px;\">\n" +
                "                                                    <ol class=\"leftList\"\n" +
                "                                                        style=\"margin-top: 0; margin-bottom: 0; padding: 0; padding-left: 20px; font-weight: 400; text-align: left; color: #262626; direction: ltr; font-family: Inter,sans-serif; font-size: 14px; letter-spacing: 0; line-height: 180%; mso-line-height-alt: 25.2px; list-style-type: disc;\">\n" +
                "                                                        <li style=\"margin-bottom: 0; text-align: left;\"><strong>Lot\n" +
                "                                                            Number</strong> - " + sampleRequestDTO.getLotNumber() + "\n" +
                "                                                        </li>\n" +
                "                                                        <li style=\"margin-bottom: 0; text-align: left;\"><strong>Sales\n" +
                "                                                            Number</strong> - " + sampleRequestDTO.getSaleNumber() + "\n" +
                "                                                        </li>\n" +
                "                                                        <li style=\"margin-bottom: 0; text-align: left;\">\n" +
                "                                                            <strong>Comment</strong> - " + sampleRequestDTO.getBuyerComment() + "\n" +
                "                                                        </li>\n" +
                "                                                    </ol>\n" +
                "                                                </div>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                    <table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"button_block block-2\"\n" +
                "                                           role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\">\n" +
                "                                                <div align=\"center\" class=\"alignment\"><!--[if mso]>\n" +
                "                                                    <v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\"\n" +
                "                                                                 xmlns:w=\"urn:schemas-microsoft-com:office:word\"\n" +
                "                                                                 style=\"height:42px;width:164px;v-text-anchor:middle;\"\n" +
                "                                                                 arcsize=\"10%\" stroke=\"false\" fillcolor=\"#88b44e\">\n" +
                "                                                        <w:anchorlock/>\n" +
                "                                                        <v:textbox inset=\"0px,0px,0px,0px\">\n" +
                "                                                            <center style=\"color:#ffffff; font-family:sans-serif; font-size:16px\">\n" +
                "                                                    <![endif]-->\n" +
                "                                                    <div style=\"text-decoration:none;display:inline-block;color:#ffffff;background-color:#88b44e;border-radius:4px;width:auto;border-top:0px solid transparent;font-weight:400;border-right:0px solid transparent;border-bottom:0px solid transparent;border-left:0px solid transparent;padding-top:5px;padding-bottom:5px;font-family:Inter, sans-serif;font-size:16px;text-align:center;mso-border-alt:none;word-break:keep-all;\">\n" +
                "                                                        <span style=\"padding-left:20px;padding-right:20px;font-size:16px;display:inline-block;cursor: pointer;letter-spacing:normal;\">\n" +
                "                                                            <a href=\"https://jkl.ceyentra.lk/srs/manager-modal/" + sampleRequestDTO.getId() + "\"\n" +
                "                                                                style=\"word-break: break-word; line-height: 32px; color: white!important; text-decoration: none!important; cursor: pointer\">Accept / Decline\n" +
                "                                                            </a>\n" +
                "                                                        </span>\n" +
                "                                                    </div>\n" +
                "                                                    <!--[if mso]></center></v:textbox></v:roundrect><![endif]-->\n" +
                "                                                </div>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-4\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ede9e9; background-size: auto;\"\n" +
                "                   width=\"100%\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\"\n" +
                "                               role=\"presentation\"\n" +
                "                               style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-size: auto; background-color: #88b44e; border-radius: 0; color: #000; width: 600px; margin: 0 auto;\"\n" +
                "                               width=\"600\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td class=\"column column-1\"\n" +
                "                                    style=\"font-weight: 400; text-align: left; mso-table-lspace: 0pt; mso-table-rspace: 0pt; padding-bottom: 10px; padding-left: 10px; padding-right: 10px; padding-top: 10px; vertical-align: middle; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n" +
                "                                    width=\"100%\">\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"paragraph_block block-1\"\n" +
                "                                           role=\"presentation\"\n" +
                "                                           style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\">\n" +
                "                                                <div style=\"color:#ffffff;direction:ltr;font-family:'Roboto', Tahoma, Verdana, Segoe, sans-serif;font-size:11px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:center;mso-line-height-alt:13.2px;\">\n" +
                "                                                    <p style=\"margin: 0; margin-bottom: 16px;\">www.johnkeellstea.com</p>\n" +
                "                                                    <p style=\"margin: 0; margin-bottom: 16px;\">Finally House, 186 ,\n" +
                "                                                        Vauxhall Street, Colombo 2 , Srilanka</p>\n" +
                "                                                    <p style=\"margin: 0;\">+94 112 30 6000</p>\n" +
                "                                                </div>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "    </tbody>\n" +
                "</table><!-- End -->\n" +
                "</body>\n" +
                "</html>";
    }

    public String sendSampleRequestToSREmployeeTemplate(SampleRequestDTO sampleRequestDTO) {
        return "<!DOCTYPE html>\n" +
                "\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <title></title>\n" +
                "    <meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\"/>\n" +
                "    <meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\"/>\n" +
                "    <!--[if mso]>\n" +
                "    <xml>\n" +
                "        <o:OfficeDocumentSettings>\n" +
                "            <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
                "            <o:AllowPNG/>\n" +
                "        </o:OfficeDocumentSettings>\n" +
                "    </xml><![endif]--><!--[if !mso]><!-->\n" +
                "    <link href=\"https://fonts.googleapis.com/css?family=Noto+Serif\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
                "    <link href=\"https://fonts.googleapis.com/css2?family=Inter&family=Work+Sans:wght@700&display=swap\" rel=\"stylesheet\"\n" +
                "          type=\"text/css\"/>\n" +
                "    <link href=\"https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;600;700;800;900\"\n" +
                "          rel=\"stylesheet\" type=\"text/css\"/><!--<![endif]-->\n" +
                "    <style>\n" +
                "        * {\n" +
                "            box-sizing: border-box;\n" +
                "        }\n" +
                "a {\n" +
                "            color: white!important;\n" +
                "            text-decoration: none!important;\n" +
                "        }" +
                "\n" +
                "        body {\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "        }\n" +
                "\n" +
                "        a[x-apple-data-detectors] {\n" +
                "            color: inherit !important;\n" +
                "            text-decoration: inherit !important;\n" +
                "        }\n" +
                "\n" +
                "        #MessageViewBody a {\n" +
                "            color: inherit;\n" +
                "            text-decoration: none;\n" +
                "        }\n" +
                "\n" +
                "        p {\n" +
                "            line-height: inherit\n" +
                "        }\n" +
                "\n" +
                "        .desktop_hide,\n" +
                "        .desktop_hide table {\n" +
                "            mso-hide: all;\n" +
                "            display: none;\n" +
                "            max-height: 0px;\n" +
                "            overflow: hidden;\n" +
                "        }\n" +
                "\n" +
                "        .image_block img + div {\n" +
                "            display: none;\n" +
                "        }\n" +
                "\n" +
                "        @media (max-width: 620px) {\n" +
                "            .desktop_hide table.icons-inner {\n" +
                "                display: inline-block !important;\n" +
                "            }\n" +
                "\n" +
                "            .icons-inner {\n" +
                "                text-align: center;\n" +
                "            }\n" +
                "\n" +
                "            .icons-inner td {\n" +
                "                margin: 0 auto;\n" +
                "            }\n" +
                "\n" +
                "            .mobile_hide {\n" +
                "                display: none;\n" +
                "            }\n" +
                "\n" +
                "            .row-content {\n" +
                "                width: 100% !important;\n" +
                "            }\n" +
                "\n" +
                "            .stack .column {\n" +
                "                width: 100%;\n" +
                "                display: block;\n" +
                "            }\n" +
                "\n" +
                "            .mobile_hide {\n" +
                "                min-height: 0;\n" +
                "                max-height: 0;\n" +
                "                max-width: 0;\n" +
                "                overflow: hidden;\n" +
                "                font-size: 0px;\n" +
                "            }\n" +
                "\n" +
                "            .desktop_hide,\n" +
                "            .desktop_hide table {\n" +
                "                display: table !important;\n" +
                "                max-height: none !important;\n" +
                "            }\n" +
                "\n" +
                "            .row-4 .column-1 {\n" +
                "                padding: 5px 25px !important;\n" +
                "            }\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body style=\"margin: 0; background-color: #fff; padding: 0; -webkit-text-size-adjust: none; text-size-adjust: none;\">\n" +
                "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"nl-container\" role=\"presentation\"\n" +
                "       style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fff;\" width=\"100%\">\n" +
                "    <tbody>\n" +
                "    <tr>\n" +
                "        <td>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-1\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ede9e9;\" width=\"100%\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\"\n" +
                "                               role=\"presentation\"\n" +
                "                               style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fff; border-bottom: 0 solid #efeef4; border-left: 0 solid #efeef4; border-radius: 0; border-right: 0px solid #efeef4; border-top: 0 solid #efeef4; color: #000; width: 600px; margin: 0 auto;\"\n" +
                "                               width=\"600\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td class=\"column column-1\"\n" +
                "                                    style=\"font-weight: 400; text-align: left; mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffffff; border-bottom: 1px solid transparent; border-left: 1px solid transparent; border-right: 1px solid transparent; border-top: 1px solid transparent; vertical-align: top;\"\n" +
                "                                    width=\"100%\">\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"icons_block block-1\"\n" +
                "                                           role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\"\n" +
                "                                                style=\"vertical-align: middle; color: #4f5aba; font-family: 'Noto Serif', Georgia, serif; font-size: 24px; letter-spacing: 0px; padding-bottom: 5px; padding-top: 10px; text-align: center;\">\n" +
                "                                                <table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"alignment\"\n" +
                "                                                       role=\"presentation\"\n" +
                "                                                       style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
                "                                                    <tr>\n" +
                "                                                        <td style=\"vertical-align: middle; text-align: center; padding-top: 10px; padding-bottom: 0px; padding-left: 20px; padding-right: 20px;\">\n" +
                "                                                            <a href=\"https://www.example.com\"\n" +
                "                                                               style=\"text-decoration: none;\" target=\"_self\"><img\n" +
                "                                                                    align=\"center\" alt=\"new year celebration\"\n" +
                "                                                                    class=\"icon\" height=\"64\"\n" +
                "                                                                    src=\"https://jkl.ceyentra.lk/srs/templateresources/jkl-logo.png\"\n" +
                "                                                                    style=\"display: block; height: auto; margin: 0 auto; border: 0;\"\n" +
                "                                                                    width=\"49\"/></a></td>\n" +
                "                                                    </tr>\n" +
                "                                                </table>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"heading_block block-2\"\n" +
                "                                           role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\" style=\"padding-top:10px;text-align:center;width:100%;\">\n" +
                "                                                <h1 style=\"margin: 0; color: #1a2028; direction: ltr; font-family: 'Roboto', Tahoma, Verdana, Segoe, sans-serif; font-size: 36px; font-weight: 700; letter-spacing: 1px; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0;\">\n" +
                "                                                    <span class=\"tinyMce-placeholder\">John Keells PLC</span></h1>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"heading_block block-3\"\n" +
                "                                           role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\"\n" +
                "                                                style=\"padding-bottom:10px;padding-top:25px;text-align:center;width:100%;\">\n" +
                "                                                <h2 style=\"margin: 0; color: #1a2028; direction: ltr; font-family: 'Noto Serif', Georgia, serif; font-size: 20px; font-weight: 700; letter-spacing: normal; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0;\">\n" +
                "                                                    <span class=\"tinyMce-placeholder\">Sample Request to SRE</span></h2>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"image_block block-4\"\n" +
                "                                           role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\" style=\"width:100%;padding-right:0px;padding-left:0px;\">\n" +
                "                                                <div align=\"center\" class=\"alignment\" style=\"line-height:10px\"><img\n" +
                "                                                        src=\"https://jkl.ceyentra.lk/srs/templateresources/tea-picker.png\"\n" +
                "                                                        style=\"display: block; height: auto; border: 0; max-width: 239px; width: 100%;\"\n" +
                "                                                        width=\"239\"/></div>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-2\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ede9e9;\" width=\"100%\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\"\n" +
                "                               role=\"presentation\"\n" +
                "                               style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fff; border-radius: 0; color: #000; width: 600px; margin: 0 auto;\"\n" +
                "                               width=\"600\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td class=\"column column-1\"\n" +
                "                                    style=\"font-weight: 400; text-align: left; mso-table-lspace: 0pt; mso-table-rspace: 0pt; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n" +
                "                                    width=\"100%\">\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"paragraph_block block-1\"\n" +
                "                                           role=\"presentation\"\n" +
                "                                           style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\"\n" +
                "                                           width=\"100%\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td class=\"pad\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"text-align: center; vertical-align: middle; padding-right: 20px; padding-left: 20px\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display: inline-block; border: 2px solid #88B44E; padding: 10px 20px 10px 20px; margin-top: 10px;\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"color:#101112;direction:ltr;font-family:Inter, sans-serif;font-size:14px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:center;mso-line-height-alt:16.8px;\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"margin: 0; line-height: 30px;\"><img src=\"https://jkl.ceyentra.lk/srs/templateresources/icon-user.png\" alt=\"image user\" style=\"margin-right: 8px; vertical-align: middle;\"/>" + sampleRequestDTO.getBuyer().getName() + "</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"margin: 0; line-height: 24px;\"><img src=\"https://jkl.ceyentra.lk/srs/templateresources/icon-time.png\" alt=\"image user\" style=\"margin-right: 8px; vertical-align: middle;\"/>" + new SimpleDateFormat("hh:mm a").format(sampleRequestDTO.getRequestedDate()) + " - " + new SimpleDateFormat("dd/MM/yyyy").format(sampleRequestDTO.getRequestedDate()) + "" + "</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-3\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ede9e9;\" width=\"100%\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\"\n" +
                "                               role=\"presentation\"\n" +
                "                               style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fff; color: #000; width: 600px; margin: 0 auto;\"\n" +
                "                               width=\"600\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td class=\"column column-1\"\n" +
                "                                    style=\"font-weight: 400; text-align: left; mso-table-lspace: 0pt; mso-table-rspace: 0pt; padding-bottom: 10px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n" +
                "                                    width=\"100%\"><!--[if mso]>\n" +
                "                                    <style>#list-r2c0m0 ol li {\n" +
                "                                        mso-special-format: number;\n" +
                "                                        text-align: -webkit-match-parent;\n" +
                "                                        display: list-item;\n" +
                "                                    }\n" +
                "\n" +
                "                                    #list-r2c0m0 .levelOne li {\n" +
                "                                        margin-top: 0 !important;\n" +
                "                                    }\n" +
                "\n" +
                "                                    #list-r2c0m0 .levelOne {\n" +
                "                                        margin-left: -20px !important;\n" +
                "                                    }\n" +
                "\n" +
                "                                    #list-r2c0m0 .levelTwo li {\n" +
                "                                        margin-top: 0 !important;\n" +
                "                                    }\n" +
                "\n" +
                "                                    #list-r2c0m0 .levelTwo {\n" +
                "                                        margin-left: 10px !important;\n" +
                "                                    }\n" +
                "\n" +
                "                                    #list-r2c0m0 .levelThree li {\n" +
                "                                        margin-top: 0 !important;\n" +
                "                                    }\n" +
                "\n" +
                "                                    #list-r2c0m0 .levelThree {\n" +
                "                                        margin-left: 40px !important;\n" +
                "                                    }\n" +
                "\n" +
                "                                    #list-r2c0m0 .levelFour li {\n" +
                "                                        margin-top: 0 !important;\n" +
                "                                    }\n" +
                "\n" +
                "                                    #list-r2c0m0 .levelFour {\n" +
                "                                        margin-left: 70px !important;\n" +
                "                                    }\n" +
                "\n" +
                "                                    #list-r2c0m0 .levelFive li {\n" +
                "                                        margin-top: 0 !important;\n" +
                "                                    }\n" +
                "\n" +
                "                                    #list-r2c0m0 .levelFive {\n" +
                "                                        margin-left: 100px !important;\n" +
                "                                    }\n" +
                "\n" +
                "                                    #list-r2c0m0 .levelSix li {\n" +
                "                                        margin-top: 0 !important;\n" +
                "                                    }\n" +
                "\n" +
                "                                    #list-r2c0m0 .levelSix {\n" +
                "                                        margin-left: 130px !important;\n" +
                "                                    }\n" +
                "\n" +
                "                                    #list-r2c0m0 .levelSeven li {\n" +
                "                                        margin-top: 0 !important;\n" +
                "                                    }\n" +
                "\n" +
                "                                    #list-r2c0m0 .levelSeven {\n" +
                "                                        margin-left: 160px !important;\n" +
                "                                    }\n" +
                "\n" +
                "                                    #list-r2c0m0 .levelEight li {\n" +
                "                                        margin-top: 0 !important;\n" +
                "                                    }\n" +
                "\n" +
                "                                    #list-r2c0m0 .levelEight {\n" +
                "                                        margin-left: 190px !important;\n" +
                "                                    }</style><![endif]-->\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"list_block block-1\"\n" +
                "                                           id=\"list-r2c0m0\" role=\"presentation\"\n" +
                "                                           style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\"\n" +
                "                                                style=\"padding-bottom:10px;padding-left:30px;padding-right:30px;padding-top:10px;\">\n" +
                "                                                <div class=\"levelTwo\" style=\"margin-left: 30px;\">\n" +
                "                                                    <ol class=\"leftList\"\n" +
                "                                                        style=\"margin-top: 0; margin-bottom: 0; padding: 0; padding-left: 20px; font-weight: 400; text-align: left; color: #262626; direction: ltr; font-family: Inter,sans-serif; font-size: 14px; letter-spacing: 0; line-height: 180%; mso-line-height-alt: 25.2px; list-style-type: disc;\">\n" +
                "                                                        <li style=\"margin-bottom: 0; text-align: left;\"><strong>Lot\n" +
                "                                                            Number</strong> - " + sampleRequestDTO.getLotNumber() + "\n" +
                "                                                        </li>\n" +
                "                                                        <li style=\"margin-bottom: 0; text-align: left;\"><strong>Sales\n" +
                "                                                            Number</strong> - " + sampleRequestDTO.getSaleNumber() + "\n" +
                "                                                        </li>\n" +
                "                                                        <li style=\"margin-bottom: 0; text-align: left;\">\n" +
                "                                                            <strong>Comment</strong> - " + sampleRequestDTO.getBuyerComment() +
                "                                                        </li>\n" +
                "                                                    </ol>\n" +
                "                                                </div>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                    <table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"button_block block-2\"\n" +
                "                                           role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\">\n" +
                "                                                <div align=\"center\" class=\"alignment\"><!--[if mso]>\n" +
                "                                                    <v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\"\n" +
                "                                                                 xmlns:w=\"urn:schemas-microsoft-com:office:word\"\n" +
                "                                                                 style=\"height:42px;width:164px;v-text-anchor:middle;\"\n" +
                "                                                                 arcsize=\"10%\" stroke=\"false\" fillcolor=\"#88b44e\">\n" +
                "                                                        <w:anchorlock/>\n" +
                "                                                        <v:textbox inset=\"0px,0px,0px,0px\">\n" +
                "                                                            <center style=\"color:#ffffff; font-family:sans-serif; font-size:16px\">\n" +
                "                                                    <![endif]-->\n" +
                "                                                    <div style=\"text-decoration:none;display:inline-block;color:#ffffff;background-color:#88b44e;border-radius:4px;width:auto;border-top:0px solid transparent;font-weight:400;border-right:0px solid transparent;border-bottom:0px solid transparent;border-left:0px solid transparent;padding-top:5px;padding-bottom:5px;font-family:Inter, sans-serif;font-size:16px;text-align:center;mso-border-alt:none;word-break:keep-all;\">\n" +
                "                                                        <span style=\"padding-left:20px;padding-right:20px;font-size:16px;display:inline-block;cursor: pointer;letter-spacing:normal;\">\n" +
                "                                                            <a href=\"https://jkl.ceyentra.lk/srs/sre-modal/" + sampleRequestDTO.getId() + "\"\n" +
                "                                                                style=\"word-break: break-word; line-height: 32px; color: white!important; text-decoration: none!important; cursor: pointer\">Dispatch / Decline\n" +
                "                                                            </a>\n" +
                "                                                        </span>\n" +
                "                                                    </div>\n" +
                "                                                    <!--[if mso]></center></v:textbox></v:roundrect><![endif]-->\n" +
                "                                                </div>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-4\" role=\"presentation\"\n" +
                "                   style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ede9e9; background-size: auto;\"\n" +
                "                   width=\"100%\">\n" +
                "                <tbody>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\"\n" +
                "                               role=\"presentation\"\n" +
                "                               style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-size: auto; background-color: #88b44e; border-radius: 0; color: #000; width: 600px; margin: 0 auto;\"\n" +
                "                               width=\"600\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                                <td class=\"column column-1\"\n" +
                "                                    style=\"font-weight: 400; text-align: left; mso-table-lspace: 0pt; mso-table-rspace: 0pt; padding-bottom: 10px; padding-left: 10px; padding-right: 10px; padding-top: 10px; vertical-align: middle; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\"\n" +
                "                                    width=\"100%\">\n" +
                "                                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"paragraph_block block-1\"\n" +
                "                                           role=\"presentation\"\n" +
                "                                           style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\"\n" +
                "                                           width=\"100%\">\n" +
                "                                        <tr>\n" +
                "                                            <td class=\"pad\">\n" +
                "                                                <div style=\"color:#ffffff;direction:ltr;font-family:'Roboto', Tahoma, Verdana, Segoe, sans-serif;font-size:11px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:center;mso-line-height-alt:13.2px;\">\n" +
                "                                                    <p style=\"margin: 0; margin-bottom: 16px;\">www.johnkeellstea.com</p>\n" +
                "                                                    <p style=\"margin: 0; margin-bottom: 16px;\">Finally House, 186 ,\n" +
                "                                                        Vauxhall Street, Colombo 2 , Srilanka</p>\n" +
                "                                                    <p style=\"margin: 0;\">+94 112 30 6000</p>\n" +
                "                                                </div>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "    </tbody>\n" +
                "</table><!-- End -->\n" +
                "</body>\n" +
                "</html>";
    }

}
