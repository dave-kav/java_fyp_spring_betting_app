package dk.cit.fyp.service;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {
	
	private static String last_file;

	/**
	 * Takes in a filePath and returns the file as bytes 
	 */
	@Override
	public byte[] getBytes(String filePath) {
		// convert image to bytes
        FileInputStream fis = null; 
        ByteArrayOutputStream bos = null;
        byte[] fileBytes = null;
        
        try {
	        fis = new FileInputStream(filePath);
	        bos = new ByteArrayOutputStream();
	        int b;
	        byte[] buffer = new byte[1024];
	        
	        while((b=fis.read(buffer))!=-1){
	           bos.write(buffer,0,b);
	        }
	        
	        fileBytes = bos.toByteArray();
	        
        } catch (IOException e) {
        	e.printStackTrace();
        } finally {
        	try {
	        	fis.close();
	        	bos.close();
	        	
        	} catch (IOException e) {
        		e.printStackTrace();
        	}
        }
		return fileBytes;
	}
	
	@Override
	public String getImageSource(byte[] bytes) {
		byte[] encoded=Base64.getEncoder().encode(bytes);
        String encodedString = new String(encoded);
        return "data:image/jpeg;base64," + encodedString;
	}

	@Override
	public void storeLastImgPath(String filePath) {
		ImageServiceImpl.last_file = filePath;
		
	}

	@Override
	public String getLastImagePath() {
		return ImageServiceImpl.last_file;
	}
}