package picture;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Position;
import org.apache.commons.io.IOUtils;
import org.springframework.util.ResourceUtils;
import util.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 图片分享工具类
 */
public class ShareUtils {

    public static String BASE_PATH = System.getProperty("user.dir");
//    public static String FONT_PATH = "/static/SourceHanSansCN-Medium.otf";
    public static String FONT_PATH = "/static/SourceHanSansCN-Medium.ttf";

    public static Font DEFALUT_FONT = null;

    public static Font PINGFANG_BOLD = null;
    public static Font PINGFANG_CHANGGUITI = null;
    public static Font PINGFANG_ZHONGHEITI = null;

    /**
     * 默认字体
     *
     * @return
     */
    public static Font getDefalutFont() {

        if (DEFALUT_FONT != null) {
            return DEFALUT_FONT;
        }

        InputStream resourceAsStream = null;
        try {
            resourceAsStream = ShareImageUtils.class.getResourceAsStream(FONT_PATH);
            if (resourceAsStream == null){
//                String basePath = "D:/workspace/nicetuan/nicetuan-weapp-server/nicetuan-weapp/nicetuan-weapp-boot/src/main/resources/";
                String basePath = "/Users/yangjian/IdeaProjects/nicetuan/nicetuan-api-detail-server/nicetuan-detail/nicetuan-detail-boot/src/main/resources";
                resourceAsStream = new FileInputStream(ResourceUtils.getFile(basePath + FONT_PATH));
            }
            DEFALUT_FONT = Font.createFont(Font.TRUETYPE_FONT, resourceAsStream);
            System.out.println( "load font PingFangRegular.ttf...");
            return DEFALUT_FONT;
        } catch (Exception e) {
            System.out.println("load font PingFangRegular.ttf error." + e.getMessage());
            System.out.println("加载字体失败");
            DEFALUT_FONT = new Font("宋体", Font.PLAIN, 14);
        } finally {
            IOUtils.closeQuietly(resourceAsStream);
        }
        return DEFALUT_FONT;
    }

