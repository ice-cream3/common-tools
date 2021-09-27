package picture;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 图片元素
 */
public abstract class Element {

    /**
     * ID
     */
    private String id;

    /**
     * 2D
     */
    protected Graphics2D graphics2D;

    /**
     * 左上角X坐标
     */
    protected int x = 0;

    /**
     * 左上角Y坐标
     */
    protected int y = 0;

    /**
     * 宽度
     */
    protected int width = 0;

    /**
     * 高度
     */
    protected int height = 0;

    /**
     * 元素颜色
     */
    protected Color color;

    /**
     * 边框
     */
    protected int border = 0;

    /**
     * 横向对齐格式
     */
    protected int horizontalAlign = 0;

    /**
     * 纵向对齐格式
     */
    protected int verticalAlign = 0;

    /**
     * 旋转角度
     */
    protected int degree;

    /**
     * 子元素列表
     */
    protected List<Element> elementList = new ArrayList<>();
    /**
     * PNG
     */
    protected List<Element> pngElementList = new ArrayList<>();

    public abstract void draw(Element parent) throws Exception;

    protected void drawChildren(Element parent) throws Exception {
        for (Element each : elementList) {
            each.draw(parent);
        }
    }

    public void addElement(Element element) {
        elementList.add(element);
    }

    public void addPngElement(Element element) {
        pngElementList.add(element);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Graphics2D getGraphics2D() {
        return graphics2D;
    }

    public void setGraphics2D(Graphics2D graphics2D) {
        this.graphics2D = graphics2D;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getBorder() {
        return border;
    }

    public void setBorder(int border) {
        this.border = border;
    }

    public int getHorizontalAlign() {
        return horizontalAlign;
    }

    public void setHorizontalAlign(int horizontalAlign) {
        this.horizontalAlign = horizontalAlign;
    }

    public int getVerticalAlign() {
        return verticalAlign;
    }

    public void setVerticalAlign(int verticalAlign) {
        this.verticalAlign = verticalAlign;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public List<Element> getElementList() {
        return elementList;
    }

    public void setElementList(List<Element> elementList) {
        this.elementList = elementList;
    }
}
