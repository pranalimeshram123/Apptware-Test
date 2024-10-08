package com.apptware.interview.singleton.SinglrtonTest2;

public class Singleton {
	    private static volatile Singleton single_instance = null;
	    public String s;

	    private Singleton() {
	        // Prevent reflection from creating a new instance
	        if (single_instance != null) {
	            throw new IllegalStateException("Cannot create another instance of Singleton using reflection");
	        }
	        s = "Hello I am a string part of Singleton class";
	    }

	    public static Singleton getInstance() {
	        if (single_instance == null) {
	            synchronized (Singleton.class) {
	                if (single_instance == null) {
	                    single_instance = new Singleton();
	                }
	            }
	        }
	        return single_instance;
	    }
	}


	

	