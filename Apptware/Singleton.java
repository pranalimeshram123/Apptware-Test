package Apptware;

public class Singleton {
	
	    private static volatile Singleton single_instance = null;
	    
	    public String s;

	    private Singleton() {
	        s = "Hello I am a string part of Singleton class";
	    }

	    public static Singleton getInstance() {
	        if (single_instance == null) { // First check (no locking)
	            synchronized (Singleton.class) { // Locking
	                if (single_instance == null) { // Second check (with locking)
	                    single_instance = new Singleton();
	                }
	            }
	        }
	        return single_instance;
	    }
	}



