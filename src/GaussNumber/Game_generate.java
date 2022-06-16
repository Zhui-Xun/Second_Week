package GaussNumber;

public class Game_generate {

    // ��Ϸ����
    private int RangeStart;
    private int RangeEnd;
    private int Epoch;
    private int NumberToGauss;

    // ���췽��
    private Game_generate(int RangeStart, int RangeEnd, int Epoch, int NumberToGauss) {
    //public Game_generate(int RangeStart, int RangeEnd, int Epoch, int NumberToGauss) {
        this.RangeStart = RangeStart;
        this.RangeEnd = RangeEnd;
        this.Epoch = Epoch;
        this.NumberToGauss = NumberToGauss;
    }

    // ��Ϸ������������󣬽�����Ϸ��ʼ����
    // >> TODO ��Ϊ���췽����˽�еģ��޷����ⲿʹ�ã������ڵ���"Game_generate"���ʱ���޷�����"Game_generate"ʵ����ֻ��ͨ����̬����������ʵ����
    public static Game_generate game_generate_init(int RangeStart, int RangeEnd, int Epoch) {

        // �ж����ַ�Χ�Ƿ�Ϸ�
        int mod = RangeEnd - RangeStart;
        if (RangeStart < 0 || RangeEnd < 0) {
            System.out.println("��ʼ��Χ�����ǷǸ�����");
            return null;
        }
        if (mod <= 1) {
            System.out.println("�Ƿ������ַ�Χ��[" + RangeStart + "," + RangeEnd + "]");
            return null;
        }

        // ���ؽ��
        System.out.println("��������Ϸ�Ѵ��������ַ�ΧΪ��(" + RangeStart + "," + RangeEnd + ")������\"" + Epoch + "\"�λ��ᣬ����-1������Ϸ��");
        return new Game_generate(RangeStart, RangeEnd, Epoch, Generate_Random(RangeStart, RangeEnd));

    }

    // ����ָ����Χ�ڵ������
    private static int Generate_Random(int RangeStart, int RangeEnd) {

        int mod = RangeEnd - RangeStart;
        int RandomNumber = (int) (Math.random() * 100 + RangeEnd);
        int NumberToGauss = (RandomNumber % mod) + RangeStart;
        if (NumberToGauss == RangeStart) {
            NumberToGauss += 1;
        }
        if (NumberToGauss == RangeEnd) {
            NumberToGauss -= 1;
        }
        return NumberToGauss;
    }

    // ��ȡ˽�г�Ա������ֵ
    public int Get_RangeStart(){
        return RangeStart;
    }
    public int Get_RangeEnd(){
        return RangeEnd;
    }
    public int Get_Epoch(){
        return Epoch;
    }
    // ȡ�����ɵ������
    public int Get_NumberToGauss() {
        return NumberToGauss;
    }


}
