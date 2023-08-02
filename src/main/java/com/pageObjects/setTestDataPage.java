package com.pageObjects;


import org.fluttercode.datafactory.NameDataValues;


public class setTestDataPage implements NameDataValues
{

	String prefixes[] = {"Mr","Mrs","Miss","Dr","Prof"};
	
	String genders[] = {"Male","Female","Others"};
	
	
	@Override
	public String[] getFirstNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getLastNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getPrefixes() {
		return prefixes;
		
	}

	@Override
	public String[] getSuffixes() {
		// TODO Auto-generated method stub
		return null;
	}

    public String[] genders()
    {
    	return genders;
    }

}
