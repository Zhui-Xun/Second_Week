package GaussNumber;
import java.util.Scanner;

public class Number_Compare {

    private int NumToGauss;
    private int LeftEpoch;

    public Number_Compare(int NumToGauss,int Epoch){
        this.NumToGauss = NumToGauss;
        this.LeftEpoch = Epoch;
    }

    public int Gaming(int NumToGauss,int Epoch) {

        Scanner in = new Scanner(System.in);
        this.NumToGauss = NumToGauss;
        this.LeftEpoch = Epoch;
        int GameState = 0; // ������Ϸ��״̬��-1��ʾ������0��ʾʧ�ܣ�1��ʾ�ɹ���

        // ��Ϸ��ʼ
        while (LeftEpoch > 0) {
            System.out.println("������²����֣�");
            // �����û�����
            int Gauss = in.nextInt();

            // �ж��Ƿ������Ϸ
            if (Gauss < 0) {
                System.out.println("�û�ѡ�������Ϸ��");
                GameState = -1;
                break;
            }
            LeftEpoch--;
            if (Gauss < NumToGauss) {
                System.out.println("�������ֱ�Ŀ����\"С\"��\tʣ��" + LeftEpoch + "�λ��ᣡ");
            } else if (Gauss > NumToGauss) {
                System.out.println("�������ֱ�Ŀ����\"��\"��\tʣ��" + LeftEpoch + "�λ��ᣡ");
            } else {
                System.out.println("������ȷ��");
                System.out.println("��ϲ����Ϸ�ɹ���");
                System.out.println("������Ϸ����");
                GameState = 1;
                break;
            }
            if (LeftEpoch == 0) {
                System.out.println("���ź���������Ϸʧ�ܣ�");
                GameState = 0;
            }
        }
        System.out.println("==========================================================");
        return GameState; // ������Ϸ״̬
    }
}
