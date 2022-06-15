import MARKET.Commodity_Create;
import MARKET.Customer_Create;
import MARKET.Market_Creat;

import java.util.Scanner;

public class a_1_SuperMarket {
    public static void main(String[] args) {

        // 超市创建
        Market_Creat market = new Market_Creat("阳光超市", "上海市浦东新区666号", 200, 100);
        // 商品生成
        Commodity_Create[] All_Commodity = market.MK_Products_Generate(market.Get_MarketProductsNumber());
        // 超市介绍
        market.MK_describe();


        System.out.println("\n超市开门营业啦！\n");
        boolean open = true;
        // 创建输入
        Scanner scanner = new Scanner(System.in);

        // 主程序循环
        while (open) {
            // 创建顾客
            Customer_Create customer = Customer_Create.Customer_init();
            //System.out.println(customer.name);
            System.out.println("--------------------------------------------------------");
            // 是否接待顾客
            if (customer.isDrivingCar) {
                if (market.Get_MarketParkingNumber() > 0) {
                    System.out.println("欢迎" + customer.name + "光临，本店已经为您安排了车位，车位编号为" + market.Market_Parking_Number);
                    market.Market_Parking_Number--;
                } else {
                    System.out.println("本店车位已满，欢迎下次光临！");
                    continue;
                }
            }
            // 开始接待顾客
            double TotalCost = 0;
            System.out.println("欢迎\"" + customer.name + "\"，请您随意选购!");
            while (true) {
                System.out.println("请输入商品编号：(商品编号范围为\"1-" + market.Market_Commodity_Number + "\"，输入\"-1\"结束购物)");
                int merchandiseId = scanner.nextInt() - 1;
                // 输入负数，结束购买
                if (merchandiseId < 0) {
                    System.out.println("您本次共消费：\"" + TotalCost + "。欢迎再次光临!");
                    break;
                }
                // 商品编号超出范围，重新选择
                if (merchandiseId > market.Market_Commodity_Number) {
                    System.out.println("本店无此商品，欢迎继续挑选！\n");
                    continue;
                }
                // 商品有，问顾客要购买多少个
                Commodity_Create Buy = All_Commodity[merchandiseId];
                System.out.println("\"" + Buy.Get_Pro_name() + "\"，单价：\"" + Buy.Get_Pro_soldprice() + "\"。请问购买几个？");
                int numToBuy = scanner.nextInt();
                // 购买数量有误
                if (numToBuy <= 0) {
                    System.out.println("不买看看也好，欢迎继续选购！\n");
                    continue;
                }
                // 买的太多，库存不够
                if (Buy.Get_Pro_count() < numToBuy) {
                    System.out.println("\"" + Buy.Get_Pro_name() + "\"库存只有\"" + Buy.Get_Pro_count() + "\"个，数量不足\"" + numToBuy + "\"个。欢迎继续选购。");
                    continue;
                }
                // 顾客钱不够
                if (numToBuy * Buy.Get_Pro_soldprice() + TotalCost > customer.money) {
                    System.out.println("您带的钱不够结账，请您理智消费!\n");
                    continue;
                }

                // 钱也够，货也够。更新顾客此次消费的总额：
                TotalCost += numToBuy * Buy.Get_Pro_soldprice();
                System.out.println("您当前共消费：" + TotalCost + "。\n");
                // 更新商品库存
                Buy.Change_Count(numToBuy);
                // System.out.println("\"" + Buy.Get_Pro_name() + "\"的剩余库存为：\""+Buy.Get_Pro_count()+"\"个。");
                // 更新今日销货数据
                market.Market_Commodity_Sold[merchandiseId] += numToBuy;
            }
            System.out.println("--------------------------------------------------------\n");
            // 当前顾客消费结束，归还车位
            if (customer.isDrivingCar) {
                market.Market_Parking_Number++;
            }
            // 更新数据
            customer.money -= TotalCost;
            market.Market_incomingSum += TotalCost;
            System.out.println("\"" + customer.name + "\"共消费: \"" + TotalCost + "\"。欢迎再次光临。");

            System.out.println("\n请问继续营业吗？ \"true\" or \"false\"");
            String continueopen = scanner.next();
            if ("true".equals(continueopen)) {
                open = true;
            } else if ("false".equals(continueopen)) {
                open = false;
            } else {
                System.out.println("非法输入，超市关闭！");
                open =false;
            }

        }

        System.out.println("\n超市关门啦！\n");

        System.out.println("今日销售额为" + market.Market_incomingSum + "。营业记录如下：");
        for (int i = 0; i < market.Market_Commodity_Sold.length; i++) {
            int sold = market.Market_Commodity_Sold[i];
            if (sold > 0) {
                Commodity_Create m = market.Market_Commodity[i];
                double netIncoming = sold * (m.profit());
                double incoming = sold * m.Get_Pro_soldprice();
                System.out.println("\"" + market.Market_Commodity[i].Get_Pro_name() + "\"售出：\"" + sold + "\"个。" +
                        "销售额为：\"" + incoming + "\"。毛利润为：\"" + netIncoming + "\"。");
            }
        }
    }
}
