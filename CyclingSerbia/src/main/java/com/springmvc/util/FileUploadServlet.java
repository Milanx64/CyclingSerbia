package com.springmvc.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.FileBucket;

@WebServlet(name = "fileUploadServlet", urlPatterns = {""})
@MultipartConfig(location="D:/temp",
                 fileSizeThreshold=0,    
                 maxFileSize=5242880,       // 5 MB
                 maxRequestSize=20971520)   // 20 MB
public class FileUploadServlet extends HttpServlet {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		   MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		   MultipartFile multipartFile = multipartRequest.getFile("FileBucket");
		   
		return null;
		   
	}
}
