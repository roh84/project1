package com.jsp.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;


public class UserAnimal {
	    private String userNum; //유저번호
	    private String animalname;//동물이름
	    private String animalBirth;//동물생일
	    private String animalgender;//동물성별
	    private String animalweight;//동물무게
	    private String animalProfile;//동물이미지
	          
		public String getUserNum() {
			return userNum;
		}
		public void setUserNum(String userNum) {
			this.userNum = userNum;
		}
		public String getAnimallname() {
			return animalname;
		}
		public void setAnimallname(String animallname) {
			this.animalname = animallname;
		}
		public String getAnimall() {
			return animalBirth;
		}
		public void setAnimall(String animall) {
			this.animalBirth = animall;
		}
		public String getAnimallgender() {
			return animalgender;
		}
		public void setAnimallgender(String animallgender) {
			this.animalgender = animallgender;
		}
		public String getAnimallweight() {
			return animalweight;
		}
		public void setAnimallweight(String animallweight) {
			this.animalweight = animallweight;
		}
		   
		 public String getAnimalProfile() {
				return animalProfile;
		}		 
		public void setAnimalProfile(String animalProfile) {
				this.animalProfile = animalProfile;
		}
		
	public String toStringPUN() {
		 return this.userNum;
	 }  
	 
	 public String toStringPatName() {
		 return this.animalname;
	 }  
	 
	 public String toStringPatBirth() {
	        try {
	           
	            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(this.animalBirth);
       
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	            return sdf.format(date);

	        } catch (ParseException e) {
          
	            e.printStackTrace();
	            return ""; 
	        }
	    }
	 
	 public String toStringPatGender() {
		 return this.animalgender;
	 }  
	 
	 public String toStringPatWeight() {
		 return this.animalweight;
	 }  
	 
	 public String toStringPatPropflie() {
		 return this.animalProfile;
	 }  
	    
	    
}
