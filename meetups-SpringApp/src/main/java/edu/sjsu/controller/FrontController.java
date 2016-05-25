package edu.sjsu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.sjsu.dao.TopicDao;
import edu.sjsu.entity.CountryUser;
import edu.sjsu.entity.Topic;
import edu.sjsu.service.CountryUserService;
import edu.sjsu.service.TopicService;

@RestController

@RequestMapping("/api/v1")
public class FrontController {
	
	@Autowired
	private TopicService topicService;
	@Autowired
	private CountryUserService countryUserService;
    // TopicDao topicDao;
	
	public FrontController() {
		System.out.println("FrontController()");
		} 
	
	@RequestMapping(value="/greeting",method=RequestMethod.GET)
	public void hello() {
        System.out.println("heyyy !!!!");
    }
	
	/*@RequestMapping(value="/topic",method=RequestMethod.GET)
        public Iterable<Topic> getTopic(@RequestParam(value="name", defaultValue="IT") String name) {
            return topicDao.findByCategoryName(name) ;
            //new Topic(counter.incrementAndGet(),name, lname);
    }*/
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value="/topic/{id}", method = RequestMethod.GET)
	Topic findById(@PathVariable("id") int topicId) {
	return topicService.getTopic(topicId);
	} 
	
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value="/CountryUser/{id}", method = RequestMethod.GET)
	CountryUser findByIdc(@PathVariable("id") int countryUserId) {
	return countryUserService.getCountryUser(countryUserId);
	} 
	
	@RequestMapping(value="/CountryUser", method = RequestMethod.GET)
	List<CountryUser> findAll() {
	List<CountryUser> cs=  countryUserService.getAllCountryUser();
	
	
	return cs;
	} 
	
}
