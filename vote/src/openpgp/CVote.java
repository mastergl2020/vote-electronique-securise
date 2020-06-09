package openpgp;

import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;

public class CVote {
	
///Encryption Decryption///
	String data="hello my new project";
	byte[] input;
	byte[] keyBytes= "12345678".getBytes();
	byte[] ivBytes= "input123".getBytes();
	SecretKeySpec key = new SecretKeySpec(keyBytes,"DES");
	IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
	Cipher cipher;
	byte[] cipherText;
	int ctLength;
	////////////////////////////////////////////////////////////////
	public void encrypt() {
		try {
			Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
			
			input=data.getBytes();
			SecretKeySpec key = new SecretKeySpec(keyBytes,"DES");
			IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
			cipher = Cipher.getInstance("DES/CTR/NoPadding","BC");
			cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
			
			cipherText = new byte[cipher.getOutputSize(input.length)];
			
			ctLength = cipher.update(input, 0, input.length, cipherText, 0);
			
			ctLength += cipher.doFinal(cipherText, ctLength);
			System.out.println(new String(cipherText));
			
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null,ex);
		}
	}
	
	
	
	/////////decryption method//////////////////
	public void decrypt() {
		try {
			
			
			cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
			byte[] plainText = new byte[cipher.getOutputSize(ctLength)];
			int ptLength = cipher.update(cipherText, 0, ctLength, plainText, 0);			
			ptLength += cipher.doFinal(plainText, ptLength);
			System.out.println(new String(plainText));
			
			
			
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null,ex);
		}
	}
	
}