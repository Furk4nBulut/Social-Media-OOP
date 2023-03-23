package ooplab4.socailmedia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class MessageGUI extends JFrame {

    private User currentUser;
    private User friend;

    private JTextArea messageArea;
    private JButton sendButton;
    private JTextArea conversationArea;

    public MessageGUI(User currentUser, User friend) {
        super("Messaging App");
        this.currentUser = currentUser;
        this.friend = friend;

        JPanel mainPanel = new JPanel(new BorderLayout());

        conversationArea = new JTextArea(10, 40);
        conversationArea.setEditable(false);
        conversationArea.setLineWrap(true);
        conversationArea.setWrapStyleWord(true);

        JScrollPane conversationScrollPane = new JScrollPane(conversationArea);

        mainPanel.add(conversationScrollPane, BorderLayout.CENTER);

        JPanel messagePanel = new JPanel(new BorderLayout());

        messageArea = new JTextArea(3, 40);
        messageArea.setLineWrap(true);
        messageArea.setWrapStyleWord(true);

        JScrollPane messageScrollPane = new JScrollPane(messageArea);

        sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String messageText = messageArea.getText();
                if (!messageText.isEmpty()) {
                    Message message = new Message(currentUser, friend, messageText, new Date());
                    friend.receiveMessage(message);
                    currentUser.sendMessage(messageText, friend);
                    updateConversation();
                }
                messageArea.setText("");
            }
        });

        messagePanel.add(messageScrollPane, BorderLayout.CENTER);
        messagePanel.add(sendButton, BorderLayout.EAST);

        mainPanel.add(messagePanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        updateConversation();
    }

    private void updateConversation() {
        conversationArea.setText("");
        for (Message message : currentUser.getOutbox()) {
            if (message.getReceiver() == friend) {
                conversationArea.append(message.getSender().getName() + ": " + message.getMessageText() + "\n");
            }
        }
        for (Message message : currentUser.getInbox()) {
            if (message.getSender() == friend) {
                conversationArea.append(message.getSender().getName()+ ": " + message.getMessageText() + "\n");
            }
        }
    }
    public void changeUserAndReply(User newFriend, String messageText) {
        if (newFriend != null) {
            this.friend = newFriend;
            updateConversation();
        }
        if (messageText != null && !messageText.isEmpty()) {
            Message message = new Message(currentUser, friend, messageText, new Date());
            friend.receiveMessage(message);
            currentUser.sendMessage(messageText, friend);
            updateConversation();
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Date d = new Date();
            User user1 = new User("Furkan","Bulut","ToFuDuK","210316011","furkan",d,"male");
            User user2 = new User("Ahmet","Bulut","InfinityOfDeath","ahmet","ahmet",d,"male");

            user1.addFriend(user2);
            user2.addFriend(user1);

            MessageGUI gui = new MessageGUI(user1, user2);
            gui.setVisible(true);
        });
    }

}
