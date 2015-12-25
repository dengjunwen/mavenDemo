package com.cgq.util;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.jpedal.PdfDecoder;
import org.jpedal.exception.PdfException;

/**
 * 文档工具类
 * 
 * @author wangjie
 *
 */
public class DocumentUtil {

	private int newWidth = 573;
	private int newHeight = 4;

	/**
	 * pdf文档转为图片
	 * 
	 * @param pdffile
	 *            pdf文件地址 也可以是URL
	 * @param jpgfilepath
	 *            jpg文件保存目录 必须是本地有读写权限的目录
	 * @return 各个页面图片的保存路径
	 * @throws IOException
	 * @throws PdfException
	 */
	public static List<String> PdfconvertJpg(String pdffile, String jpgfilepath, int width, int height)
			throws IOException, PdfException {
		/** instance of PdfDecoder to convert PDF into image */
		PdfDecoder decode_pdf = new PdfDecoder(true);

		/** set mappings for non-embedded fonts to use */
		// FontMappings.setFontReplacements();

		/** open the PDF file - can also be a URL or a byte array */
		decode_pdf.openPdfFile(pdffile); // file
		// decode_pdf.openPdfFile("C:/myPDF.pdf", "password"); //encrypted
		// file
		// decode_pdf.openPdfArray(bytes); //bytes is byte[] array with PDF
		// decode_pdf.openPdfFileFromURL("http://www.mysite.com/myPDF.pdf",false);

		/** get page 1 as an image */
		// page range if you want to extract all pages with a loop
		int start = 1, end = decode_pdf.getPageCount();
		List<String> jpgPathList = new ArrayList<String>();
		String jpgname = UUID.randomUUID().toString();
		for (int i = start; i < end + 1; i++) {
			BufferedImage img = decode_pdf.getPageAsImage(i);
			BufferedImage newImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = newImg.createGraphics();  
	        // 从原图上取颜色绘制新图  
	        g.drawImage(img, 0, 0, img.getWidth(), img.getHeight(), null);  
	        g.dispose();  
	        // 根据图片尺寸压缩比得到新图的尺寸  
	        newImg.getGraphics().drawImage(  
	        		img.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0,  
	                null);  
			ImageIO.write(newImg, "jpg", new File(jpgfilepath + jpgname + "_" + i + ".jpg"));
			System.out.println(jpgfilepath + jpgname + "_" + i + ".jpg");
			jpgPathList.add(jpgfilepath + jpgname + "_" + i + ".jpg");
		}
		/** close the pdf file */
		decode_pdf.closePdfFile();
		return jpgPathList;
	}

	public static void main(String[] args) throws IOException, PdfException, InterruptedException {
		PdfconvertJpg("/home/mengxg/pdfPicFile/22222.pdf", "/home/mengxg/pdfPicFile/", 573, 494);
	}

}