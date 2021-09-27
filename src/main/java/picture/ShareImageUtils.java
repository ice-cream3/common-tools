package picture;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import util.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;

import static picture.ShareUtils.*;

public class ShareImageUtils {

//    public static String basePath = System.getProperty("user.dir");

//    public static Font DEFALUT_FONT = null;

    public static void main(String[] args) {


        String path = "/Users/songguoyuan/work/image/white200.png";
        //createBackground(200, 200, new File(path), "png");
//        //生成白色背景图片
//        String back = "D:\\test\\".concat(File.separator).concat("back.png");
//        if (!createBackground(60, 20, new File(back), "png")) {
//            LoggerUtils.error(CommonLogger.ERROR, "生成白色背景失败");
//        }
//
//        String f1 = "D:\\test\\132.png";
//        String f2 = "D:\\test\\132.png";
//        String f3 = "D:\\test\\132.png";
//        String f4 = "D:\\test\\132-join.jpg";
//        append(back, f1, PositionType.TOP_JOIN_HEAD1);
//        append(back, f2, PositionType.TOP_JOIN_HEAD2);
//        append(back, f3, PositionType.TOP_JOIN_HEAD3);
    }
//
//    /**
//     * 默认字体
//     *
//     * @return
//     */
//    public static Font getDefalutFont() {
//        /*InputStream resourceAsStream = null;
//        try {
//            if (DEFALUT_FONT != null) {
//                return DEFALUT_FONT;
//            }
//
//            resourceAsStream = ShareImageUtils.class.getResourceAsStream("/static/PingFangRegular.ttf");
//            DEFALUT_FONT = Font.createFont(Font.TRUETYPE_FONT, resourceAsStream);
//            LoggerUtils.info(CommonLogger.BIZ, "load font PingFangRegular.ttf...");
//            return DEFALUT_FONT;
//        } catch (Exception e) {
//            System.out.println("load font PingFangRegular.ttf error." + e.getMessage());
//            LoggerUtils.error(CommonLogger.ERROR, e, "加载字体失败");
//        } finally {
//            IOUtils.closeQuietly(resourceAsStream);
//        }*/
//
//        DEFALUT_FONT = new Font("宋体", Font.PLAIN, 14);
//        return DEFALUT_FONT;
//    }

    /**
     * @param srcFile  源文件地址
     * @param destFile 修改后文件地址
     * @param width    修改后长度
     * @param height   修改后宽度
     * @return: void
     * @auther: sgy
     * @date: 2018/5/31 19:55
     */
//    public static void resize(String srcFile, String destFile, int width, int height) {
//
//        try {
//            Thumbnails.of(srcFile).size(width, height).toFile(destFile);
//
//        } catch (Exception e) {
//            throw new IllegalStateException(e);
//        }
//
//    }

    /**
     * @param srcFile 源文件地址
     * @param width   修改后长度
     * @param height  修改后宽度
     * @return: void
     * @auther: sgy
     * @date: 2018/5/31 19:55
     */
//    public static void resize(String srcFile, int width, int height) {
//
//        try {
//            Thumbnails.of(srcFile).size(width, height).toFiles(Rename.NO_CHANGE);
//
//        } catch (Exception e) {
//            throw new IllegalStateException(e);
//        }
//
//    }

    /**
     * @param srcFile   图片底板
     * @param imageFile 需要拼接的图片
     * @param position  坐标
     * @return: void
     * @auther: sgy
     * @date: 2018/6/1 10:56
     */
//    public static void append(String srcFile, String imageFile, Position position) {
//
//        try {
//            Thumbnails.of(srcFile).// 原图片
//                    //size(179 * 2, 144 * 2). // 缩放大小
//                    // outputFormat("jpg").
//                            scale(1).
//                    watermark(position, ImageIO.read(new File(imageFile)), 1f).
//                    toFile(srcFile);// 图片保存目录
//
//        } catch (Exception e) {
//            throw new IllegalStateException(e);
//        }
//    }


    /**
     * @param srcFile  图片底板
     * @param position 坐标
     * @return: void
     * @auther: sgy
     * @date: 2018/6/1 10:56
     */
//    public static void appendUseStream(String srcFile, InputStream in, Position position) {
//
//        try {
//            Thumbnails.of(srcFile).// 原图片
//                    //size(179 * 2, 144 * 2). // 缩放大小
//                    // outputFormat("jpg").
//                            scale(1).
//                    watermark(position, ImageIO.read(in), 1f).
//                    toFile(srcFile);// 图片保存目录
//
//        } catch (Exception e) {
//            throw new IllegalStateException(e);
//        }
//    }

    /**
     * @param srcFile 图片底板路径
     * @param content 文本内容
     * @param font    文本字体
     * @param color   颜色
     * @param x       坐标
     * @param y       坐标
     * @return: void
     * @auther: sgy
     * @date: 2018/6/1 15:47
     */
//    public static void appendText(String srcFile, String content, Font font, Color color, int x, int y) {
//        ImageElement root = new ImageElement();
//        root.setId("root");
//        root.setFile(new File(srcFile));
//
//        TextElement text = new TextElement();
//        text.setId("text");
//        text.setX(x);
//        text.setY(y);
//        text.setText(content);
//        //设置字体颜色为黑色
//        text.setColor(color);
//        text.setFont(font);
//        root.addElement(text);
//
//        Document doc = Document.createDocument(root);
//        com.yhdx.tool.dfs.image.util.ImageUtils.draw(new File(srcFile), doc);
//
//    }


    /**
     * 图片添加文字水印
     *
     * @param souchFilePath    源图片路径
     * @param targetFilePath   生成后的目标图片路径
     * @param markContent      要加的文字
     * @param markContentColor 文字颜色
     * @return
     */
//    public static String createMark(String souchFilePath, String targetFilePath, String markContent, Color markContentColor, Font font, Float fontSize, int w, int h) {
//
//        //构建要处理的源图片
//        ImageIcon imageIcon = new ImageIcon(souchFilePath);
//
//        //获取要处理的图片
//        Image image = imageIcon.getImage();
//
//        //Image可以获得图片的属性信息
//        int width = image.getWidth(null);
//        int height = image.getHeight(null);
//
//        //为画出与源图片的相同大小的图片(可以自己定义)
//        BufferedImage bImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//
//        //构建2D画笔
//        Graphics2D g = bImage.createGraphics();
//
//        //设置2D画笔的画出的文字颜色
//        g.setColor(markContentColor);
//
//        //设置2D画笔的画出的文字背景色
//        g.setBackground(Color.WHITE);
//
//        //画出图片
//        g.drawImage(image, 0, 0, null);
//
//        //===============对要显示的文字进行处理 start ===============
//        AttributedString ats = new AttributedString(markContent);
//        //Font font = new Font(fontType, Font.PLAIN, fontSize);
//        g.setFont(font);
//
//        //消除java.awt.Font字体的锯齿
//        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//
//        //消除java.awt.Font字体的锯齿
//        font = g.getFont().deriveFont(fontSize);
//        ats.addAttribute(TextAttribute.FONT, font, 0, markContent.length());
//        AttributedCharacterIterator iter = ats.getIterator();
//
//        //添加水印的文字和设置水印文字出现的内容 ----位置
//        g.drawString(iter, w, h);
//        //===============对要显示的文字进行处理 end ===============
//
//        // 画笔结束
//        g.dispose();
//
//        try {
//
//            // 输出 文件 到指定的路径
////            FileOutputStream out = new FileOutputStream(targetFilePath);
////            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
////            JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(bImage);
////            param.setQuality(qualNum, true);
////            encoder.encode(bImage, param);
////            out.close();
//
//            ImageIO.write(bImage, "jpg", new File(targetFilePath));
//            return targetFilePath;
//        } catch (Exception e) {
//            LoggerUtils.warn(CommonLogger.WARN, e, "图片增加文字水印失败：", e.getMessage());
//        }
//        return null;
//    }


    /**
     * @param width
     * @param height
     * @param dest
     * @return: java.lang.String
     * @auther: sgy
     * @date: 2018/6/1 11:29
     */
//    public static Boolean createBackground(int width, int height, File dest, String imageFormat) {
//        BufferedImage bufferedImage = new BufferedImage(
//                width,
//                height,
//                BufferedImage.TYPE_INT_RGB
//
//        );
//
//        Graphics2D graphics2D = (Graphics2D) bufferedImage.getGraphics();
//
//        //高清设置
//        RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        renderingHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
//        graphics2D.setRenderingHints(renderingHints);
//        //高清设置
//
//        graphics2D.setBackground(Color.WHITE);
//        graphics2D.clearRect(0, 0, width, height);
//        graphics2D.setPaint(Color.RED);
//        FontRenderContext fontRenderContext = graphics2D.getFontRenderContext();
//        //Rectangle2D stringBounds = font.getStringBounds(content, fontRenderContext);
//        //  double x = (width - stringBounds.getWidth()) / 2;
//        /// double y = (height - stringBounds.getHeight()) / 2;
//        //  double ascent = -stringBounds.getY();
//        //  double baseY = y + ascent;
//        // graphics2D.drawString(content, (int)x, (int)baseY);
//
//        // 1.将图片写到实体图片里
//
//        try {
//            ImageIO.write(bufferedImage, imageFormat, dest);
//            return Boolean.TRUE;
//        } catch (Exception e) {
//            return Boolean.FALSE;
//        }
//    }

    /**
     * @param path 生成目录路径
     * @return: java.lang.String
     * @auther: sgy
     * @date: 2018/6/1 11:24
     */
//    public static Boolean mkdir(String path) {
//
//        File dest = new File(path);
//        dest.setWritable(true, false);
//        Boolean result = dest.mkdirs();
//        if (!result) {
//            return Boolean.FALSE;
//        }
//        return Boolean.TRUE;
//    }

    /**
     * 通过网络获取图片
     *
     * @param url
     * @return
     */
//    public static Boolean getUrlByBufferedImage(String url, File dest) {
//        FileOutputStream outStream = null;
//        try {
//            URL urlObj = new URL(url);
//            HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
//            // 连接超时
//            conn.setDoInput(true);
//            conn.setDoOutput(true);
//            conn.setConnectTimeout(25000);
//            // 读取超时 --服务器响应比较慢,增大时间
//            conn.setReadTimeout(25000);
//            conn.setRequestMethod("GET");
//            conn.addRequestProperty("Accept-Language", "zh-cn");
//            conn.addRequestProperty("Content-type", "image/jpeg");
//            conn.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0; .NET CLR 2.0.50727)");
//            conn.connect();
//
//            byte[] data = readInputStream(conn.getInputStream());
//            outStream = new FileOutputStream(dest);
//            outStream.write(data);
//            outStream.close();
//            conn.disconnect();
//            return Boolean.TRUE;
//        } catch (Exception e) {
//            LoggerUtils.warn(CommonLogger.WARN, e, "获取远程文件失败：", e.getMessage());
//        } finally {
//            IOUtils.closeQuietly(outStream);
//        }
//        return Boolean.FALSE;
//    }

    /**
     * 通过网络获取图片
     *
     * @param url
     * @return
     */
//    public static BufferedImage getUrlByBufferedImage(String url) {
//        int count = 0;
//        BufferedImage bufImg = null;
//        do {
//            try {
//
//                URL urlObj = new URL(url);
//                HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
//                // 连接超时
//                conn.setDoInput(true);
//                conn.setDoOutput(true);
//                conn.setConnectTimeout(25000);
//                // 读取超时 --服务器响应比较慢,增大时间
//                conn.setReadTimeout(25000);
//                conn.setRequestMethod("GET");
//                conn.addRequestProperty("Accept-Language", "zh-cn");
//                conn.addRequestProperty("Content-type", "image/jpeg");
//                conn.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0; .NET CLR 2.0.50727)");
//                conn.connect();
//                bufImg = ImageIO.read(conn.getInputStream());
//                conn.disconnect();
//                count = 3;
//            } catch (Exception e) {
//                count++;
//                LoggerUtils.warn(CommonLogger.WARN, e, "获取远程文件失败：", e.getMessage(), " try...count = ", count, " url=", url);
//            }
//        } while (count < 3);
//        return bufImg;
//    }

    /**
     * 通过网络获取图片
     *
     * @param url
     * @return
     */
//    public static InputStream getInputStreamByUrl(String url) {
//        int count = 0;
//        InputStream inputStream = null;
//        do {
//            try {
//
//                URL urlObj = new URL(url);
//                HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
//                // 连接超时
//                conn.setDoInput(true);
//                conn.setDoOutput(true);
//                conn.setConnectTimeout(25000);
//                // 读取超时 --服务器响应比较慢,增大时间
//                conn.setReadTimeout(25000);
//                conn.setRequestMethod("GET");
//                conn.addRequestProperty("Accept-Language", "zh-cn");
//                conn.addRequestProperty("Content-type", "image/jpeg");
//                conn.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0; .NET CLR 2.0.50727)");
//                conn.connect();
//                inputStream = conn.getInputStream();
//                conn.disconnect();
//                count = 3;
//            } catch (Exception e) {
//                count++;
//                LoggerUtils.warn(CommonLogger.WARN, e, "获取远程文件失败：", e.getMessage(), " try...count = ", count, " url=", url);
//            }
//        } while (count < 3);
//        return inputStream;
//    }

//    public static byte[] readInputStream(InputStream inStream) throws Exception {
//
//        ByteArrayOutputStream outStream = null;
//        try {
//            outStream = new ByteArrayOutputStream();
//            //创建一个Buffer字符串
//            byte[] buffer = new byte[1024];
//            //每次读取的字符串长度，如果为-1，代表全部读取完毕
//            int len = 0;
//            //使用一个输入流从buffer里把数据读取出来
//            while ((len = inStream.read(buffer)) != -1) {
//                //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
//                outStream.write(buffer, 0, len);
//            }
//            //关闭输入流
//            inStream.close();
//            //把outStream里的数据写入内存
//            return outStream.toByteArray();
//        } catch (Exception e) {
//            LoggerUtils.warn(CommonLogger.ERROR, e, "readInputStream失败：", e.getMessage());
//        } finally {
//            IOUtils.closeQuietly(outStream);
//            IOUtils.closeQuietly(inStream);
//        }
//        return null;
//    }

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
//    public static Boolean toRoundedCornerWithChange(BufferedImage bi1, File result, String type, int cornerRadius, int width, int height) {
//        try {
//            // 根据需要是否使用 BufferedImage.TYPE_INT_ARGB
//            BufferedImage image = getRundedCornerBufferedImage(bi1, cornerRadius, width, height);
//            ImageIO.write(image, type, result);
//            return Boolean.TRUE;
//        } catch (Exception e) {
//            LoggerUtils.warn(CommonLogger.WARN, e, "生成圆角头像失败：", e.getMessage());
//        }
//
//        return Boolean.FALSE;
//    }

