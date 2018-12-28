package my.encode;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Component;

/**
 * User: Sushakov
 * Date: 12/26/2018
 * Time: 12:33
 **/
@Component("springDecryptor")
public class SpringDecrypt implements DecryptedService {

    @Value("${encrypt.KEY}")
    private String key;
    @Value("${encrypt.SALT}")
    private String salt;

    private TextEncryptor encodingService;

    public SpringDecrypt() {
    }

    @Override
    public String encrypt(String text) throws Exception {
            initEncryptor();
            return encodingService.encrypt(text);
    }

    @Override
    public String decrypt(String text) throws Exception {
            initEncryptor();
            return encodingService.decrypt(text);
    }

    @Override
    public void initEncryptor() {
        encodingService=Encryptors.text(key, salt);
    }
}
