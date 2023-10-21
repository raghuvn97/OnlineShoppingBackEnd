package com.lti.service;

import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.lti.dto.ProductPictures;

@Service
public class PictureUploadServiceImpl implements PictureUploadService {
	
	@Autowired
	RetailerService retailerService;

	@Override
	public void uploadProductPics(ProductPictures productpics) {
		 int productId=productpics.getpId();
		String imgUploadLocation = "G:/uploads/";
		String uploadedFileName1 = productpics.getpImage1().getOriginalFilename();
		String uploadedFileName2 = productpics.getpImage2().getOriginalFilename();
		String uploadedFileName3 = productpics.getpImage3().getOriginalFilename();
		String uploadedFileName4 = productpics.getpImage4().getOriginalFilename();
		String newFileName1=productId+"-"+uploadedFileName1;
		String newFileName2=productId+"-"+uploadedFileName2;
		String newFileName3=productId+"-"+uploadedFileName3;
		String newFileName4=productId+"-"+uploadedFileName4;
		String targetFileName1 = imgUploadLocation + newFileName1;
	    String targetFileName2 = imgUploadLocation +newFileName2;
	    String targetFileName3 = imgUploadLocation +newFileName3;
	    String targetFileName4 = imgUploadLocation +newFileName4;
		try {
			FileCopyUtils.copy(productpics.getpImage1().getInputStream(), new FileOutputStream(targetFileName1));
			FileCopyUtils.copy(productpics.getpImage2().getInputStream(), new FileOutputStream(targetFileName2));
			FileCopyUtils.copy(productpics.getpImage3().getInputStream(), new FileOutputStream(targetFileName3));
			FileCopyUtils.copy(productpics.getpImage4().getInputStream(), new FileOutputStream(targetFileName4));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		retailerService.updateProductPic(productId, newFileName1, newFileName2, newFileName3, newFileName4);
	}

}
