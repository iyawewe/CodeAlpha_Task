import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class ChatBotGUI extends JFrame implements ActionListener {
    JTextField inputField;
    JTextArea chatArea;
    JButton sendButton;

    HashMap<String, String> knowledgeBase;

    public ChatBotGUI() {
        setTitle("Java ChatBot");
        setSize(500, 500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());

        inputField = new JTextField();
        inputField.addActionListener(this);
        sendButton = new JButton("Send");
        sendButton.addActionListener(this);

        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        add(inputPanel, BorderLayout.SOUTH);

        buildKnowledgeBase();
        chatArea.append("🤖 Bot: Hello! I'm your chatbot. Ask me anything!\n");

        setVisible(true);
    }

    // Create a simple rule-based NLP system
    void buildKnowledgeBase() {
        knowledgeBase = new HashMap<>();
        knowledgeBase.put("hi", "Hello there!");
        knowledgeBase.put("hello", "Hi! How can I help you?");
        knowledgeBase.put("how are you", "I'm just a bot, but I'm doing fine. Thanks!");
        knowledgeBase.put("what is your name", "I'm JavaBot, your assistant.");
        knowledgeBase.put("help", "You can ask me about greetings, my name, or how I'm doing.");
        knowledgeBase.put("bye", "Goodbye! Have a great day!");
    }

    // Normalize input and look for matches
    String getResponse(String userInput) {
        String cleaned = userInput.trim().toLowerCase();

        for (String key : knowledgeBase.keySet()) {
            if (cleaned.contains(key)) {
                return knowledgeBase.get(key);
            }
        }
        return "I'm sorry, I don't understand that yet.";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userInput = inputField.getText().trim();
        if (userInput.isEmpty()) return;

        chatArea.append("🧑 You: " + userInput + "\n");
        String response = getResponse(userInput);
        chatArea.append("🤖 Bot: " + response + "\n");

        inputField.setText("");
    }

    public static void main(String[] args) {
        new ChatBotGUI();
    }
}
