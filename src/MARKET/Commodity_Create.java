package MARKET;

import java.util.SplittableRandom;

public class Commodity_Create {

    private String Pro_name;
    private String Pro_id;
    private int Pro_count;
    private double Pro_purchaseprice;
    private double Pro_soldprice;

    // ���췽��
    public Commodity_Create() {
        this.Pro_name = null;
        this.Pro_id = null;
        this.Pro_count = 0;
        this.Pro_purchaseprice = 0;
        this.Pro_soldprice = 0;
    }

    // ���췽������
    public Commodity_Create(String name, String id, int count) {

        this.Pro_name = "��Ʒ" + name;
        this.Pro_id = "ID-" + id;
        this.Pro_count = count;
        this.Pro_purchaseprice = Math.random() * 200;
        this.Pro_soldprice = Pro_purchaseprice * (1 + Math.random());

    }

    public Commodity_Create(String name, String id, int count, double purchaseprice, double soldprice) {

        this.Pro_name = "��Ʒ" + name;
        this.Pro_id = "ID-" + id;
        this.Pro_count = count;
        this.Pro_purchaseprice = purchaseprice;
        this.Pro_soldprice = soldprice;

    }

    public static Commodity_Create[] Commodity_Create_list(int ProductNumber) {

        Commodity_Create merchandise_list[] = new Commodity_Create[ProductNumber];
        for (int i = 0; i < ProductNumber; i++) {
            String name = "00" + (i + 1);
            String id = "00" + (i + 1);
            merchandise_list[i] = new Commodity_Create(name, id, 200);
        }
        return merchandise_list;

    }


    // ��������
    public double profit() {
        double Profit = Pro_soldprice - Pro_purchaseprice;
        return Profit;
    }

    // ��Ʒ����
    public void describe() {
        System.out.println("����Ʒ��Ϊ��\"" + Pro_name + "\"����Ʒ���Ϊ��\"" + Pro_id + "\"��" +
                "����Ϊ��\"" + Pro_count + "\"��������Ϊ��\"" + Pro_purchaseprice + "\"���ۼ�Ϊ��\""
                + Pro_soldprice + "\"������Ϊ��\"" + profit() + "\"��");
    }

    // ˽�г�Ա��������
    public String Get_Pro_name() {
        return Pro_name;
    }

    public String Get_Pro_id() {
        return Pro_id;
    }

    public int Get_Pro_count() {
        return Pro_count;
    }

    public double Get_Pro_purchaseprice() {
        return Pro_purchaseprice;
    }

    public double Get_Pro_soldprice() {
        return Pro_soldprice;
    }

    // ���¿��
    public void Change_Count(int SoldNumber) {
        Pro_count = Pro_count - SoldNumber;
    }


}
