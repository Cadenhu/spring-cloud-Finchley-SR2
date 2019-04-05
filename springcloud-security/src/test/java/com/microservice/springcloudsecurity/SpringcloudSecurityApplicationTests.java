package com.microservice.springcloudsecurity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.test.context.junit4.SpringRunner;
import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.interfaces.RSAPublicKey;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringcloudSecurityApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Test
	public  void  Testbcrypt(){
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		System.out.println(encoder.encode("secret"));
	}
	@Test
	public  void  TestCrypt(){
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		System.out.println(encoder.encode("123456"));
	}
	@Test
	public void exportPublicKey()  {
		String keyStoreType = "jks";
		String keystoreFile = "D:\\bert.hu\\javaDEV\\DEVCode\\Demo\\springcloud\\springcloud-security\\src\\main\\resources\\cnsesan-jwt.jks";
		String exportPublicFile = "D:\\bert.hu\\javaDEV\\DEVCode\\Demo\\springcloud\\springcloud-security\\src\\main\\resources\\publicKey.txt";
		String password = "cnsesan123"; //keystore的解析密码
		String friendPassword = "cnsesan123";//条目的解析密码
		String alias = "cnsesan-jwt";//条目别名
		try {
			KeyStore keyStore = KeyStore.getInstance(keyStoreType);
			keyStore.load(new FileInputStream(keystoreFile), password.toCharArray());
			PublicKey keyPair = keyStore.getCertificate(alias).getPublicKey(); //new KeyStoreKeyFactory(new ClassPathResource())
			BASE64Encoder encoder = new BASE64Encoder();
			String encoded = encoder.encode(keyPair.getEncoded());
			FileWriter fileWriter = new FileWriter(exportPublicFile);
			fileWriter.write("-----Begin Public Key-----\r\n");//非必须
			fileWriter.write(encoded);
			fileWriter.write("\r\n-----End Public Key-----");//非必须
			fileWriter.close();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (CertificateException e) {
			e.printStackTrace();
		}
	}
	@Test
	public  void pub(){
		Resource resource = new ClassPathResource("kevin_key.jks");
		KeyPair keyPair = new KeyStoreKeyFactory(resource, "123456".toCharArray()).getKeyPair("kevin_key");
		RSAPublicKey key = (RSAPublicKey)keyPair.getPublic();
		System.out.println(key);
		String verifierKey = "-----BEGIN PUBLIC KEY-----\n" + new String(Base64.encode(key.getEncoded()))
			+ "\n-----END PUBLIC KEY-----";
		System.out.println(verifierKey);
}
}
