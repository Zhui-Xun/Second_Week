package MARKET;

public class Market_Creat {

    // ˽�г�Ա����
    private String Market_Name;         // ��������
    private String Market_Address;      // ���е�ַ
    public int Market_Commodity_Number; // ��Ʒ����
    public int Market_Parking_Number;  // ͣ��λ����
    // ������Ա����
    public double Market_incomingSum;           // Ӫҵ����
    public Commodity_Create[] Market_Commodity; // ��Ʒ����
    public int[] Market_Commodity_Sold;         // �۳���Ʒ


    // >> TODO ���췽��
    public Market_Creat(String MarketName, String MarketAddress, int MarketProductsNumber, int MarketParkingNumber) {

        this.Market_Name = MarketName;
        this.Market_Address = MarketAddress;
        this.Market_Commodity_Number = MarketProductsNumber;
        this.Market_Parking_Number = MarketParkingNumber;
        this.Market_incomingSum = 0;
        this.Market_Commodity = new Commodity_Create[MarketProductsNumber];
        this.Market_Commodity_Sold = new int[MarketProductsNumber];

    }

    // >> TODO ����

    // ��Ʒ����
    public Commodity_Create[] MK_Products_Generate(int ProductsNumber) {

        for (int i = 0; i < ProductsNumber; i++) {
            String name = "" + (i + 1);
            String id = "" + (i + 1);
            Commodity_Create product = new Commodity_Create(name, id, 200);
            Market_Commodity[i] = product;
        }
        return Market_Commodity;

    }


    // ��������
    public void MK_describe() {
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("\"" + Market_Name + "\"��ҵ��������ַ��\"" + Market_Address + "\"��" +
                "���й���\"" + Market_Commodity_Number + "\"����Ʒ��ͣ��λ��\"" + Market_Parking_Number + "\"������ӭ���ѡ����");
        System.out.println("-----------------------------------------------------------------------------------");
    }


    // >> TODO ˽�б����鿴
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
