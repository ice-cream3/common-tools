package picture;

import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.util.ResourceUtils;
import util.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

import static picture.ShareUtils.*;

/**
 * 商品详情卡片分享图片
 */
public class ShareDetailImageUtils {

    /**
     * 库存小于等于该数量时才显示
     */
    private static final int REMAIN_QUANTITY = 10;

//    public static void main(String[] args) {
//        //String basePath = "/Users/qianli/work/IdeaProjects/nicetuan2/nicetuan-weapp-server/nicetuan-weapp/nicetuan-weapp-boot/src/main/resources/";
//        String basePath = "D:/workspace/nicetuan/nicetuan-weapp-server/nicetuan-weapp/nicetuan-weapp-boot/src/main/resources/";
//        String coverImageUrl = "https://imgcdn.nicetuan.net/upload/311612/202004/3704618.jpg";
//        coverImageUrl = "http://devdev.cdn.akucun.com/a04d46b6ebc66d6ea918d8aad9f2f11fb42c88b5_1559553340827_73.jpg";
//        String price = "48.0005";
//        String originPrice = "50.000005";
//        int quantity = 100;
//        int groupType = 1;
//        BufferedImage bufferedImage = getShareDetailImage(basePath, coverImageUrl, price, originPrice, quantity, groupType);
//        try {
//            File output = new File(basePath + "share/detail-card/a.png");
//            ImageIO.write(bufferedImage, "png", output);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        String basePath = "/Users/lxllzwj/wsapi/nicetuan-api-detail-server/nicetuan-detail/nicetuan-detail-boot/src/main/resources/";
        String coverImageUrl = "https://imgcdn.nicetuan.net/upload/311612/202004/3704618.jpg";
        coverImageUrl = "http://devdev.cdn.akucun.com/a04d46b6ebc66d6ea918d8aad9f2f11fb42c88b5_1559553340827_73.jpg";
        String price = "62.8";
        String originPrice = "132.6";
        buildImage(basePath, coverImageUrl, price, originPrice, 10, 1, false);
        buildImage(basePath, coverImageUrl, price, originPrice, 11, 1, false);

        buildImage(basePath, coverImageUrl, price, originPrice, 10, 0, true);
        buildImage(basePath, coverImageUrl, price, originPrice, 11, 0, true);

