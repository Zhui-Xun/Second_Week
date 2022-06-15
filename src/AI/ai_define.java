package AI;

public class ai_define {

    public String Answer(String Question) {

        String answer = null;

        // "��", "��", "��", "��", "��"?
        answer = handleCanStart(Question);
        if (answer != null) {
            return answer;
        }

        // "���", "����", "����", "���", "����"?
        answer = handleCanStart2(Question);
        if (answer != null) {
            return answer;
        }

        // "��", "��?", "��"?
        answer = handleAskTail(Question);
        if (answer != null) {
            return answer;
        }

        return handleUnknown(Question);
    }

    // ���췽��
    private String handleCanStart(String Question) {
        String[] CanStart = new String[]{"��", "��", "��", "��", "��"};
        for (int i = 0; i < CanStart.length; i++) {
            if (Question.startsWith(CanStart[i])) {
                return CanStart[i] + "!";
            }
        }
        return null;
    }
    private String handleCanStart2(String Question) {
        String[] CanStart2 = new String[]{"���", "����", "����", "���", "����"};
        for (int i = 0; i < CanStart2.length; i++) {
            if (Question.startsWith(CanStart2[i])) {
                String ans = CanStart2[i];
                return "��"+ans.charAt(ans.length()-1) + "!";
            }
        }
        return null;
    }
    private String handleAskTail(String Question) {
        String[] AskTail = new String[]{"��", "��?", "��"};
        for (int i = 0; i < AskTail.length; i++) {
            if (Question.endsWith(AskTail[i])) {
                return Question.replace(AskTail[i], "!");
            }
        }
        return null;
    }

    private String handleUnknown(String Question) {
        return "�һش���\"" + Question + "\"�������!";
    }


}
