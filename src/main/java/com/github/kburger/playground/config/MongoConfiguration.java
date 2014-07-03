package com.github.kburger.playground.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories("com.github.kburger.playground.repository")
public class MongoConfiguration {
    @Bean
    public MongoClient mongo() throws Exception {
        return new MongoClient();
    }
    
    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(mongo(), "playground");
    }
    
    @Bean
    public MongoOperations mongoTemplate() throws Exception {
        MappingMongoConverter converter = new MappingMongoConverter(mongoDbFactory(), new MongoMappingContext());
        converter.setTypeMapper(null);
        return new MongoTemplate(mongoDbFactory(), converter);
    }
    
    @Bean
    public Jackson2RepositoryPopulatorFactoryBean jackson2RepositoryPopulator() {
        Jackson2RepositoryPopulatorFactoryBean factory = new Jackson2RepositoryPopulatorFactoryBean();
        factory.setResources(new Resource[] { new ClassPathResource("items.json"), new ClassPathResource("notes.json") });
        return factory;
    }
}
