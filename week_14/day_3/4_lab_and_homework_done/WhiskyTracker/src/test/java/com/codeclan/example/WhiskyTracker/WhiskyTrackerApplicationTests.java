package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ActiveProfiles("test") //Indicates it's a test profile so will not run DataLoader
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindAllDistilleriesForRegion_Lowland(){
		List<Distillery> foundDistilleries = distilleryRepository.findByRegion("Lowland");
		assertEquals("Rosebank", foundDistilleries.get(0).getName());
	}

	@Test
	public void canFindAllDistilleriesForRegion_Highland(){
		List<Distillery> foundDistilleries = distilleryRepository.findByRegion("Highland");
		assertEquals("Glendronach", foundDistilleries.get(0).getName());
	}

	@Test
	public void canFindWhiskiesForAParticularYear(){
		List<Whisky> foundWhiskies = whiskyRepository.findByYear(2018);
		assertEquals("The Glendronach Revival", foundWhiskies.get(0).getName());
	}

	@Test
	public void canFindAllWhiskiesByNameAndAge(){
		List<Whisky> foundWhiskies = whiskyRepository.findByDistilleryNameAndAge("Highland Park", 16);
		assertEquals("Twist Tattoo", foundWhiskies.get(0).getName());
	}

	@Test
	public void canFindAllWhiskiesByRegion(){
		List<Whisky> foundWhiskies = whiskyRepository.findByDistilleryRegion("Island");
		assertEquals("Viking Honour", foundWhiskies.get(0).getName());
		assertEquals("Twist Tattoo", foundWhiskies.get(1).getName());
	}

	@Test
	public void canFindDistillerByWhiskiesAge(){
		List<Distillery> foundDistilleries = distilleryRepository.findByWhiskiesAge(15);
		assertEquals("Glendronach", foundDistilleries.get(0).getName());
		assertEquals("Glenkinchie", foundDistilleries.get(1).getName());
	}

}
