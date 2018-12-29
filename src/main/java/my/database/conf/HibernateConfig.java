package my.database.conf;

import my.encode.DecryptedService;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * User: Sushakov
 * Date: 12/29/2018
 * Time: 10:02
 **/

@Configuration
@EnableTransactionManagement
public class HibernateConfig {

    @Value("${datasource.conf.url}")
    private String url;
    @Value("${datasource.conf.base}")
    private String base;
    @Value("${datasource.conf.user}")
    private String user;
    @Value("${datasource.conf.pass}")
    private String pass;
    @Value("${datasource.conf.driver}")
    private String driver;

    @Value("${hibernate.config.package}")
    private String entityPackage;
    @Value("${hibernate.property.dialect}")
    private String dialect;

    private DecryptedService decryptedService;
    private static final Logger LOG = Logger.getLogger(HibernateConfig.class);

    public HibernateConfig(DecryptedService decryptedService) {
        this.decryptedService = decryptedService;
    }

    @Bean
    public LocalSessionFactoryBean localSessionFactoryBean() {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource());
        localSessionFactoryBean.setPackagesToScan(entityPackage);
        localSessionFactoryBean.setHibernateProperties(hibernateProperties());
        return localSessionFactoryBean;
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(url);
        basicDataSource.setDefaultCatalog(base);
        basicDataSource.setDriverClassName(driver);
        basicDataSource.setUsername(user);
        basicDataSource.setDefaultAutoCommit(false);
        try {
            basicDataSource.setPassword(decryptedService.decrypt(pass));
        } catch (Exception e) {
            LOG.error("Error decode password: " + e);
            basicDataSource.setPassword(pass);
        }
        return basicDataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(localSessionFactoryBean().getObject());
        return transactionManager;
    }

    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", dialect);
        return hibernateProperties;
    }

}
