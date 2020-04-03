package email;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @Description: EmailTest
 * @author: lixl
 * @Date: 2020/4/3 18:04
 *
 * <!--发送邮件-->
 *         <dependency>
 *             <groupId>org.apache.commons</groupId>
 *             <artifactId>commons-email</artifactId>
 *             <version>1.4</version>
 *         </dependency>
 */
public class EmailUtil {
    /** 发件人的邮箱和密码 */
    private static final String SEND_EMAIL_ACCOUNT = "support@cloud-er.com";
    private static final String SEND_EMAIL_PW = "clouder2019!A";
    private static final String SEND_EMAIL_SMTP_HOST = "smtp.exmail.qq.com";
    private static final String SUBJECT_TITLE = "云尔科技";
    private static final String RECEIVE_PEOPLE = "您好";
    private static final String SEND_EMAIL_PERSONAL = "北京云尔计算科技有限公司";

    // JavaMail须要Properties来创建一个session对象。它将寻找字符串"mail.smtp.host"，属性值就是发送邮件的主机.
    public static void main(String[] args) throws Exception {
        List<String> receiveMail = Arrays.asList("lixiaolong@cloud-er.com");
        // setContent(“邮件的正文内容”,”设置邮件内容的编码方式”)
        String html = new StringBuffer()
                .append("<html>")
                .append("<head> <title>我的第一个 HTML 页面</title> </head>")
                .append("<body>")
                .append("<img src='cid:lineAndShap'>")
                .append("<p>body 元素的内容会显示在浏览器中。</p>")
                .append("<img src='cid:bar'>")
                .append("<p>title 元素的内容会显示在浏览器的标题栏中。</p>")
                .append("<img src='cid:barGroup'>")
                .append("<p>title 元素的内容会显示在浏览器的标题栏中。</p>")
                .append("</body>")
                .append("</html>").toString();
        List<String> pictures = Arrays.asList("d:\\lineAndShap.jpg", "d:/bar.png", "d:/barGroup.png");
        sendPictureEmail2(receiveMail, html, pictures);
//        sendPictureEmail(receiveMail, html);
    }

