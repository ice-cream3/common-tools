package picture;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class QrCodeImageElement extends ImageElement {

    /**
     * 二维码内容
     */
    private String content;

    @Override
    public void draw(Element parent) throws Exception {
        if (image == null) {
            // 生成图片
            generateImage();

            // 画图
            drawImage(parent);
        } else {
            // 直接导入
            super.draw(parent);
        }
    }

    /**
     * 画自己
     * @param parent
     * @throws Exception
     */
    @Override
    protected void drawMyself(Element parent) throws Exception {
        if (parent == null) {
            // 根节点
        } else {
            // 普通节点
            parent.getGraphics2D().setColor(color);
            parent.getGraphics2D().drawImage(image, x, y, width, height, color, null);
        }
    }

    protected void drawWithBorder(Element parent) throws IOException {
        throw new UnsupportedOperationException("cannnot support drawWithBorder for qrCode!");
    }

    private void generateImage() throws Exception {
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();

        Map hints = new HashMap();
        // 设置UTF-8， 防止中文乱码
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        // 设置二维码四周白色区域的大小
        hints.put(EncodeHintType.MARGIN,border);
        // 设置二维码的容错性
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);

        // 画二维码，记得调用multiFormatWriter.encode()时最后要带上hints参数，不然上面设置无效
        BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, width, height, hints);

        image = toBufferedImage(bitMatrix);
        if (width <= 0) {
            width = image.getWidth();
        }
        if (height <= 0) {
            height = image.getHeight();
        }
    }

    private BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
            }
        }
        return image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
