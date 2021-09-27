package picture;

import java.util.List;

/**
 */
public class ShareOrder{

    /**
     * 当前用户订单序号
     */
    private int orderGrouponNo;
    /**
     * 当前用户订单订单描述
     */
    private String goodsDescription;
    /**
     * 该订单节省金额
     */
    private String economizeAmount;
    /**
     * 该订单下前三个商品
     */
    private List<ShareOrderMerchdies> shareOrderMerchdies;

    /**
     * 当前用户订单前两个订单
     */
    private List<ShareOrder> beforeShareOrders;

    private int numTotal;

    public int getNumTotal() {
        return numTotal;
    }

    public void setNumTotal(int numTotal) {
        this.numTotal = numTotal;
    }

    public int getOrderGrouponNo() {
        return orderGrouponNo;
    }

    public void setOrderGrouponNo(int orderGrouponNo) {
        this.orderGrouponNo = orderGrouponNo;
    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription;
    }

    public String getEconomizeAmount() {
        return economizeAmount;
    }

    public void setEconomizeAmount(String economizeAmount) {
        this.economizeAmount = economizeAmount;
    }

    public List<ShareOrderMerchdies> getShareOrderMerchdies() {
        return shareOrderMerchdies;
    }

    public void setShareOrderMerchdies(List<ShareOrderMerchdies> shareOrderMerchdies) {
        this.shareOrderMerchdies = shareOrderMerchdies;
    }

    public List<ShareOrder> getBeforeShareOrders() {
        return beforeShareOrders;
    }

    public void setBeforeShareOrders(List<ShareOrder> beforeShareOrders) {
        this.beforeShareOrders = beforeShareOrders;
    }
}
