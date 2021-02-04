package com.clive.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.clive.utils.PictureUtils;

@RunWith(SpringJUnit4ClassRunner.class)   
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MyTest {
   @Test
   public void show1() {
	   String pictureName = "1.jpg";
	   String substring = pictureName.substring(pictureName.lastIndexOf("."));
	   System.out.println("==========>"+substring);
   }
   @Test
   public void show2() {
	   String imageNmae = PictureUtils.getImageNmae("asdsad.jpg.asda.png");
	   System.out.println(imageNmae);
   }
}
