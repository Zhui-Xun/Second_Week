// ��ҵ2�����췽������̬�����뾲̬����
import MARKET.Commodity_Create;
import MARKET.VIP_DisCount;
import static MARKET.VIP_DisCount.*;


public class a_2_Construction_Method {
    public static void main(String[] args) {

        // ���췽����������Ʒ
        Commodity_Create merchandise = new Commodity_Create();
        System.out.println("\n-------------------------");
        System.out.println("���췽������-����Ʒ");
        merchandise.describe();
        System.out.println("-------------------------");

        // ʹ�����ع��췽��������Ʒ

        Commodity_Create merchandise2 = new Commodity_Create("ţ��", "10086", 100, 50, 60);
        System.out.println("\n-------------------------");
        System.out.println("ʹ�����ع��췽��������Ʒ-ţ��");
        merchandise2.describe();
        System.out.println("-------------------------");

        // �໥����
        int Product_number = 5;
        Commodity_Create[] merchandise3 = merchandise.Commodity_Create_list(Product_number);
        System.out.println("\n-------------------------");
        System.out.println("���ù��췽��������\"" + Product_number + "\"����Ʒ���ֱ�Ϊ��");
        for (int i = 0; i < Product_number; i++) {
            merchandise3[i].describe();
        }
        System.out.println("-------------------------");

        // ��̬�����뾲̬����
        VIP_DisCount user1 = new VIP_DisCount();
        System.out.println("\n-------------------------");
        System.out.println("��̬�����뾲̬����: ");
        System.out.println("�����ۿ�Ϊ��" + getBASE_DISCOUNT()); // ��̬��������Ҫ������ʵ������ʹ�ã�
        System.out.println("VIP�ۿ�Ϊ��" + user1.VIP_DISCOUNT);   // �Ǿ�̬������Ҫ����ʵ����ſ�ʹ�ã�
        System.out.println("SVIP�ۿ�Ϊ��" + getSVIP_DISCOUNT());
        System.out.println("-------------------------");

        user1.VIP_DISCOUNT = 0.85;
        System.out.println("user1�� VIP �ۿ�Ϊ��" + user1.VIP_DISCOUNT);   // �Ǿ�̬������ֻ�������ض�������ۿ�
        VIP_DisCount user2 = new VIP_DisCount();
        System.out.println("user2�� VIP �ۿ�Ϊ��" + user2.VIP_DISCOUNT);

        Change_SVIP_discount(0.75);
        System.out.println("user1�� SVIP �ۿ�Ϊ��" + getSVIP_DISCOUNT()); // ��̬�������������ж�����ۿ�
        System.out.println("user2�� SVIP �ۿ�Ϊ��" + getSVIP_DISCOUNT()); // ��̬��������Ҫʹ��static�ؼ��ֵ��� import static ��̬����λ��
    }
}
