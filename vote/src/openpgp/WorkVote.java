package openpgp;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class WorkVote {
	private static final String UNICODE_FORMAT="UTF-8";
	public static void main(String[] args) {
		String text="Meriem Sermani ";
		try {
			SecretKey key=generatekey("AES");
			Cipher chipher = Cipher.getInstance("AES");
			
			byte[] encryptedData =encrypteString(text, key, chipher);
			String encryptedString =new String(encryptedData);
			System.out.println(encryptedString);
			String decrypted=decryptString(encryptedData,key,chipher);
			System.out.println(decrypted);
		} catch (Exception e) {
			
		}
	}
	public static SecretKey generatekey(String encryptionType) {
		try {
			KeyGenerator keyGenerator =KeyGenerator.getInstance(encryptionType);
			SecretKey mykey=keyGenerator.generateKey();
			return mykey;
		} catch (Exception e) {
			return null;
			
		}
		
	}
	/********************************************Cryptage**************************************/
	public static byte[] encrypteString(String dataToEncrypt,SecretKey mykey,Cipher cipher) {
		try {
			byte[] text =dataToEncrypt.getBytes(UNICODE_FORMAT);
			cipher.init(Cipher.ENCRYPT_MODE,mykey);
			byte[] textEncrypted=cipher.doFinal(text);
			return textEncrypted;
			
			
		} catch (Exception e) {
			return null;
		}
	}
	/********************************************Decryptage**************************************/
	public static String decryptString(byte[] dataToDecrypt,SecretKey mykey,Cipher cipher) {
		try {
			cipher.init(Cipher.DECRYPT_MODE, mykey);
			byte [] textDecrypted=cipher.doFinal(dataToDecrypt);
			String result =new String(textDecrypted);
			return result;
			
		} catch (Exception e) {
			return null;
		}
	}
	
	

}
