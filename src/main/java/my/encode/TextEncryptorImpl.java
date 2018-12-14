package my.encode;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;

/**
 * User: sushakov
 * Date: 11/21/2018
 * Time: 11:21
 **/
@Configuration
public class TextEncryptorImpl implements TextEncryptor {

    private final String KEY = "Secret Key";
    private final String SALT = "f89ad285791dba45";

    private String incomingText;

    public TextEncryptorImpl() {

    }

    public String encodeText(String text) {
        setIncomingText(text);
        return getEncodeText();
    }

    public String getIncomingText() {
        return incomingText;
    }

    public void setIncomingText(String incomingText) {
        this.incomingText = incomingText;
    }

    private String getEncodeText() {
        org.springframework.security.crypto.encrypt.TextEncryptor encryptor;
        encryptor = Encryptors.text(KEY, SALT);
        return encryptor.encrypt(incomingText);
    }


}
