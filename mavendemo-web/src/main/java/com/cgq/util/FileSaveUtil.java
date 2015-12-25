package com.cgq.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.jpedal.exception.PdfException;

import com.google.common.io.Files;

/**
 * 文件服务器文件操作类
 * 
 * @author wangjie
 *
 */
public class FileSaveUtil {


	public static byte[] fromHexString( String s )  
    {  
    int stringLength = s.length();  
    if ( ( stringLength & 0x1 ) != 0 )  
        {  
        throw new IllegalArgumentException( "fromHexString requires an even number of hex characters" );  
        }  
    byte[] bytes = new byte[stringLength / 2];  

    for ( int i = 0, j = 0; i < stringLength; i += 2, j++ )  
        {  
        int high = charToNibble( s.charAt( i ) );  
        int low = charToNibble( s.charAt( i + 1 ) );  
        // You can store either unsigned 0..255 or signed -128..127 bytes in a byte type.  
        bytes[ j ] = ( byte ) ( ( high << 4 ) | low );  
        }  
    return bytes;  
    }  
	
	 private static byte[] correspondingNibble = new byte['f' + 1];  
	
	 static  
     {  
     // only 0..9 A..F a..f have meaning. rest are errors.  
     for ( int i = 0; i <= 'f'; i++ )  
         {  
         correspondingNibble[ i ] = -1;  
         }  
     for ( int i = '0'; i <= '9'; i++ )  
         {  
         correspondingNibble[ i ] = ( byte ) ( i - '0' );  
         }  
     for ( int i = 'A'; i <= 'F'; i++ )  
         {  
         correspondingNibble[ i ] = ( byte ) ( i - 'A' + 10 );  
         }  
     for ( int i = 'a'; i <= 'f'; i++ )  
         {  
         correspondingNibble[ i ] = ( byte ) ( i - 'a' + 10 );  
         }  
     }  
	 
	private static int charToNibble( char c )  
    {  
    if ( c > 'f' )  
        {  
        throw new IllegalArgumentException( "Invalid hex character: " + c );  
        }  
    int nibble = correspondingNibble[ c ];  
    if ( nibble < 0 )  
        {  
        throw new IllegalArgumentException( "Invalid hex character: " + c );  
        }  
    return nibble;  
    }  
	
	
	/**
	 * 将PDF文件保存为JPG并返回绝对路径
	 * @param pdffile 文件路径
	 * @return
	 * @throws IOException
	 * @throws PdfException
	 */
	public static List<String> pdfSaveToJpg(String pdffile,int width,int height,String jpgpath) throws IOException, PdfException{
		ResourceBundle bundle = ResourceBundle.getBundle("sysconf");
		String fileServerAbsoultPath = bundle.getString("FileServerAbsoluteLocation");
		List<String> jpgAbsoultPaths = DocumentUtil.PdfconvertJpg(pdffile, jpgpath,width,height);
		List<String> jpgPaths = new ArrayList<String>();
		return jpgAbsoultPaths;
	}
	
	/**
	 * 新建文件到本地磁盘 返回相对路径
	 * 
	 * @param bytes
	 *            被写入的数据
	 * @param filename
	 *           带后缀名的 文件名称
	 * @throws IOException
	 */
	public static String save(byte[] bytes, String filename,String filepath) throws IOException {
		// TODO Auto-generated method stub
		ResourceBundle bundle = ResourceBundle.getBundle("sysconf");
		// 文件服务的物理路径
		String fileServerPath = bundle.getString("FileServerAbsoluteLocation");
		int filetypeindex = filename.lastIndexOf(".");
		String filetype = filename.substring(filetypeindex+1);
		File file = new File(fileServerPath + filepath);
		Files.write(bytes, file);
		return filepath;
	}

}