        buildImage(basePath, coverImageUrl, price, originPrice, 10, 0, false);
        buildImage(basePath, coverImageUrl, price, originPrice, 11, 0, false);
    }

    private static void buildImage(String basePath, String coverImageUrl, String price, String originPrice, int quantity, int groupType, boolean mailHome) {
        BufferedImage bufferedImage = getShareDetailImageV2(basePath, coverImageUrl, price, originPrice, quantity, groupType,8, mailHome);
        try {
            File output = new File(basePath + "share/detail-card/a"+quantity+"-"+groupType+"-"+mailHome+".png");
            ImageIO.write(bufferedImage, "png", output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成商品详情分享图片(500 * 400)
     *
     * @param coverImageUrl 商品图片
     * @param price         商品价格
     * @param originPrice   商品原价
     * @param quantity      剩余数量
     * @param groupType     团类型：0普通团，1秒杀团
     * @return
     * @author Yangjian
     */
    public static BufferedImage getShareDetailImage(String basePath, String coverImageUrl, String price, String originPrice, int quantity, int groupType) {
        InputStream remainImageInputStream = null;
        InputStream watermarkImageInputStream = null;
        InputStream detailBottomImageInputStream = null;
        InputStream rootBackbroundImageInputStream = null;
        try {

            //1、背景图根元素
            ImageElement rootElement = new ImageElement();
            rootElement.setId("backgroundImage");

            //白色背景底图（500 * 400）
            String backgroundImagePath = StringUtils.join(basePath, "/share/detail-card/20200402_detal_gb_500_400.jpg");
            rootBackbroundImageInputStream = ShareImageUtils.class.getResourceAsStream(backgroundImagePath);

            //本地Main测试使用
            if (rootBackbroundImageInputStream == null) {
                rootElement.setBufferedImage(ImageIO.read(ResourceUtils.getFile(backgroundImagePath)));
            }
            rootElement.setImageStream(rootBackbroundImageInputStream);

            //2、图片价格底栏
            ImageElement bottomImageElement = new ImageElement();
            bottomImageElement.setId("bottomImage");
            String detailBottomPath = StringUtils.join(basePath, "/share/detail-card/20200402_detail_bottom_", groupType, ".png");
            detailBottomImageInputStream = ShareImageUtils.class.getResourceAsStream(detailBottomPath);

            //本地Main测试使用
            if (detailBottomImageInputStream == null) {
                bottomImageElement.setBufferedImage(ImageIO.read(ResourceUtils.getFile(detailBottomPath)));
            }
            bottomImageElement.setImageStream(detailBottomImageInputStream);

            //3、商品图片
            ImageElement merchandiseImageElement = new ImageElement();
            merchandiseImageElement.setId("merchandiseImage");
            BufferedImage merchandiseBufferedImage = getBufferedImageRegion(coverImageUrl, 500, 342);

            merchandiseImageElement.setBufferedImage(merchandiseBufferedImage);
            merchandiseImageElement.setWidth(500);
            merchandiseImageElement.setHeight(342);
            merchandiseImageElement.setBorder(0);
            merchandiseImageElement.setX(0);
            merchandiseImageElement.setY(1);

            //4、商品价格
            int merchandiseOriginPriceWidth = 26 + 16;

            //商品价格人民币符号部分
            TextElement merchandisePriceIntMoneyElement = new TextElement();
            merchandisePriceIntMoneyElement.setId("price1");
            merchandisePriceIntMoneyElement.setText("¥");
            merchandisePriceIntMoneyElement.setColor(new Color(255, 255, 255));
            merchandisePriceIntMoneyElement.setX(13);
            merchandisePriceIntMoneyElement.setY(55);
            merchandisePriceIntMoneyElement.setFont(getDefalutFont().deriveFont(Font.PLAIN, 36));

            //商品价格整数部分
            TextElement merchandisePriceIntElement = new TextElement();
            merchandisePriceIntElement.setId("price2");
            merchandisePriceIntElement.setText(price);
            merchandisePriceIntElement.setColor(new Color(255, 255, 255));
            merchandisePriceIntElement.setX(36);
            merchandisePriceIntElement.setY(55);
            merchandisePriceIntElement.setFont(getDefalutFont().deriveFont(Font.TRUETYPE_FONT, 52));
            merchandiseOriginPriceWidth = merchandiseOriginPriceWidth + merchandisePriceIntElement.getStringBounds().width;

            bottomImageElement.addElement(merchandisePriceIntMoneyElement);
            bottomImageElement.addElement(merchandisePriceIntElement);

            //商品原价
            TextElement merchandiseOriginPriceElement = new TextElement();
            merchandiseOriginPriceElement.setId("originPrice");
            merchandiseOriginPriceElement.setText(originPrice);
            merchandiseOriginPriceElement.setColor(new Color(255, 255, 255));
            merchandiseOriginPriceElement.setX(merchandiseOriginPriceWidth);
            merchandiseOriginPriceElement.setY(55);
//            merchandiseOriginPriceElement.setRow(1);
//            merchandiseOriginPriceElement.setRowWidth(80);
//            merchandiseOriginPriceElement.setRowEllipsis(true);
            merchandiseOriginPriceElement.setFont(getDefalutFont().deriveFont(Font.PLAIN, 25));

            //删除线
            merchandiseOriginPriceElement.setDrawLine(true);
            merchandiseOriginPriceElement.setX1(merchandiseOriginPriceElement.getX());
            merchandiseOriginPriceElement.setY1(merchandiseOriginPriceElement.getY() - 9);
            merchandiseOriginPriceElement.setY2(merchandiseOriginPriceElement.getY() - 9);

            //商品图片
            rootElement.addElement(merchandiseImageElement);
            Document document = Document.createDocument(rootElement);

            //用水印方式添加底栏价格
            bottomImageElement.addElement(merchandiseOriginPriceElement);
            Document documentBottom = Document.createDocument(bottomImageElement);
            BufferedImage bufferedImageBottom = ImageUtils.draw(documentBottom);

            //在底图对象上加剩余水印，以免图片尺寸过小导致模糊
            BufferedImage bufferedImage = ImageUtils.draw(document);

            //5、销量剩余水印
            String remainImagePath = null;
            if (groupType == 1) {
                if (quantity <= REMAIN_QUANTITY) {
                    remainImagePath = StringUtils.join(basePath, "/share/detail-card/20200402_detail_second_skill_remain.png");
                } else {
                    remainImagePath = StringUtils.join(basePath, "/share/detail-card/20200402_detail_second_skill.png");
                }
            } else if (groupType == 2 && quantity <= REMAIN_QUANTITY) {
                remainImagePath = StringUtils.join(basePath, "/share/detail-card/20200402_detail_remain.png");
            }
            if (remainImagePath != null) {
                ImageElement remainImageElement = new ImageElement();
                remainImageElement.setId("remainImage");
                remainImageInputStream = ShareImageUtils.class.getResourceAsStream(remainImagePath);

                //本地Main测试使用
                if (remainImageInputStream == null) {
                    remainImageElement.setBufferedImage(ImageIO.read(ResourceUtils.getFile(remainImagePath)));
                }
                remainImageElement.setImageStream(remainImageInputStream);

                //剩余数量
                if (remainImagePath != null && quantity <= REMAIN_QUANTITY) {
                    TextElement remainWordElement = new TextElement();
                    remainWordElement.setId("quantity");
                    remainWordElement.setText(String.valueOf(quantity));
                    remainWordElement.setColor(new Color(255, 206, 81));
                    remainWordElement.setX(78);
                    if (groupType == 1) {
                        remainWordElement.setColor(new Color(255, 255, 255));
                        remainWordElement.setX(145);
                    }
                    remainWordElement.setY(40);
                    remainWordElement.setFont(getDefalutFont().deriveFont(Font.BOLD, 33));
                    remainImageElement.addElement(remainWordElement);
                }

                Document remainDocumentBottom = Document.createDocument(remainImageElement);
                BufferedImage remainBufferedImage = ImageUtils.draw(remainDocumentBottom);

                //剩余水印 + 底栏价格水印
                return watermark(watermark(bufferedImage, bufferedImageBottom, Positions.BOTTOM_CENTER), remainBufferedImage, PositionType.TOP_Y1);
            }

            //底栏价格水印
            return watermark(bufferedImage, bufferedImageBottom, Positions.BOTTOM_CENTER);
        } catch (Exception e) {
            System.out.println("生成商品详情分享图片");
            throw new NullPointerException();
        } finally {
            close(remainImageInputStream);
            close(watermarkImageInputStream);
            close(detailBottomImageInputStream);
            close(rootBackbroundImageInputStream);
        }
    }

    public static BufferedImage getShareDetailImageV2(String basePath, String coverImageUrl,
        String price, String originPrice, int quantity, int groupType, int size, boolean mailHome) {

        InputStream rootBackgroundImageInputStream = null;
        InputStream flagImageInputStream = null;
        InputStream handImageInputStream = null;
        try {
            //1、背景图根元素
            ImageElement rootElement = new ImageElement();
            rootElement.setId("backgroundImage");
            // 背景
            addBackGround(rootElement, basePath, rootBackgroundImageInputStream,groupType,mailHome,quantity);
            // 商品图
            addMerchandiseImage(coverImageUrl, rootElement);
            if (mailHome) {
                addMailhomeImage(basePath, "flag_mailhome.png", rootElement);
            }

            Document document = Document.createDocument(rootElement);
            //在底图对象上加剩余水印，以免图片尺寸过小导致模糊
            BufferedImage bufferedImage = ImageUtils.draw(document);
            Graphics2D graphics2D = bufferedImage.createGraphics();

            ImageElement imageElement = new ImageElement();
            imageElement.setId("imageElement");
            imageElement.setBufferedImage(bufferedImage);
            //商品价格
            addMerchandisePrice(graphics2D, price, imageElement,mailHome,groupType,quantity);
            //商品原价(去掉划线价，2021年5月26日 by yangjian)
            //addMerchandiseOriginPrice(graphics2D, originPrice, imageElement,mailHome,groupType,quantity);
            // 库存数量
            addQuantity(graphics2D,quantity, imageElement,groupType,mailHome);

            return ImageUtils.draw(Document.createDocument(imageElement));
        } catch (Exception e) {
            System.out.println("生成商品详情分享图片");
            throw new NullPointerException();
        } finally {
            close(rootBackgroundImageInputStream);
            close(flagImageInputStream);
            close(handImageInputStream);
        }
    }

    private static void addQuantity(Graphics2D graphics2D, int quantity, ImageElement imageElement, int groupType, boolean mailHome) {
        if (quantity > REMAIN_QUANTITY || quantity == 0) {
            return;
        }
        TextElement remainWordElement = new TextElement();
        remainWordElement.setId("quantity1");
        remainWordElement.setText("仅剩"+quantity+"件");
        remainWordElement.setFont(getPingFangChangGuiTiFont().deriveFont(Font.BOLD, 24));
        remainWordElement.setColor(new Color(4, 185, 34));

        int width = graphics2D.getFontMetrics(remainWordElement.getFont()).stringWidth(remainWordElement.getText());
        remainWordElement.setX(294+(195-width)/2);
        int y = 278; // 288
        if (!mailHome && groupType == 0) {
            // 普通品 26
            y -= 36;
        }
        remainWordElement.setY(y);
        imageElement.addElement(remainWordElement);
    }

    private static void addMerchandiseOriginPrice(Graphics2D graphics2D, String originPrice, ImageElement imageElement, boolean mailHome, int groupType, int quantity) {

        TextElement merchandiseOriginPriceElement = new TextElement();
        merchandiseOriginPriceElement.setId("originPrice");
        merchandiseOriginPriceElement.setText(StringUtils.join("￥", originPrice));
        merchandiseOriginPriceElement.setColor(new Color(0.53F, 0.53F, 0.56F));
        merchandiseOriginPriceElement.setFont(getPingFangChangGuiTiFont().deriveFont(Font.PLAIN, 28));

        int price3w = graphics2D.getFontMetrics(merchandiseOriginPriceElement.getFont()).stringWidth(merchandiseOriginPriceElement.getText());

        merchandiseOriginPriceElement.setX(292+(194-price3w)/2);
        int y = 278;
        if (!mailHome && groupType == 0) {
            // 普通品
            y -= 22;
            if (quantity > 0 && quantity <= REMAIN_QUANTITY) {
                y -= 26;
            }
        } else if (quantity > 0 && quantity <= REMAIN_QUANTITY){
            y -= 22;
        }
        merchandiseOriginPriceElement.setY(y);

        //删除线
        merchandiseOriginPriceElement.setDrawLine(true);
        merchandiseOriginPriceElement.setX1(merchandiseOriginPriceElement.getX());
//        merchandiseOriginPriceElement.setX2(merchandiseOriginPriceElement.getX() + merchandiseOriginPriceElement.getWidth());
        merchandiseOriginPriceElement.setY1(merchandiseOriginPriceElement.getY() - 9);
        merchandiseOriginPriceElement.setY2(merchandiseOriginPriceElement.getY() - 9);

        imageElement.addElement(merchandiseOriginPriceElement);
    }

    private static void addMerchandisePrice(Graphics2D graphics2D, String price, ImageElement imageElement, boolean mailHome, int groupType, int quantity) {
        //商品价格人民币符号部分
        TextElement merchandisePriceIntMoneyElement = new TextElement();
        merchandisePriceIntMoneyElement.setId("price1");
        merchandisePriceIntMoneyElement.setText("¥");
        merchandisePriceIntMoneyElement.setColor(new Color(1F, 0.27F, 0));
        merchandisePriceIntMoneyElement.setFont(getPingFangBoldFont().deriveFont(Font.PLAIN, 24));
        //商品价格整数部分
        TextElement merchandisePriceIntElement = new TextElement();
        merchandisePriceIntElement.setId("price2");
        merchandisePriceIntElement.setText(price);
        merchandisePriceIntElement.setColor(new Color(1F, 0.27F, 0));
        merchandisePriceIntElement.setFont(getPingFangBoldFont().deriveFont(Font.TRUETYPE_FONT, 56));

        int price1w = graphics2D.getFontMetrics(merchandisePriceIntMoneyElement.getFont()).stringWidth(merchandisePriceIntMoneyElement.getText());
        int price2w = graphics2D.getFontMetrics(merchandisePriceIntElement.getFont()).stringWidth(merchandisePriceIntElement.getText());
        merchandisePriceIntMoneyElement.setX(292+(194-price1w-price2w)/2);
        int y = 253;
        if (!mailHome && groupType == 0) {
            // 普通品
            y -= 20;
            if (quantity > 0 && quantity <= REMAIN_QUANTITY) {
                y -= 30;
            }
        } else if (quantity > 0 && quantity <= REMAIN_QUANTITY){
            y -= 22;
        }
        merchandisePriceIntMoneyElement.setY(y);
        merchandisePriceIntElement.setX(292+(194-price1w-price2w)/2+18);
        merchandisePriceIntElement.setY(y);

        imageElement.addElement(merchandisePriceIntMoneyElement);
        imageElement.addElement(merchandisePriceIntElement);
    }

    private static void addMailhomeImage(String basePath, String imageName, ImageElement rootElement) throws Exception {
        int merchandiseOriginPriceWidth = 26;
        int merchandiseOriginPriceHeight = 325;
        //3、商品图片
        ImageElement imageElement = new ImageElement();
        imageElement.setId("mailhomeImage");
        String imageUrl = StringUtils.join(basePath+"/share/detail-card-v2/",imageName);
        InputStream inputStream = ShareDetailImageUtils.class.getResourceAsStream(imageUrl);
        //本地Main测试使用
        if (inputStream != null) {
            imageElement.setBufferedImage(ImageIO.read(inputStream));
        } else {
            BufferedImage image = ImageIO.read(new FileInputStream(new File(imageUrl)));
            imageElement.setBufferedImage(image);
        }


        //把原图片的内容复制到新的图片，同时把背景设为透明
        /*int alpha = 0;
        for(int i = 0; i < imgWidth; ++i) {
            for(int j = 0; j < imgHeight; ++j) {
                int rgb = temp.getRGB(i, j);
                int R =(rgb & 0xff0000 ) >> 16 ;
                int G= (rgb & 0xff00 ) >> 8 ;
                int B= (rgb & 0xff );
                if(((255-R)==0) && ((255-G)==0) && ((255-B)==0)){
                    rgb = ((alpha + 1) << 24) | (rgb & 00000000);
                }
                temp.setRGB(i, j, rgb);
            }
        }*/
        imageElement.setWidth(208);
        imageElement.setHeight(50);
        imageElement.setBorder(0);
        imageElement.setX(merchandiseOriginPriceWidth);
        imageElement.setY(merchandiseOriginPriceHeight);
        rootElement.addElement(imageElement);
    }

    private static void addMerchandiseImage(String coverImageUrl, ImageElement rootElement) {
        int merchandiseOriginPriceWidth = 14+12;
        int merchandiseOriginPriceHeight = 108;
        //3、商品图片
        ImageElement merchandiseImageElement = new ImageElement();
        merchandiseImageElement.setId("merchandiseImage");
        BufferedImage merchandiseBufferedImage = getBufferedImageRegion(coverImageUrl, 266, 266);
        merchandiseBufferedImage = getRundedCornerBufferedImage(merchandiseBufferedImage, 12, 266, 266);
        merchandiseImageElement.setBufferedImage(merchandiseBufferedImage);
        merchandiseImageElement.setWidth(266);
        merchandiseImageElement.setHeight(266);
        merchandiseImageElement.setBorder(0);
        merchandiseImageElement.setX(merchandiseOriginPriceWidth);
        merchandiseImageElement.setY(merchandiseOriginPriceHeight);

        rootElement.addElement(merchandiseImageElement);
    }

    private static void addBackGround(ImageElement rootElement, String basePath, InputStream rootBackgroundImageInputStream, int groupType, boolean mailHome, int quantity) throws IOException {
        //背景（500 * 400）
        String imageName ;
        boolean remain = quantity > 0 && quantity <= REMAIN_QUANTITY;
        if (mailHome) {
            //imageName = remain ? "bg_2x_qiang_mailhome_v2.png" : "bg_2x_qiang_mailhome.png";
            imageName = remain ? "bg_2x_qiang_mailhome_v2_new.png" : "bg_2x_qiang_mailhome_new.png";
        } else if (groupType == 1) {
            //imageName = remain ? "bg_2x_qiang_miaosha_v2.png" : "bg_2x_qiang_miaosha.png";
            imageName = remain ? "bg_2x_qiang_miaosha_v2_new.png" : "bg_2x_qiang_miaosha_new.png";
        } else {
            //imageName = "bg_2x_qiang.png";
            imageName = remain ? "bg_2x_qiang_new.png":"bg_2x_qiang_v2_new.png";
        }
        String backgroundImagePath = StringUtils.join(basePath+"/share/detail-card-v2/",imageName);
        rootBackgroundImageInputStream = ShareDetailImageUtils.class.getResourceAsStream(backgroundImagePath);
        //本地Main测试使用
        if (rootBackgroundImageInputStream == null) {
            rootElement.setBufferedImage(ImageIO.read(ResourceUtils.getFile(backgroundImagePath)));
        }
        rootElement.setImageStream(rootBackgroundImageInputStream);
    }

    public static void close(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (Exception e) {
            // 忽略
        }
    }

}
