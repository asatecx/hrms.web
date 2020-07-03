package hrms.wapi.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import af.base.model.mail.Mail;
import af.base.service.mail.SendEmailService;
import af.base.util.MD5Util;
import af.main.model.User;
import hrms.model.Company;
import hrms.model.Constants;
import hrms.model.Login;
import hrms.wapi.base.HrmsSimpleDaoService;

/*************************************************************************
 * Copyright     Asatecx Co.,Ltd.<br/>
 * Package       af.main.wapi.company<br/>
 * Class         CompanyService<br/>
 * Summary       会社サービス<br/>
 * <br/>
 * Date             Author      Category     Version     Note<br/>
 * 2020/04/09       tang-xf     Add          1.0.0       新規作成<br/>
 ************************************************************************/
@Service("hrms.companyService")
public class CompanyService extends HrmsSimpleDaoService {

	@Autowired
    @Qualifier("sendEmailService")
	private SendEmailService sendEmailService;

	/**
     * 会社情報登録.
     * @param company
     * @return boolean
     */
	@Transactional("hrms.tx")
	public boolean registCompany(Company company, Login login) {
		Login checkUser = super.find(login);
		if (checkUser != null) {
			return false;
		}
		String validateCode = MD5Util.md5Encrypt32Upper(company.getMail());
		login.setValidateCode(validateCode);
		super.insert(true, login);
		super.insert(true, company);
		sendMail(company.getMail(), validateCode);
		return true;
	}

	/**
     * 会社情報有効.
     * @param login
     * @return boolean
     */
	@Transactional("hrms.tx")
	public boolean activateCompany(Login login, String validateCode) {
		Login loginInfo = super.find(login);
		if(!validateCode.equals(loginInfo.getValidateCode())) {
			return false;
		}
		loginInfo.setValidFlg("1");
		super.update(true, loginInfo);
		return true;
	}
    /**
     * Select user without password.
     * @param userId
     * @return user
     */
    public User getUser(String userId) {
        User user = new User();
        user.setUSER_ID(userId);
        user = super.find(user);
        if (user != null) {
            if (!Constants.VALID_FLG_TRUE.equals(user.getVALID_FLG())) {
                user = null;
            } else {
                // TODO Somethig
            }
        }
        return user;
    }

    /**
     * get company info.
     * @param companyId company Id
     * @return Company info
     */
    public Company getCompany(String companyId) {
        Company company = new Company();
        company.setUserId(companyId);
        company = super.find(company);
        return company;
    }

	private String sendMail(String sendTo, String validateCode) {

		String mailText = "こんにちは" + sendTo + "\r\n";
		mailText += "HRMSへのサインアップありがとうございます！\r\n";
		mailText += "アカウントを開くには下記のリンクをクリックしてメールアドレスの認証をしてください：\r\n";
		mailText += "http://127.0.0.1:8091/company/activate/"+ sendTo + "/" + validateCode;
		mailText += "\r\n";
		mailText += "ご利用ありがとうございます！";
		String[] arySendTo = sendTo.split(";");
		Mail mail = new Mail();
		mail.setSmtp_host("smtp22.gmoserver.jp");
		mail.setPort("587");
		mail.setSocketFactory_port("587");
		mail.setSmtp_auth(true);
		mail.setDebug(false);
		mail.setFallback(false);
		mail.setSsl(false);
		mail.setStore_protocol("pop3");
		mail.setTransport_protocol("smtp");
		mail.setUsername("admin@asatecx.com");
		mail.setPassword("F#fk8kD#");
		mail.setMail_from("admin@asatecx.com");
		mail.setMail_to(arySendTo);
		mail.setMail_subject("Confirm your HRMS account please");
		mail.setMail_text(mailText);
		sendEmailService.sendmail(mail);

		return "mail";
	}

}
