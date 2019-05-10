package com.aprovechaessec.repositories;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.aprovechaessec.entity.Users;

@Repository
 public class UserRepositoryImpl {
	public final MongoTemplate mongoTemplate;
	@Autowired
    public UserRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
	
	@Autowired private MongoOperations mongoOps;
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public Users getUserByEmail(String email) {
		Users user = mongoOps.findOne(query(where("email").is(email)), Users.class);
		return user;
	}
	
	public Users getUserbyEmail(String email) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email));
		List<Users> users = mongoTemplate.find(query, Users.class);
		return users.get(0);
	}
	
	public Users getUserbyName(String name) throws Exception{
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(name));
		List<Users> users = mongoTemplate.find(query, Users.class);
		return users.get(0);
	}
	
	private void useMongoTemplateForQueries() {
        
//        setupTestData();
        
        //------------------------------------------------- equality
        
        Users user = mongoOps.findOne(query(where("name").is("Asia")), Users.class);
        
        /*Query europeanQuery = query(where("continent.name").is("Europe"));
        List<Country> europeanCountries = mongoOps.find(europeanQuery, Country.class);
        
        //------------------------------------------------- not equal to
        
        List<Continent> notAsia = mongoOps.find(query(where("name").ne("Asia")), Continent.class);
        
        //------------------------------------------------- less than
        
        List<Country> smallCountries = mongoOps.find(query(where("area").lt(30000)), Country.class);
        
        //------------------------------------------------- between
        
        Criteria between = where("population").gt(5000000).lt(30000000);
        List<Country> popBetween = mongoOps.find(query(between), Country.class);
        
        //------------------------------------------------- in list
        
        List<Country> ghanaAndGambia = mongoOps.find(query(where("name").in("Ghana", "Gambia")), Country.class);
        List<Country> notGhanaAndGambia = mongoOps.find(query(where("name").nin("Ghana", "Gambia")), Country.class);
        
        //------------------------------------------------- regular expression

        List<Country> regex = mongoOps.find(query(where("name").regex("G[ae].*")), Country.class);
        
        //------------------------------------------------- not
        
        List<Country> notRegex = mongoOps.find(query(where("name").not().regex("G[ae].*")), Country.class);
        
        //------------------------------------------------- subdocument
        
        List<Country> asianCountries = mongoOps.find(query(where("continent.name").is("Asia")), Country.class);
        
        //------------------------------------------------- and
        
        Criteria smallAreaAndBigPop = where("area").lt(500000).and("population").gt(30000000);
        List<Country> densePop = mongoOps.find(query(smallAreaAndBigPop), Country.class);
        
        //------------------------------------------------- or
        
        Criteria smallArea = where("area").lt(50000);
        Criteria smallPop = where("population").lt(2000000);
        Criteria smallAreaOrPop = new Criteria().orOperator(smallArea, smallPop);
        List<Country> smallAreaOrSmallPop = mongoOps.find(query(smallAreaOrPop), Country.class);
        
        //------------------------------------------------- and / or
        
        Criteria countries = where("name").regex("G[ae].*");
        Criteria andOr = new Criteria().andOperator(countries, smallAreaOrPop);
        List<Country> countryList = mongoOps.find(query(andOr), Country.class);

        

        //------------------------------------------------- query document
    
        BasicQuery queryDoc = new BasicQuery("{ continent.name : 'Europe', area : { $gt : 50000 } }");
        List<Country> largeEuropean = mongoOps.find(queryDoc, Country.class);*/
        
    }

}