    /**
     * 图片圆角处理，背景透明化   原图片和处理后图片尺寸变化
     *
     * @param bi1
     * @param type         图片格式
     * @param cornerRadius 720为圆角
     * @param width        处理后图片的width
     * @param height       处理后图片的height
     */
//    public static byte[] roundedCorner2ByteArray(BufferedImage bi1, String type, int cornerRadius, int width, int height) {
//        try {
//            BufferedImage image = getRundedCornerBufferedImage(bi1, cornerRadius, width, height);
//            return bufferedImage2ByteArray(image, type);
//        } catch (Exception e) {
//            LoggerUtils.warn(CommonLogger.WARN, e, "生成圆角头像失败：", e.getMessage());
//        }
//        return null;
//    }

//    /**
//     * 图片圆角处理，背景透明化   原图片和处理后图片尺寸变化
//     *
//     * @param bi1          图片
//     * @param cornerRadius 720为圆角
//     * @param width
//     * @param height
//     * @return
//     */
//    public static BufferedImage getRundedCornerBufferedImage(BufferedImage bi1, int cornerRadius, int width, int height) {
//        // 根据需要是否使用 BufferedImage.TYPE_INT_ARGB
//        BufferedImage image = new BufferedImage(width, height,
//                BufferedImage.TYPE_INT_ARGB);
//
//        Ellipse2D.Double shape = new Ellipse2D.Double(0, 0, width, height);
//
//        Graphics2D g2 = image.createGraphics();
//
//        //高清设置
//        RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        renderingHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
//        g2.setRenderingHints(renderingHints);
//        //高清设置
//
//        image = g2.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
//        g2 = image.createGraphics();
//        g2.setComposite(AlphaComposite.Clear);
//        g2.fill(new Rectangle(image.getWidth(), image.getHeight()));
//        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC, 1.0f));
//        g2.setClip(shape);
//
//        // 使用 setRenderingHint 设置抗锯齿
//        g2 = image.createGraphics();
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        g2.fillRoundRect(0, 0, width, height, cornerRadius, cornerRadius);
//        g2.setComposite(AlphaComposite.SrcIn);
//        g2.drawImage(bi1, 0, 0, width, height, null);
//        g2.dispose();
//        return image;
//    }

    //删除文件夹
//    public static void delFolder(String folderPath) {
//        try {
//            delAllFile(folderPath);
//            File folder = new File(folderPath);
//            folder.delete();
//        } catch (Exception e) {
//            LoggerUtils.warn(CommonLogger.WARN, e, "删除文件夹或文件失败：", e.getMessage());
//        }
//
//    }
//
//    public static void delAllFile(String path) {
//        File file = new File(path);
//        if (!file.exists()) {
//            return;
//        }
//        if (!file.isDirectory()) {
//            return;
//        }
//        String[] tempList = file.list();
//        File temp = null;
//        for (int i = 0; i < tempList.length; i++) {
//            if (path.endsWith(File.separator)) {
//                temp = new File(path + tempList[i]);
//            } else {
//                temp = new File(path + File.separator + tempList[i]);
//            }
//
//            if (temp.isFile()) {
//                temp.delete();
//            }
//
//            if (temp.isDirectory()) {
//                delAllFile(path + "/" + tempList[i]);//先删除文件夹里面的文件
//                delFolder(path + "/" + tempList[i]);//再删除空文件夹
//            }
//
//        }
//
//    }
//
//    public static void appendByURL(URL srcURL, URL watermarkFile, String newFile, Position position) {
//        int count = 0;
//        do {
//            try {
//                Thumbnails.of(srcURL).// 原图片
//                        size(85, 85).//
//                        // scale(1).//
//                                watermark(position, ImageIO.read(watermarkFile), 1f).//
//                        toFile(newFile);// 图片保存目录
//                count = 3;
//            } catch (Exception e) {
//                count++;
//                LoggerUtils.error(CommonLogger.SCHEDULE, e, "图片获取失败 try...count = ", count);
//            }
//        } while (count < 3);
//    }
//
//    public static BufferedImage watermark(BufferedImage bufferedImage, InputStream watermarkFile, Position position) {
//        int count = 0;
//        do {
//            BufferedImage watermarkBufferedImage = null;
//            try {
//                watermarkBufferedImage = ImageIO.read(watermarkFile);
//                BufferedImage newImage = Thumbnails.of(bufferedImage).scale(1).watermark(position, watermarkBufferedImage, 1f).asBufferedImage();
//                count = 3;
//                return newImage;
//            } catch (Exception e) {
//                count++;
//                LoggerUtils.error(CommonLogger.ERROR, e, "图片获取失败 try...count = ", count);
//            } finally {
//                watermarkBufferedImage = null;
//            }
//        } while (count < 3);
//        return bufferedImage;
//    }

//    public static BufferedImage watermark(BufferedImage bufferedImage, BufferedImage watermarkBufferedImage, Position position) {
//        int count = 0;
//        do {
//            try {
//                BufferedImage newImage = Thumbnails.of(bufferedImage).scale(1).watermark(position, watermarkBufferedImage, 1f).//
//                        asBufferedImage();
//                count = 3;
//                return newImage;
//            } catch (Exception e) {
//                count++;
//                LoggerUtils.error(CommonLogger.ERROR, e, "图片获取失败 try...count = ", count);
//            }
//        } while (count < 3);
//        return bufferedImage;
//    }
//
//    public static void appendByFile(String srcFile, URL watermarkFile, Position position) {
//        try {
//            Thumbnails.of(srcFile).// 原图片
//                    scale(1).//
//                    watermark(position, ImageIO.read(watermarkFile), 1f).//
//                    toFile(srcFile);// 图片保存目录
//        } catch (Exception e) {
//            throw new IllegalStateException(e);
//        }
//    }
//
//    /**
//     * 图片转byte[]
//     *
//     * @param image
//     * @param type
//     * @return
//     */
//    public static byte[] bufferedImage2ByteArray(BufferedImage image, String type) {
//        ByteArrayOutputStream out = null;
//        try {
//            out = new ByteArrayOutputStream();
//            ImageIO.write(image, type, out);
//            return out.toByteArray();
//        } catch (Exception e) {
//            LoggerUtils.error(CommonLogger.SCHEDULE, e);
//        } finally {
//            IOUtils.closeQuietly(out);
//        }
//        return null;
//    }
//
//    /**
//     * 图片剪切(图片比例5:4)：
//     * 1、图片大于给定尺寸时限进行等比缩略，然后再进行剪切；
//     * 2、图片小于给定尺寸时，根据比例进行计算宽或高，直接进行剪切。
//     *
//     * @param url       图片地址
//     * @param newWidth  0到x像素(300)
//     * @param newHeight 0到y像素(240)
//     * @return
//     */
//    public static BufferedImage getBufferedImageRegion(String url, int newWidth, int newHeight) {
//        try {
//
//            if (StringUtils.isEmpty(url)) {
//                return null;
//            }
//
//            //BufferedImage bufferedImage = Thumbnails.of(new URL(url)).width(1).sourceRegion(0, 0, x, y).asBufferedImage();
//            //BufferedImage bufferedImage = Thumbnails.of(Thumbnails.of(new URL(url)).height(y).keepAspectRatio(true).asBufferedImage()).scale(1).sourceRegion(0, 0, x, y).asBufferedImage();
//
//            BufferedImage sourceImage = getUrlByBufferedImage(url);
//            if (sourceImage == null) {
//                return null;
//            }
//
//            BufferedImage newImage = null;
//            int sourceWidth = sourceImage.getWidth();
//            int sourceHeight = sourceImage.getHeight();
//
//            //尺寸相同
//            if (sourceWidth == newWidth && sourceHeight == newHeight) {
//                return sourceImage;
//            }
//
//            //图片宽高比
//            double scale = new BigDecimal(newWidth).divide(new BigDecimal(newHeight), 10, RoundingMode.HALF_DOWN).doubleValue();
//
//            //以高度来缩
//            if (sourceWidth / scale >= sourceHeight) {
//
//                //源图片高小于240
//                if (sourceHeight < newHeight) {
//
//                    //计算该比例下的宽度值
//                    BigDecimal tempNewWidth = new BigDecimal(sourceHeight).multiply(new BigDecimal(scale)).setScale(10, RoundingMode.DOWN);
//
//                    //居中剪裁，起始y值
//                    int i0Width = (sourceWidth - tempNewWidth.intValue()) / 2;
//                    newImage = Thumbnails.of(sourceImage).scale(1).sourceRegion(i0Width, 0, tempNewWidth.intValue(), sourceHeight).asBufferedImage();
//                } else {
//
//                    BufferedImage newHeightBufferedImage = Thumbnails.of(sourceImage).height(newHeight).keepAspectRatio(true).asBufferedImage();
//                    int i0Width = (newHeightBufferedImage.getWidth() - newWidth) / 2;
//
//                    newImage = Thumbnails.of(newHeightBufferedImage).scale(1).sourceRegion(i0Width, 0, newWidth, newHeight).asBufferedImage();
//                }
//            }
//
//            //以宽度来缩
//            else/* if (sourceWidth / scale < sourceHeight) */ {
//                if (sourceWidth < newWidth) {
//                    BigDecimal tempNewHeight = new BigDecimal(sourceWidth).divide(new BigDecimal(scale), 10, RoundingMode.DOWN);
//
//                    int i1Height = (sourceHeight - tempNewHeight.intValue()) / 2;
//
//                    newImage = Thumbnails.of(sourceImage).scale(1).sourceRegion(0, i1Height, sourceWidth, tempNewHeight.intValue()).asBufferedImage();
//                } else {
//
//                    BufferedImage newWidthBufferedImage = Thumbnails.of(sourceImage).width(newWidth).keepAspectRatio(true).asBufferedImage();
//                    int i1Height = (newWidthBufferedImage.getHeight() - newHeight) / 2;
//
//                    newImage = Thumbnails.of(newWidthBufferedImage).scale(1).sourceRegion(0, i1Height, newWidth, newHeight).asBufferedImage();
//                }
//            }
//
//            return newImage;
//        } catch (Exception e) {
//            LoggerUtils.error(CommonLogger.SCHEDULE, e);
//        }
//        return null;
//    }

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
//    public static byte[] imageRegion(String url, int newWidth, int newHeight) {
//        try {
//
//            BufferedImage newImage = getBufferedImageRegion(url, newWidth, newHeight);
//            if (newImage == null) {
//                return null;
//            }
//
//            String fileSuffix = "png";
//            if (url.lastIndexOf(".") > 0) {
//                int temp = url.lastIndexOf(".") + 1;
//                fileSuffix = url.substring(temp);
//            }
//            return bufferedImage2ByteArray(newImage, fileSuffix);
//        } catch (Exception e) {
//            LoggerUtils.error(CommonLogger.SCHEDULE, e);
//        }
//        return null;
//    }

