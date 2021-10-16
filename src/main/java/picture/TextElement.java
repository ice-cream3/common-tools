package picture;

import util.StringUtils;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.io.IOException;

/**
 */
public class TextElement extends Element {

    /**
     * 文字内容
     */
    private String text;

    /**
     * 文字字体
     */
    private Font font;

    /**
     * 是否给文字自动增加横线（删除线）
     */
    private boolean drawLine = false;
    /**
     * X1，Y1是确定直线的起始点，即横坐标为x1，纵坐标为y1的点。同理x2,y2确定直线的终点。
     */
    private int x1 = 0;
    private int y1 = 0;

    private int x2 = 0;
    private int y2 = 0;

    /**
     * 每行文字的宽度
     */
    private int rowWidth;
    /**
     * 在给定宽度里显示几行
     */
    private int row;
    /**
     * 文字超出给定宽度后是否使用省略号
     */
    private boolean rowEllipsis = true;

    @Override
    public void draw(Element parent) throws IOException {
        if (getBorder() > 0) {
            throw new UnsupportedOperationException("cannot support text with border");
        }
        parent.getGraphics2D().setColor(Color.WHITE);
        parent.getGraphics2D().setBackground(Color.WHITE);

        if (font != null) {

            //旋转
            if (degree != 0) {
                AffineTransform affineTransform = new AffineTransform();
                affineTransform.rotate(Math.toRadians(degree), 0, 0);
                Font rotatedFont = font.deriveFont(affineTransform);
                parent.getGraphics2D().setFont(rotatedFont);
            } else {
                parent.getGraphics2D().setFont(font);
            }

            // 根据字体宽度自动计算XY值
            autoX(parent);
            autoY(parent);
        }

        //消除锯齿状
        parent.getGraphics2D().setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        parent.getGraphics2D().setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        parent.getGraphics2D().setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        parent.getGraphics2D().setColor(color);

        //获取字符串 字符的总宽度
        int strWidth = getStringLength(parent);

        //获取字符高度
        int strHeight = getStringHeight(parent);

        //字符串总个数
        if (rowWidth > 0 && strWidth > rowWidth) {
            int rowstrnum = getRowStrNum(text.length(), strWidth);
            int rows = getRows(strWidth);

            //只显示指定行数
            int lines = rows;
            if (row > 0 && row < rows) {
                lines = row;
            }
            String temp = "";
            int loc_Y = y;
            for (int i = 0; i < lines; i++) {
                //获取各行的String
                if (i == rows - 1) {
                    //最后一行
                    temp = text.substring(i * rowstrnum, text.length());
                } else {
                    temp = text.substring(i * rowstrnum, i * rowstrnum + rowstrnum);
                }

                //换行的最后一行
                if (row > 0 && row < rows && i == lines - 1) {
                    if (rowEllipsis) {
                        temp = StringUtils.join(temp.substring(0, temp.length() - 2), "...");
                    }
                }

                if (i > 0) {
                    //第一行不需要增加字符高度，以后的每一行在换行的时候都需要增加字符高度
                    loc_Y = loc_Y + strHeight;
                }
                parent.getGraphics2D().drawString(temp, x, loc_Y);
            }
        } else {
            //直接绘制
            parent.getGraphics2D().drawString(text, x, y);
        }


        if (isDrawLine()) {

            //横向终点x2 = x + 当前字体宽度
            FontMetrics fm = parent.getGraphics2D().getFontMetrics(font);
            int x2 = x + fm.stringWidth(text);
            parent.getGraphics2D().drawLine(x1, y1, x2, y2);
        }

    }

    /**
     * 每一行字符的个数
     *
     * @param strnum
     * @param strWidth
     * @return
     */
    private int getRowStrNum(int strnum, int strWidth) {
        int rowstrnum = (rowWidth * strnum) / strWidth;
        return rowstrnum;
    }

    /**
     * 字符行数
     *
     * @param strWidth
     * @return
     */
    private int getRows(int strWidth) {
        int rows = 0;
        if (strWidth % rowWidth > 0) {
            rows = strWidth / rowWidth + 1;
        } else {
            rows = strWidth / rowWidth;
        }
        return rows;
    }

    /**
     * 字符串总宽度
     *
     * @param parent
     * @return
     */
    private int getStringLength(Element parent) {
        if (parent == null) {
            return 0;
        }
        char[] strcha = text.toCharArray();
        int strWidth = parent.getGraphics2D().getFontMetrics().charsWidth(strcha, 0, text.length());
        return strWidth;
    }

    /**
     * 字符串的边界
     *
     * @param font
     * @param text
     * @return
     */
    private static FontRenderContext FONT_RENDER_CONTEXT = new FontRenderContext(new AffineTransform(), true, true);

    public Rectangle getStringBounds() {
        if (font == null || StringUtils.isEmpty(text)) {
            return new Rectangle();
        }
        Rectangle rectangle = font.getStringBounds(text, FONT_RENDER_CONTEXT).getBounds();
        return rectangle;
    }

    /**
     * 字符高度
     *
     * @param parent
     * @return
     */
    private int getStringHeight(Element parent) {
        if (parent == null) {
            return 0;
        }
        int height = parent.getGraphics2D().getFontMetrics().getHeight();
        return height;
    }

    private void autoX(Element parent) {
        if (x <= 0 && parent != null) {
            // 没有设置横坐标则根据字体宽度自动计算
            FontMetrics fm = parent.getGraphics2D().getFontMetrics(font);
            width = fm.stringWidth(text);
            x = (parent.getWidth() - width) / 2;
        }
    }

    private void autoY(Element parent) {
        if (y <= 0 && parent != null) {
            // 没有设置横坐标则根据字体宽度自动计算
            FontMetrics fm = parent.getGraphics2D().getFontMetrics(font);
            int height = fm.getHeight();
            y = (parent.getHeight() - height) / 2;
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public boolean isDrawLine() {
        return drawLine;
    }

    public void setDrawLine(boolean drawLine) {
        this.drawLine = drawLine;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public int getRowWidth() {
        return rowWidth;
    }

    public void setRowWidth(int rowWidth) {
        this.rowWidth = rowWidth;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public boolean isRowEllipsis() {
        return rowEllipsis;
    }

    public void setRowEllipsis(boolean rowEllipsis) {
        this.rowEllipsis = rowEllipsis;
    }
}
