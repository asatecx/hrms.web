package af.main.config;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;

//import af.base.service.AmazonS3Service;
import af.base.service.CsvReportService;
import af.base.service.ExcelReportService;
import af.base.service.PdfReportService;
import af.base.util.FileUtil;

/*************************************************************************
 * Copyright     Asatecx Co.,Ltd.<br/>
 * Package       af.main.config<br/>
 * Class         OtherConfig<br/>
 * Summary       そのた配置クラス<br/>
 *
 * Date             Author      Category     Version     Note<br/>
 * 2020/03/01       tang        Add          1.0.0        新規作成<br/>
 ************************************************************************/
@Configuration
public class OtherConfig {

    @Autowired
    private Environment env;

//    /**
//     * Eメールサービス
//     * @return Eメールサービス
//     */
//    @Autowired
//    @Bean("main.mailService")
//    public MailService mailService() {
//        MailService mailService = new MailService();
//        mailService.setHost(env.getProperty("main.mail.host"));
//        mailService.setPort(Integer.parseInt(env.getProperty("main.mail.port")));
//        mailService.setUseTLS(Boolean.valueOf(env.getProperty("main.mail.useTLS")));
//        mailService.setUser(env.getProperty("main.mail.user"));
//        mailService.setPassword(env.getProperty("main.mail.password"));
//        mailService.setFrom(env.getProperty("main.mail.from"));
//        mailService.setTemplateFolder(env.getProperty("main.mail.templateFolder"));
//
//        //for dalian environment
//        //mailService.setHost("smtp.163.com");
//        //mailService.setPort(25);
//        //mailService.setUseTLS(false);
//        //mailService.setUser("licauth@163.com");
//        //mailService.setPassword("licauth2");
//        //mailService.setFrom("licauth@163.com");
//
//        return mailService;
//    }
//
    /**
     * PDFレポートサービス
     * @return PDFレポートサービス
     */
    @Autowired
    @Bean("main.pdfReportService")
    public PdfReportService pdfReportService() {
        PdfReportService pdfReportService = new PdfReportService();
        pdfReportService.setTemplateFolder("classpath:af/main/pdfTemplate");
        pdfReportService.setFont("classpath:af/main/font");
        pdfReportService.setExportFolder(env.getProperty("pdf.tmp.path"));

        return pdfReportService;
    }
    @PostConstruct
    public void testInit() {
    	InputStream is = null;
        try {
//        	is = ApplicationContextUtil.getContext().getResource("classpath:af/main/font"+"/simhei.ttf").getInputStream();
        	ClassPathResource resource = new ClassPathResource("af/main/font/simhei.ttf");
        	is = resource.getInputStream();
            FileUtil.inputStreamToFile(is, env.getProperty("pdf.tmp.path")+"/simhei.ttf");
            is.close();
        }catch(IOException e) {
        	e.printStackTrace();
        }finally {
        	if (is != null) try { is.close(); } catch(Exception ignore) {}
        }
    }

    /**
     * Excelレポートサービス
     * @return Excelレポートサービス
     */
    @Bean("main.excelReportService")
    public ExcelReportService excelReportService() {
        ExcelReportService excelReportService = new ExcelReportService();
        excelReportService.setTemplateFolder("classpath:af/main/excelTemplate");
        excelReportService.setExportFolder("C:/pfj/excel/out");
        return excelReportService;
    }

    /**
     * CSVレポートサービス
     * @return CSVレポートサービス
     */
    @Bean("main.csvReportService")
    public CsvReportService csvReportService() {
        CsvReportService csvReportService = new CsvReportService();
        csvReportService.setTemplateFolder("classpath:af/main/csvTemplate");
        csvReportService.setExportFolder("C:/pfj/csv/out");
        return csvReportService;
    }

//    /**
//     * FTPサービス
//     * @return FTPサービス
//     */
//    @Bean("main.ftpService")
//    public FtpService ftpService() {
//        FtpService ftpService = new FtpService();
//        ftpService.setHost("172.31.8.81");
//        ftpService.setPort(21);
//        ftpService.setUser("centos");
//        ftpService.setPassword("password");
//        ftpService.setEncoding("UTF-8");
//        return ftpService;
//    }
//
//    /**
//     * AWS S3ファイル連携サービス（暗号化なし）
//     * @return FTPサービス
//     */
//    @Bean("main.amazonS3PlainService")
//    public AmazonS3Service amazonS3PlainService() {
//        AmazonS3Service s3Service = new AmazonS3Service();
//        s3Service.setRegionName("ap-northeast-1");
//        s3Service.setAccessKey("AKIA2Q5TREHZ7X5H2XQX");
//        s3Service.setSecretKey("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");
//        s3Service.setBucketName("filepacket-test-01");
//        return s3Service;
//    }
//
//    /**
//     * AWS S3ファイル連携サービス（暗号化あり）
//     * @return FTPサービス
//     */
//    @Bean("main.amazonS3EncryptService")
//    public AmazonS3Service amazonS3EncryptService() {
//        AmazonS3Service s3Service = new AmazonS3Service();
//        s3Service.setRegionName("ap-northeast-1");
//        s3Service.setAccessKey("AKIA2Q5TREHZ7X5H2XQX");
//        s3Service.setSecretKey("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");
//        s3Service.setKmsEncryptKeyID("alias/s3-kms-key");
//        s3Service.setBucketName("filepacket-test-01");
//        return s3Service;
//    }

    /**
     * タスクスケジューラ
     * @return タスクスケジューラ
     */
    @Bean
    public ThreadPoolTaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(5);
        return scheduler;
    }

    /**
     * タスクExecutor
     * @return タスクExecutor
     */
    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(25);
        return executor;
    }

    /**
     * キャッシュ配置
     * @return キャッシュ配置
     */
    @Bean
    public Config hazelCastConfig(){
        int mailCodeCacheTimeoutSeconds = Integer.parseInt(env.getProperty("main.mailCodeCache.timeoutSeconds"));
        int ipCodeCountCacheTimeoutSeconds = Integer.parseInt(env.getProperty("main.ipCodeCountCache.timeoutSeconds"));
        return new Config()
                .setInstanceName("hazelcast-instance")
                .addMapConfig(
                        new MapConfig()
                                .setName("main.mailCodeCache")
                                .setMaxSizeConfig(new MaxSizeConfig(10000, MaxSizeConfig.MaxSizePolicy.PER_NODE))
                                .setEvictionPolicy(EvictionPolicy.LRU)
                                .setTimeToLiveSeconds(mailCodeCacheTimeoutSeconds))
                .addMapConfig(
                        new MapConfig()
                                .setName("main.ipCodeCountCache")
                                .setMaxSizeConfig(new MaxSizeConfig(10000, MaxSizeConfig.MaxSizePolicy.PER_NODE))
                                .setEvictionPolicy(EvictionPolicy.LRU)
                                .setTimeToLiveSeconds(ipCodeCountCacheTimeoutSeconds));
    }
}
