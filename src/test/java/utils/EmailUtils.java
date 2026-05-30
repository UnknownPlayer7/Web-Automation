package utils;

import jakarta.mail.*;
import jakarta.mail.search.FromStringTerm;
import jakarta.mail.search.SearchTerm;
import lombok.experimental.UtilityClass;
import utils.models.LoginData;

import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UtilityClass
public class EmailUtils {

    private final String GMAIL_PROPERTIES = "/properties/gmail.properties";

    public LoginData getRestoredLoginData(String recipient, String recipientPassword, String sender) {
        Folder inbox = getInbox(recipient, recipientPassword);
        String text = getTextFromMessage(sender, inbox);

        String username = scan("username:\\s*(.*)$", text);
        String password = scan("password:\\s*(.*)$", text);
        String url = scan("(https://\\S+)", text);

        return new LoginData(username, password, url);
    }

    public Folder getInbox(String recipient, String recipientPassword) {
        Properties properties = PropertiesSupplier.getProperties(GMAIL_PROPERTIES);

        try {
            Session session = Session.getInstance(properties);
            Store store = session.getStore("imaps");
            store.connect(recipient, recipientPassword);

            return store.getFolder("INBOX");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private String getTextFromMessage(String sender, Folder inbox) {
        try {
            return getLastMessageFrom(sender, inbox).getContent().toString();
        } catch (MessagingException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    private Message getLastMessageFrom(String sender, Folder inbox) throws MessagingException {
        SearchTerm filter = new FromStringTerm(sender);

        inbox.open(Folder.READ_ONLY);
        Message[] messages = inbox.search(filter);

        if (messages.length != 0) {
            return messages[messages.length - 1];
        } else {
            throw new MessagingException("No messages from the service sender!");
        }
    }

    private String scan(String pattern, String text) {
        Matcher matcher = Pattern.compile(pattern, Pattern.MULTILINE).matcher(text);
        if (matcher.find()) {
            return matcher.group(1).trim();
        }
        return "";
    }
}
