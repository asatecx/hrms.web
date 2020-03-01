package af.main.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.apache.ibatis.session.ExecutorType;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import af.base.dao.BaseDao;
import af.base.orm.mybatis.MySqlSessionFactoryBean;

/*************************************************************************
 * Copyright     Asatecx Co.,Ltd.<br/>
 * Package       af.main.config<br/>
 * Class         MainDaoConfig<br/>
 * Summary       DBアクセス配置クラス<br/>
 *
 * Date             Author      Category     Version     Note<br/>
 * 2020/03/01       tang        Add          1.0.0        新規作成<br/>
 ************************************************************************/
@Configuration
public class MainDaoConfig {

    @Autowired
    private Environment env;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Autowired
    @Bean("main.tx")
    public DataSourceTransactionManager transactionManager(
            @Qualifier("main.dataSource") DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

    @Autowired
    @Bean("main.databaseIdProvider")
    public DatabaseIdProvider databaseIdProvider() {
        VendorDatabaseIdProvider databaseIdProvider = new VendorDatabaseIdProvider();
        Properties ps = new Properties();
        ps.setProperty("Oracle", "oracle");
        ps.setProperty("SQL Server", "sqlserver");
        ps.setProperty("DB2", "db2");
        ps.setProperty("MySQL", "mysql");
        ps.setProperty("H2", "h2");
        ps.setProperty("PostgreSQL", "postgresql");
        databaseIdProvider.setProperties(ps);
        return databaseIdProvider;
    }

    @Autowired
    @Bean("main.sqlSession")
    public SqlSessionTemplate sqlSession(
            @Qualifier("main.dataSource") DataSource dataSource,
            @Qualifier("main.databaseIdProvider") DatabaseIdProvider databaseIdProvider) throws Exception {
        MySqlSessionFactoryBean bean = new MySqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setDatabaseIdProvider(databaseIdProvider);
        ResourcePatternResolver resolver = ResourcePatternUtils.getResourcePatternResolver(
                new DefaultResourceLoader());
        bean.setConfigLocation(resolver.getResource("classpath:af/main/sqlMap.xml"));
        bean.setMapperLocations(resolver.getResources("classpath:af/main/sqlMap/**/*.xml"));
        bean.setPmdKnownBroken(false);
        bean.setDevMode(Boolean.parseBoolean(env.getProperty("devMode")));
        return new SqlSessionTemplate(bean.getObject(), ExecutorType.SIMPLE);
    }

    @Primary
    @Autowired
    @Bean("main.dataSource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("main.db.driver"));
        dataSource.setUrl(env.getProperty("main.db.url"));
        dataSource.setUsername(env.getProperty("main.db.username"));
        dataSource.setPassword(env.getProperty("main.db.password"));
        return dataSource;
    }

    @Autowired
    @Bean("main.baseDao")
    public BaseDao baseDao(@Qualifier("main.sqlSession") SqlSessionTemplate sqlSession) {
        BaseDao baseDao = new BaseDao();
        baseDao.setSqlSession(sqlSession);
        return baseDao;
    }

    /*
    @PostConstruct
    public void onStartUp()
    {
      // This is the mapping between the columns in the table and what to insert in it.
      ColumnConfig[] columnConfigs = new ColumnConfig[6];
      columnConfigs[0] =  ColumnConfig.createColumnConfig(null, "LOG_TIME", null, null, "true", null, null);
      columnConfigs[1] =  ColumnConfig.createColumnConfig(null, "LOG_THREAD", "%thread", null, null, "false", null);
      columnConfigs[2] =  ColumnConfig.createColumnConfig(null, "LOG_LEVEL", "%level", null, null, "false", null);
      columnConfigs[3] =  ColumnConfig.createColumnConfig(null, "LOGGER", "%logger", null, null, "false", null);
      columnConfigs[4] =  ColumnConfig.createColumnConfig(null, "MESSAGE", "%message", null, null, "false", null);
      columnConfigs[5] =  ColumnConfig.createColumnConfig(null, "EXCEPTION", "%ex{full}", null, null, "false", null);

      ThresholdFilter filter = ThresholdFilter.createFilter(Level.DEBUG, null, null);

      JdbcAppender appender = JdbcAppender.createAppender("dbAppender", "true", filter, new MyConnectionSource(), "1", "T_PF_SYS_LOG", columnConfigs);
      appender.start();
      ((Logger) LogManager.getLogger("prepareForDBAppender")).addAppender(appender);
    }

    private class MyConnectionSource implements ConnectionSource {


        public Connection getConnection() throws SQLException {
            return dataSource().getConnection();
        }

        @Override
        public State getState() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public void initialize() {
            // TODO Auto-generated method stub

        }

        @Override
        public void start() {
            // TODO Auto-generated method stub

        }

        @Override
        public void stop() {
            // TODO Auto-generated method stub

        }

        @Override
        public boolean isStarted() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean isStopped() {
            // TODO Auto-generated method stub
            return false;
        }
    }
*/
}
