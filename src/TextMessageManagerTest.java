import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class TextMessageManagerTest {

    private TextMessage text1 = new TextMessage("Hello!", "Bob", 110);
    private TextMessage text2 = new TextMessage("Eek!", "Bill", 101);
    private TextMessage text3 = new TextMessage("Oi!", "Ben", 99);
    private TextMessage text4 = new TextMessage("Nope!", "Barry", 106);
    private TextMessage text5 = new TextMessage("Nope!", "Brian", 107);
    private TextMessageManager manager = new TextMessageManager(4);

    public void setDefaults(){
        TextMessage text1 = new TextMessage("Hello!", "Bob", 110);
        TextMessage text2 = new TextMessage("Eek!", "Bill", 101);
        TextMessage text3 = new TextMessage("Oi!", "Ben", 99);
        TextMessage text4 = new TextMessage("Nice!", "Bob", 106);
        TextMessage text5 = new TextMessage("Nope!", "Brian", 107);
        TextMessageManager manager = new TextMessageManager(4);
    }

    @BeforeEach
    void setUp() {
        setDefaults();
    }

    @AfterEach
    void tearDown() {
        setDefaults();
    }

    @Test
    void getTextMessagesSize() {
        manager.addTextMessage(text1);
        manager.addTextMessage(text2);
        manager.addTextMessage(text3);
        int sizeCounter = manager.collectionSize();
        assertEquals(3, sizeCounter);
    }


    @Test
    void addTextMessage() {
        manager.addTextMessage(text1);
        manager.addTextMessage(text2);
        manager.addTextMessage(text3);
        manager.addTextMessage(text4);
        assertEquals(4, manager.collectionSize());
    }

    @Test
    void addTextMessageWhenFull() {
        manager.addTextMessage(text1);
        manager.addTextMessage(text2);
        manager.addTextMessage(text3);
        manager.addTextMessage(text4);
        Exception e = assertThrows(IllegalStateException.class, () -> {
            manager.addTextMessage(text5);
        });
    }

    @Test
    void addExistingTextMessage() {
        manager.addTextMessage(text1);
        manager.addTextMessage(text2);
        manager.addTextMessage(text3);
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            manager.addTextMessage(text1);
        });
    }

    @Test
    void checkTextMessagesEmpty() {
        assertEquals(0, manager.collectionSize());
    }

    @Test
    void returnNumTextsInSearch() {
        manager.addTextMessage(text1);
        manager.addTextMessage(text2);
        manager.addTextMessage(text3);
        manager.addTextMessage(text4);

        assertEquals(2, manager.returnNumTextsInSearch("Bob"));
    }

    @Test
    void returnNumTextsInSearchWhenEmpty() {
        Exception e = assertThrows(NoSuchElementException.class, () -> {
            manager.returnNumTextsInSearch("Brian");
        });
    }
}