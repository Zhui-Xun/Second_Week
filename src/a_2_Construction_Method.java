// 作业2，构造方法，静态方法与静态变量
import MARKET.Commodity_Create;
import MARKET.VIP_DisCount;
import static MARKET.VIP_DisCount.*;


public class a_2_Construction_Method {
    public static void main(String[] args) {

        // 构造方法创建空商品
        Commodity_Create merchandise = new Commodity_Create();
        System.out.println("\n-------------------------");
        System.out.println("构造方法创建-空商品");
        merchandise.describe();
        System.out.println("-------------------------");

        // 使用重载构造方法创建商品

        Commodity_Create merchandise2 = new Commodity_Create("牛奶", "10086", 100, 50, 60);
        System.out.println("\n-------------------------");
        System.out.println("使用重载构造方法创建商品-牛奶");
        merchandise2.describe();
        System.out.println("-------------------------");

        // 相互调用
        int Product_number = 5;
        Commodity_Create[] merchandise3 = merchandise.Commodity_Create_list(Product_number);
        System.out.println("\n-------------------------");
        System.out.println("调用构造方法创建了\"" + Product_number + "\"种商品，分别为：");
        for (int i = 0; i < Product_number; i++) {
            merchandise3[i].describe();
        }
        System.out.println("-------------------------");

        // 静态变量与静态方法
        VIP_DisCount user1 = new VIP_DisCount();
        System.out.println("\n-------------------------");
        System.out.println("静态变量与静态方法: ");
        System.out.println("基础折扣为：" + getBASE_DISCOUNT()); // 静态变量不需要创建类实例即可使用；
        System.out.println("VIP折扣为：" + user1.VIP_DISCOUNT);   // 非静态变量需要创建实例后才可使用；
        System.out.println("SVIP折扣为：" + getSVIP_DISCOUNT());
        System.out.println("-------------------------");

        user1.VIP_DISCOUNT = 0.85;
        System.out.println("user1的 VIP 折扣为：" + user1.VIP_DISCOUNT);   // 非静态变量，只更改了特定对象的折扣
        VIP_DisCount user2 = new VIP_DisCount();
        System.out.println("user2的 VIP 折扣为：" + user2.VIP_DISCOUNT);

        Change_SVIP_discount(0.75);
        System.out.println("user1的 SVIP 折扣为：" + getSVIP_DISCOUNT()); // 静态变量，更改所有对象的折扣
        System.out.println("user2的 SVIP 折扣为：" + getSVIP_DISCOUNT()); // 静态方法，需要使用static关键字导入 import static 静态方法位置
    }
}