    /**
     * 转换BufferedImage 数据为byte数组
     *
     * @param bImage Image对象
     * @param format image格式字符串.如"gif","png"
     * @return byte数组
     */
//    public static byte[] imageToBytes(BufferedImage bImage, String format) {
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        try {
//            ImageIO.write(bImage, format, out);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return out.toByteArray();
//    }

    /**
     * 生成朋友圈分享图片(返回图片)
     *
     * @param partnerNicename     团长昵称
     * @param avatarImageUrl      团长微信头像
     * @param coverImageUrl       商品图片
     * @param merchandiseTitle    商品标题
     * @param price               商品价格
     * @param backgroundImagePath 背景图
     * @param qrCodePath          小程序码
     * @param newImageFile        图片保存路径（为空时返回BufferedImage）
     * @return BufferedImage
     */
    public static BufferedImage getShareQrCodeImage(String partnerNicename, String avatarImageUrl,
        String coverImageUrl, String merchandiseTitle, String price, String backgroundImagePath, String qrCodePath, File newImageFile) {

        InputStream priceStyleInputStream = null;
        InputStream qrCodeInputStream = null;
        InputStream rootBackbroundImageInputStream = null;

        BufferedImage merchandiseBufferedImage = null;
        BufferedImage partnerHeadImage = null;
        try {

            //背景图（640 * 1198）
            rootBackbroundImageInputStream = ShareImageUtils.class.getResourceAsStream(backgroundImagePath);

            //背景图根元素
            ImageElement rootElement = new ImageElement();
            rootElement.setId("backgroundImage");
            rootElement.setImageStream(rootBackbroundImageInputStream);
            //rootElement.setBufferedImage(ImageIO.read(new File(backgroundImagePath)));

            //商品图片（750 * 390） 改为 640 * 340
            ImageElement merchandiseImageElement = new ImageElement();
            merchandiseImageElement.setId("merchandiseImage");
            merchandiseBufferedImage = getBufferedImageRegion(coverImageUrl, 640, 340);
            if (null == merchandiseBufferedImage) {
                throw new Exception();
            }
            merchandiseImageElement.setBufferedImage(merchandiseBufferedImage);
            merchandiseImageElement.setWidth(640);
            merchandiseImageElement.setHeight(340);
            merchandiseImageElement.setBorder(0);
            merchandiseImageElement.setY(1);

            //fontStyleInputStream = ShareImageUtils.class.getResourceAsStream(fontPath);

            //商品名称
            TextElement merchandiseRemarkElement = new TextElement();
            merchandiseRemarkElement.setId("merchandiseRemark");
            merchandiseRemarkElement.setText(merchandiseTitle);
            merchandiseRemarkElement.setColor(new Color(0, 0, 0));
            merchandiseRemarkElement.setY(390);
            merchandiseRemarkElement.setWidth(312);
            merchandiseRemarkElement.setHeight(20);

//            //计算文字在图片中的位置
//            //每个文字占用的坐标数
//            int textOccupyX = 30;
//            //图片中心点
//            int imageCenterpoint = 375;
//            int merchandiseTitlePosition = StringUtils.length(merchandiseTitle);
//            //计算位置
//            merchandiseTitlePosition = merchandiseTitlePosition * textOccupyX;
//            merchandiseTitlePosition = imageCenterpoint - merchandiseTitlePosition;

            merchandiseRemarkElement.setX(0);
            merchandiseRemarkElement.setFont(getDefalutFont().deriveFont(Font.BOLD, 30));
            //merchandiseRemarkElement.setFont(Font.createFont(Font.PLAIN, fontStyleInputStream).deriveFont(Font.PLAIN, 30f));

            //商品价格
            TextElement merchandisePriceElement = new TextElement();
            //priceStyleInputStream = CollageWeAppUtils.class.getResourceAsStream(fontPath);

            String priceText = StringUtils.join("十荟价：", price, "元");
            merchandisePriceElement.setId("merchandisePrice");
            merchandisePriceElement.setText(priceText);
            merchandisePriceElement.setColor(new Color(254, 0, 0));
            merchandisePriceElement.setX(0);//为0时自动居中
            merchandisePriceElement.setY(450);
            merchandisePriceElement.setHeight(130);
            merchandisePriceElement.setWidth(50);
            merchandisePriceElement.setFont(getDefalutFont().deriveFont(Font.BOLD, 30));
            //merchandisePriceElement.setFont(Font.createFont(Font.PLAIN, priceStyleInputStream).deriveFont(Font.BOLD, 52));

            //团长头像46 * 46（头像：x 352,y 550）
            ImageElement avatarImageElement = new ImageElement();
            //InputStream avatarInputStream = HttpUtils.getUrlInputStream(avatarImageUrl);
            partnerHeadImage = getRundedCornerBufferedImage(getUrlByBufferedImage(avatarImageUrl), 720, 64, 64);
            if (null == partnerHeadImage) {
                throw new Exception();
            }
            avatarImageElement.setId("avatarImage");
            avatarImageElement.setBufferedImage(partnerHeadImage);
            avatarImageElement.setWidth(64);
            avatarImageElement.setHeight(64);
            avatarImageElement.setBorder(0);
            avatarImageElement.setX(288);
            avatarImageElement.setY(532);

            //团长呢称
            TextElement partnerNicenameElement = new TextElement();
            partnerNicenameElement.setId("partnerNicename");
            partnerNicenameElement.setText(partnerNicename);
            partnerNicenameElement.setColor(new Color(102, 102, 102));
            partnerNicenameElement.setX(0);//为0时自动居中
            partnerNicenameElement.setY(626);
            partnerNicenameElement.setFont(getDefalutFont().deriveFont(Font.BOLD, 22));

            //小程序码
            ImageElement shareQrCodeImageElement = new ImageElement();
            shareQrCodeImageElement.setId("qrCode");
//            qrCodeInputStream = HttpUtils.getUrlInputStream("https://imgcdn-test.youhaodongxi.com//qr/collage/shareImage/qrcode.png");
            qrCodeInputStream = HttpUtils.getUrlInputStream(qrCodePath);
            if (null == qrCodeInputStream) {
                throw new Exception();
            }
            shareQrCodeImageElement.setImageStream(qrCodeInputStream);
            shareQrCodeImageElement.setX(205);
            shareQrCodeImageElement.setY(740);
            shareQrCodeImageElement.setWidth(220);
            shareQrCodeImageElement.setHeight(220);

            rootElement.addElement(merchandiseImageElement);
            rootElement.addElement(merchandiseRemarkElement);
            rootElement.addElement(merchandisePriceElement);
            rootElement.addElement(avatarImageElement);
            rootElement.addElement(partnerNicenameElement);
            rootElement.addElement(shareQrCodeImageElement);
            Document document = Document.createDocument(rootElement);
            if (newImageFile == null) {
                return ImageUtils.draw(document);
            } else {
                ImageUtils.draw(newImageFile, document);
                return null;
            }
        } catch (Exception e) {
            System.out.println("生成图片失败");
            throw new NullPointerException();
        } finally {
            //close(merchandiseImageInputStream);
            close(priceStyleInputStream);
            close(qrCodeInputStream);
            close(rootBackbroundImageInputStream);

            merchandiseBufferedImage = null;
            partnerHeadImage = null;
        }
    }


    /**
     * 生成朋友圈分享图片V2(返回图片)
     *
     * @param coverImageUrl       商品图片
     * @param merchandiseTitle    商品标题
     * @param price               商品价格
     * @param originPrice         商品原价
     * @param backgroundImagePath 背景图
     * @param qrCodePath          小程序码
     * @return BufferedImage
     */
    public static BufferedImage getShareQrCodeImageV2(String coverImageUrl, String merchandiseTitle, String price, String originPrice, String backgroundImagePath, String qrCodePath) {
        InputStream priceStyleInputStream = null;
        InputStream qrCodeInputStream = null;
        InputStream rootBackbroundImageInputStream = null;

        BufferedImage merchandiseBufferedImage = null;
        BufferedImage qrCodeImage = null;
        BufferedImage bufferedImage = null;
        try {

            //背景图
            rootBackbroundImageInputStream = ShareImageUtils.class.getResourceAsStream(backgroundImagePath);

            //背景图根元素
            ImageElement rootElement = new ImageElement();
            rootElement.setId("backgroundImage");
            //测试时候使用此种方式加载
            if (rootBackbroundImageInputStream == null) {
                rootElement.setFile(new File(backgroundImagePath));
            } else {
                rootElement.setImageStream(rootBackbroundImageInputStream);
            }

            //商品图片
            ImageElement merchandiseImageElement = new ImageElement();
            merchandiseImageElement.setId("merchandiseImage");
            merchandiseBufferedImage = getBufferedImageRegion(coverImageUrl, 350, 350);
            if (null == merchandiseBufferedImage) {
                throw new Exception();
            }
            merchandiseImageElement.setBufferedImage(merchandiseBufferedImage);
            merchandiseImageElement.setWidth(350);
            merchandiseImageElement.setHeight(350);
            merchandiseImageElement.setBorder(0);
            merchandiseImageElement.setX(76);
            merchandiseImageElement.setY(159);

            //商品名称
            TextElement merchandiseRemarkElement = new TextElement();
            merchandiseRemarkElement.setId("merchandiseRemark");
            merchandiseRemarkElement.setText(merchandiseTitle);
            merchandiseRemarkElement.setColor(new Color(51, 51, 51));
            merchandiseRemarkElement.setY(550);
            //merchandiseRemarkElement.setWidth(312);
            merchandiseRemarkElement.setWidth(312);
            merchandiseRemarkElement.setHeight(20);
            merchandiseRemarkElement.setX(0);
            merchandiseRemarkElement.setFont(getDefalutFont().deriveFont(Font.BOLD, 24));

//            //计算文字在图片中的位置
//            //每个文字占用的坐标数
//            int textOccupyX = 30;
//            //图片中心点
//            int imageCenterpoint = 375;
//            int merchandiseTitlePosition = StringUtils.length(merchandiseTitle);
//            //计算位置
//            merchandiseTitlePosition = merchandiseTitlePosition * textOccupyX;
//            merchandiseTitlePosition = imageCenterpoint - merchandiseTitlePosition;


            //merchandiseRemarkElement.setFont(Font.createFont(Font.PLAIN, fontStyleInputStream).deriveFont(Font.PLAIN, 30f));


            //===============================商品现价===========================================
            //商品价格人民币符号部分
            TextElement moneySymbolElement = new TextElement();
            moneySymbolElement.setId("priceSymbol");
            moneySymbolElement.setText("¥");
            moneySymbolElement.setColor(new Color(230, 31, 10));
            //moneySymbolElement.setX(178);
            //moneySymbolElement.setX((750-2)/2);
            moneySymbolElement.setY(598);
            moneySymbolElement.setFont(getDefalutFont().deriveFont(Font.PLAIN, 24));

            //商品价格部分
            TextElement merchandisePriceElement = new TextElement();
            merchandisePriceElement.setId("price");
            merchandisePriceElement.setText(price);
            merchandisePriceElement.setColor(new Color(230, 31, 10));
            //merchandisePriceElement.setX(moneySymbolElement.getX()+4);
            merchandisePriceElement.setY(600);
            merchandisePriceElement.setFont(getDefalutFont().deriveFont(Font.BOLD, 40));

            //商品价格小数部分
//            TextElement merchandisePriceDecimalElement = new TextElement();
//            merchandisePriceDecimalElement.setId("price3");
//            merchandisePriceDecimalElement.setText(StringUtils.join(".", prices[1]));
//            merchandisePriceDecimalElement.setColor(new Color(255, 255, 255));
//            merchandisePriceDecimalElement.setX(26 + merchandisePriceIntElement.getStringBounds().width);
//            merchandisePriceDecimalElement.setY(363);
//            merchandisePriceDecimalElement.setFont(getDefalutFont().deriveFont(Font.BOLD, 26));
//            merchandiseOriginPriceWidth = merchandiseOriginPriceWidth + merchandisePriceIntElement.getStringBounds().width + merchandisePriceDecimalElement.getStringBounds().width;

            //===============================商品原价===========================================
            //商品原价
            TextElement merchandiseOriginPriceElement = new TextElement();
            merchandiseOriginPriceElement.setId("originPrice");
            merchandiseOriginPriceElement.setText(StringUtils.join("¥", originPrice));
            merchandiseOriginPriceElement.setColor(new Color(102, 102, 102));
            //merchandiseOriginPriceElement.setX(merchandisePriceElement.getX()+merchandisePriceElement.getStringBounds().width+2);
            merchandiseOriginPriceElement.setY(600);
            merchandiseOriginPriceElement.setFont(getDefalutFont().deriveFont(Font.PLAIN, 14));
            //删除线
            merchandiseOriginPriceElement.setDrawLine(true);

            merchandiseOriginPriceElement.setY1(merchandiseOriginPriceElement.getY() - 4);
            merchandiseOriginPriceElement.setY2(merchandiseOriginPriceElement.getY() - 4);

            int tatalWidth=moneySymbolElement.getStringBounds().width+merchandisePriceElement.getStringBounds().width+4+merchandiseOriginPriceElement.getStringBounds().width;

            moneySymbolElement.setX((rootElement.getImage().getWidth()-tatalWidth)/2);
            merchandisePriceElement.setX(moneySymbolElement.getX()+1+moneySymbolElement.getStringBounds().width);
            merchandiseOriginPriceElement.setX(merchandisePriceElement.getX()+4+merchandisePriceElement.getStringBounds().width);
            merchandiseOriginPriceElement.setX1(merchandisePriceElement.getX()+4+merchandisePriceElement.getStringBounds().width);

            //小程序码
            ImageElement shareQrCodeImageElement = new ImageElement();
            shareQrCodeImageElement.setId("qrCode");
            BufferedImage urlByBufferedImage = getUrlByBufferedImage(qrCodePath);

            if (null == urlByBufferedImage) {
                throw new Exception();
            }

            qrCodeImage = getRundedCornerBufferedImage(urlByBufferedImage, 720, urlByBufferedImage.getWidth(), urlByBufferedImage.getHeight());

//            URL url=new URL(qrCodePath);
//            BufferedImage bufferedImage1 = Thumbnails.of(url).scale(0.37).outputFormat("PNG").asBufferedImage();
//            System.out.println(bufferedImage1.getWidth());
//            qrCodeImage = ShareImageUtils.getRundedCornerBufferedImage(bufferedImage1, 720, bufferedImage1.getWidth(), bufferedImage1.getHeight());


            shareQrCodeImageElement.setBufferedImage(qrCodeImage);
            shareQrCodeImageElement.setX(75);
            shareQrCodeImageElement.setY(658);
            shareQrCodeImageElement.setWidth(95);
            shareQrCodeImageElement.setHeight(95);

            rootElement.addElement(merchandiseImageElement);
            rootElement.addElement(merchandiseRemarkElement);
            rootElement.addElement(moneySymbolElement);
            rootElement.addElement(merchandisePriceElement);
            rootElement.addElement(merchandiseOriginPriceElement);
            rootElement.addPngElement(shareQrCodeImageElement);
            //rootElement.addElement(merchandisePriceElement);
            //rootElement.addElement(shareQrCodeImageElement);
            Document document = Document.createDocument(rootElement);
            return ImageUtils.draw(document);

//            URL qrUrl=new URL(qrCodePath);
//            qrCodeImage = ShareImageUtils.getRundedCornerBufferedImage(Thumbnails.of(qrUrl).scale(1).outputFormat("PNG").asBufferedImage(), 720, 76, 76);
//            if (null == qrCodeImage) {
//                throw new BusinessException(CommonResultCode.ILLEGAL_REQ_PARAMETER);
//            }
//            bufferedImage=Thumbnails.of(ImageUtils.draw(document)).scale(1)
//                    .watermark(PositionType.QRCODE,qrCodeImage,1)
//                    .asBufferedImage();

//            return bufferedImage;

        } catch (Exception e) {
            throw new NullPointerException();
        } finally {
            //close(merchandiseImageInputStream);
            close(priceStyleInputStream);
            close(qrCodeInputStream);
            close(rootBackbroundImageInputStream);

            merchandiseBufferedImage = null;
            qrCodeImage = null;
            bufferedImage = null;

        }
    }

    /**
     * 生成群分享图片
     *
     * @param partnerNicename     团长昵称
     * @param avatarImageUrl      团长微信头像
     * @param coverImageUrl       商品图片
     * @param backgroundImagePath 背景图
     * @return
     */
    public static BufferedImage getShareImage(String partnerNicename, String avatarImageUrl, String coverImageUrl, String backgroundImagePath) {
        InputStream rootBackbroundImageInputStream = null;
        BufferedImage merchandiseBufferedImage = null;
        BufferedImage partnerHeadImage = null;
        try {

            //背景图（300 * 240）
            rootBackbroundImageInputStream = ShareImageUtils.class.getResourceAsStream(backgroundImagePath);

            //背景图根元素
            ImageElement rootElement = new ImageElement();
            rootElement.setId("backgroundImage");
            rootElement.setImageStream(rootBackbroundImageInputStream);
            //rootElement.setBufferedImage(ImageIO.read(new File(backgroundImagePath)));

            //商品图片300 * 188
            ImageElement merchandiseImageElement = new ImageElement();
            merchandiseImageElement.setId("merchandiseImage");
            merchandiseBufferedImage = getBufferedImageRegion(coverImageUrl, 500, 346);
            if (null != merchandiseBufferedImage) {
                merchandiseImageElement.setBufferedImage(merchandiseBufferedImage);
            }
            merchandiseImageElement.setWidth(500);
            merchandiseImageElement.setHeight(346);
            merchandiseImageElement.setBorder(0);
            merchandiseImageElement.setX(0);
            merchandiseImageElement.setY(1);

            //团长头像
            ImageElement avatarImageElement = new ImageElement();
            avatarImageElement.setId("avatarImage");
            partnerHeadImage = getRundedCornerBufferedImage(getUrlByBufferedImage(avatarImageUrl), 720, 46, 46);
            if (null != partnerHeadImage) {
                avatarImageElement.setBufferedImage(partnerHeadImage);
            }
            avatarImageElement.setWidth(46);
            avatarImageElement.setHeight(46);
            avatarImageElement.setBorder(0);
            avatarImageElement.setX(6);
            avatarImageElement.setY(351);

            //团长呢称
            TextElement partnerNicenameElement = new TextElement();
            partnerNicenameElement.setId("partnerNicename");
            partnerNicenameElement.setText(StringUtils.join(partnerNicename, "邀请你一起买"));
            partnerNicenameElement.setColor(new Color(0, 0, 0));//102,102,102
            partnerNicenameElement.setX(58);//为0时自动居中
            partnerNicenameElement.setY(380);
            partnerNicenameElement.setFont(getDefalutFont().deriveFont(Font.PLAIN, 24));

            rootElement.addElement(merchandiseImageElement);
            rootElement.addElement(avatarImageElement);
            rootElement.addElement(partnerNicenameElement);
            Document document = Document.createDocument(rootElement);
            return ImageUtils.draw(document);
        } catch (Exception e) {
            throw new NullPointerException();
        } finally {
            close(rootBackbroundImageInputStream);
            merchandiseBufferedImage = null;
            partnerHeadImage = null;
        }
    }

    /**
     * 生成商品详情分享图片
     *
     * @param coverImageUrl       商品图片
     * @param price               商品价格
     * @param originPrice         商品原价
     * @param quantity            剩余数量
     * @param soldQuantity        已团数量
     * @param endTime             截团时间
     * @param backgroundImagePath 背景图片
     * @return
     */
    public static BufferedImage getShareDetailImage(String coverImageUrl, String price, String originPrice, int quantity, int soldQuantity, Date endTime, String backgroundImagePath) {
        InputStream rootBackbroundImageInputStream = null;
        BufferedImage merchandiseBufferedImage = null;
        try {

            //背景图（300 * 240）
            rootBackbroundImageInputStream = ShareImageUtils.class.getResourceAsStream(backgroundImagePath);

            //背景图根元素
            ImageElement rootElement = new ImageElement();
            rootElement.setId("backgroundImage");
            rootElement.setImageStream(rootBackbroundImageInputStream);
            //rootElement.setBufferedImage(ImageIO.read(new File(backgroundImagePath)));

            //商品图片164 * 164
            ImageElement merchandiseImageElement = new ImageElement();
            merchandiseImageElement.setId("merchandiseImage");
            merchandiseBufferedImage = getBufferedImageRegion(coverImageUrl, 273, 273);
            if (null != merchandiseBufferedImage) {
                merchandiseImageElement.setBufferedImage(merchandiseBufferedImage);
            }
            merchandiseImageElement.setWidth(273);
            merchandiseImageElement.setHeight(273);
            merchandiseImageElement.setBorder(0);
            merchandiseImageElement.setX(17);
            merchandiseImageElement.setY(17);

            //商品价格
            int merchandisePriceFontSize = 48;
            Money merchandisePrice = new Money(price);
            if (merchandisePrice.compareTo(new Money(new BigDecimal(100.00))) >= 0 && merchandisePrice.compareTo(new Money(new BigDecimal(1000.00))) == -1) {
                merchandisePriceFontSize = 44;
            } else if (merchandisePrice.compareTo(new Money(new BigDecimal(1000.00))) >= 0 && merchandisePrice.compareTo(new Money(new BigDecimal(10000.00))) == -1) {
                merchandisePriceFontSize = 36;
            } else if (merchandisePrice.compareTo(new Money(new BigDecimal(10000.00))) >= 0) {
                merchandisePriceFontSize = 30;
            }
            TextElement merchandisePriceElement = new TextElement();
            merchandisePriceElement.setId("price");
            merchandisePriceElement.setText(price);
            merchandisePriceElement.setColor(new Color(255, 100, 100));
            merchandisePriceElement.setX(330);//为0时自动居中
            merchandisePriceElement.setY(78);
            merchandisePriceElement.setFont(getDefalutFont().deriveFont(Font.BOLD, merchandisePriceFontSize));

            //商品原价
            TextElement merchandiseOriginPriceElement = new TextElement();
            merchandiseOriginPriceElement.setId("originPrice");
            merchandiseOriginPriceElement.setText(originPrice);
            merchandiseOriginPriceElement.setColor(new Color(51, 51, 51));
            merchandiseOriginPriceElement.setX(330);//为0时自动居中
            merchandiseOriginPriceElement.setY(106);
            merchandiseOriginPriceElement.setFont(getDefalutFont().deriveFont(Font.PLAIN, 24));
            //删除线
            merchandiseOriginPriceElement.setDrawLine(true);
            merchandiseOriginPriceElement.setX1(merchandiseOriginPriceElement.getX() - 16);
            merchandiseOriginPriceElement.setY1(merchandiseOriginPriceElement.getY() - 8);
            merchandiseOriginPriceElement.setY2(merchandiseOriginPriceElement.getY() - 8);


            //剩余数量
            TextElement merchandiseQuantityElement = new TextElement();
            merchandiseQuantityElement.setId("quantity");
            merchandiseQuantityElement.setText(StringUtils.join("剩余", quantity, "份"));
            merchandiseQuantityElement.setColor(new Color(51, 51, 51));
            merchandiseQuantityElement.setX(307);//为0时自动居中
            merchandiseQuantityElement.setY(242);
            //merchandiseQuantityElement.setFont(getDefalutFont().deriveFont(Font.PLAIN, 16));
            merchandiseQuantityElement.setFont(getDefalutFont().deriveFont(Font.BOLD, 26));

            //已团数量
            TextElement merchandiseSoldQuantityElement = new TextElement();
            merchandiseSoldQuantityElement.setId("soldQuantity");
            merchandiseSoldQuantityElement.setText(StringUtils.join("已团", soldQuantity, "份"));
            merchandiseSoldQuantityElement.setColor(new Color(153, 153, 153));
            merchandiseSoldQuantityElement.setX(307);//为0时自动居中
            merchandiseSoldQuantityElement.setY(277);
            merchandiseSoldQuantityElement.setFont(getDefalutFont().deriveFont(Font.BOLD, 24));

            //截团时间
            String endTimeStr = DateUtils.format(endTime, "HH:mm:ss");
            TextElement endTimeElement = new TextElement();
            endTimeElement.setId("endTime");
            endTimeElement.setText(endTimeStr);
            endTimeElement.setColor(new Color(255, 255, 255));
            endTimeElement.setX(10);//为0时自动居中
            endTimeElement.setY(380);
            endTimeElement.setFont(getDefalutFont().deriveFont(Font.BOLD, 47));

            rootElement.addElement(merchandiseImageElement);
            rootElement.addElement(merchandisePriceElement);
            rootElement.addElement(merchandiseOriginPriceElement);
            rootElement.addElement(merchandiseQuantityElement);
            rootElement.addElement(merchandiseSoldQuantityElement);
            rootElement.addElement(endTimeElement);
            Document document = Document.createDocument(rootElement);
            return ImageUtils.draw(document);
        } catch (Exception e) {
            System.out.println("生成商品详情分享图片");
            throw new NullPointerException();
        } finally {
            close(rootBackbroundImageInputStream);
            merchandiseBufferedImage = null;
        }
    }

    /**
     * 生成商品详情分享图片
     *
     * @param coverImageUrl 商品图片
     * @param price         商品价格
     * @param originPrice   商品原价
     * @param quantity      剩余数量
     * @param soldQuantity  已团数量
     * @param endTime       截团时间
     * @param groupType     团类型：0普通团，1秒杀团
     * @return
     */
    public static BufferedImage getShareDetailImageInvestor(String coverImageUrl, String price, String originPrice, int quantity, int soldQuantity, Date endTime, int groupType) {
        InputStream rootBackbroundImageInputStream = null;
        InputStream watermarkImageInputStream = null;
        BufferedImage merchandiseBufferedImage = null;
        BufferedImage watermarkBufferedImage = null;
        try {

            String backgroundImagePath = StringUtils.join("/share/detal_gb_investor_500x400_m", groupType, ".png");

            //背景图（300 * 240）
            rootBackbroundImageInputStream = ShareImageUtils.class.getResourceAsStream(backgroundImagePath);

            //背景图根元素
            ImageElement rootElement = new ImageElement();
            rootElement.setId("backgroundImage");

//            //本地Main测试使用
//            File file = ResourceUtils.getFile("D:/workspace/nicetuan/youhaodongxi-agbweapp-server/yhdx-agbweapp/yhdx-agbweapp-boot/src/main/resources" + backgroundImagePath);
//            rootElement.setBufferedImage(ImageIO.read(file));

            rootElement.setImageStream(rootBackbroundImageInputStream);

            //商品图片164 * 164
            ImageElement merchandiseImageElement = new ImageElement();
            merchandiseImageElement.setId("merchandiseImage");
            merchandiseBufferedImage = getBufferedImageRegion(coverImageUrl, 500, 324);
            if (null != merchandiseBufferedImage) {
                merchandiseImageElement.setBufferedImage(merchandiseBufferedImage);
            }
            merchandiseImageElement.setWidth(500);
            merchandiseImageElement.setHeight(324);
            merchandiseImageElement.setBorder(0);
            merchandiseImageElement.setX(0);
            merchandiseImageElement.setY(1);

            int merchandiseOriginPriceWidth = 26 + 10;
            String[] prices = StringUtils.split(price, ".");
            if (prices.length == 2) {

                //商品价格人民币符号部分
                TextElement merchandisePriceIntMoneyElement = new TextElement();
                merchandisePriceIntMoneyElement.setId("price1");
                merchandisePriceIntMoneyElement.setText("¥");
                merchandisePriceIntMoneyElement.setColor(new Color(255, 255, 255));
                merchandisePriceIntMoneyElement.setX(13);
                merchandisePriceIntMoneyElement.setY(362);
                merchandisePriceIntMoneyElement.setFont(getDefalutFont().deriveFont(Font.PLAIN, 24));

                //商品价格整数部分
                TextElement merchandisePriceIntElement = new TextElement();
                merchandisePriceIntElement.setId("price2");
                merchandisePriceIntElement.setText(prices[0]);
                merchandisePriceIntElement.setColor(new Color(255, 255, 255));
                merchandisePriceIntElement.setX(26);
                merchandisePriceIntElement.setY(363);
                merchandisePriceIntElement.setFont(getDefalutFont().deriveFont(Font.BOLD, 38));

                //商品价格小数部分
                TextElement merchandisePriceDecimalElement = new TextElement();
                merchandisePriceDecimalElement.setId("price3");
                merchandisePriceDecimalElement.setText(StringUtils.join(".", prices[1]));
                merchandisePriceDecimalElement.setColor(new Color(255, 255, 255));
                merchandisePriceDecimalElement.setX(26 + merchandisePriceIntElement.getStringBounds().width);
                merchandisePriceDecimalElement.setY(363);
                merchandisePriceDecimalElement.setFont(getDefalutFont().deriveFont(Font.BOLD, 26));
                merchandiseOriginPriceWidth = merchandiseOriginPriceWidth + merchandisePriceIntElement.getStringBounds().width + merchandisePriceDecimalElement.getStringBounds().width;

                rootElement.addElement(merchandisePriceIntMoneyElement);
                rootElement.addElement(merchandisePriceIntElement);
                rootElement.addElement(merchandisePriceDecimalElement);
            } else {
                //商品价格
                TextElement merchandisePriceIntElement = new TextElement();
                merchandisePriceIntElement.setId("price");
                merchandisePriceIntElement.setText(StringUtils.join("¥", price));
                merchandisePriceIntElement.setColor(new Color(255, 255, 255));
                merchandisePriceIntElement.setX(26);
                merchandisePriceIntElement.setY(362);
                merchandisePriceIntElement.setFont(getDefalutFont().deriveFont(Font.BOLD, 38));
                merchandiseOriginPriceWidth = merchandiseOriginPriceWidth + merchandisePriceIntElement.getStringBounds().width;
                rootElement.addElement(merchandisePriceIntElement);
            }

            //商品原价
            TextElement merchandiseOriginPriceElement = new TextElement();
            merchandiseOriginPriceElement.setId("originPrice");
            merchandiseOriginPriceElement.setText(StringUtils.join("¥", originPrice));
            merchandiseOriginPriceElement.setColor(new Color(255, 255, 255));
            merchandiseOriginPriceElement.setX(merchandiseOriginPriceWidth);
            merchandiseOriginPriceElement.setY(362);
            merchandiseOriginPriceElement.setFont(getDefalutFont().deriveFont(Font.PLAIN, 22));
            //删除线
            merchandiseOriginPriceElement.setDrawLine(true);
            merchandiseOriginPriceElement.setX1(merchandiseOriginPriceElement.getX());
            merchandiseOriginPriceElement.setY1(merchandiseOriginPriceElement.getY() - 8);
            merchandiseOriginPriceElement.setY2(merchandiseOriginPriceElement.getY() - 8);

            //剩余|已团数量
            TextElement merchandiseQuantityElement = new TextElement();
            merchandiseQuantityElement.setId("quantity");
            merchandiseQuantityElement.setText(StringUtils.join("剩余", quantity, " | 已团", soldQuantity));
            merchandiseQuantityElement.setColor(new Color(255, 255, 255));
            merchandiseQuantityElement.setX(13);
            merchandiseQuantityElement.setY(387);
            merchandiseQuantityElement.setFont(getDefalutFont().deriveFont(Font.BOLD, 19));

            //截团时间
            String endTimeStr = DateUtils.format(endTime, "HH:mm:ss");
            /*String endTimeStr = DateUtils.format(endTime, "MM月dd日HH点");
            if (endTimeStr.startsWith("0")) {
                endTimeStr = endTimeStr.substring(1);
            }
            endTimeStr = StringUtils.join(endTimeStr, "后截团")
            */
            TextElement endTimeElement = new TextElement();
            endTimeElement.setId("endTime");
            endTimeElement.setText(StringUtils.join("截团：", endTimeStr));

            //秒杀
            if (groupType == 1) {
                endTimeElement.setColor(new Color(255, 255, 255));
                endTimeElement.setX(330);
            }
            //普通团
            else {
                endTimeElement.setColor(new Color(138, 206, 50));
                endTimeElement.setX(342);
            }
            endTimeElement.setY(390);
            endTimeElement.setFont(getDefalutFont().deriveFont(Font.PLAIN, 22));

            rootElement.addElement(endTimeElement);
            rootElement.addElement(merchandiseImageElement);
            rootElement.addElement(merchandiseOriginPriceElement);
            rootElement.addElement(merchandiseQuantityElement);
            Document document = Document.createDocument(rootElement);

            if (groupType == 1) {
                watermarkImageInputStream = ShareImageUtils.class.getResourceAsStream("/share/second_skill_68x69.png");
                BufferedImage bufferedImage = ImageUtils.draw(document);

//                File file1 = ResourceUtils.getFile("D:/workspace/nicetuan/youhaodongxi-agbweapp-server/yhdx-agbweapp/yhdx-agbweapp-boot/src/main/resources/share/second_skill_68x69.png");
//                BufferedImage watermarkImageInputStream = ImageIO.read(file1);

                return watermark(bufferedImage, watermarkImageInputStream, Positions.TOP_LEFT);
            } else {
                return ImageUtils.draw(document);
            }
        } catch (Exception e) {
            System.out.println("生成商品详情分享图片");
            throw new NullPointerException();
        } finally {
            close(rootBackbroundImageInputStream);
            close(watermarkImageInputStream);
            merchandiseBufferedImage = null;
            watermarkBufferedImage = null;
        }
    }


    /**
    * 商品详情分享  2019.2.15版本
    * */
//    public static BufferedImage createShareDetailImage(String coverImageUrl, String price, String originPrice, int quantity,int groupType) {
//
//
//        //LoggerUtils.info(CommonLogger.BIZ, "createShareDetailImage price=", price, ", originPrice=", originPrice);
//        BufferedImage merchandiseBufferedImage=null;
//        BufferedImage bottomWaerMark=null;
//        InputStream bottomImageInputStream=null;
//        InputStream remainImageInputStream=null;
//        try {
//
//            //1加载商品图片
//            merchandiseBufferedImage = getBufferedImageRegion(coverImageUrl, 300, 240);
//            //2加载底部图
//            String bottomImagePath = StringUtils.join("/share/bottom_", groupType, ".png");
//            bottomImageInputStream = ShareImageUtils.class.getResourceAsStream(bottomImagePath);
//            //3将底部图以水印的方式添加到商品背景图
//            bottomWaerMark = watermark(merchandiseBufferedImage, bottomImageInputStream, PositionType.BOTTOM);
//
//            ImageElement rootElement = new ImageElement();
//            rootElement.setId("root");
//            //rootElement.setBufferedImage(bottomWaerMark);
//
//            if(1==groupType){
//                //秒杀
//                if(quantity<=10){
//                    String remainImagePath = "/share/secondkill_remain.png";
//                    remainImageInputStream = ShareImageUtils.class.getResourceAsStream(remainImagePath);
//
//                    bottomWaerMark = watermark(bottomWaerMark, remainImageInputStream, PositionType.TOP);
//                    rootElement.setBufferedImage(bottomWaerMark);
//                    //剩余文字
//                    TextElement remainWordElement = new TextElement();
//                    remainWordElement.setId("quantity");
//                    remainWordElement.setText(StringUtils.join("秒杀 仅剩",quantity));
//                    remainWordElement.setColor(new Color(255, 255, 255));
//                    remainWordElement.setX(6);
//                    remainWordElement.setY(24);
//                    remainWordElement.setFont(getDefalutFont().deriveFont(Font.BOLD, 19));
//                    rootElement.addElement(remainWordElement);
//
//                }else {
//
//                    String secondkillImagePath = "/share/secondkill.png";
//                    remainImageInputStream = ShareImageUtils.class.getResourceAsStream(secondkillImagePath);
//
//                    bottomWaerMark = watermark(bottomWaerMark, remainImageInputStream, PositionType.TOP);
//                    rootElement.setBufferedImage(bottomWaerMark);
//
//                }
//
//            }else {
//                if(quantity<=10){
//                    String remainImagePath = "/share/remain.png";
//                    remainImageInputStream = ShareImageUtils.class.getResourceAsStream(remainImagePath);
//
//                    bottomWaerMark = watermark(bottomWaerMark, remainImageInputStream, PositionType.TOP);
//                    rootElement.setBufferedImage(bottomWaerMark);
//                    //剩余文字
//                    TextElement remainWordElement = new TextElement();
//                    remainWordElement.setId("quantity");
//                    remainWordElement.setText(StringUtils.join("仅剩",quantity));
//                    remainWordElement.setColor(new Color(255, 206, 81));
//                    remainWordElement.setX(10);
//                    remainWordElement.setY(24);
//                    remainWordElement.setFont(getDefalutFont().deriveFont(Font.BOLD, 19));
//                    rootElement.addElement(remainWordElement);
//
//                }else {
//                    rootElement.setBufferedImage(bottomWaerMark);
//                }
//            }
//
//
//            //底部价格部分
//            int merchandiseOriginPriceX=13;
//            //商品价格人民币符号部分
//            TextElement merchandisePriceIntMoneyElement = new TextElement();
//            merchandisePriceIntMoneyElement.setId("price1");
//            merchandisePriceIntMoneyElement.setText("¥");
//            merchandisePriceIntMoneyElement.setColor(new Color(255, 255, 255));
//            merchandisePriceIntMoneyElement.setX(13);
//            merchandisePriceIntMoneyElement.setY(227);
//            merchandisePriceIntMoneyElement.setFont(getDefalutFont().deriveFont(Font.PLAIN, 16));
//            rootElement.addElement(merchandisePriceIntMoneyElement);
//            merchandiseOriginPriceX+=merchandisePriceIntMoneyElement.getStringBounds().width;
//
//            //===============//
//            String[] prices = StringUtils.split(price, ".");
//            if(prices.length==2){
//                //商品价格整数部分
//                TextElement merchandisePriceIntElement = new TextElement();
//                merchandisePriceIntElement.setId("price2");
//                merchandisePriceIntElement.setText(prices[0]);
//                merchandisePriceIntElement.setColor(new Color(255, 255, 255));
//                merchandisePriceIntElement.setX(22);
//                merchandisePriceIntElement.setY(227);
//                merchandisePriceIntElement.setFont(getDefalutFont().deriveFont(Font.BOLD, 28));
//                rootElement.addElement(merchandisePriceIntElement);
//                merchandiseOriginPriceX+=merchandisePriceIntElement.getStringBounds().width;
//
//
//                TextElement dotElement = new TextElement();
//                dotElement.setId("dot");
//                dotElement.setText(".");
//                dotElement.setColor(new Color(255, 255, 255));
//                dotElement.setX(21 + merchandisePriceIntElement.getStringBounds().width);
//                dotElement.setY(227);
//                dotElement.setFont(getDefalutFont().deriveFont(Font.BOLD, 19));
//                rootElement.addElement(dotElement);
//                merchandiseOriginPriceX+=4;
//
//
//                //商品价格小数部分
//                TextElement merchandisePriceDecimalElement = new TextElement();
//                merchandisePriceDecimalElement.setId("price3");
//                merchandisePriceDecimalElement.setText(prices[1]);
//               // merchandisePriceDecimalElement.setText(StringUtils.join(".", prices[1]));
//                merchandisePriceDecimalElement.setColor(new Color(255, 255, 255));
//                merchandisePriceDecimalElement.setX(22 +4+ merchandisePriceIntElement.getStringBounds().width);
//                merchandisePriceDecimalElement.setY(227);
//                merchandisePriceDecimalElement.setFont(getDefalutFont().deriveFont(Font.BOLD, 28));
//                rootElement.addElement(merchandisePriceDecimalElement);
//                merchandiseOriginPriceX+=merchandisePriceDecimalElement.getStringBounds().width;
//                //merchandiseOriginPriceWidth = merchandiseOriginPriceWidth + merchandisePriceIntElement.getStringBounds().width + merchandisePriceDecimalElement.getStringBounds().width;
//
//            }else {
//                //商品价格
//                TextElement merchandisePriceIntElement = new TextElement();
//                merchandisePriceIntElement.setId("price2");
//                merchandisePriceIntElement.setText(price);
//                merchandisePriceIntElement.setColor(new Color(255, 255, 255));
//                merchandisePriceIntElement.setX(22);
//                merchandisePriceIntElement.setY(227);
//                merchandisePriceIntElement.setFont(getDefalutFont().deriveFont(Font.BOLD, 28));
//                rootElement.addElement(merchandisePriceIntElement);
//                merchandiseOriginPriceX+=merchandisePriceIntElement.getStringBounds().width;
//
//            }
//
//            //商品原价
//            TextElement merchandiseOriginPriceElement = new TextElement();
//            merchandiseOriginPriceElement.setId("originPrice");
//            merchandiseOriginPriceElement.setText(StringUtils.join("¥", originPrice));
//            merchandiseOriginPriceElement.setColor(new Color(255, 255, 255));
//            //merchandiseOriginPriceElement.setX(merchandiseOriginPriceWidth+merchandisePriceIntElement.getStringBounds().width);
//            merchandiseOriginPriceElement.setX(merchandiseOriginPriceX);
//            merchandiseOriginPriceElement.setY(227);
//            merchandiseOriginPriceElement.setFont(getDefalutFont().deriveFont(Font.PLAIN, 17));
//            //删除线
//            merchandiseOriginPriceElement.setDrawLine(true);
//            merchandiseOriginPriceElement.setX1(merchandiseOriginPriceElement.getX());
//            merchandiseOriginPriceElement.setY1(merchandiseOriginPriceElement.getY() - 6);
//            merchandiseOriginPriceElement.setY2(merchandiseOriginPriceElement.getY() - 6);
//            rootElement.addElement(merchandiseOriginPriceElement);
//
//            Document document = Document.createDocument(rootElement);
//            return ImageUtils.draw(document);
//
//        } catch (Exception e) {
//            LoggerUtils.error(CommonLogger.ACCESS, e, "生成商品详情分享图片");
//            throw new BusinessException(CommonResultCode.ILLEGAL_REQ_PARAMETER);
//        } finally {
//
//            close(bottomImageInputStream);
//            close(remainImageInputStream);
//            merchandiseBufferedImage = null;
//            bottomWaerMark=null;
//        }
//    }


    /**
     * 生成订单分享图片
     *
     * @param buyerNicename        买家昵称
     * @param orderTime            下单时间
     * @param merchandiseImageUrl1 商品图片1
     * @param merchandiseImageUrl2 商品图片2
     * @param watermarkFile        水印图片
     * @param backgroundImagePath
     * @return
     */
    public static BufferedImage getShareOrderImage(String buyerNicename, String orderTime,
                                                   String merchandiseImageUrl1, String merchandiseImageUrl2, String backgroundImagePath, String watermarkFile) {

        InputStream rootBackbroundImageInputStream = null;
        InputStream watermarkImageInputStream = null;
        BufferedImage merchandiseBufferedImage = null;
        BufferedImage merchandiseBufferedImage1 = null;
        BufferedImage merchandiseBufferedImage2 = null;
        try {

            //背景图（300 * 240）
            rootBackbroundImageInputStream = ShareImageUtils.class.getResourceAsStream(backgroundImagePath);

            //背景图根元素
            ImageElement rootElement = new ImageElement();
            rootElement.setId("backgroundImage");
            rootElement.setImageStream(rootBackbroundImageInputStream);
            //rootElement.setBufferedImage(ImageIO.read(new File(backgroundImagePath)));

            //买家昵称
            TextElement buyerNicenameElement = new TextElement();
            buyerNicenameElement.setId("buyerNicename");
            buyerNicenameElement.setText(StringUtils.join(buyerNicename));
            buyerNicenameElement.setColor(new Color(153, 153, 153));//102,102,102
            buyerNicenameElement.setX(2);//为0时自动居中
            buyerNicenameElement.setY(31);
            buyerNicenameElement.setFont(getDefalutFont().deriveFont(Font.BOLD, 26));

            //订单时间
            TextElement orderTimeElement = new TextElement();
            orderTimeElement.setId("orderTime");
            orderTimeElement.setText(StringUtils.join(orderTime));
            orderTimeElement.setColor(new Color(153, 153, 153));//102,102,102
            orderTimeElement.setX(326);//为0时自动居中
            orderTimeElement.setY(31);
            orderTimeElement.setFont(getDefalutFont().deriveFont(Font.BOLD, 26));

            watermarkImageInputStream = ShareImageUtils.class.getResourceAsStream(watermarkFile);
            if (StringUtils.isNotEmpty(merchandiseImageUrl1) && StringUtils.isEmpty(merchandiseImageUrl2)) {
                //商品图片300 * 210
                ImageElement merchandiseImageElement = new ImageElement();
                merchandiseImageElement.setId("merchandiseImage");
                merchandiseBufferedImage = getBufferedImageRegion(merchandiseImageUrl1, 500, 356);
                if (null != merchandiseBufferedImage) {
                    merchandiseImageElement.setBufferedImage(watermark(merchandiseBufferedImage, watermarkImageInputStream, Positions.TOP_RIGHT));
                }
                merchandiseImageElement.setWidth(500);
                merchandiseImageElement.setHeight(356);
                merchandiseImageElement.setBorder(0);
                merchandiseImageElement.setX(0);
                merchandiseImageElement.setY(44);
                rootElement.addElement(merchandiseImageElement);
            } else {
                //商品图片100 * 100
                ImageElement merchandiseImageElement1 = new ImageElement();
                merchandiseImageElement1.setId("merchandiseImage1");
                merchandiseBufferedImage1 = getBufferedImageRegion(merchandiseImageUrl1, 248, 356);
                if (null != merchandiseBufferedImage1) {
                    merchandiseImageElement1.setBufferedImage(merchandiseBufferedImage1);
                }
                merchandiseImageElement1.setWidth(248);
                merchandiseImageElement1.setHeight(356);
                merchandiseImageElement1.setBorder(0);
                merchandiseImageElement1.setX(1);
                merchandiseImageElement1.setY(44);

                ImageElement merchandiseImageElement2 = new ImageElement();
                merchandiseImageElement2.setId("merchandiseImage2");
                merchandiseBufferedImage2 = getBufferedImageRegion(merchandiseImageUrl2, 248, 356);
                if (null != merchandiseBufferedImage2) {
                    merchandiseImageElement2.setBufferedImage(watermark(merchandiseBufferedImage2, watermarkImageInputStream, Positions.TOP_RIGHT));
                }
                merchandiseImageElement2.setWidth(246);
                merchandiseImageElement2.setHeight(356);
                merchandiseImageElement2.setBorder(0);
                merchandiseImageElement2.setX(252);
                merchandiseImageElement2.setY(44);
                rootElement.addElement(merchandiseImageElement1);
                rootElement.addElement(merchandiseImageElement2);
            }

            rootElement.addElement(buyerNicenameElement);
            rootElement.addElement(orderTimeElement);
            Document document = Document.createDocument(rootElement);
            return ImageUtils.draw(document);
        } catch (Exception e) {
            System.out.println( "生成图片失败");
            throw new NullPointerException();
        } finally {
            close(rootBackbroundImageInputStream);
            close(watermarkImageInputStream);
            merchandiseBufferedImage = null;
            merchandiseBufferedImage1 = null;
            merchandiseBufferedImage2 = null;
        }
    }

    /**
     * 生成订单分享图片
     *
     * @param shareOrder 当前订单
     * @return
     */
    public static BufferedImage getShareOrderImage(ShareOrder shareOrder) {

        InputStream rootBackbroundImageInputStream = null;
        BufferedImage merchandiseBufferedImage = null;
        BufferedImage merchandiseBufferedImage1 = null;
        BufferedImage merchandiseBufferedImage2 = null;
        BufferedImage merchandiseBufferedImage3 = null;

        int orderGrouponNo = shareOrder.getOrderGrouponNo();
        java.util.List<ShareOrderMerchdies> shareOrderMerchdies = shareOrder.getShareOrderMerchdies();
        if (CollectionUtils.isNullOrEmpty(shareOrderMerchdies)) {
            throw new NullPointerException();
        }

        try {

            int size = shareOrderMerchdies.size();
            String backgroundImagePath = StringUtils.join("/share/share_order_bg_", size, ".png");

            //背景图（500 * 400）
            rootBackbroundImageInputStream = ShareImageUtils.class.getResourceAsStream(backgroundImagePath);

            //背景图根元素
            ImageElement rootElement = new ImageElement();
            rootElement.setId("backgroundImage");
            try {

                //线上环境
                rootElement.setImageStream(rootBackbroundImageInputStream);
            } catch (Exception e) {
                System.out.println("加载背景失败");

                //本地Main测试使用
                rootElement.setBufferedImage(ImageIO.read(new File(backgroundImagePath)));
            }

            //用户订单序号（grouponNo）
            TextElement orderGrouponNoElement = new TextElement();
            orderGrouponNoElement.setId("orderGrouponNo");
            orderGrouponNoElement.setText(StringUtils.join("第", orderGrouponNo, "单"));
            orderGrouponNoElement.setColor(new Color(255, 255, 255));
            int orderGrouponNoX = 16;
            int orderGrouponNoY = 100;
            if (orderGrouponNo < 10) {
                orderGrouponNoX = 40;
                orderGrouponNoY = 106;
            } else if (orderGrouponNo >= 10 && orderGrouponNo <= 99) {
                orderGrouponNoX = 32;
                orderGrouponNoY = 109;
            }
            orderGrouponNoElement.setX(orderGrouponNoX);
            orderGrouponNoElement.setY(orderGrouponNoY);
            orderGrouponNoElement.setDegree(-14);//旋转角度
            orderGrouponNoElement.setFont(getDefalutFont().deriveFont(Font.BOLD, 28));

            //来一单需求去掉了第几单
        /*    //订单接龙信息（前2单信息）第一行
            //第一个下单人分享时，右上角的文案：我是第一个下单的，团长快来接单～
            //第二个下单人分享时，右上角的文案：？？？
            if (orderGrouponNo <= 2) {
                String orderInfo1Text = "我是第一个下单的";
                if (orderGrouponNo == 2) {
                    orderInfo1Text = "我是第二个下单的";
                }
                TextElement orderInfoElement1 = new TextElement();
                orderInfoElement1.setId("orderInfo1");
                orderInfoElement1.setText(orderInfo1Text);
                orderInfoElement1.setColor(new Color(255, 255, 255));
                orderInfoElement1.setX(190);//为0时自动居中
                orderInfoElement1.setY(30);
                orderInfoElement1.setFont(getDefalutFont().deriveFont(Font.BOLD, 19));

                //订单接龙信息（前2单信息）第二行
                TextElement orderInfoElement2 = new TextElement();
                orderInfoElement2.setId("orderInfo2");
                orderInfoElement2.setText(StringUtils.join("团长快来接单～"));
                orderInfoElement2.setColor(new Color(255, 255, 255));
                orderInfoElement2.setX(190);//为0时自动居中
                orderInfoElement2.setY(62);
                orderInfoElement2.setFont(getDefalutFont().deriveFont(Font.BOLD, 19));

                rootElement.addElement(orderInfoElement1);
                rootElement.addElement(orderInfoElement2);
            } else if (!CollectionUtils.isNullOrEmpty(shareOrder.getBeforeShareOrders())
                    && shareOrder.getBeforeShareOrders().size() >= 2) {

                //订单序号x起始值
                int orderInfoGrouponNoX = 210;

                //第一单
                TextElement orderInfoElement1a = new TextElement();
                orderInfoElement1a.setId("orderInfo1a");
                orderInfoElement1a.setText("第");
                orderInfoElement1a.setColor(new Color(255, 255, 255));
                orderInfoElement1a.setX(190);
                orderInfoElement1a.setY(30);
                orderInfoElement1a.setFont(getDefalutFont().deriveFont(Font.PLAIN, 19));

                TextElement orderInfoElement1b = new TextElement();
                orderInfoElement1b.setId("orderInfo1b");
                orderInfoElement1b.setText(String.valueOf(shareOrder.getBeforeShareOrders().get(1).getOrderGrouponNo()));
                orderInfoElement1b.setColor(new Color(255, 236, 22));
                orderInfoElement1b.setX(orderInfoGrouponNoX);
                orderInfoElement1b.setY(30);
                orderInfoElement1b.setFont(getDefalutFont().deriveFont(Font.BOLD, 28));

                //订单序号宽度
                int orderInfo1cX = (int) orderInfoElement1b.getStringBounds().getWidth();
                TextElement orderInfoElement1c = new TextElement();
                orderInfoElement1c.setId("orderInfo1c");
                orderInfoElement1c.setColor(new Color(255, 255, 255));
                orderInfoElement1c.setFont(getDefalutFont().deriveFont(Font.PLAIN, 19));
                orderInfoElement1c.setText(StringUtils.join("单买了", shareOrder.getBeforeShareOrders().get(1).getGoodsDescription()));
                orderInfoElement1c.setX(orderInfoGrouponNoX + orderInfo1cX + 2);
                orderInfoElement1c.setY(30);
                orderInfoElement1c.setRow(1);
                orderInfoElement1c.setRowWidth(500 - (orderInfoGrouponNoX + orderInfo1cX + 15));

                //第二单
                TextElement orderInfoElement2a = new TextElement();
                orderInfoElement2a.setId("orderInfo2a");
                orderInfoElement2a.setText("第");
                orderInfoElement2a.setColor(new Color(255, 255, 255));
                orderInfoElement2a.setX(190);
                orderInfoElement2a.setY(62);
                orderInfoElement2a.setFont(getDefalutFont().deriveFont(Font.PLAIN, 19));

                TextElement orderInfoElement2b = new TextElement();
                orderInfoElement2b.setId("orderInfo2b");
                orderInfoElement2b.setText(String.valueOf(shareOrder.getBeforeShareOrders().get(0).getOrderGrouponNo()));
                orderInfoElement2b.setColor(new Color(255, 236, 22));
                orderInfoElement2b.setX(orderInfoGrouponNoX);
                orderInfoElement2b.setY(62);
                orderInfoElement2b.setFont(getDefalutFont().deriveFont(Font.BOLD, 28));

                int orderInfo2cX = (int) orderInfoElement2b.getStringBounds().getWidth();
                TextElement orderInfoElement2c = new TextElement();
                orderInfoElement2c.setId("orderInfo2c");
                orderInfoElement2c.setColor(new Color(255, 255, 255));
                orderInfoElement2c.setFont(getDefalutFont().deriveFont(Font.PLAIN, 19));
                orderInfoElement2c.setText(StringUtils.join("单买了", shareOrder.getBeforeShareOrders().get(0).getGoodsDescription()));
                orderInfoElement2c.setX(orderInfoGrouponNoX + orderInfo2cX + 2);
                orderInfoElement2c.setY(62);
                orderInfoElement2c.setRow(1);
                orderInfoElement2c.setRowWidth(500 - (orderInfoGrouponNoX + orderInfo2cX + 15));

                rootElement.addElement(orderInfoElement1a);
                rootElement.addElement(orderInfoElement1b);
                rootElement.addElement(orderInfoElement1c);
                rootElement.addElement(orderInfoElement2a);
                rootElement.addElement(orderInfoElement2b);
                rootElement.addElement(orderInfoElement2c);
            }*/


            //订单接龙信息（节省金额）

            TextElement economizeAmountElementA = new TextElement();
            economizeAmountElementA.setId("oeconomizeAmountA");
            economizeAmountElementA.setText("我买了");
            economizeAmountElementA.setColor(new Color(51, 51, 51));
            economizeAmountElementA.setX(225);
            economizeAmountElementA.setY(orderGrouponNoY-30);
            economizeAmountElementA.setRowWidth(140);
            economizeAmountElementA.setFont(getDefalutFont().deriveFont(Font.BOLD, 30));

            int orderInfo2cX = (int) economizeAmountElementA.getStringBounds().getWidth();
            TextElement economizeAmountElementA1 = new TextElement();
            economizeAmountElementA1.setId("oeconomizeAmountA1");
            economizeAmountElementA1.setText(shareOrder.getNumTotal()+"");
            economizeAmountElementA1.setColor(new Color(234, 51, 64));
            economizeAmountElementA1.setFont(getDefalutFont().deriveFont(Font.BOLD, 30));
            economizeAmountElementA1.setX(225+orderInfo2cX+5);
            economizeAmountElementA1.setY(orderGrouponNoY-30);

            int economizeAmountWidth1 = (int) economizeAmountElementA1.getStringBounds().getWidth();
            TextElement economizeAmountElementA2 = new TextElement();
            economizeAmountElementA2.setId("economizeAmountElementA2");
            economizeAmountElementA2.setText("件省");
            economizeAmountElementA2.setRowWidth(120);
            economizeAmountElementA2.setColor(new Color(51, 51, 51));
            economizeAmountElementA2.setX(225+orderInfo2cX+economizeAmountWidth1+10);
            economizeAmountElementA2.setY(orderGrouponNoY-30);
            economizeAmountElementA2.setFont(getDefalutFont().deriveFont(Font.BOLD, 30));

            //int economizeAmountWidth1_1 = (int) economizeAmountElementA1.getStringBounds().getWidth();
            TextElement economizeAmountElementA2_1 = new TextElement();
            economizeAmountElementA2_1.setId("economizeAmountElementA2_1");
            economizeAmountElementA2_1.setText("了");
            economizeAmountElementA2_1.setColor(new Color(51, 51, 51));
            economizeAmountElementA2_1.setX(225);
            economizeAmountElementA2_1.setY(orderGrouponNoY+10);
            economizeAmountElementA2_1.setFont(getDefalutFont().deriveFont(Font.BOLD, 30));


            int economizeAmountWidth2 = (int) economizeAmountElementA2_1.getStringBounds().getWidth();
            TextElement economizeAmountElementB = new TextElement();
            economizeAmountElementB.setId("oeconomizeAmountB");
            economizeAmountElementB.setText(shareOrder.getEconomizeAmount());
            economizeAmountElementB.setColor(new Color(234, 51, 64));
            economizeAmountElementB.setFont(getDefalutFont().deriveFont(Font.BOLD, 30));
            economizeAmountElementB.setX(225+economizeAmountWidth2+5);
            economizeAmountElementB.setY(orderGrouponNoY+10);

            //计算“节省金额”字符串的宽度
            int economizeAmountWidth3 = (int) economizeAmountElementB.getStringBounds().getWidth();
            TextElement economizeAmountElementC = new TextElement();
            economizeAmountElementC.setId("oeconomizeAmountC");
            economizeAmountElementC.setText("元");
            economizeAmountElementC.setColor(new Color(51, 51, 51));
            economizeAmountElementC.setX(225+economizeAmountWidth2+economizeAmountWidth3+10);//430
            economizeAmountElementC.setY(orderGrouponNoY+10);
            economizeAmountElementC.setFont(getDefalutFont().deriveFont(Font.BOLD, 30));

            switch (size) {
                case 1: {
                    //商品图片234 * 193
                    ImageElement merchandiseImageElement = new ImageElement();
                    merchandiseImageElement.setId("merchandiseImage");
                    merchandiseBufferedImage = getBufferedImageRegion(shareOrderMerchdies.get(0).getImage(), 135, 135);
                    if (null != merchandiseBufferedImage) {
                        merchandiseImageElement.setBufferedImage(merchandiseBufferedImage);
                    }
                    merchandiseImageElement.setWidth(200);
                    merchandiseImageElement.setHeight(165);
                    merchandiseImageElement.setBorder(0);
                    merchandiseImageElement.setX(11);
                    merchandiseImageElement.setY(186);
                    rootElement.addElement(merchandiseImageElement);

                    //订单接龙信息（商品标题）
                    TextElement merchandiseTitleElement = new TextElement();
                    merchandiseTitleElement.setId("merchandiseTitle");
                    merchandiseTitleElement.setText(StringUtils.join(shareOrderMerchdies.get(0).getAbbreviation()));
                    merchandiseTitleElement.setColor(new Color(51, 51, 51));
                    merchandiseTitleElement.setX(286);
                    merchandiseTitleElement.setY(224);
                    merchandiseTitleElement.setRow(2);
                    merchandiseTitleElement.setRowWidth(163);
                    merchandiseTitleElement.setFont(getDefalutFont().deriveFont(Font.BOLD, 30));
                    rootElement.addElement(merchandiseTitleElement);

                    //订单接龙信息（商品金额）
                    TextElement merchandisePriceElement = new TextElement();
                    merchandisePriceElement.setId("merchandisePrice");
                    merchandisePriceElement.setText(StringUtils.join("¥", shareOrderMerchdies.get(0).getPrice()));
                    merchandisePriceElement.setColor(new Color(254, 51, 34));
                    merchandisePriceElement.setX(286);
                    merchandisePriceElement.setY(334);
                    merchandisePriceElement.setFont(getDefalutFont().deriveFont(Font.BOLD, 28));
                    rootElement.addElement(merchandisePriceElement);
                    break;
                }
                case 2: {

                    //商品1图片135 * 135
                    ImageElement merchandiseImageElement1 = new ImageElement();
                    merchandiseImageElement1.setId("merchandiseImage1");
                    merchandiseBufferedImage1 = getBufferedImageRegion(shareOrderMerchdies.get(0).getImage(), 135, 135);
                    if (null != merchandiseBufferedImage1) {
                        merchandiseImageElement1.setBufferedImage(merchandiseBufferedImage1);
                    }
                    merchandiseImageElement1.setWidth(135);
                    merchandiseImageElement1.setHeight(120);
                    merchandiseImageElement1.setBorder(0);
                    merchandiseImageElement1.setX(68);
                    merchandiseImageElement1.setY(186);
                    //merchandiseImageElement1.setDegree(10);
                    rootElement.addElement(merchandiseImageElement1);

                    //订单接龙信息（商品1金额）
                    TextElement merchandisePriceElement1 = new TextElement();
                    merchandisePriceElement1.setId("merchandisePrice1");
                    merchandisePriceElement1.setText(StringUtils.join("¥", shareOrderMerchdies.get(0).getPrice()));
                    merchandisePriceElement1.setColor(new Color(255, 255, 255));
                    merchandisePriceElement1.setX(46);
                    merchandisePriceElement1.setY(340);
                    merchandisePriceElement1.setFont(getDefalutFont().deriveFont(Font.BOLD, 27));
                    rootElement.addElement(merchandisePriceElement1);


                    //商品2图片135 * 135
                    ImageElement merchandiseImageElement2 = new ImageElement();
                    merchandiseImageElement2.setId("merchandiseImage2");
                    merchandiseBufferedImage2 = getBufferedImageRegion(shareOrderMerchdies.get(1).getImage(), 135, 135);
                    if (null != merchandiseBufferedImage2) {
                        merchandiseImageElement2.setBufferedImage(merchandiseBufferedImage2);
                    }
                    merchandiseImageElement2.setWidth(135);
                    merchandiseImageElement2.setHeight(120);
                    merchandiseImageElement2.setBorder(0);
                    merchandiseImageElement2.setX(281);
                    merchandiseImageElement2.setY(186);
                    rootElement.addElement(merchandiseImageElement2);

                    //订单接龙信息（商品2金额）
                    TextElement merchandisePriceElement2 = new TextElement();
                    merchandisePriceElement2.setId("merchandisePrice2");
                    merchandisePriceElement2.setText(StringUtils.join("¥", shareOrderMerchdies.get(1).getPrice()));
                    merchandisePriceElement2.setColor(new Color(255, 255, 255));
                    merchandisePriceElement2.setX(258);
                    merchandisePriceElement2.setY(340);
                    merchandisePriceElement2.setFont(getDefalutFont().deriveFont(Font.BOLD, 27));
                    rootElement.addElement(merchandisePriceElement2);
                    break;
                }
                case 3: {
                    //商品1图片135 * 135
                    ImageElement merchandiseImageElement1 = new ImageElement();
                    merchandiseImageElement1.setId("merchandiseImage1");
                    merchandiseBufferedImage1 = getBufferedImageRegion(shareOrderMerchdies.get(0).getImage(), 135, 135);
                    if (null != merchandiseBufferedImage1) {
                        merchandiseImageElement1.setBufferedImage(merchandiseBufferedImage1);
                    }
                    merchandiseImageElement1.setWidth(135);
                    merchandiseImageElement1.setHeight(120);
                    merchandiseImageElement1.setBorder(0);
                    merchandiseImageElement1.setX(18);
                    merchandiseImageElement1.setY(186);
                    rootElement.addElement(merchandiseImageElement1);

                    //订单接龙信息（商品1金额）
                    TextElement merchandisePriceElement1 = new TextElement();
                    merchandisePriceElement1.setId("merchandisePrice1");
                    merchandisePriceElement1.setText(StringUtils.join("¥", shareOrderMerchdies.get(0).getPrice()));
                    merchandisePriceElement1.setColor(new Color(255, 255, 255));
                    merchandisePriceElement1.setX(8);
                    merchandisePriceElement1.setY(340);
                    merchandisePriceElement1.setFont(getDefalutFont().deriveFont(Font.BOLD, 27));
                    rootElement.addElement(merchandisePriceElement1);


                    //商品2图片135 * 135
                    ImageElement merchandiseImageElement2 = new ImageElement();
                    merchandiseImageElement2.setId("merchandiseImage2");
                    merchandiseBufferedImage2 = getBufferedImageRegion(shareOrderMerchdies.get(1).getImage(), 135, 135);
                    if (null != merchandiseBufferedImage2) {
                        merchandiseImageElement2.setBufferedImage(merchandiseBufferedImage2);
                    }
                    merchandiseImageElement2.setWidth(135);
                    merchandiseImageElement2.setHeight(120);
                    merchandiseImageElement2.setBorder(0);
                    merchandiseImageElement2.setX(183);
                    merchandiseImageElement2.setY(186);
                    rootElement.addElement(merchandiseImageElement2);

                    //订单接龙信息（商品2金额）
                    TextElement merchandisePriceElement2 = new TextElement();
                    merchandisePriceElement2.setId("merchandisePrice2");
                    merchandisePriceElement2.setText(StringUtils.join("¥", shareOrderMerchdies.get(1).getPrice()));
                    merchandisePriceElement2.setColor(new Color(255, 255, 255));
                    merchandisePriceElement2.setX(172);
                    merchandisePriceElement2.setY(340);
                    merchandisePriceElement2.setFont(getDefalutFont().deriveFont(Font.BOLD, 27));
                    rootElement.addElement(merchandisePriceElement2);

                    //商品3图片135 * 135
                    ImageElement merchandiseImageElement3 = new ImageElement();
                    merchandiseImageElement3.setId("merchandiseImage2");
                    merchandiseBufferedImage3 = getBufferedImageRegion(shareOrderMerchdies.get(2).getImage(), 135, 135);
                    if (null != merchandiseBufferedImage3) {
                        merchandiseImageElement3.setBufferedImage(merchandiseBufferedImage3);
                    }
                    merchandiseImageElement3.setWidth(136);
                    merchandiseImageElement3.setHeight(120);
                    merchandiseImageElement3.setBorder(0);
                    merchandiseImageElement3.setX(348);
                    merchandiseImageElement3.setY(186);
                    rootElement.addElement(merchandiseImageElement3);

                    //订单接龙信息（商品3金额）
                    TextElement merchandisePriceElement3 = new TextElement();
                    merchandisePriceElement3.setId("merchandisePrice3");
                    merchandisePriceElement3.setText(StringUtils.join("¥", shareOrderMerchdies.get(2).getPrice()));
                    merchandisePriceElement3.setColor(new Color(255, 255, 255));
                    merchandisePriceElement3.setX(336);
                    merchandisePriceElement3.setY(340);
                    merchandisePriceElement3.setFont(getDefalutFont().deriveFont(Font.BOLD, 27));
                    rootElement.addElement(merchandisePriceElement3);
                    break;
                }
            }

            rootElement.addElement(orderGrouponNoElement);
            rootElement.addElement(economizeAmountElementA);
            rootElement.addElement(economizeAmountElementA1);
            rootElement.addElement(economizeAmountElementA2);
            rootElement.addElement(economizeAmountElementA2_1);
            rootElement.addElement(economizeAmountElementB);
            rootElement.addElement(economizeAmountElementC);
            Document document = Document.createDocument(rootElement);
            return ImageUtils.draw(document);
        } catch (Exception e) {
            System.out.println("生成图片失败");
            throw new NullPointerException();
        } finally {
            close(rootBackbroundImageInputStream);

            merchandiseBufferedImage = null;
            merchandiseBufferedImage1 = null;
            merchandiseBufferedImage2 = null;
            merchandiseBufferedImage3 = null;
        }
    }


    public static BufferedImage createShareOrderImage(ShareOrder shareOrder) {

        InputStream rootBackbroundImageInputStream = null;
        InputStream left1BgImageInputStream = null;
        InputStream centerBgImageInputStream = null;
        InputStream rightBgImageInputStream = null;
        InputStream priceImageInputStream = null;
        InputStream rightPriceImageInputStream = null;
        InputStream leftBg = null;
        InputStream rightBg = null;

        BufferedImage merchandiseBufferedImage = null;
        BufferedImage leftMerchanise = null;
        BufferedImage priceImage = null;
        BufferedImage rightMerchanise = null;
        BufferedImage rightPriceImage = null;
        BufferedImage centerPriceImage = null;
        BufferedImage leftPriceImage = null;

        int orderGrouponNo = shareOrder.getOrderGrouponNo();
        java.util.List<ShareOrderMerchdies> shareOrderMerchdies = shareOrder.getShareOrderMerchdies();
        if (CollectionUtils.isNullOrEmpty(shareOrderMerchdies)) {
            throw new NullPointerException();
        }

        try {

            int size = shareOrderMerchdies.size();
            int index = (size == 1 ? 1 : 2);
            String backgroundImagePath = StringUtils.join("/share/new_share_", index, ".png");
            //String backgroundImagePath = StringUtils.join("/share/share_order_bg_", size, ".png");

            //背景图（500 * 400）
            rootBackbroundImageInputStream = ShareImageUtils.class.getResourceAsStream(backgroundImagePath);

            //背景图根元素
            ImageElement rootElement = new ImageElement();
            rootElement.setId("backgroundImage");

            //线上环境
            if (rootBackbroundImageInputStream != null) {
                rootElement.setImageStream(rootBackbroundImageInputStream);
            } else {
                //本地Main测试使用
                rootElement.setBufferedImage(ImageIO.read(new File(backgroundImagePath)));
            }

            //用户订单序号（grouponNo）
            TextElement orderGrouponNoElement = new TextElement();
            orderGrouponNoElement.setId("orderGrouponNo");
            orderGrouponNoElement.setText(StringUtils.join("第", orderGrouponNo, "单"));
            orderGrouponNoElement.setColor(new Color(255, 255, 255));
            int orderGrouponNoX = 16;
            int orderGrouponNoY = 95;
            if (orderGrouponNo < 10) {
                orderGrouponNoX = 30;
                orderGrouponNoY = 91;
            } else if (orderGrouponNo >= 10 && orderGrouponNo <= 99) {
                orderGrouponNoX = 22;
                orderGrouponNoY = 93;
            }
            orderGrouponNoElement.setX(orderGrouponNoX);
            orderGrouponNoElement.setY(orderGrouponNoY);
            orderGrouponNoElement.setDegree(-14);//旋转角度
            orderGrouponNoElement.setFont(getDefalutFont().deriveFont(Font.BOLD, 28));
            rootElement.addElement(orderGrouponNoElement);


            //订单接龙信息（前2单信息）第一行
            //第一个下单人分享时，右上角的文案：我是第一个下单的，团长快来接单～
            //第二个下单人分享时，右上角的文案：？？？
            if (orderGrouponNo <= 2) {
                String orderInfo1Text = "我是第一个下单的";
                if (orderGrouponNo == 2) {
                    orderInfo1Text = "我是第二个下单的";
                }
                TextElement orderInfoElement1 = new TextElement();
                orderInfoElement1.setId("orderInfo1");
                orderInfoElement1.setText(orderInfo1Text);
                orderInfoElement1.setColor(new Color(255, 255, 255));
                orderInfoElement1.setX(190);//为0时自动居中
                orderInfoElement1.setY(30);
                orderInfoElement1.setFont(getDefalutFont().deriveFont(Font.BOLD, 19));

                //订单接龙信息（前2单信息）第二行
                TextElement orderInfoElement2 = new TextElement();
                orderInfoElement2.setId("orderInfo2");
                orderInfoElement2.setText(StringUtils.join("团长快来接单～"));
                orderInfoElement2.setColor(new Color(255, 255, 255));
                orderInfoElement2.setX(190);//为0时自动居中
                orderInfoElement2.setY(62);
                orderInfoElement2.setFont(getDefalutFont().deriveFont(Font.BOLD, 19));

                rootElement.addElement(orderInfoElement1);
                rootElement.addElement(orderInfoElement2);
            } else if (!CollectionUtils.isNullOrEmpty(shareOrder.getBeforeShareOrders())
                    && shareOrder.getBeforeShareOrders().size() >= 2) {

                //订单序号x起始值
                int orderInfoGrouponNoX = 210;

                //第一单
                TextElement orderInfoElement1a = new TextElement();
                orderInfoElement1a.setId("orderInfo1a");
                orderInfoElement1a.setText("第");
                orderInfoElement1a.setColor(new Color(255, 255, 255));
                orderInfoElement1a.setX(190);
                orderInfoElement1a.setY(30);
                orderInfoElement1a.setFont(getDefalutFont().deriveFont(Font.PLAIN, 19));

                TextElement orderInfoElement1b = new TextElement();
                orderInfoElement1b.setId("orderInfo1b");
                orderInfoElement1b.setText(String.valueOf(shareOrder.getBeforeShareOrders().get(1).getOrderGrouponNo()));
                orderInfoElement1b.setColor(new Color(255, 236, 22));
                orderInfoElement1b.setX(orderInfoGrouponNoX);
                orderInfoElement1b.setY(30);
                orderInfoElement1b.setFont(getDefalutFont().deriveFont(Font.BOLD, 28));

                //订单序号宽度
                int orderInfo1cX = (int) orderInfoElement1b.getStringBounds().getWidth();
                TextElement orderInfoElement1c = new TextElement();
                orderInfoElement1c.setId("orderInfo1c");
                orderInfoElement1c.setColor(new Color(255, 255, 255));
                orderInfoElement1c.setFont(getDefalutFont().deriveFont(Font.PLAIN, 19));
                orderInfoElement1c.setText(StringUtils.join("单买了", shareOrder.getBeforeShareOrders().get(1).getGoodsDescription()));
                orderInfoElement1c.setX(orderInfoGrouponNoX + orderInfo1cX + 2);
                orderInfoElement1c.setY(30);
                orderInfoElement1c.setRow(1);
                orderInfoElement1c.setRowWidth(500 - (orderInfoGrouponNoX + orderInfo1cX + 15));

                //第二单
                TextElement orderInfoElement2a = new TextElement();
                orderInfoElement2a.setId("orderInfo2a");
                orderInfoElement2a.setText("第");
                orderInfoElement2a.setColor(new Color(255, 255, 255));
                orderInfoElement2a.setX(190);
                orderInfoElement2a.setY(62);
                orderInfoElement2a.setFont(getDefalutFont().deriveFont(Font.PLAIN, 19));

                TextElement orderInfoElement2b = new TextElement();
                orderInfoElement2b.setId("orderInfo2b");
                orderInfoElement2b.setText(String.valueOf(shareOrder.getBeforeShareOrders().get(0).getOrderGrouponNo()));
                orderInfoElement2b.setColor(new Color(255, 236, 22));
                orderInfoElement2b.setX(orderInfoGrouponNoX);
                orderInfoElement2b.setY(62);
                orderInfoElement2b.setFont(getDefalutFont().deriveFont(Font.BOLD, 28));

                int orderInfo2cX = (int) orderInfoElement2b.getStringBounds().getWidth();
                TextElement orderInfoElement2c = new TextElement();
                orderInfoElement2c.setId("orderInfo2c");
                orderInfoElement2c.setColor(new Color(255, 255, 255));
                orderInfoElement2c.setFont(getDefalutFont().deriveFont(Font.PLAIN, 19));
                orderInfoElement2c.setText(StringUtils.join("单买了", shareOrder.getBeforeShareOrders().get(0).getGoodsDescription()));
                orderInfoElement2c.setX(orderInfoGrouponNoX + orderInfo2cX + 2);
                orderInfoElement2c.setY(62);
                orderInfoElement2c.setRow(1);
                orderInfoElement2c.setRowWidth(500 - (orderInfoGrouponNoX + orderInfo2cX + 15));

                rootElement.addElement(orderInfoElement1a);
                rootElement.addElement(orderInfoElement1b);
                rootElement.addElement(orderInfoElement1c);
                rootElement.addElement(orderInfoElement2a);
                rootElement.addElement(orderInfoElement2b);
                rootElement.addElement(orderInfoElement2c);
            }


            if (size == 1) {
                //商品图片234 * 193
                ImageElement merchandiseImageElement = new ImageElement();
                merchandiseImageElement.setId("merchandiseImage");
                merchandiseBufferedImage = getBufferedImageRegion(shareOrderMerchdies.get(0).getImage(), 234, 193);
                if (null != merchandiseBufferedImage) {
                    merchandiseImageElement.setBufferedImage(merchandiseBufferedImage);
                }
                merchandiseImageElement.setWidth(231);
                merchandiseImageElement.setHeight(231);
                merchandiseImageElement.setBorder(0);
                merchandiseImageElement.setX(38);
                merchandiseImageElement.setY(146);
                rootElement.addElement(merchandiseImageElement);

                //订单接龙信息（商品标题）
                TextElement merchandiseTitleElement = new TextElement();
                merchandiseTitleElement.setId("merchandiseTitle");
                merchandiseTitleElement.setText(StringUtils.join(shareOrderMerchdies.get(0).getAbbreviation()));
                merchandiseTitleElement.setColor(new Color(51, 51, 51));
                merchandiseTitleElement.setX(288);
                merchandiseTitleElement.setY(183);
                merchandiseTitleElement.setRow(2);
                merchandiseTitleElement.setRowWidth(162);
                merchandiseTitleElement.setFont(getDefalutFont().deriveFont(Font.BOLD, 29));
                rootElement.addElement(merchandiseTitleElement);

                //订单接龙信息（商品金额）
                TextElement merchandisePriceElement = new TextElement();
                merchandisePriceElement.setId("merchandisePrice");
                merchandisePriceElement.setText(StringUtils.join("¥", shareOrderMerchdies.get(0).getPrice()));
                merchandisePriceElement.setColor(new Color(254, 51, 34));
                merchandisePriceElement.setX(289);
                merchandisePriceElement.setY(272);
                merchandisePriceElement.setFont(getDefalutFont().deriveFont(Font.BOLD, 28));
                rootElement.addElement(merchandisePriceElement);

                Document document = Document.createDocument(rootElement);
                BufferedImage draw = ImageUtils.draw(document);
                merchandiseImageElement.clear();
                //rootElement.clear();
                return draw;
            } else if (size == 2) {

                Document document = Document.createDocument(rootElement);
                Thumbnails.Builder builder = Thumbnails.of(ImageUtils.draw(document)).scale(1);
                //使用后清理
                //rootElement.clear();
                //左边白色背景图
                String leftBgPath = "/share/white253.png";
                leftBg = ShareImageUtils.class.getResourceAsStream(leftBgPath);
                //线上环境
                if (leftBg != null) {
                    builder.watermark(PositionType.TWO_LEFT_WHITE_BG, Thumbnails.of(leftBg).scale(1).asBufferedImage(), 1);
                } else {
                    //本地Main测试使用
                    builder.watermark(PositionType.TWO_LEFT_WHITE_BG, ImageIO.read(new File(leftBgPath)), 1);
                }
                //左边商品图片
                ShareOrderMerchdies shareOrderMerchdies1 = shareOrderMerchdies.get(0);
                leftMerchanise = getBufferedImageRegion(shareOrderMerchdies1.getImage(), 230, 230);
                builder.watermark(PositionType.TWO_LEFT_MER, leftMerchanise, 1);
                //左边商品价格
                priceImage = createPrice(shareOrderMerchdies1);
                builder.watermark(PositionType.TWO_LEFT_PRICE, priceImage, 1);

                //右边的处理 先拼出整体再旋
                Thumbnails.Builder builderRight = null;

                //右边白色背景
                String rightBgPath = "/share/white235.png";
                rightBg = ShareImageUtils.class.getResourceAsStream(rightBgPath);
                //线上环境
                if (rightBg != null) {
                    builderRight = Thumbnails.of(rightBg).scale(1);
                } else {
                    //本地Main测试使用
                    builderRight = Thumbnails.of(ImageIO.read(new File(rightBgPath))).scale(1);
                }
                //右边商品图片
                ShareOrderMerchdies shareOrderMerchdies2 = shareOrderMerchdies.get(1);
                rightMerchanise = getBufferedImageRegion(shareOrderMerchdies2.getImage(), 214, 214);
                builderRight.watermark(PositionType.TWO_RIGHT_MER, rightMerchanise, 1);

                builder.watermark(PositionType.TWO_RIGHT_IMAGE, builderRight.rotate(15).asBufferedImage(), 1);

                //右边商品价格
                rightPriceImage = createRotatePrice(shareOrderMerchdies2);
                BufferedImage bufferedImage = builder.watermark(PositionType.TWO_RIGHT_PRICE, rightPriceImage, 1).asBufferedImage();
                builder = null;
                return bufferedImage;
                //builderRight.watermark(PositionType.TWO_RIGHT_PRICE,rightPriceImage,1);
                //return builder.asBufferedImage();
                //return builder.asBufferedImage();

                //Document document = Document.createDocument(rootElement);
                //return Thumbnails.of(ImageUtils.draw(document)).scale(1).asBufferedImage();
                //return Thumbnails.of(ImageUtils.draw(document)).watermark(PositionType.DEST_bb,createPrice(shareOrder),1).scale(1).asBufferedImage();
            } else {

                Document document = Document.createDocument(rootElement);
                Thumbnails.Builder builder = Thumbnails.of(ImageUtils.draw(document)).scale(1);
                //rootElement.clear();

                //左边整体背景
                Thumbnails.Builder leftBuilder;
                left1BgImageInputStream = ShareImageUtils.class.getResourceAsStream("/share/white200.png");
                if (left1BgImageInputStream != null) {
                    leftBuilder = Thumbnails.of(left1BgImageInputStream);
                } else {
                    leftBuilder = Thumbnails.of((ImageIO.read(new File("/share/white200.png"))));
                }

                //左边商品
                leftBuilder.watermark(PositionType.THREE_LEFT_MER, getBufferedImageRegion(shareOrderMerchdies.get(0).getImage(), 184, 184), 1);
                //左边价格
                //右边商品价格
                leftPriceImage = createPrice(shareOrderMerchdies.get(0));
                leftBuilder.watermark(PositionType.THREE_LETT_PRICE, leftPriceImage, 1);
                builder.watermark(PositionType.THREE_LEFT_WHITE_BG, leftBuilder.scale(1).rotate(15).asBufferedImage(), 1);


                //中间整体背景
                Thumbnails.Builder centerBuilder;
                centerBgImageInputStream = ShareImageUtils.class.getResourceAsStream("/share/white253.png");
                if (left1BgImageInputStream != null) {
                    centerBuilder = Thumbnails.of(centerBgImageInputStream);
                } else {
                    centerBuilder = Thumbnails.of((ImageIO.read(new File("/share/white253.png"))));
                }

                //中间商品
                centerBuilder.watermark(PositionType.THREE_CENTER_MER, getBufferedImageRegion(shareOrderMerchdies.get(1).getImage(), 229, 229), 1);

                //中间商品价格
//                BufferedImage centerPriceImage = createPrice(shareOrderMerchdies.get(1));
//                centerBuilder.watermark(PositionType.THREE_CENTER_PRICE,centerPriceImage,1);
                builder.watermark(PositionType.THREE_CENTER_WHITE_BG, centerBuilder.scale(1).asBufferedImage(), 1);

                //右边整体背景
                Thumbnails.Builder rightBuilder;
                rightBgImageInputStream = ShareImageUtils.class.getResourceAsStream("/share/white235.png");
                if (rightBgImageInputStream != null) {
                    rightBuilder = Thumbnails.of(rightBgImageInputStream);
                } else {
                    rightBuilder = Thumbnails.of((ImageIO.read(new File("/share/white235.png"))));
                }

                //右边商品
                rightBuilder.watermark(PositionType.TWO_RIGHT_MER, getBufferedImageRegion(shareOrderMerchdies.get(2).getImage(), 214, 214), 1);


                //rightBuilder.watermark(PositionType.THREE_RIGHT_PRICE,rightPriceImage,1);
                builder.watermark(PositionType.THREE_RIGHT_MER, rightBuilder.scale(1).rotate(15).asBufferedImage(), 1);

                //中间商品价格
                centerPriceImage = createPrice(shareOrderMerchdies.get(1));
                builder.watermark(PositionType.THREE_CENTER_PRICE, centerPriceImage, 1);
                //右边商品价格
                rightPriceImage = createRotatePrice(shareOrderMerchdies.get(2));
                BufferedImage bufferedImage = builder.watermark(PositionType.THREE_RIGHT_PRICE, Thumbnails.of(rightPriceImage).scale(1).asBufferedImage(), 1).asBufferedImage();
                builder = null;
                return bufferedImage;

            }

        } catch (Exception e) {
            System.out.println("生成图片失败");
            throw new NullPointerException();
        } finally {
            close(leftBg);
            close(rightBg);
            close(rootBackbroundImageInputStream);
            close(priceImageInputStream);
            close(left1BgImageInputStream);
            close(centerBgImageInputStream);
            close(rightBgImageInputStream);

            //return null;

            merchandiseBufferedImage = null;
            leftMerchanise = null;
            priceImage = null;
            rightMerchanise = null;
            rightPriceImage = null;
            centerPriceImage = null;
            leftPriceImage = null;

        }

    }

    /**
     * @description: 创建背景元素并添加文本信息
     * @param shareOrder 订单信息
     * @return: ImageElement 根元素
     * @date: 2019-04-15 15:41
     * @auther: sgy
     *
     */
    public static ImageElement createBackground(ShareOrder shareOrder) {

        InputStream rootBackbroundImageInputStream = null;

        int orderGrouponNo = shareOrder.getOrderGrouponNo();
        java.util.List<ShareOrderMerchdies> shareOrderMerchdies = shareOrder.getShareOrderMerchdies();
        if (CollectionUtils.isNullOrEmpty(shareOrderMerchdies)) {
            throw new NullPointerException();
        }

        try {

            int index = (shareOrderMerchdies.size() == 1 ? 1 : 2);
            String backgroundImagePath = StringUtils.join("/share/new_share_", index, ".png");
            //String backgroundImagePath = StringUtils.join("/share/share_order_bg_", size, ".png");

            //背景图（500 * 400）
            rootBackbroundImageInputStream = ShareImageUtils.class.getResourceAsStream(backgroundImagePath);

            //背景图根元素
            ImageElement rootElement = new ImageElement();
            rootElement.setId("backgroundImage");

            //线上环境
            if (rootBackbroundImageInputStream != null) {
                rootElement.setImageStream(rootBackbroundImageInputStream);
            } else {
                //本地Main测试使用
                rootElement.setBufferedImage(ImageIO.read(new File(backgroundImagePath)));
            }

            //用户订单序号（grouponNo）
            TextElement orderGrouponNoElement = new TextElement();
            orderGrouponNoElement.setId("orderGrouponNo");
            orderGrouponNoElement.setText(StringUtils.join("第", orderGrouponNo, "单"));
            orderGrouponNoElement.setColor(new Color(255, 255, 255));
            int orderGrouponNoX = 16;
            int orderGrouponNoY = 95;
            if (orderGrouponNo < 10) {
                orderGrouponNoX = 30;
                orderGrouponNoY = 91;
            } else if (orderGrouponNo >= 10 && orderGrouponNo <= 99) {
                orderGrouponNoX = 22;
                orderGrouponNoY = 93;
            }
            orderGrouponNoElement.setX(orderGrouponNoX);
            orderGrouponNoElement.setY(orderGrouponNoY);
            orderGrouponNoElement.setDegree(-14);//旋转角度
            orderGrouponNoElement.setFont(getDefalutFont().deriveFont(Font.BOLD, 28));
            rootElement.addElement(orderGrouponNoElement);


            //订单接龙信息（前2单信息）第一行
            //第一个下单人分享时，右上角的文案：我是第一个下单的，团长快来接单～
            //第二个下单人分享时，右上角的文案：？？？
            if (orderGrouponNo <= 2) {
                String orderInfo1Text = "我是第一个下单的";
                if (orderGrouponNo == 2) {
                    orderInfo1Text = "我是第二个下单的";
                }
                TextElement orderInfoElement1 = new TextElement();
                orderInfoElement1.setId("orderInfo1");
                orderInfoElement1.setText(orderInfo1Text);
                orderInfoElement1.setColor(new Color(255, 255, 255));
                orderInfoElement1.setX(190);//为0时自动居中
                orderInfoElement1.setY(30);
                orderInfoElement1.setFont(getDefalutFont().deriveFont(Font.BOLD, 19));

                //订单接龙信息（前2单信息）第二行
                TextElement orderInfoElement2 = new TextElement();
                orderInfoElement2.setId("orderInfo2");
                orderInfoElement2.setText(StringUtils.join("团长快来接单～"));
                orderInfoElement2.setColor(new Color(255, 255, 255));
                orderInfoElement2.setX(190);//为0时自动居中
                orderInfoElement2.setY(62);
                orderInfoElement2.setFont(getDefalutFont().deriveFont(Font.BOLD, 19));

                rootElement.addElement(orderInfoElement1);
                rootElement.addElement(orderInfoElement2);
            } else if (!CollectionUtils.isNullOrEmpty(shareOrder.getBeforeShareOrders())
                    && shareOrder.getBeforeShareOrders().size() >= 2) {

                //订单序号x起始值
                int orderInfoGrouponNoX = 210;

                //第一单
                TextElement orderInfoElement1a = new TextElement();
                orderInfoElement1a.setId("orderInfo1a");
                orderInfoElement1a.setText("第");
                orderInfoElement1a.setColor(new Color(255, 255, 255));
                orderInfoElement1a.setX(190);
                orderInfoElement1a.setY(30);
                orderInfoElement1a.setFont(getDefalutFont().deriveFont(Font.PLAIN, 19));

                TextElement orderInfoElement1b = new TextElement();
                orderInfoElement1b.setId("orderInfo1b");
                orderInfoElement1b.setText(String.valueOf(shareOrder.getBeforeShareOrders().get(1).getOrderGrouponNo()));
                orderInfoElement1b.setColor(new Color(255, 236, 22));
                orderInfoElement1b.setX(orderInfoGrouponNoX);
                orderInfoElement1b.setY(30);
                orderInfoElement1b.setFont(getDefalutFont().deriveFont(Font.BOLD, 28));

                //订单序号宽度
                int orderInfo1cX = (int) orderInfoElement1b.getStringBounds().getWidth();
                TextElement orderInfoElement1c = new TextElement();
                orderInfoElement1c.setId("orderInfo1c");
                orderInfoElement1c.setColor(new Color(255, 255, 255));
                orderInfoElement1c.setFont(getDefalutFont().deriveFont(Font.PLAIN, 19));
                orderInfoElement1c.setText(StringUtils.join("单买了", shareOrder.getBeforeShareOrders().get(1).getGoodsDescription()));
                orderInfoElement1c.setX(orderInfoGrouponNoX + orderInfo1cX + 2);
                orderInfoElement1c.setY(30);
                orderInfoElement1c.setRow(1);
                orderInfoElement1c.setRowWidth(500 - (orderInfoGrouponNoX + orderInfo1cX + 15));

                //第二单
                TextElement orderInfoElement2a = new TextElement();
                orderInfoElement2a.setId("orderInfo2a");
                orderInfoElement2a.setText("第");
                orderInfoElement2a.setColor(new Color(255, 255, 255));
                orderInfoElement2a.setX(190);
                orderInfoElement2a.setY(62);
                orderInfoElement2a.setFont(getDefalutFont().deriveFont(Font.PLAIN, 19));

                TextElement orderInfoElement2b = new TextElement();
                orderInfoElement2b.setId("orderInfo2b");
                orderInfoElement2b.setText(String.valueOf(shareOrder.getBeforeShareOrders().get(0).getOrderGrouponNo()));
                orderInfoElement2b.setColor(new Color(255, 236, 22));
                orderInfoElement2b.setX(orderInfoGrouponNoX);
                orderInfoElement2b.setY(62);
                orderInfoElement2b.setFont(getDefalutFont().deriveFont(Font.BOLD, 28));

                int orderInfo2cX = (int) orderInfoElement2b.getStringBounds().getWidth();
                TextElement orderInfoElement2c = new TextElement();
                orderInfoElement2c.setId("orderInfo2c");
                orderInfoElement2c.setColor(new Color(255, 255, 255));
                orderInfoElement2c.setFont(getDefalutFont().deriveFont(Font.PLAIN, 19));
                orderInfoElement2c.setText(StringUtils.join("单买了", shareOrder.getBeforeShareOrders().get(0).getGoodsDescription()));
                orderInfoElement2c.setX(orderInfoGrouponNoX + orderInfo2cX + 2);
                orderInfoElement2c.setY(62);
                orderInfoElement2c.setRow(1);
                orderInfoElement2c.setRowWidth(500 - (orderInfoGrouponNoX + orderInfo2cX + 15));

                rootElement.addElement(orderInfoElement1a);
                rootElement.addElement(orderInfoElement1b);
                rootElement.addElement(orderInfoElement1c);
                rootElement.addElement(orderInfoElement2a);
                rootElement.addElement(orderInfoElement2b);
                rootElement.addElement(orderInfoElement2c);
            }

            return rootElement;

        } catch (Exception e) {
            System.out.println("生成图片失败");
            throw new NullPointerException();
        } finally {
            close(rootBackbroundImageInputStream);
        }
    }

    private static BufferedImage createRotatePrice(ShareOrderMerchdies shareOrderMerchdies) {
        String backgroundImagePath = "/share/price3.png";
        //InputStream rootBackbroundImageInputStream = priceImageInputStream;
        InputStream priceImageInputStream = ShareImageUtils.class.getResourceAsStream(backgroundImagePath);

        //背景图根元素
        ImageElement rootElement = new ImageElement();
        rootElement.setId("backgroundImage");

        try {
            //线上环境
            if (priceImageInputStream != null) {
                rootElement.setImageStream(priceImageInputStream);
            } else {
                //本地Main测试使用
                rootElement.setBufferedImage(ImageIO.read(new File(backgroundImagePath)));
            }

            //订单接龙信息（商品2金额）
            TextElement merchandisePriceElement2 = new TextElement();
            merchandisePriceElement2.setId("merchandisePrice2");
            merchandisePriceElement2.setText(StringUtils.join("¥", shareOrderMerchdies.getPrice()));
            merchandisePriceElement2.setColor(new Color(255, 255, 255));
            merchandisePriceElement2.setX(12);
            merchandisePriceElement2.setY(29);
            merchandisePriceElement2.setFont(getDefalutFont().deriveFont(Font.BOLD, 27));
            merchandisePriceElement2.setDegree(15);
            rootElement.addElement(merchandisePriceElement2);

            Document document = Document.createDocument(rootElement);
            BufferedImage draw = ImageUtils.draw(document);
            //rootElement.clear();
            return draw;
            //ImageIO.write(ShareImageUtils.createShareOrderImage(order), "png", new FileOutputStream(saveFilePath));
        } catch (Exception e) {
            System.out.println( "生成图片失败");
            throw new NullPointerException();
        } finally {
            close(priceImageInputStream);
        }

    }

    private static BufferedImage createPrice(ShareOrderMerchdies shareOrderMerchdies) {
        String backgroundImagePath = "/share/pricebg.png";
        //InputStream rootBackbroundImageInputStream = priceImageInputStream;
        InputStream priceImageInputStream = ShareImageUtils.class.getResourceAsStream(backgroundImagePath);

        //背景图根元素
        ImageElement rootElement = new ImageElement();
        rootElement.setId("backgroundImage");

        try {
            //线上环境
            if (priceImageInputStream != null) {
                rootElement.setImageStream(priceImageInputStream);
            } else {
                //本地Main测试使用
                rootElement.setBufferedImage(ImageIO.read(new File(backgroundImagePath)));
            }

            //订单接龙信息（商品2金额）
            TextElement merchandisePriceElement2 = new TextElement();
            merchandisePriceElement2.setId("merchandisePrice2");
            merchandisePriceElement2.setText(StringUtils.join("¥", shareOrderMerchdies.getPrice()));
            merchandisePriceElement2.setColor(new Color(255, 255, 255));
            merchandisePriceElement2.setX(12);
            merchandisePriceElement2.setY(29);
            merchandisePriceElement2.setFont(getDefalutFont().deriveFont(Font.BOLD, 27));
            rootElement.addElement(merchandisePriceElement2);

            Document document = Document.createDocument(rootElement);
            BufferedImage draw = ImageUtils.draw(document);
            //rootElement.clear();
            return draw;
            //ImageIO.write(ShareImageUtils.createShareOrderImage(order), "png", new FileOutputStream(saveFilePath));
        } catch (Exception e) {
            System.out.println("生成图片失败");
            throw new NullPointerException();
        } finally {
            close(priceImageInputStream);
        }

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
