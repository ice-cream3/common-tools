package picture;

import net.coobird.thumbnailator.geometry.Position;

import java.awt.*;

public enum PositionType implements Position {

    BOTTOM {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(0, 194);
        }
    },

    TOP {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(0, 0);
        }
    },

    //底图加水印时需要y增加1像素
    TOP_Y1 {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(0, 1);
        }
    },

    //两张图片时候左边商品价格坐标
    TWO_LEFT_PRICE {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(9, 317);
        }
    },

    //两张图片时候左边商品图片坐标
    TWO_LEFT_MER {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(28, 138);
        }
    },

    //两张图片时候左边白色背景坐标
    TWO_LEFT_WHITE_BG {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(17, 126);
        }
    },
    //三张图片时候左边白色背景坐标
    THREE_LEFT_WHITE_BG {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(-33, 133);
        }
    },

    //三张图片时候中间白色背景坐标
    THREE_CENTER_WHITE_BG {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(129, 125);
        }
    },

    //三张图片时候左边商品坐标
    THREE_LEFT_MER {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(8, 8);
        }
    },

    //三张图片时候右边商品坐标
    THREE_RIGHT_MER {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(308, 94);
        }
    },

    //三张图片时候中间商品坐标
    THREE_CENTER_MER {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(11, 12);
        }
    },

    //两张图片时候右边白色背景坐标
    TWO_RIGHT_WHITE_BG {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(215, 95);
        }
    },

    //两张图片时候右边商品坐标
    TWO_RIGHT_MER {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(11, 12);
        }
    },

    //两张图片时候右边商品价格坐标
    TWO_RIGHT_PRICE {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(209, 265);
        }
    },


    //三张图片时候左边商品价格坐标
    THREE_LETT_PRICE {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(-7, 138);
        }
    },

    //三张图片时候中间商品价格坐标
    THREE_CENTER_PRICE {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(121, 315);
        }
    },


    //三张图片时候右边商品价格坐标
    THREE_RIGHT_PRICE {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(306, 263);
        }
    },

    //两张图片时候右边完整图片坐标
    TWO_RIGHT_IMAGE {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(211, 95);
        }
    },

    //===========================我是分割线==================================
    DEST_PRICE {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(9, 317);
        }
    },

    DEST_bb {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(-50, 160);
        }
    },


    DEST {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(27, 134);
        }
    },

    CENTER {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(10, 10);
        }
    },

    DEMO_MONEY {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(2, 160);
        }
    },


    QRCODE {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(83, 666);
        }
    },

    TOP_PARTNER {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(10, 14);
        }
    },

    TOP_MAP {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(30 * 2, 32);
        }
    },

    TOP_M1 {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(10, 88);
        }
    },

    TOP_M2 {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(67 * 2, 88);
        }
    },

    TOP_M3 {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(129 * 2, 88);
        }
    },

    TOP_MONEY1 {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(13 * 2, 96 * 2);
        }
    },

    TOP_MONEY2 {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(74 * 2, 96 * 2);
        }
    },

    TOP_MONEY3 {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(138 * 2, 96 * 2);
        }
    },

    TOP_HEAD1 {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(5 * 2, 123 * 2);
        }
    },

    TOP_HEAD2 {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(15 * 2, 123 * 2);
        }
    },

    TOP_HEAD3 {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(25 * 2, 123 * 2);
        }
    },
    TOP_JOIN_HEAD1 {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(0, 0);
        }
    },

    TOP_JOIN_HEAD2 {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(100 * 1, 0);
        }
    },

    TOP_JOIN_HEAD3 {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(100 * 2, 0);
        }
    },

    BOTTOM_PARTNER_HEAD {
        @Override
        public Point calculate(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
            return new Point(0, 203);
        }
    };

    private PositionType() {
    }
}
