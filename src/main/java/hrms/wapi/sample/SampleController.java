package hrms.wapi.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import af.base.model.JsonModel;
import af.base.model.JsonModelTable;

/*************************************************************************
 * Copyright     Asatecx Co.,Ltd.<br/>
 * Package       af.hrms.wapi.sample<br/>
 * Class         SampleController<br/>
 * Summary       ユーザー管理<br/>
 * <br/>
 * Date             Author      Category     Version     Note<br/>
 * 2019/10/16       tang-xf      Add          1.0.0      新規作成<br/>
 ************************************************************************/
@Scope("request")
@RestController
public class SampleController {
    @Autowired
    @Qualifier("hrms.sampleService")
	private SampleService sampleService;

    /**
     *
     */
    @RequestMapping(value = "/main", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonModel getNoitces() {

		return new JsonModelTable(1, null);
    }

}
