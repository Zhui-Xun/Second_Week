import MARKET.Commodity_Create;
import MARKET.Customer_Create;
import MARKET.Market_Creat;

import java.util.Scanner;

public class a_1_SuperMarket {
    public static void main(String[] args) {

        // ���д���
        Market_Creat market = new Market_Creat("���ⳬ��", "�Ϻ����ֶ�����666��", 200, 100);
        // ��Ʒ����
        Commodity_Create[] All_Commodity = market.MK_Products_Generate(market.Get_MarketProductsNumber());
        // ���н���
        market.MK_describe();


        System.out.println("\n���п���Ӫҵ����\n");
        boolean open = true;
        // ��������
        Scanner scanner = new Scanner(System.in);

        // ������ѭ��
        while (open) {
            // �����˿�
            Customer_Create customer = Customer_Create.Customer_init();
            //System.out.println(customer.name);
            System.out.println("--------------------------------------------------------");
            // �Ƿ�Ӵ��˿�
            if (customer.isDrivingCar) {
                if (market.Get_MarketParkingNumber() > 0) {
                    System.out.println("��ӭ" + customer.name + "���٣������Ѿ�Ϊ�������˳�λ����λ���Ϊ" + market.Market_Parking_Number);
                    market.Market_Parking_Number--;
                } else {
                    System.out.println("���공λ��������ӭ�´ι��٣�");
                    continue;
                }
            }
            // ��ʼ�Ӵ��˿�
            double TotalCost = 0;
            System.out.println("��ӭ\"" + customer.name + "\"����������ѡ��!");
            while (true) {
                System.out.println("��������Ʒ��ţ�(��Ʒ��ŷ�ΧΪ\"1-" + market.Market_Commodity_Number + "\"������\"-1\"��������)");
                int merchandiseId = scanner.nextInt() - 1;
                // ���븺������������
                if (merchandiseId < 0) {
                    System.out.println("�����ι����ѣ�\"" + TotalCost + "����ӭ�ٴι���!");
                    break;
                }
                // ��Ʒ��ų�����Χ������ѡ��
                if (merchandiseId > market.Market_Commodity_Number) {
                    System.out.println("�����޴���Ʒ����ӭ������ѡ��\n");
                    continue;
                }
                // ��Ʒ�У��ʹ˿�Ҫ������ٸ�
                Commodity_Create Buy = All_Commodity[merchandiseId];
                System.out.println("\"" + Buy.Get_Pro_name() + "\"�����ۣ�\"" + Buy.Get_Pro_soldprice() + "\"�����ʹ��򼸸���");
                int numToBuy = scanner.nextInt();
                // ������������
                if (numToBuy <= 0) {
                    System.out.println("���򿴿�Ҳ�ã���ӭ����ѡ����\n");
                    continue;
                }
                // ���̫�࣬��治��
                if (Buy.Get_Pro_count() < numToBuy) {
                    System.out.println("\"" + Buy.Get_Pro_name() + "\"���ֻ��\"" + Buy.Get_Pro_count() + "\"������������\"" + numToBuy + "\"������ӭ����ѡ����");
                    continue;
                }
                // �˿�Ǯ����
                if (numToBuy * Buy.Get_Pro_soldprice() + TotalCost > customer.money) {
                    System.out.println("������Ǯ�������ˣ�������������!\n");
                    continue;
                }

                // ǮҲ������Ҳ�������¹˿ʹ˴����ѵ��ܶ
                TotalCost += numToBuy * Buy.Get_Pro_soldprice();
                System.out.println("����ǰ�����ѣ�" + TotalCost + "��\n");
                // ������Ʒ���
                Buy.Change_Count(numToBuy);
                // System.out.println("\"" + Buy.Get_Pro_name() + "\"��ʣ����Ϊ��\""+Buy.Get_Pro_count()+"\"����");
                // ���½�����������
                market.Market_Commodity_Sold[merchandiseId] += numToBuy;
            }
            System.out.println("--------------------------------------------------------\n");
            // ��ǰ�˿����ѽ������黹��λ
            if (customer.isDrivingCar) {
                market.Market_Parking_Number++;
            }
            // ��������
            customer.money -= TotalCost;
            market.Market_incomingSum += TotalCost;
            System.out.println("\"" + customer.name + "\"������: \"" + TotalCost + "\"����ӭ�ٴι��١�");

            System.out.println("\n���ʼ���Ӫҵ�� \"true\" or \"false\"");
            String continueopen = scanner.next();
            if ("true".equals(continueopen)) {
                open = true;
            } else if ("false".equals(continueopen)) {
                open = false;
            } else {
                System.out.println("�Ƿ����룬���йرգ�");
                open =false;
            }

        }

        System.out.println("\n���й�������\n");

        System.out.println("�������۶�Ϊ" + market.Market_incomingSum + "��Ӫҵ��¼���£�");
        for (int i = 0; i < market.Market_Commodity_Sold.length; i++) {
            int sold = market.Market_Commodity_Sold[i];
            if (sold > 0) {
                Commodity_Create m = market.Market_Commodity[i];
                double netIncoming = sold * (m.profit());
                double incoming = sold * m.Get_Pro_soldprice();
                System.out.println("\"" + market.Market_Commodity[i].Get_Pro_name() + "\"�۳���\"" + sold + "\"����" +
                        "���۶�Ϊ��\"" + incoming + "\"��ë����Ϊ��\"" + netIncoming + "\"��");
            }
        }
    }
}
