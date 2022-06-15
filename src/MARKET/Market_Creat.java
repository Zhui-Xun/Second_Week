package MARKET;

public class Market_Creat {

    // 私有成员变量
    private String Market_Name;         // 超市名称
    private String Market_Address;      // 超市地址
    public int Market_Commodity_Number; // 商品数量
    public int Market_Parking_Number;  // 停车位数量
    // 公共成员变量
    public double Market_incomingSum;           // 营业收入
    public Commodity_Create[] Market_Commodity; // 商品数组
    public int[] Market_Commodity_Sold;         // 售出商品


    // >> TODO 构造方法
    public Market_Creat(String MarketName, String MarketAddress, int MarketProductsNumber, int MarketParkingNumber) {

        this.Market_Name = MarketName;
        this.Market_Address = MarketAddress;
        this.Market_Commodity_Number = MarketProductsNumber;
        this.Market_Parking_Number = MarketParkingNumber;
        this.Market_incomingSum = 0;
        this.Market_Commodity = new Commodity_Create[MarketProductsNumber];
        this.Market_Commodity_Sold = new int[MarketProductsNumber];

    }

    // >> TODO 方法

    // 商品生成
    public Commodity_Create[] MK_Products_Generate(int ProductsNumber) {

        for (int i = 0; i < ProductsNumber; i++) {
            String name = "" + (i + 1);
            String id = "" + (i + 1);
            Commodity_Create product = new Commodity_Create(name, id, 200);
            Market_Commodity[i] = product;
        }
        return Market_Commodity;

    }


    // 超市描述
    public void MK_describe() {
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("\"" + Market_Name + "\"开业啦！，地址：\"" + Market_Address + "\"，" +
                "超市共有\"" + Market_Commodity_Number + "\"种商品，停车位有\"" + Market_Parking_Number + "\"个，欢迎大家选购！");
        System.out.println("-----------------------------------------------------------------------------------");
    }


    // >> TODO 私有变量查看
    public String Get_MarketName() {
        return Market_Name;
    }

    public String Get_MarketAddress() {
        return Market_Address;
    }

    public int Get_MarketProductsNumber() {
        return Market_Commodity_Number;
    }

    public int Get_MarketParkingNumber() {
        return Market_Parking_Number;
    }


}
