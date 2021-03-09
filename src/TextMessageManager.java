import java.util.*;

/**
 * @author George Thomson
 * @version 27/11/20
 */
public class TextMessageManager
{

    private TextMessage[] textMessages;
    private int size;
    private int capacity;


    public TextMessageManager(int c)
    {
        capacity = c;
        textMessages = new TextMessage[capacity];
        size = 0;
    }

    public int collectionSize()
    {
        int sizeCount = 0;
        for (int i = 0; i< textMessages.length; i++) {
            if(textMessages[i] != null) {
                sizeCount++;
            }
        }

        return sizeCount;

    }

    public void addTextMessage(TextMessage textMessage){
        if(size == capacity){
            throw new IllegalStateException("Text message manager is full");
        } else {
            List<TextMessage> texts = new ArrayList<>(Arrays.asList(textMessages));
                if (texts.contains(textMessage)){
                    throw new IllegalArgumentException("Text message already in manager");
                } else{
                    textMessages[size] = textMessage;
                    size ++;
                }
            }
    }


    public boolean checkTextMessagesEmpty()
    {
        if(size == 0) {
            return true;
        } else {
            return false;
        }
    }


    public int returnNumTextsInSearch(String senderName) throws NoSuchElementException
    {
        if(!(checkTextMessagesEmpty())){
            int numTexts = 0;
            for(int i = 0; i < textMessages.length; i++) {
                TextMessage text = textMessages[i];
                if(text.getSenderName() == senderName || text.getMessageSize() < 100) {
                    numTexts++;
                }
            }

            return numTexts;

        } else {
            throw new NoSuchElementException("Text message manager is empty");
        }
    }

}