    private static void sendPictureEmail2(List<String> receiveMail, String html, List<String> pictures) {
        try {
            Properties properties = new Properties();
            // 设置smtp主机
            properties.put("mail.smtp.host", SEND_EMAIL_SMTP_HOST);
            // 使用smtp身份验证
            properties.put("mail.smtp.auth", "true");
            /*
             * 在 JavaMail 中，能够通过 extends Authenticator 抽象类，在子类中覆盖父类中的
             * getPasswordAuthentication() 方法。就能够实现以不同的方式来进行登录邮箱时的用户身份认证。JavaMail
             * 中的这样的设计是使用了策略模式（Strategy)
             */
            Authenticator authenticator = new Authenticator() {
                @Override
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(SEND_EMAIL_ACCOUNT, SEND_EMAIL_PW);
                }
            };
            MimeMessage message = new MimeMessage(Session.getInstance(properties, authenticator));
            // 设置邮件的发件人
            message.setFrom(new InternetAddress(SEND_EMAIL_ACCOUNT));
            // 设置邮件的收件人 cc表示抄送 bcc 表示暗送（可以增加多个收件人、抄送、密送）
            Address[] addresses = new InternetAddress[receiveMail.size()];
            for (int i = 0; i < receiveMail.size(); i++) {
                addresses[i] = new InternetAddress(receiveMail.get(i), "", "UTF-8");
            }
            message.setRecipients(Message.RecipientType.TO, addresses);
            message.setSubject(SUBJECT_TITLE);
            MimeBodyPart text = new MimeBodyPart();
            text.setContent(html, "text/html;charset=utf-8");

            /*
             * JavaMail API不限制信息仅仅为文本,不论什么形式的信息都可能作茧自缚MimeMessage的一部分.
             * 除了文本信息,作为文件附件包括在电子邮件信息的一部分是非常普遍的.
             * JavaMail API通过使用DataHandler对象,提供一个同意我们包括非文本BodyPart对象的简便方法.
             */

            // 附件与正文（text 和 img）的关系
            MimeMultipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(text);
            // 创建图片
            for (String picture : pictures) {
                MimeBodyPart img = new MimeBodyPart();
                // 每一张图片路径
                FileDataSource fileDataSource = new FileDataSource(picture);
                DataHandler firstDataHandler = new DataHandler(fileDataSource);
                img.setDataHandler(firstDataHandler);
                // 创建图片的一个表示用于显示在邮件中显示
                String contentId = getContentId(picture);
                img.setContentID(contentId);

                // 关系 正文和图片的
                MimeMultipart mm = new MimeMultipart();
                mm.addBodyPart(img);
                // 设置正文与图片之间的关系
                mm.setSubType("related");
                // 图片与正文的 body
                MimeBodyPart all = new MimeBodyPart();
                all.setContent(mm);

                mimeMultipart.addBodyPart(all);
                mimeMultipart.addBodyPart(img);
                // 设置正文与附件之间的关系
                mimeMultipart.setSubType("mixed");
            }
            // 创建附件
            // MimeBodyPart attch = new MimeBodyPart();
            // DataHandler dh1 = new DataHandler(new FileDataSource("src//b.jpg"));
            // attch.setDataHandler(dh1);
            // String filename1 = dh1.getName();
            // MimeUtility 是一个工具类，encodeText（）用于处理附件字，防止中文乱码问题
            // attch.setFileName(MimeUtility.encodeText(filename1));

            message.setContent(mimeMultipart);
            // 保存改动
            message.saveChanges();
            // 发送邮件
            Transport.send(message);
            System.out.println("邮件发送成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getContentId(String picture) {
        boolean lastExists = picture.contains("/");
        boolean mayLastExists = picture.contains("\\");
        int last = picture.lastIndexOf("/");
        int mayLast = picture.lastIndexOf("\\");
        int start = 0;
        if (lastExists && mayLastExists) {
            start = last > mayLast ? mayLast : last;
        } else if(lastExists && !mayLastExists) {
            start = last;
        } else {
            start = mayLast;
        }
        return picture.substring(start+1, picture.lastIndexOf("."));
    }

    private static void sendPictureEmail(List<String> receiveMail, String html) {
        try {
            Properties properties = new Properties();
            // 设置smtp主机
            properties.put("mail.smtp.host", SEND_EMAIL_SMTP_HOST);
            // 使用smtp身份验证
            properties.put("mail.smtp.auth", "true");
            /*
             * 在 JavaMail 中，能够通过 extends Authenticator 抽象类，在子类中覆盖父类中的
             * getPasswordAuthentication() 方法。就能够实现以不同的方式来进行登录邮箱时的用户身份认证。JavaMail
             * 中的这样的设计是使用了策略模式（Strategy)
             */
            Authenticator authenticator = new Authenticator() {
                @Override
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(SEND_EMAIL_ACCOUNT, SEND_EMAIL_PW);
                }
            };
            MimeMessage message = new MimeMessage(Session.getInstance(properties, authenticator));
            // 设置邮件的发件人
            message.setFrom(new InternetAddress(SEND_EMAIL_ACCOUNT));
            // 设置邮件的收件人 cc表示抄送 bcc 表示暗送（可以增加多个收件人、抄送、密送）
            Address[] addresses = new InternetAddress[receiveMail.size()];
            for (int i = 0; i < receiveMail.size(); i++) {
                addresses[i] = new InternetAddress(receiveMail.get(i), "", "UTF-8");
            }
            message.setRecipients(Message.RecipientType.TO, addresses);
            message.setSubject(SUBJECT_TITLE);
            MimeBodyPart text = new MimeBodyPart();
            text.setContent(html, "text/html;charset=utf-8");

            /*
             * JavaMail API不限制信息仅仅为文本,不论什么形式的信息都可能作茧自缚MimeMessage的一部分.
             * 除了文本信息,作为文件附件包括在电子邮件信息的一部分是非常普遍的.
             * JavaMail API通过使用DataHandler对象,提供一个同意我们包括非文本BodyPart对象的简便方法.
             */
            // 创建图片
            MimeBodyPart img = new MimeBodyPart();
            // 每一张图片路径
            FileDataSource fileDataSource = new FileDataSource("d://lineAndShap.jpg");
            DataHandler firstDataHandler = new DataHandler(fileDataSource);
            img.setDataHandler(firstDataHandler);
            // 创建图片的一个表示用于显示在邮件中显示
            img.setContentID("a");

            MimeBodyPart img2 = new MimeBodyPart();
            // 第二张图片路径
            DataHandler secondDataHandler = new DataHandler(new FileDataSource("d://bar.png"));
            img2.setDataHandler(secondDataHandler);
            img2.setContentID("b");
            // 创建附件
            // MimeBodyPart attch = new MimeBodyPart();
            // DataHandler dh1 = new DataHandler(new FileDataSource("src//b.jpg"));
            // attch.setDataHandler(dh1);
            // String filename1 = dh1.getName();
            // MimeUtility 是一个工具类，encodeText（）用于处理附件字，防止中文乱码问题
            // attch.setFileName(MimeUtility.encodeText(filename1));
            // 关系 正文和图片的
            MimeMultipart mm = new MimeMultipart();
            mm.addBodyPart(text);
            mm.addBodyPart(img);
            // 设置正文与图片之间的关系
            mm.setSubType("related");
            // 图片与正文的 body
            MimeBodyPart all = new MimeBodyPart();
            all.setContent(mm);
            // 附件与正文（text 和 img）的关系
            MimeMultipart mm2 = new MimeMultipart();
            mm2.addBodyPart(all);
            mm2.addBodyPart(img2);
            // 设置正文与附件之间的关系
            mm2.setSubType("mixed");
            message.setContent(mm2);
            // 保存改动
            message.saveChanges();
            // 发送邮件
            Transport.send(message);
            System.out.println("邮件发送成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
