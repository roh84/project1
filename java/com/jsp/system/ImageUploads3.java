package com.jsp.system;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.jsp.dao.PostImageDao3;
import com.jsp.system.DBConnector;
import com.jsp.system.RandomStringGenerator;


@WebServlet(urlPatterns = { "/api/image/upload3" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 20, maxFileSize = 1024 * 1024 * 100, maxRequestSize = 1024 * 1024
      * 500)
public class ImageUploads3 extends HttpServlet {


   
   
   protected Part getParameter(Collection<Part> parts, String key) {
      for (Part part : parts) {
         if (part.getName().equalsIgnoreCase(key))
            return part;
      }
      return null;
   }
   
//확장자 토큰으로 반환해줌
   protected String getSignature(Part part) {
      String header = part.getHeader("Content-Disposition");
      String[] headers = header.split(";");
      for (String head : headers) {
         head = head.trim();
         if (head.startsWith("filename")) {
            String filename = head.split("=")[1];

            String token = filename.substring(filename.lastIndexOf('.'));
            token = token.substring(0, token.length() - 1);
            // 드랍존 오류인지 꼬랑지에 ;를 달고다님 잘라줬음

            return token;
         }
      }
      return "";
   }
   



   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      Collection<Part> parts = req.getParts();

      Part part = getParameter(parts, "boardImage");
      
      String token = getSignature(part);

      
       String uploadPath ="C:\\eclip\\workspace\\JSPB\\src\\main\\webapp\\WEB-INF\\resources\\img\\";
       System.out.println("경로" + Paths.get(getServletContext().getContextPath()) + "경로");
      
      if (!Files.exists(Paths.get(uploadPath+
            String.join("/", req.getParameter("year"), req.getParameter("month"), req.getParameter("day")))))
         Files.createDirectories(Paths.get(uploadPath +
               String.join("/", req.getParameter("year"), req.getParameter("month"), req.getParameter("day"))));
      
      System.out.println(Paths.get(uploadPath +
            String.join("/", req.getParameter("year"), req.getParameter("month"), req.getParameter("day"))));


      while (true)
         try {
            String imageName = RandomStringGenerator.generateRandomString(10);
            
            Files.copy(part.getInputStream(), Paths.get(uploadPath +
                  String.join("/", req.getParameter("year"), req.getParameter("month"), req.getParameter("day"))
                        + "/" + imageName + token));
            //이미지 저장
            
            try (DBConnector con = new DBConnector();) {
               // DB에 이미지 이름, 순서, 작성글 id 저장
               PostImageDao3 map = con.OpenMap(req, PostImageDao3.class);
               
               Thread.sleep(750);
               
               int boardListNum3 = map.getNewlyInsertedBoardId3();

               
               System.out.println("이미지가 가져오는 게시글 넘버 : " + boardListNum3);
               System.out.println(imageName);
               
                map.saveImage3(String.join("/", req.getParameter("year"), req.getParameter("month"), req.getParameter("day"),imageName +token), boardListNum3);
                  
                
                System.out.println(String.join("/", req.getParameter("year"), req.getParameter("month"), req.getParameter("day"),imageName)+token);

               
            } catch (Exception e) {
                e.printStackTrace();
               System.out.println("게시글 넘버 못받아옴");
            }
            break;
            
         } catch (Exception e) {

         }
   }
}



