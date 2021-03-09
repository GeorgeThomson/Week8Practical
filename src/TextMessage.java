/**
 *
 * @author George Thomson
 * @version 27/11/20
 */
public class TextMessage
{
    private String textMessage;
    private String senderName;
    private int messageSize;


    public TextMessage(String textMessage, String senderName, int messageSize)
    {
        this.textMessage = textMessage;
        this.senderName = senderName;
        this.messageSize = messageSize;

    }

    public String getTextMessage()
    {
        return textMessage;
    }

    public String getSenderName()
    {
        return senderName;
    }


    public int getMessageSize()
    {
        return messageSize;
    }


    public void setTextMessage(String textMessage)
    {
        this.textMessage = textMessage;
    }


    public void setSenderName(String senderName)
    {
        this.senderName = senderName;
    }


    public void setMessageSize(int messageSize)
    {
        this.messageSize = messageSize;
    }


    public void printDetails()
    {
        System.out.println("Text Message: " + textMessage);
        System.out.println("Sender Name: " + senderName);
        System.out.println("Message Size: " + messageSize + " KB");
    }
}