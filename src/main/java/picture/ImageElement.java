package picture;

import org.apache.commons.io.IOUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.*;

public class ImageElement extends Element {

    /**
     * 图片
     */
    protected BufferedImage image;

    @Override
    public void draw(Element parent) throws Exception {

        // 生成图片
        generateImage();

        // 画图
        drawImage(parent);

        // 画图PGN
        drawPng();
    }


    private void generateImage() throws Exception {
        if (width <= 0) {
            width = image.getWidth();
        }
        if (height <= 0) {
            height = image.getHeight();
        }
    }

    protected void drawImage(Element parent) throws Exception {
        // 自动计算X值
        autoX(parent);
        autoY(parent);

        // 调用子节点的画图方法
        drawChildren(parent);

        // 再画自己
        drawMyself(parent);
    }

    private void autoX(Element parent) {
        if (x <= 0 && parent != null) {
            // 没有设置x的值则自动计算
            x = (parent.getWidth() - width) / 2;
        }
    }

    private void autoY(Element parent) {
        if (y <= 0 && parent != null) {
            // 没有设置x的值则自动计算
            y = (parent.getHeight() - height) / 2;
        }
    }

    /**
     * 调用子节点画图
     *
     * @param parent
     * @throws Exception
     */
    protected void drawChildren(Element parent) throws Exception {
        int size = elementList.size();
        if (size > 0) {
            graphics2D = image.createGraphics();
            super.drawChildren(this);
            graphics2D.dispose();
        }
    }

    /**
     * 画自己
     *
     * @param parent
     * @throws Exception
     */
    protected void drawMyself(Element parent) throws Exception {
        if (getBorder() > 0) {
            drawWithBorder(parent);
        } else {
            drawWithoutBorder(parent);
        }
    }

    private void drawWithBorder(Element parent) throws IOException {
        if (parent == null) {
            // 根节点
            throw new UnsupportedOperationException("cannot support root with border");
        } else {
            // 普通节点
            parent.getGraphics2D().drawRect(x, y, width, height);
            parent.getGraphics2D().setStroke(new BasicStroke(border));
            parent.getGraphics2D().setColor(color);

            //旋转
            if (degree != 0) {
                rotate(parent);
            } else {
                parent.getGraphics2D().drawImage(image, x + border, y + border, width - border * 2, height - border * 2, color, null);
            }
        }
    }

    private void drawWithoutBorder(Element parent) throws IOException {
        if (parent == null) {
            // 根节点
        } else {
            // 普通节点
            parent.getGraphics2D().setColor(color);

            //旋转
            if (degree != 0) {
                rotate(parent);
            } else {
                parent.getGraphics2D().drawImage(image, x, y, width, height, color, null);
            }

        }
    }

    /**
     * 图片旋转，degree为旋转角度
     *
     * @param parent
     */
    private void rotate(Element parent) {

        // 角度计算
        degree = degree % 360;
        if (degree < 0) {
            degree = 360 + degree;
        }

        //将角度转换为弧度
        double radian = Math.toRadians(degree);

        //原始宽高
        int originalImWidth = image.getWidth();
        int originalImHeight = image.getHeight();

        //周转宽高
        double cosVal = Math.abs(Math.cos(radian));
        double sinVal = Math.abs(Math.sin(radian));
        int rotateImWidth = (int) (sinVal * originalImHeight) + (int) (cosVal * originalImWidth);
        int rotateImHeight = (int) (sinVal * originalImWidth) + (int) (cosVal * originalImHeight);

        //计算点坐标
        int x = (rotateImWidth / 2) - (originalImWidth / 2);
        int y = (rotateImHeight / 2) - (originalImHeight / 2);

        //创建旋转图像
        BufferedImage rotatedImage = new BufferedImage(rotateImWidth, rotateImHeight, image.getType());
        Graphics2D graphics2D = (Graphics2D) rotatedImage.getGraphics();
        graphics2D.fillRect(0, 0, rotateImWidth, rotateImHeight);

        //旋转图像
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.rotate(radian, rotateImWidth / 2, rotateImHeight / 2);
        affineTransform.translate(x, y);

        AffineTransformOp affineTransformOp = new AffineTransformOp(affineTransform, AffineTransformOp.TYPE_BICUBIC);
        affineTransformOp.filter(image, rotatedImage);
        parent.getGraphics2D().drawImage(rotatedImage, getX(), getY(), originalImWidth, originalImHeight, color, null);
    }

    private void drawPng() {

        if (pngElementList.size() == 0) {
            return;
        }

        Graphics2D graphics2DNew = image.createGraphics();
        BufferedImage imageNew = graphics2DNew.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
        graphics2DNew.dispose();

        graphics2DNew = imageNew.createGraphics();
        graphics2DNew.drawImage(image, 0, 0, width, height, null);

        for (Element element : pngElementList) {
            ImageElement imageElement = (ImageElement) element;
            if (imageElement.getImage() == null) {
                continue;
            }
            graphics2DNew.drawImage(imageElement.getImage(), imageElement.getX(), imageElement.getY(), imageElement.getWidth(), imageElement.getHeight(), null);
        }
        image = imageNew;
    }

    public void setFile(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            this.image = ImageIO.read(bufferedInputStream);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            IOUtils.closeQuietly(fileInputStream);
            IOUtils.closeQuietly(bufferedInputStream);
        }
    }

    public void setImageStream(InputStream imageStream) throws IOException {
        if (imageStream == null) {
            return;
        }
        this.image = ImageIO.read(imageStream);
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        if (bufferedImage == null) {
            return;
        }
        this.image = bufferedImage;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void clear() {
        try {
            this.image = null;
            graphics2D = null;
            elementList = null;
            pngElementList = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
