package test;

import static org.junit.Assert.*;

import org.junit.Test;

import game.landFactory;

public class LandFactoryTest {

	@Test
	public void makeLandtest() {
		landFactory factory=new landFactory();
		for(char i='A';i<='L';i++) {
			factory.makeLand(i);
		}
	}

}
