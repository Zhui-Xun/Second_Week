// ��ҵ4��������Ϸ��������

import GaussNumber.Game_generate;
import GaussNumber.Number_Compare;

public class b_1_Gauss_Number {
    public static void main(String[] args) {

        // ��Ϸ��¼
        boolean EndGame = false;
        int TotalGame = 0;
        int SuccessGame = 0;

        // ��ʽ��Ϸ��ʼ
        while (!EndGame) {

            System.out.println("\n==========================================================");
            // ������Ϸ����
            Game_generate Game = Game_generate.game_generate_init(20, 50, 5);
            // System.out.println("Random = "+Game.Get_NumberToGauss());
            // ��ʽ��Ϸ
            System.out.println("��Ϸ��ʼ�����ַ�ΧΪ��(" + Game.Get_RangeStart() + "," + Game.Get_RangeEnd() + ")������-1������Ϸ��");
            TotalGame++;

            Number_Compare NewGame = new Number_Compare(Game.Get_NumberToGauss(), Game.Get_Epoch());

            int GameState = NewGame.Gaming(Game.Get_NumberToGauss(), Game.Get_Epoch());

            // ��Ϸ�����¼
            if (GameState < 0) {
                TotalGame--;
                break;
            } else if (GameState == 0) {
                continue;
            } else if (GameState == 1) {
                SuccessGame++;
                continue;
            } else {
                System.out.println("��Ϸ����");
                EndGame = true;
            }
        }
        System.out.println("\n========== ������" + TotalGame + "����Ϸ���ɹ���" + SuccessGame + "�Σ�==========");
        System.out.println("");
    }
}
