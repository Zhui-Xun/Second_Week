package AI;

public class ai_define {

    public String Answer(String Question) {

        String answer = null;

        // "会", "能", "有", "敢", "在"?
        answer = handleCanStart(Question);
        if (answer != null) {
            return answer;
        }

        // "你会", "你能", "你有", "你敢", "你在"?
        answer = handleCanStart2(Question);
        if (answer != null) {
            return answer;
        }

        // "吗？", "吗?", "吗"?
        answer = handleAskTail(Question);
        if (answer != null) {
            return answer;
        }

        return handleUnknown(Question);
    }

    // 构造方法
    private String handleCanStart(String Question) {
        String[] CanStart = new String[]{"会", "能", "有", "敢", "在"};
        for (int i = 0; i < CanStart.length; i++) {
            if (Question.startsWith(CanStart[i])) {
                return CanStart[i] + "!";
            }
        }
        return null;
    }
    private String handleCanStart2(String Question) {
        String[] CanStart2 = new String[]{"你会", "你能", "你有", "你敢", "你在"};
        for (int i = 0; i < CanStart2.length; i++) {
            if (Question.startsWith(CanStart2[i])) {
                String ans = CanStart2[i];
                return "我"+ans.charAt(ans.length()-1) + "!";
            }
        }
        return null;
    }
    private String handleAskTail(String Question) {
        String[] AskTail = new String[]{"吗？", "吗?", "吗"};
        for (int i = 0; i < AskTail.length; i++) {
            if (Question.endsWith(AskTail[i])) {
                return Question.replace(AskTail[i], "!");
            }
        }
        return null;
    }

    private String handleUnknown(String Question) {
        return "我回答不了\"" + Question + "\"这个问题!";
    }


}
