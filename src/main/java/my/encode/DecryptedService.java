package my.encode;

/**
 * User: Sushakov
 * Date: 12/26/2018
 * Time: 12:32
 **/

public interface DecryptedService {

    void initEncryptor();
    String encrypt(String text) throws Exception;
    String decrypt(String text) throws Exception;
}
