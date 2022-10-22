package edu.home.common.until;

import edu.home.model.Order;
import edu.home.model.OrderDetail;
import edu.home.service.OrderDetailsService;
import edu.home.service.OrderService;
import edu.home.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class FormMailOrder {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailsService orderDetailsService;
    @Autowired
    private ProductService productService;

    public String content(Long orderID){

        List<String> itemProduct = new ArrayList<>();
        Order order = orderService.findByOrderID(orderID);

        List<OrderDetail> orderDetails = orderDetailsService.findByOrderId(orderID);

        Double subTotal = orderDetails.stream().mapToDouble(item -> item.getPrice()).sum();
        Double grandTotal = orderDetails.stream().mapToDouble(item -> item.getPrice()).sum() + 30000;


        orderDetailsService.findByOrderId(orderID).stream().forEach(item ->{
            itemProduct.add(
                    "<!--[if (mso)|(IE)]><td align=\"center\" width=\"239\" style=\"width: 239px;padding: 0px 0px 0px 2px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                    "<div class=\"u-col u-col-43p56\" style=\"max-width: 320px;min-width: 239.58px;display: table-cell;vertical-align: top;\">\n" +
                    "  <div style=\"height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                    "  <!--[if (!mso)&(!IE)]><!--><div style=\"height: 100%; padding: 0px 0px 0px 2px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                    "  \n" +
                    "<table id=\"u_content_image_3\" style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 10px 10px 30px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                    "  <tr>\n" +
                    "    <td class=\"v-text-align\" style=\"padding-right: 0px;padding-left: 0px;\" align=\"right\">\n" +
                    "      \n" +
                    "      <img align=\"right\" border=\"0\" src=\"https://cdn.templates.unlayer.com/assets/1636800942645-687412\" alt=\"Product\" title=\"Product\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 100%;max-width: 199.58px;\" width=\"199.58\" class=\"v-src-width v-src-max-width\"/>\n" +
                    "      \n" +
                    "    </td>\n" +
                    "  </tr>\n" +
                    "</table>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +
                    "\n" +
                    "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                    "  </div>\n" +
                    "</div>\n" +
                    "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "<!--[if (mso)|(IE)]><td align=\"center\" width=\"310\" style=\"width: 310px;padding: 0px 0px 0px 20px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                    "<div class=\"u-col u-col-56p44\" style=\"max-width: 320px;min-width: 310.42px;display: table-cell;vertical-align: top;\">\n" +
                    "  <div style=\"height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                    "  <!--[if (!mso)&(!IE)]><!--><div style=\"height: 100%; padding: 0px 0px 0px 20px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                    "  \n" +
                    "<table id=\"u_content_heading_3\" style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 10px 10px 0px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "  <h4 class=\"v-text-align\" style=\"margin: 0px; color: #646469; line-height: 140%; text-align: left; word-wrap: break-word; font-weight: normal; font-family: 'Lato',sans-serif; font-size: 19px;\">\n" +
                    "    <strong>" + productService.findById(item.getProduct().getId()).getName() +"</strong>\n" +
                    "  </h4>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +
                    "\n" +
                    "<table id=\"u_content_text_5\" style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:0px 10px 5px 0px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "  <div class=\"v-text-align\" style=\"color: #12097a; line-height: 140%; text-align: left; word-wrap: break-word;\">\n" +
                    "    <p style=\"font-size: 14px; line-height: 140%;\"><strong><span style=\"font-size: 16px; line-height: 22.4px;\">Price :&nbsp; " + item.getPrice() + "VND</span></strong></p>\n" +
                    "  </div>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +//
                    "\n" +
                    "<table id=\"u_content_text_6\" style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:0px 10px 10px 0px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "  <div class=\"v-text-align\" style=\"color: #12097a; line-height: 140%; text-align: left; word-wrap: break-word;\">\n" +
                    "    <p style=\"font-size: 14px; line-height: 140%;\"><strong><span style=\"font-size: 16px; line-height: 22.4px;\">Quantity :&nbsp; " + item.getQuantity() + "</span></strong></p>\n" +
                    "  </div>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +
                    "\n" +
                    "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                    "  </div>\n" +
                    "</div>\n" +
                    "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                    "\n" +
                    "\n" +
                    "\n");
        });



        return "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                "<head>\n" +
                "<!--[if gte mso 9]>\n" +
                "<xml>\n" +
                "  <o:OfficeDocumentSettings>\n" +
                "    <o:AllowPNG/>\n" +
                "    <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
                "  </o:OfficeDocumentSettings>\n" +
                "</xml>\n" +
                "<![endif]-->\n" +
                "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "  <meta name=\"x-apple-disable-message-reformatting\">\n" +
                "  <!--[if !mso]><!--><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><!--<![endif]-->\n" +
                "  <title></title>\n" +
                "  \n" +
                "    <style type=\"text/css\">\n" +
                "      @media only screen and (min-width: 570px) {\n" +
                "  .u-row {\n" +
                "    width: 550px !important;\n" +
                "  }\n" +
                "  .u-row .u-col {\n" +
                "    vertical-align: top;\n" +
                "  }\n" +
                "\n" +
                "  .u-row .u-col-43p56 {\n" +
                "    width: 239.58px !important;\n" +
                "  }\n" +
                "\n" +
                "  .u-row .u-col-50 {\n" +
                "    width: 275px !important;\n" +
                "  }\n" +
                "\n" +
                "  .u-row .u-col-56p44 {\n" +
                "    width: 310.42px !important;\n" +
                "  }\n" +
                "\n" +
                "  .u-row .u-col-100 {\n" +
                "    width: 550px !important;\n" +
                "  }\n" +
                "\n" +
                "}\n" +
                "\n" +
                "@media (max-width: 570px) {\n" +
                "  .u-row-container {\n" +
                "    max-width: 100% !important;\n" +
                "    padding-left: 0px !important;\n" +
                "    padding-right: 0px !important;\n" +
                "  }\n" +
                "  .u-row .u-col {\n" +
                "    min-width: 320px !important;\n" +
                "    max-width: 100% !important;\n" +
                "    display: block !important;\n" +
                "  }\n" +
                "  .u-row {\n" +
                "    width: calc(100% - 40px) !important;\n" +
                "  }\n" +
                "  .u-col {\n" +
                "    width: 100% !important;\n" +
                "  }\n" +
                "  .u-col > div {\n" +
                "    margin: 0 auto;\n" +
                "  }\n" +
                "  }\n" +
                "body {\n" +
                "  margin: 0;\n" +
                "  padding: 0;\n" +
                "}\n" +
                "\n" +
                "table,\n" +
                "tr,\n" +
                "td {\n" +
                "  vertical-align: top;\n" +
                "  border-collapse: collapse;\n" +
                "}\n" +
                "\n" +
                "p {\n" +
                "  margin: 0;\n" +
                "}\n" +
                "\n" +
                ".ie-container table,\n" +
                ".mso-container table {\n" +
                "  table-layout: fixed;\n" +
                "}\n" +
                "\n" +
                "* {\n" +
                "  line-height: inherit;\n" +
                "}\n" +
                "\n" +
                "a[x-apple-data-detectors='true'] {\n" +
                "  color: inherit !important;\n" +
                "  text-decoration: none !important;\n" +
                "}\n" +
                "\n" +
                "table, td { color: #f1f1f1; } #u_body a { color: #0000ee; text-decoration: underline; } @media (max-width: 480px) { #u_content_image_2 .v-src-width { width: 100% !important; } #u_content_image_2 .v-src-max-width { max-width: 100% !important; } #u_content_image_7 .v-src-width { width: 100% !important; } #u_content_image_7 .v-src-max-width { max-width: 100% !important; } #u_content_heading_1 .v-container-padding-padding { padding: 0px 0px 10px !important; } #u_content_heading_1 .v-text-align { text-align: center !important; } #u_content_text_1 .v-container-padding-padding { padding: 10px 10px 30px !important; } #u_content_text_1 .v-text-align { text-align: center !important; } #u_content_text_12 .v-container-padding-padding { padding: 10px 10px 30px !important; } #u_content_text_12 .v-text-align { text-align: center !important; } #u_content_button_4 .v-container-padding-padding { padding: 10px 10px 50px !important; } #u_content_button_4 .v-size-width { width: 100% !important; } #u_content_button_4 .v-padding { padding: 18px 10px !important; } #u_content_heading_2 .v-text-align { text-align: center !important; } #u_content_text_4 .v-text-align { text-align: center !important; } #u_content_text_3 .v-text-align { text-align: center !important; } #u_content_text_9 .v-container-padding-padding { padding: 10px 10px 40px !important; } #u_content_text_9 .v-text-align { text-align: center !important; } #u_content_image_3 .v-container-padding-padding { padding: 10px !important; } #u_content_image_3 .v-text-align { text-align: center !important; } #u_content_heading_3 .v-container-padding-padding { padding: 10px !important; } #u_content_heading_3 .v-text-align { text-align: center !important; } #u_content_text_5 .v-container-padding-padding { padding: 0px 10px 5px !important; } #u_content_text_5 .v-text-align { text-align: center !important; } #u_content_text_6 .v-container-padding-padding { padding: 0px 10px 10px !important; } #u_content_text_6 .v-text-align { text-align: center !important; } #u_content_text_2 .v-container-padding-padding { padding: 10px !important; } #u_content_text_2 .v-text-align { text-align: center !important; } #u_content_text_10 .v-container-padding-padding { padding: 10px 10px 50px !important; } #u_content_text_10 .v-text-align { text-align: center !important; } }\n" +
                "    </style>\n" +
                "  \n" +
                "  \n" +
                "\n" +
                "<!--[if !mso]><!--><link href=\"https://fonts.googleapis.com/css?family=Rubik:400,700\" rel=\"stylesheet\" type=\"text/css\"><link href=\"https://fonts.googleapis.com/css?family=Lato:400,700\" rel=\"stylesheet\" type=\"text/css\"><link href=\"https://fonts.googleapis.com/css?family=Cabin:400,700\" rel=\"stylesheet\" type=\"text/css\"><!--<![endif]-->\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "<body class=\"clean-body u_body\" style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #ffffff;color: #f1f1f1\">\n" +
                "  <!--[if IE]><div class=\"ie-container\"><![endif]-->\n" +
                "  <!--[if mso]><div class=\"mso-container\"><![endif]-->\n" +
                "  <table id=\"u_body\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;min-width: 320px;Margin: 0 auto;background-color: #ffffff;width:100%\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "  <tbody>\n" +
                "  <tr style=\"vertical-align: top\">\n" +
                "    <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                "    <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color: #ffffff;\"><![endif]-->\n" +
                "    \n" +
                "\n" +
                "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 550px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
                "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:550px;\"><tr style=\"background-color: transparent;\"><![endif]-->\n" +
                "      \n" +
                "<!--[if (mso)|(IE)]><td align=\"center\" width=\"546\" style=\"width: 546px;padding: 0px;border-top: 2px solid #e5ecfe;border-left: 2px solid #e5ecfe;border-right: 2px solid #e5ecfe;border-bottom: 2px solid #e5ecfe;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 550px;display: table-cell;vertical-align: top;\">\n" +
                "  <div style=\"height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                "  <!--[if (!mso)&(!IE)]><!--><div style=\"height: 100%; padding: 0px;border-top: 2px solid #e5ecfe;border-left: 2px solid #e5ecfe;border-right: 2px solid #e5ecfe;border-bottom: 2px solid #e5ecfe;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                "  \n" +
                "<table id=\"u_content_image_2\" style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:35px 10px 0px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
                "        \n" +
                "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "  <tr>\n" +
                "    <td class=\"v-text-align\" style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
                "      \n" +
                "      <img align=\"center\" border=\"0\" src=\"https://assets.unlayer.com/projects/107360/1665830706152-Picture1.png\" alt=\"Hero Image\" title=\"Hero Image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 26%;max-width: 137.8px;\" width=\"137.8\" class=\"v-src-width v-src-max-width\"/>\n" +
                "      \n" +
                "    </td>\n" +
                "  </tr>\n" +
                "</table>\n" +
                "\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>\n" +
                "\n" +
                "<table id=\"u_content_image_7\" style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:17px 10px 40px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
                "        \n" +
                "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "  <tr>\n" +
                "    <td class=\"v-text-align\" style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
                "      \n" +
                "      <img align=\"center\" border=\"0\" src=\"https://cdn.templates.unlayer.com/assets/1636798713536-20943859.png\" alt=\"Hero Image\" title=\"Hero Image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 63%;max-width: 333.9px;\" width=\"333.9\" class=\"v-src-width v-src-max-width\"/>\n" +
                "      \n" +
                "    </td>\n" +
                "  </tr>\n" +
                "</table>\n" +
                "\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>\n" +
                "\n" +
                "<table id=\"u_content_heading_1\" style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:0px 30px 21px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
                "        \n" +
                "  <h1 class=\"v-text-align\" style=\"margin: 0px; color: #0e056e; line-height: 150%; text-align: center; word-wrap: break-word; font-weight: normal; font-family: 'Rubik',sans-serif; font-size: 41px;\">\n" +
                "    <div>Thank you for your order!</div>\n" +
                "  </h1>\n" +
                "\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>\n" +
                "\n" +
                "<table id=\"u_content_text_1\" style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:13px 30px 12px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
                "        \n" +
                "  <div class=\"v-text-align\" style=\"color: #333333; line-height: 100%; text-align: center; word-wrap: break-word;\">\n" +
                "    <p style=\"font-size: 14px; line-height: 100%; text-align: left;\"><span style=\"font-size: 18px; line-height: 18px;\">Hello Your</span></p>\n" +
                "  </div>\n" +
                "\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>\n" +
                "\n" +
                "<table id=\"u_content_text_12\" style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:0px 30px 30px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
                "        \n" +
                "  <div class=\"v-text-align\" style=\"color: #333333; line-height: 150%; text-align: center; word-wrap: break-word;\">\n" +
                "    <p style=\"font-size: 14px; line-height: 150%; text-align: left;\"><span style=\"font-size: 18px; line-height: 27px;\">CafeTime has received your order and is processing it. You will receive a follow-up notification when your order is ready </span></p>\n" +
                "<p style=\"font-size: 14px; line-height: 150%; text-align: left;\"><span style=\"font-size: 18px; line-height: 27px;\">to be shipped.</span></p>\n" +
                "  </div>\n" +
                "\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>\n" +
                "\n" +
                "<table id=\"u_content_button_4\" style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 10px 60px 30px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
                "        \n" +
                "  <!--[if mso]><style>.v-button {background: transparent !important;}</style><![endif]-->\n" +
                "<div class=\"v-text-align\" align=\"center\">\n" +
                "  <!--[if mso]><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" href=\"http://localhost:8080/home/index\" style=\"height:57px; v-text-anchor:middle; width:334px;\" arcsize=\"2%\"  stroke=\"f\" fillcolor=\"#fe7062\"><w:anchorlock/><center style=\"color:#FFFFFF;font-family:'Lato',sans-serif;\"><![endif]-->  \n" +
                "    <a href=\"http://localhost:8080/home/index\" target=\"_blank\" class=\"v-button v-size-width\" style=\"box-sizing: border-box;display: inline-block;font-family:'Lato',sans-serif;text-decoration: none;-webkit-text-size-adjust: none;text-align: center;color: #FFFFFF; background-color: #fe7062; border-radius: 1px;-webkit-border-radius: 1px; -moz-border-radius: 1px; width:66%; max-width:100%; overflow-wrap: break-word; word-break: break-word; word-wrap:break-word; mso-border-alt: none;\">\n" +
                "      <span class=\"v-padding\" style=\"display:block;padding:18px 30px;line-height:120%;\"><span style=\"font-size: 18px; line-height: 21.599999999999998px; font-family: Rubik, sans-serif;\">Check Your Order</span></span>\n" +
                "    </a>\n" +
                "  <!--[if mso]></center></v:roundrect><![endif]-->\n" +
                "</div>\n" +
                "\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>\n" +
                "\n" +
                "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                "  </div>\n" +
                "</div>\n" +
                "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "\n" +"<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 550px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #f9f9f9;\">\n" +
                "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:550px;\"><tr style=\"background-color: #f9f9f9;\"><![endif]-->\n" +
                "      \n" +
                "<!--[if (mso)|(IE)]><td align=\"center\" width=\"550\" style=\"width: 550px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 550px;display: table-cell;vertical-align: top;\">\n" +
                "  <div style=\"height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                "  <!--[if (!mso)&(!IE)]><!--><div style=\"height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                "  \n" +
                "<table id=\"u_content_heading_2\" style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:30px 10px 0px 30px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
                "        \n" +
                "  <h1 class=\"v-text-align\" style=\"margin: 0px; color: #0e056e; line-height: 140%; text-align: left; word-wrap: break-word; font-weight: normal; font-family: 'Rubik',sans-serif; font-size: 30px;\">\n" +
                "    Order Summary\n" +
                "  </h1>\n" +
                "\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>\n" +
                "\n" +
                "<table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 30px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
                "        \n" +
                "  <table height=\"0px\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;border-top: 1px solid #d6d5d5;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
                "    <tbody>\n" +
                "      <tr style=\"vertical-align: top\">\n" +
                "        <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top;font-size: 0px;line-height: 0px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
                "          <span>&#160;</span>\n" +
                "        </td>\n" +
                "      </tr>\n" +
                "    </tbody>\n" +
                "  </table>\n" +
                "\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>\n" +
                "\n" +
                "<table id=\"u_content_text_4\" style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 30px 0px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
                "        \n" +
                "  <div class=\"v-text-align\" style=\"color: #000000; line-height: 140%; text-align: left; word-wrap: break-word;\">\n" +
                "    <p style=\"font-size: 14px; line-height: 140%;\"><strong>Order Number: " + order.getId() + "</strong></p>\n" +
                "  </div>\n" +
                "\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>\n" +
                "\n" +
                "<table id=\"u_content_text_3\" style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 30px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
                "        \n" +
                "  <div class=\"v-text-align\" style=\"color: #000000; line-height: 140%; text-align: left; word-wrap: break-word;\">\n" +
                "    <p style=\"font-size: 14px; line-height: 140%;\"><strong>Address : " + order.getAddress() + "</strong></p>\n" +
                "  </div>\n" +
                "\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>\n" +
                "\n" +
                "<table id=\"u_content_text_9\" style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 30px 40px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
                "        \n" +
                "  <div class=\"v-text-align\" style=\"color: #12097a; line-height: 150%; text-align: left; word-wrap: break-word;\">\n" +
                "    <p style=\"font-size: 14px; line-height: 160%;\"><span style=\"font-size: 16px; line-height: 25.6px;\">" + order.getCreateDate() + "</span></p>\n" +
                "<p style=\"font-size: 14px; line-height: 160%;\"><span style=\"font-size: 16px; line-height: 25.6px;\">Order From: " + order.getAccount().getUsername() + "</span></p>\n" +
                "<p style=\"font-size: 14px; line-height: 160%;\"><span style=\"font-size: 16px; line-height: 25.6px;\">" + order.getAccount().getEmail() + "</span></p>\n" +
                "  </div>\n" +
                "\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>\n" +
                "\n" +
                "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                "  </div>\n" +
                "</div>\n" +
                "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "\n"+"<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n"+
                "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 550px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #f9f9f9;\">\n" +
                "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:550px;\"><tr style=\"background-color: #f9f9f9;\"><![endif]-->\n" +
                "      \n"
                // product item
                //notice
                + itemProduct +
                //
                "</div>"+
                "</div>"+
                "</div>"+
                "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 550px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #f9f9f9;\">\n" +
                "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:550px;\"><tr style=\"background-color: #f9f9f9;\"><![endif]-->\n" +
                "      \n" +
                "<!--[if (mso)|(IE)]><td align=\"center\" width=\"550\" style=\"width: 550px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 550px;display: table-cell;vertical-align: top;\">\n" +
                "  <div style=\"height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                "  <!--[if (!mso)&(!IE)]><!--><div style=\"height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                "  \n" +
                "<table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 30px 20px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
                "        \n" +
                "  <table height=\"0px\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;border-top: 1px solid #d6d5d5;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
                "    <tbody>\n" +
                "      <tr style=\"vertical-align: top\">\n" +
                "        <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top;font-size: 0px;line-height: 0px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
                "          <span>&#160;</span>\n" +
                "        </td>\n" +
                "      </tr>\n" +
                "    </tbody>\n" +
                "  </table>\n" +
                "\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>\n" +
                "\n" +
                "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                "  </div>\n" +
                "</div>\n" +
                "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 550px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #f9f9f9;\">\n" +
                "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:550px;\"><tr style=\"background-color: #f9f9f9;\"><![endif]-->\n" +
                "      \n" +
                "<!--[if (mso)|(IE)]><td align=\"center\" width=\"275\" style=\"width: 275px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                "<div class=\"u-col u-col-50\" style=\"max-width: 320px;min-width: 275px;display: table-cell;vertical-align: top;\">\n" +
                "  <div style=\"height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                "  <!--[if (!mso)&(!IE)]><!--><div style=\"height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                "  \n" +
                "<table id=\"u_content_text_2\" style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 30px 40px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
                "        \n" +
                "  <div class=\"v-text-align\" style=\"color: #646469; line-height: 180%; text-align: left; word-wrap: break-word;\">\n" +
                "    <p style=\"font-size: 14px; line-height: 180%;\"><span style=\"font-size: 16px; line-height: 28.8px;\"><strong><span style=\"line-height: 28.8px; font-size: 16px;\">Sub Total: " + subTotal + "<i>VND</i> </span></strong></span></p>\n" +
                "<p style=\"font-size: 14px; line-height: 180%;\"><span style=\"font-size: 16px; line-height: 28.8px;\"><strong><span style=\"line-height: 28.8px; font-size: 16px;\">Delivery Charges:&nbsp; 30.000<i>VND</i></span></strong></span></p>\n" +
                "  </div>\n" +
                "\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>\n" +
                "\n" +
                "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                "  </div>\n" +
                "</div>\n" +
                "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                "<!--[if (mso)|(IE)]><td align=\"center\" width=\"275\" style=\"width: 275px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                "<div class=\"u-col u-col-50\" style=\"max-width: 320px;min-width: 275px;display: table-cell;vertical-align: top;\">\n" +
                "  <div style=\"height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                "  <!--[if (!mso)&(!IE)]><!--><div style=\"height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                "  \n" +
                "<table id=\"u_content_text_10\" style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 10px 3px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
                "        \n" +
                "  <div class=\"v-text-align\" style=\"color: #646469; line-height: 170%; text-align: left; word-wrap: break-word;\">\n" +
                "    <p style=\"font-size: 14px; line-height: 170%;\"><strong><span style=\"font-size: 22px; line-height: 37.4px;\">Grand Total: </span></strong></p>\n" +
                "<p style=\"font-size: 14px; line-height: 170%;\"><span style=\"font-size: 30px; line-height: 51px; color: #000000;\"><strong><span style=\"line-height: 51px; font-size: 30px;\">" + grandTotal + "<i>VND</i></span></strong></span></p>\n" +
                "  </div>\n" +
                "\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>\n" +
                "\n" +
                "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                "  </div>\n" +
                "</div>\n" +
                "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 550px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #f9f9f9;\">\n" +
                "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:550px;\"><tr style=\"background-color: #f9f9f9;\"><![endif]-->\n" +
                "      \n" +
                "<!--[if (mso)|(IE)]><td align=\"center\" width=\"550\" style=\"width: 550px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 550px;display: table-cell;vertical-align: top;\">\n" +
                "  <div style=\"height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                "  <!--[if (!mso)&(!IE)]><!--><div style=\"height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                "  \n" +
                "<table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:0px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
                "        \n" +
                "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "  <tr>\n" +
                "    <td class=\"v-text-align\" style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
                "      \n" +
                "      <img align=\"center\" border=\"0\" src=\"https://cdn.templates.unlayer.com/assets/1638246761051-1636803178559-bor.png\" alt=\"border\" title=\"border\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 100%;max-width: 550px;\" width=\"550\" class=\"v-src-width v-src-max-width\"/>\n" +
                "      \n" +
                "    </td>\n" +
                "  </tr>\n" +
                "</table>\n" +
                "\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>\n" +
                "\n" +
                "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                "  </div>\n" +
                "</div>\n" +
                "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 550px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #222222;\">\n" +
                "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:550px;\"><tr style=\"background-color: #222222;\"><![endif]-->\n" +
                "      \n" +
                "<!--[if (mso)|(IE)]><td align=\"center\" width=\"550\" style=\"width: 550px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 550px;display: table-cell;vertical-align: top;\">\n" +
                "  <div style=\"height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                "  <!--[if (!mso)&(!IE)]><!--><div style=\"height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                "  \n" +
                "<table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:30px 10px 10px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
                "        \n" +
                "<div class=\"menu\" style=\"text-align:center\">\n" +
                "<!--[if (mso)|(IE)]><table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\"><tr><![endif]-->\n" +
                "\n" +
                "  <!--[if (mso)|(IE)]><td style=\"padding:5px 30px\"><![endif]-->\n" +
                "  \n" +
                "    <a href=\"https://unlayer.com\" target=\"_self\" style=\"padding:5px 30px;display:inline-block;color:#ffffff;font-family:'Cabin',sans-serif;font-size:17px;text-decoration:none\"  class=\"v-padding\">\n" +
                "      Home\n" +
                "    </a>\n" +
                "  \n" +
                "  <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                "  \n" +
                "\n" +
                "  <!--[if (mso)|(IE)]><td style=\"padding:5px 30px\"><![endif]-->\n" +
                "  \n" +
                "    <a href=\"https://unlayer.com\" target=\"_self\" style=\"padding:5px 30px;display:inline-block;color:#ffffff;font-family:'Cabin',sans-serif;font-size:17px;text-decoration:none\"  class=\"v-padding\">\n" +
                "      Order Now\n" +
                "    </a>\n" +
                "  \n" +
                "  <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                "  \n" +
                "\n" +
                "  <!--[if (mso)|(IE)]><td style=\"padding:5px 30px\"><![endif]-->\n" +
                "  \n" +
                "    <a href=\"https://unlayer.com\" target=\"_self\" style=\"padding:5px 30px;display:inline-block;color:#ffffff;font-family:'Cabin',sans-serif;font-size:17px;text-decoration:none\"  class=\"v-padding\">\n" +
                "      Contact Us\n" +
                "    </a>\n" +
                "  \n" +
                "  <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                "  \n" +
                "\n" +
                "  <!--[if (mso)|(IE)]><td style=\"padding:5px 30px\"><![endif]-->\n" +
                "  \n" +
                "    <a href=\"https://unlayer.com\" target=\"_self\" style=\"padding:5px 30px;display:inline-block;color:#ffffff;font-family:'Cabin',sans-serif;font-size:17px;text-decoration:none\"  class=\"v-padding\">\n" +
                "      Support\n" +
                "    </a>\n" +
                "  \n" +
                "  <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                "  \n" +
                "\n" +
                "<!--[if (mso)|(IE)]></tr></table><![endif]-->\n" +
                "</div>\n" +
                "\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>\n" +
                "\n" +
                "<table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:30px 10px 20px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
                "        \n" +
                "<div align=\"center\">\n" +
                "  <div style=\"display: table; max-width:140px;\">\n" +
                "  <!--[if (mso)|(IE)]><table width=\"140\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"border-collapse:collapse;\" align=\"center\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse; mso-table-lspace: 0pt;mso-table-rspace: 0pt; width:140px;\"><tr><![endif]-->\n" +
                "  \n" +
                "    \n" +
                "    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 15px;\" valign=\"top\"><![endif]-->\n" +
                "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 15px\">\n" +
                "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                "        <a href=\"https://www.facebook.com/Mr.MinhxThanh\" title=\"Facebook\" target=\"_blank\">\n" +
                "          <img src=\"https://cdn.tools.unlayer.com/social/icons/rounded-black/facebook.png\" alt=\"Facebook\" title=\"Facebook\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
                "        </a>\n" +
                "      </td></tr>\n" +
                "    </tbody></table>\n" +
                "    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                "    \n" +
                "    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 15px;\" valign=\"top\"><![endif]-->\n" +
                "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 15px\">\n" +
                "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                "        <a href=\"https://www.facebook.com/Mr.MinhxThanh\" title=\"Twitter\" target=\"_blank\">\n" +
                "          <img src=\"https://cdn.tools.unlayer.com/social/icons/rounded-black/twitter.png\" alt=\"Twitter\" title=\"Twitter\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
                "        </a>\n" +
                "      </td></tr>\n" +
                "    </tbody></table>\n" +
                "    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                "    \n" +
                "    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 0px;\" valign=\"top\"><![endif]-->\n" +
                "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 0px\">\n" +
                "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                "        <a href=\"https://t.me/MinhxThanh\" title=\"Telegram\" target=\"_blank\">\n" +
                "          <img src=\"https://cdn.tools.unlayer.com/social/icons/rounded-black/telegram.png\" alt=\"Telegram\" title=\"Telegram\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
                "        </a>\n" +
                "      </td></tr>\n" +
                "    </tbody></table>\n" +
                "    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                "    \n" +
                "    \n" +
                "    <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                "  </div>\n" +
                "</div>\n" +
                "\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>\n" +
                "\n" +
                "<table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 30px 30px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
                "        \n" +
                "  <div class=\"v-text-align\" style=\"color: #ffffff; line-height: 180%; text-align: center; word-wrap: break-word;\">\n" +
                "    <p style=\"font-size: 14px; line-height: 180%;\"><span style=\"font-family: Lato, sans-serif; font-size: 16px; line-height: 28.8px;\">Want to change how you receive these emails?  </span></p>\n" +
                "<p style=\"font-size: 14px; line-height: 180%;\"><span style=\"font-family: Lato, sans-serif; font-size: 16px; line-height: 28.8px;\">You can update your preferences or unsubscribe from this list.</span></p>\n" +
                "<p style=\"font-size: 14px; line-height: 180%;\"> </p>\n" +
                "<p style=\"font-size: 14px; line-height: 180%;\"><span style=\"font-family: Lato, sans-serif; font-size: 16px; line-height: 28.8px;\">© 2022 <span style=\"text-decoration: underline; font-size: 16px; line-height: 28.8px;\">Minh Thanh</span>. All Rights Reserved.</span></p>\n" +
                "  </div>\n" +
                "\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>\n" +
                "\n" +
                "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                "  </div>\n" +
                "</div>\n" +
                "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "    <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                "    </td>\n" +
                "  </tr>\n" +
                "  </tbody>\n" +
                "  </table>\n" +
                "  <!--[if mso]></div><![endif]-->\n" +
                "  <!--[if IE]></div><![endif]-->\n" +
                "</body>\n" +
                "\n" +
                "</html>";
    }

}
