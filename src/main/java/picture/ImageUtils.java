package picture;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageUtils {

    /**
     * 默认生成JPEG格式图片
     *
     * @param target
     * @param doc
     */
    public static void draw(File target, Document doc) {
        draw(target, "JPEG", doc);
    }

    /**
     * @param target
     * @param formatName 图片格式
     * @param doc
     */
    public static void draw(File target, String formatName, Document doc) {
        try {
            BufferedImage image = draw(doc);
            ImageIO.write(image, formatName, target);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static BufferedImage draw(Document doc) {
        ImageElement rootElement = doc.getImgRootElement();
        try {
            rootElement.draw(null);
            return rootElement.getImage();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            rootElement.clear();
        }
    }

    public static void main(String[] args) throws Exception {
        test2();
    }

    private static void test2() {
        ImageElement root = new ImageElement();
        root.setId("background");
        root.setFile(new File("D:\\tmp\\test\\111.jpeg"));
        root.setWidth(300);
        root.setHeight(240);

        TextElement text = new TextElement();
        text.setId("text");
        text.setX(37);
        text.setY(root.getHeight() - 37);
        text.setWidth(root.getWidth());
        text.setHeight(37);
        text.setText("杨洒脱邀请你一起买");
        text.setColor(new Color(255, 255, 255));

        // 根据需要是否使用 BufferedImage.TYPE_INT_ARGB
        BufferedImage image = new BufferedImage(root.getWidth(), 37, BufferedImage.TYPE_INT_ARGB);

        // 创建Graphics2D对象，用在底图对象上绘图
        Graphics2D bgG2d = image.createGraphics();
        bgG2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.65F));
        bgG2d.drawImage(image, 0, 0, root.getWidth(), 37, null);

//        File fontFile = new File("/alexhome/Helvetica-Regular.ttf");
//        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(Font.PLAIN, 25f);
//        text.setFont(font);

        ImageElement avatar = new ImageElement();
        avatar.setId("avatar");
        avatar.setFile(new File("D:\\tmp\\test\\12_4_avatar.png"));
        avatar.setX(4);
        avatar.setY(root.getHeight() - 37);
        avatar.setWidth(33);
        avatar.setHeight(37);
//        avatar.setBorder(2);
//        avatar.setColor(Color.WHITE);

        ImageElement qrCode = new ImageElement();
        qrCode.setId("qrCode");
        qrCode.setX(0);
        qrCode.setY(root.getHeight() - 37);
        qrCode.setWidth(root.getWidth());
        qrCode.setHeight(37);
        qrCode.setColor(Color.WHITE);
        qrCode.setBufferedImage(image);
        qrCode.addElement(avatar);

        root.addElement(text);
        root.addElement(avatar);

        Document doc = Document.createDocument(root);
        draw(new File("D:\\tmp\\test\\testttt.jpg"), doc);
    }

    private static void test1() {
        ImageElement root = new ImageElement();
        root.setId("background");
        root.setFile(new File("/alexhome/leaderbg.png"));

        TextElement text = new TextElement();
        text.setId("text");
//        text.setX(271);
        text.setY(530);
//        text.setWidth(190);
//        text.setHeight(35);
        text.setText("ABCDEF");
        text.setColor(new Color(153, 31, 92));

//        File fontFile = new File("/alexhome/Helvetica-Regular.ttf");
//        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(Font.PLAIN, 25f);
//        text.setFont(font);

        ImageElement logo = new ImageElement();
        logo.setId("logo");
        logo.setFile(new File("/alexhome/logo.jpg"));
//        logo.setX(105);
//        logo.setY(105);
        logo.setWidth(70);
        logo.setHeight(70);
        logo.setBorder(2);
        logo.setColor(Color.WHITE);

        QrCodeImageElement qrCode = new QrCodeImageElement();
        qrCode.setId("qrCode");
//        qrCode.setX(180);
        qrCode.setY(560);
        qrCode.setWidth(280);
        qrCode.setHeight(280);
        qrCode.setColor(Color.WHITE);
        qrCode.setContent("abcdefabcdefabcdefabcdefabcdefabcdefabcdefabcdefabcdefabcdefabcdef");
        qrCode.addElement(logo);

        root.addElement(text);
        root.addElement(qrCode);

        Document doc = Document.createDocument(root);
        draw(new File("/alexhome/test.jpg"), doc);
    }

}
