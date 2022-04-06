package config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Project name(项目名称)：Mybatis_Plus实现查询操作之selectPage
 * Package(包名): config
 * Class(类名): MybatisPlusConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/4/6
 * Time(创建时间)： 20:17
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Configuration
@MapperScan("mapper") //设置mapper接口的扫描包
public class MybatisPlusConfig
{
    @Bean
    public PaginationInnerInterceptor paginationInterceptor()
    {
        return new PaginationInnerInterceptor(DbType.MYSQL);
    }
}
