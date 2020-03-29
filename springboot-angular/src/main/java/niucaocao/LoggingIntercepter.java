package niucaocao;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

/**
 * beaglesoft LLC. All rights reserved.
 * ロギングを行うインターセプター
 */
//https://blog.beaglesoft.net/entry/2015/11/18/205745
public class LoggingIntercepter implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoggingIntercepter.class);


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                             Object o) throws Exception {

        logger.debug("LoggingIntercepter.preHandle");
        System.out.println("intercepterrrrrrrrrrrrrrr pre");
        
        httpServletResponse.setCharacterEncoding("utf-8");
        String token = httpServletRequest.getHeader("access_token");
        //token不存在
        if (null != token) {
            //验证token是否正确
            boolean result = JwtUtil.verify(token);
            if (result) {
                return true;
            }else {
                ApiResponse apiResponse = ApiResponseUtil.getApiResponse(ApiResponseEnum.AUTH_ERROR);
                responseMessage(httpServletResponse,httpServletResponse.getWriter(),apiResponse);
            	return false;
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
                           ModelAndView modelAndView) throws Exception {
        logger.debug("LoggingIntercepter.postHandle");
        System.out.println("intercepterrrrrrrrrrrrrrr postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
        logger.debug("LoggingIntercepter.afterCompletion");
        System.out.println("intercepterrrrrrrrrrrrrrr afterCompletion");
    }
    /**
     * 返回信息给客户端
     *
     * @param response
     * @param out
     * @param apiResponse
     */
    private void responseMessage(HttpServletResponse response, PrintWriter out, ApiResponse apiResponse) {
        response.setContentType("application/json; charset=utf-8");
        out.print(JSONObject.toJSONString(apiResponse));
        out.flush();
        out.close();
    }
}