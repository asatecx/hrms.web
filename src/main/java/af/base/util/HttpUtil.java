package af.base.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.activation.FileTypeMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Utility class for JavaScript compatible UTF-8 encoding and decoding.
 * 
 * @see http://stackoverflow.com/questions/607176/java-equivalent-to-javascripts-encodeuricomponent-that-produces-identical-output
 * @author John Topley 
 */
@Scope("request")
@Component("HttpUtil")
public class HttpUtil {
    
    protected static final Log logger = LogFactory.getLog(HttpUtil.class);

    @Autowired 
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;

    public static HttpServletRequest getCurrentRequest() {
        return ((HttpUtil)ApplicationContextUtil.getObject("HttpUtil")).request;
    }

    public static HttpServletResponse getCurrentResponse() {
        return ((HttpUtil)ApplicationContextUtil.getObject("HttpUtil")).response;
    }
    
    
    
  /**
   * Decodes the passed UTF-8 String using an algorithm that's compatible with
   * JavaScript's <code>decodeURIComponent</code> function. Returns
   * <code>null</code> if the String is <code>null</code>.
   *
   * @param s The UTF-8 encoded String to be decoded
   * @return the decoded String
   */
  public static String decodeURIComponent(String s) {
    if (s == null) {
      return null;
    }

    String result = null;

    try {
      result = URLDecoder.decode(s, "UTF-8");
    }

    // This exception should never occur.
    catch (UnsupportedEncodingException e) {
        logger.error("failed to decode URL parameter: " + s, e);
      result = s;  
    }

    return result;
  }

  /**
   * Encodes the passed String as UTF-8 using an algorithm that's compatible
   * with JavaScript's <code>encodeURIComponent</code> function. Returns
   * <code>null</code> if the String is <code>null</code>.
   * 
   * @param s The String to be encoded
   * @return the encoded String
   */
  public static String encodeURIComponent(String s) {
    String result = null;

    try {
      result = URLEncoder.encode(s, "UTF-8")
                         .replaceAll("\\+", "%20")
                         .replaceAll("\\%21", "!")
                         .replaceAll("\\%27", "'")
                         .replaceAll("\\%28", "(")
                         .replaceAll("\\%29", ")")
                         .replaceAll("\\%7E", "~");
    }

    // This exception should never occur.
    catch (UnsupportedEncodingException e) {
        logger.error("failed to encode URL parameter: " + s, e);
      result = s;
    }

    return result;
  }

  public static String getContentType(String fileName) {
      String contentType = "application/octet-stream";
      if (fileName == null) return contentType;
      fileName = fileName.toLowerCase();
      if (fileName.endsWith(".gif")) {
          contentType = "image/gif";
      } else if (fileName.endsWith(".png")) {
          contentType = "image/png";
      } else if (fileName.endsWith(".jpg")) {
          contentType = "image/jpeg";
      } else if (fileName.endsWith(".png")) {
          contentType = "image/jpeg";
      } else if (fileName.endsWith(".bmp")) {
          contentType = "image/bmp";
      } else if (fileName.endsWith(".pdf")) {
          contentType = "application/pdf";
      } else if (fileName.endsWith(".xml")) {
          contentType = "application/xml";
      } else if (fileName.endsWith(".txt")) {
          contentType = "text/plain";
      } else if (fileName.endsWith(".pdf")) {
          contentType = "application/pdf";
      } else {
          contentType = FileTypeMap.getDefaultFileTypeMap().getContentType(fileName);
      }
      return contentType;
  }
}