    public static Font getPingFangBoldFont() {
        if (PINGFANG_BOLD != null) {
            return PINGFANG_BOLD;
        }
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = ShareUtils.class.getResourceAsStream("/static/PingFang-Bold-2.ttf");
            if (resourceAsStream == null){
//                String basePath = "D:/workspace/nicetuan/nicetuan-weapp-server/nicetuan-weapp/nicetuan-weapp-boot/src/main/resources/";
                String basePath = "/Users/yangjian/IdeaProjects/nicetuan/nicetuan-api-detail-server/nicetuan-detail/nicetuan-detail-boot/src/main/resources/";
                resourceAsStream = new FileInputStream(ResourceUtils.getFile(basePath + "/static/PingFang-Bold-2.ttf"));
            }
            PINGFANG_BOLD = Font.createFont(Font.TRUETYPE_FONT, resourceAsStream);
            System.out.println("load font PingFang-Bold-2.ttf...");
            return PINGFANG_BOLD;
        } catch (Exception e) {
            System.out.println("load font PingFang-Bold-2.ttf error." + e.getMessage());
            System.out.println( "加载字体失败");
            DEFALUT_FONT = new Font("宋体", Font.PLAIN, 14);
        } finally {
            IOUtils.closeQuietly(resourceAsStream);
        }
        return DEFALUT_FONT;
    }

    public static Font getPingFangChangGuiTiFont() {
        if (PINGFANG_CHANGGUITI != null) {
            return PINGFANG_CHANGGUITI;
        }
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = ShareUtils.class.getResourceAsStream("/static/PingFang-Jian-ChangGuiTi-2.ttf");
            if (resourceAsStream == null){
//                String basePath = "D:/workspace/nicetuan/nicetuan-weapp-server/nicetuan-weapp/nicetuan-weapp-boot/src/main/resources/";
                String basePath = "/Users/yangjian/IdeaProjects/nicetuan/nicetuan-api-detail-server/nicetuan-detail/nicetuan-detail-boot/src/main/resources/";
                resourceAsStream = new FileInputStream(ResourceUtils.getFile(basePath + "/static/PingFang-Jian-ChangGuiTi-2.ttf"));
            }
            PINGFANG_CHANGGUITI = Font.createFont(Font.TRUETYPE_FONT, resourceAsStream);
            return PINGFANG_CHANGGUITI;
        } catch (Exception e) {
            System.out.println("load font PingFang-Bold-2.ttf error." + e.getMessage());
            DEFALUT_FONT = new Font("宋体", Font.PLAIN, 14);
        } finally {
            IOUtils.closeQuietly(resourceAsStream);
        }
        return DEFALUT_FONT;
    }

    public static Font getPingFangZhongHeiTiFont() {
        if (PINGFANG_ZHONGHEITI != null) {
            return PINGFANG_ZHONGHEITI;
        }
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = ShareUtils.class.getResourceAsStream("/static/PingFang-Jian-ChangGuiTi-2.ttf");
            if (resourceAsStream == null){
//                String basePath = "D:/workspace/nicetuan/nicetuan-weapp-server/nicetuan-weapp/nicetuan-weapp-boot/src/main/resources/";
                String basePath = "/Users/yangjian/IdeaProjects/nicetuan/nicetuan-api-detail-server/nicetuan-detail/nicetuan-detail-boot/src/main/resources/";
                resourceAsStream = new FileInputStream(ResourceUtils.getFile(basePath + "/static/PingFang-Jian-ChangGuiTi-2.ttf"));
            }
            PINGFANG_ZHONGHEITI = Font.createFont(Font.TRUETYPE_FONT, resourceAsStream);
            return PINGFANG_ZHONGHEITI;
        } catch (Exception e) {
            System.out.println("load font PingFang-Bold-2.ttf error." + e.getMessage());
            DEFALUT_FONT = new Font("宋体", Font.PLAIN, 14);
        } finally {
            IOUtils.closeQuietly(resourceAsStream);
        }
        return DEFALUT_FONT;
    }

    /**
     * 图片圆角处理，背景透明化   原图片和处理后图片尺寸变化
     *
     * @param
     * @param result       处理后图片
     * @param type         图片格式
     * @param cornerRadius 720为圆角
     * @param width        处理后图片的width
     * @param height       处理后图片的height
     */
    public static Boolean toRoundedCornerWithChange(BufferedImage bi1, File result, String type, int cornerRadius, int width, int height) {
        try {
            // 根据需要是否使用 BufferedImage.TYPE_INT_ARGB
            BufferedImage image = getRundedCornerBufferedImage(bi1, cornerRadius, width, height);
            ImageIO.write(image, type, result);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println("生成圆角头像失败："+e.getMessage());
        }

        return Boolean.FALSE;
    }

    /**
     * 图片圆角处理，背景透明化   原图片和处理后图片尺寸变化
     *
     * @param bi1
     * @param type         图片格式
     * @param cornerRadius 720为圆角
     * @param width        处理后图片的width
     * @param height       处理后图片的height
     */
    public static byte[] roundedCorner2ByteArray(BufferedImage bi1, String type, int cornerRadius, int width, int height) {
        try {
            BufferedImage image = getRundedCornerBufferedImage(bi1, cornerRadius, width, height);
            return bufferedImage2ByteArray(image, type);
        } catch (Exception e) {
            System.out.println("生成圆角头像失败：" + e.getMessage());
        }
        return null;
    }

    /**
     * 图片圆角处理，背景透明化   原图片和处理后图片尺寸变化
     *
     * @param bi1          图片
     * @param cornerRadius 720为圆角
     * @param width
     * @param height
     * @return
     */
    public static BufferedImage getRundedCornerBufferedImage(BufferedImage bi1, int cornerRadius, int width, int height) {
        // 根据需要是否使用 BufferedImage.TYPE_INT_ARGB
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Ellipse2D.Double shape = new Ellipse2D.Double(0, 0, width, height);

        Graphics2D g2 = image.createGraphics();

        //高清设置
        RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        renderingHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHints(renderingHints);
        //高清设置

        image = g2.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
        g2 = image.createGraphics();
        g2.setComposite(AlphaComposite.Clear);
        g2.fill(new Rectangle(image.getWidth(), image.getHeight()));
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC, 1.0f));
        g2.setClip(shape);

        // 使用 setRenderingHint 设置抗锯齿
        g2 = image.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fillRoundRect(0, 0, width, height, cornerRadius, cornerRadius);
        g2.setComposite(AlphaComposite.SrcIn);
        g2.drawImage(bi1, 0, 0, width, height, null);
        g2.dispose();
        return image;
    }

    /**
     * 通过网络获取图片
     *
     * @param url
     * @return
     */
    public static BufferedImage getUrlByBufferedImage(String url) {
        int count = 0;
        BufferedImage bufImg = null;
        do {
            try {

                URL urlObj = new URL(url);
                HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
                // 连接超时
                conn.setDoInput(true);
                conn.setDoOutput(true);
                conn.setConnectTimeout(25000);
                // 读取超时 --服务器响应比较慢,增大时间
                conn.setReadTimeout(25000);
                conn.setRequestMethod("GET");
                conn.addRequestProperty("Accept-Language", "zh-cn");
                conn.addRequestProperty("Content-type", "image/jpeg");
                conn.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0; .NET CLR 2.0.50727)");
                conn.connect();
                bufImg = ImageIO.read(conn.getInputStream());
                conn.disconnect();
                count = 3;
            } catch (Exception e) {
                count++;
                System.out.println( "获取远程文件失败："+ e.getMessage() + " try...count = "+ count+ " url="+ url);
            }
        } while (count < 3);
        return bufImg;
    }

    public static BufferedImage watermark(BufferedImage bufferedImage, InputStream watermarkFile, Position position) {
        int count = 0;
        do {
            BufferedImage watermarkBufferedImage = null;
            try {
                watermarkBufferedImage = ImageIO.read(watermarkFile);
                BufferedImage newImage = Thumbnails.of(bufferedImage).scale(1).watermark(position, watermarkBufferedImage, 1f).asBufferedImage();
                count = 3;
                return newImage;
            } catch (Exception e) {
                count++;
                System.out.println("图片获取失败 try...count = " + count);
            } finally {
                watermarkBufferedImage = null;
            }
        } while (count < 3);
        return bufferedImage;
    }

    public static BufferedImage watermark(BufferedImage bufferedImage, BufferedImage watermarkBufferedImage, Position position) {
        int count = 0;
        do {
            try {
                BufferedImage newImage = Thumbnails.of(bufferedImage).scale(1).watermark(position, watermarkBufferedImage, 1f).//
                        asBufferedImage();
                count = 3;
                return newImage;
            } catch (Exception e) {
                count++;
                System.out.println( "图片获取失败 try...count = " + count);
            }
        } while (count < 3);
        return bufferedImage;
    }


    /**
     * 图片转byte[]
     *
     * @param image
     * @param type
     * @return
     */
    public static byte[] bufferedImage2ByteArray(BufferedImage image, String type) {
        ByteArrayOutputStream out = null;
        try {
            out = new ByteArrayOutputStream();
            ImageIO.write(image, type, out);
            return out.toByteArray();
        } catch (Exception e) {
        } finally {
            IOUtils.closeQuietly(out);
        }
        return null;
    }

    /**
     * 图片剪切(图片比例5:4)：
     * 1、图片大于给定尺寸时限进行等比缩略，然后再进行剪切；
     * 2、图片小于给定尺寸时，根据比例进行计算宽或高，直接进行剪切。
     *
     * @param url       图片地址
     * @param newWidth  0到x像素(300)
     * @param newHeight 0到y像素(240)
     * @return
     */
    public static BufferedImage getBufferedImageRegion(String url, int newWidth, int newHeight) {
        try {

            if (StringUtils.isEmpty(url)) {
                return null;
            }

            //BufferedImage bufferedImage = Thumbnails.of(new URL(url)).width(1).sourceRegion(0, 0, x, y).asBufferedImage();
            //BufferedImage bufferedImage = Thumbnails.of(Thumbnails.of(new URL(url)).height(y).keepAspectRatio(true).asBufferedImage()).scale(1).sourceRegion(0, 0, x, y).asBufferedImage();

            BufferedImage sourceImage = getUrlByBufferedImage(url);
            if (sourceImage == null) {
                return null;
            }

            BufferedImage newImage = null;
            int sourceWidth = sourceImage.getWidth();
            int sourceHeight = sourceImage.getHeight();

            //尺寸相同
            if (sourceWidth == newWidth && sourceHeight == newHeight) {
                return sourceImage;
            }

            //图片宽高比
            double scale = new BigDecimal(newWidth).divide(new BigDecimal(newHeight), 10, RoundingMode.HALF_DOWN).doubleValue();

            //以高度来缩
            if (sourceWidth / scale >= sourceHeight) {

                //源图片高小于240
                if (sourceHeight < newHeight) {

                    //计算该比例下的宽度值
                    BigDecimal tempNewWidth = new BigDecimal(sourceHeight).multiply(new BigDecimal(scale)).setScale(10, RoundingMode.DOWN);

                    //居中剪裁，起始y值
                    int i0Width = (sourceWidth - tempNewWidth.intValue()) / 2;
                    newImage = Thumbnails.of(sourceImage).scale(1).sourceRegion(i0Width, 0, tempNewWidth.intValue(), sourceHeight).asBufferedImage();
                } else {

                    BufferedImage newHeightBufferedImage = Thumbnails.of(sourceImage).height(newHeight).keepAspectRatio(true).asBufferedImage();
                    int i0Width = (newHeightBufferedImage.getWidth() - newWidth) / 2;

                    newImage = Thumbnails.of(newHeightBufferedImage).scale(1).sourceRegion(i0Width, 0, newWidth, newHeight).asBufferedImage();
                }
            }

            //以宽度来缩
            else/* if (sourceWidth / scale < sourceHeight) */ {
                if (sourceWidth < newWidth) {
                    BigDecimal tempNewHeight = new BigDecimal(sourceWidth).divide(new BigDecimal(scale), 10, RoundingMode.DOWN);

                    int i1Height = (sourceHeight - tempNewHeight.intValue()) / 2;

                    newImage = Thumbnails.of(sourceImage).scale(1).sourceRegion(0, i1Height, sourceWidth, tempNewHeight.intValue()).asBufferedImage();
                } else {

                    BufferedImage newWidthBufferedImage = Thumbnails.of(sourceImage).width(newWidth).keepAspectRatio(true).asBufferedImage();
                    int i1Height = (newWidthBufferedImage.getHeight() - newHeight) / 2;

                    newImage = Thumbnails.of(newWidthBufferedImage).scale(1).sourceRegion(0, i1Height, newWidth, newHeight).asBufferedImage();
                }
            }

            return newImage;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
